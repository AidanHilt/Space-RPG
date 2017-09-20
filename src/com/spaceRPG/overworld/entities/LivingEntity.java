package com.spaceRPG.overworld.entities;

import org.lwjgl.input.Mouse;

import com.spaceRPG.displayElements.Circle;
import com.spaceRPG.displayElements.CircleTracker;
import com.spaceRPG.overworld.Tile;
import com.spaceRPG.overworld.WarpTile;
import com.spaceRPG.overworld.managment.Position;
import com.spaceRPG.utils.Constants;
import com.spaceRPG.utils.Die;
import com.spaceRPG.weapons.RangedOrMelee;
import com.spaceRPG.weapons.Weapon;
import com.spaceRPG.weapons.melee.MeleeWeapon;
import com.spaceRPG.weapons.ranged.RangedWeapon;

public class LivingEntity extends Entity implements LivingEntityMethods{
	
	private static final long serialVersionUID = 3354838148309050279L;
	CircleTracker tracker;
	double xVel;
	double yVel;
	double speed = .2;
	boolean circleTrackerEngaged = false;
	boolean needToMove = false;
	private Tile movingTo;
	private Circle c;
	boolean moving;
	double angle;
	int i = 0;
	boolean isAttacking;
	Entity target;
	
	double time;
	double secondTime;
	
	Weapon weapon;
	protected double delay;

	public LivingEntity() {}
	
	@Override
	void draw(){
		c.draw();
		if(tracker != null){
			tracker.draw();
		}
	}
	
	public Circle getC(){
		return c;
	}
	
	public void setC(Circle c){
		this.c = c;
	}
	
	@Override
	public void pollInput(){
		if(this.c.detectLeftMouseClicked() && Constants.isCircleTrackerActive){
			Constants.entityOnDeck.selectTarget(this);
			System.out.println("Mouse y: " + Mouse.getY());
			System.out.println("Entity y: " + this.c.pos.getY());
		}
		else if(this.c.detectRightMouseClicked()){
			showInfoCard();
		}
	}
	
	public void engageMove(Tile t){
		needToMove = true;
		movingTo = t;
	
		double deltaX = this.movingTo.getDisplayPos().getX() - this.location.getDisplayPos().getX();
		double deltaY = this.movingTo.getDisplayPos().getY() - this.location.getDisplayPos().getY();
		
		xVel = speed;
		yVel = speed;
		
		angle = Math.atan2(deltaY, deltaX);
		
		this.location.entityList.remove(this); 
		needToMove = false;
		moving = true;
		}
		
	@Override
	public void calculateSize(){
		double holdVal;
		if(this.location.s.getSideLength() < this.location.s.getSideHeight()){
			holdVal = this.location.s.getSideLength();
		}else{
			holdVal = this.location.s.getSideHeight();
		}
		c = new Circle(this.location.s.pos, holdVal / 4, 1, 0, 0, -2);
	}
	
	
	@Override
	public void setLocation(Tile t){
		this.location = t;
	}
	
	public void warpInstantly(WarpTile t){
		location = t;
		t.entityList.add(this);
		calculateSize();
	}
	
	@Override
	public void update(long delta){		
		
		this.c.pos = new Position(c.pos.getX() + (xVel * Math.cos(angle) * delta), c.pos.getY() + (yVel * Math.sin(angle) * delta));
		pollInput();
		draw();
		if(this.movingTo != null){
			if(Math.abs(this.c.pos.getX() - movingTo.getDisplayPos().getX()) < .5){
				xVel = 0;}
			
			if(Math.abs(this.c.pos.getY() - movingTo.getDisplayPos().getY()) < .5){
				yVel = 0;}
			
			if(Math.abs(this.c.pos.getX() - movingTo.getDisplayPos().getX()) < 1 && Math.abs(this.c.pos.getY() - movingTo.getDisplayPos().getY()) < 1){
				xVel = 0;
				yVel = 0;
				this.setLocation(movingTo);
				this.location.entityList.add(this);
				movingTo = null;
				moving = false;
				if(this.location instanceof WarpTile){
				//	((WarpTile) location).movePlayer(this);
				}
			}
		}
		
		if(isAttacking){
			secondTime = System.currentTimeMillis();
			delay = 1000 / getAttackSpeed();
			if(secondTime - time >= delay){
				attack(target);
				time = System.currentTimeMillis();
			}
		}
	}
	
	@Override
	public void attack(Entity e) {
		int i = 0;
		if(this.weapon != null){
			System.out.println("Attacked, need to calculate weapon");
			if(this.weapon.getWeaponType() == RangedOrMelee.MELEE){
				i = Die.roll(20) + getAtkBonuses() + 10;
			}
			else if(this.weapon.getWeaponType() == RangedOrMelee.RANGED){
				i = (int) (Die.roll(20) + getAtkBonuses() + (((RangedWeapon) weapon).getAccuracy() * 10));
				int distance = (int) this.location.establishDistance(e.location);
				double rangeBonus = 0;
				if(distance / ((RangedWeapon)weapon).getRange() > 1 / 3 && distance / ((RangedWeapon)weapon).getRange() < 2 / 3){
					rangeBonus = 1.0;
				}
				else if(distance / ((RangedWeapon)weapon).getRange() > 2 / 3){
					rangeBonus = (-.25 / (((RangedWeapon)weapon).getRange() - (int)(((RangedWeapon)weapon).getRange() * 2 / 3))) * (((RangedWeapon)weapon).getRange() - distance);
				}
				else if(distance == 1 || distance == 0){
					rangeBonus = .5;
				}
				
				i += (int) (i * rangeBonus); 
			}
			
			int i1 = e.defend();
			
			System.out.println(i);
			System.out.println(i1);
			
			if(i >= i1){
				weapon.attack(e);
			}
			else{
				System.out.println("Attack did not connect");
			}
		}else{
			System.out.println("No weapon!");
		}
		
	}
	
	public void selectTarget(Entity e){
		delay = 1000 / getAttackSpeed();
		time = System.currentTimeMillis();
		secondTime = System.currentTimeMillis() + delay;
		isAttacking = true;
		target = e;
	}
	
	
	protected double getAttackSpeed() {
		double d = 0;
		if(this.weapon != null){
			if(this.weapon.getWeaponType() == RangedOrMelee.MELEE){
				d = ((MeleeWeapon)weapon).getAttackSpeed();
			}
			else if(this.weapon.getWeaponType() == RangedOrMelee.RANGED){
				d = ((RangedWeapon)weapon).getFireRate();
			}
		}
		return d;
	}

	@Override
	public int defend() {
		return Die.roll(20) + this.getArmorRating() + this.getDefBonuses();
		
	}
	
	public void addWeapon(Weapon w){
		this.weapon = w;
	}
	
	//Getters and showers
	//{{
	@Override
	public int getDefBonuses() {
		// TODO Calculate defense bonuses
		return 0;
	}
	
	@Override
	public int getAtkBonuses(){
		return 0;
		//TODO Calculate attack bonuses
	}
	@Override
	public void showInfoCard() {
		System.out.println(this);
		
	}
	
	@Override
	public int getArmorRating(){
		return 10;
		//TODO getArmorRating()

	}
	
	@Override
	public int getDamReduction() {
		// TODO Calculate damage reduction
		return 0;
	}
	
	@Override
	public int getDamBonuses() {
		// TODO Calculate damage bonuses
		return 0;
	}
	
	@Override
	public void takeDamage(double damage) {
		this.hp -= damage;
	//}}
	}
}