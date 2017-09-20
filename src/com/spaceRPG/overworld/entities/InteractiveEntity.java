package com.spaceRPG.overworld.entities;

import mightyUtil.openGL.ShapeDrawing;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import com.spaceRPG.AI.AI;
import com.spaceRPG.displayElements.Circle;
import com.spaceRPG.displayElements.CircleTracker;
import com.spaceRPG.overworld.Map;
import com.spaceRPG.overworld.Tile;
import com.spaceRPG.overworld.WarpTile;
import com.spaceRPG.overworld.managment.Position;
import com.spaceRPG.playerCharacter.Player;
import com.spaceRPG.utils.Constants;
import com.spaceRPG.utils.Die;
import com.spaceRPG.utils.fonts.InitFonts;
import com.spaceRPG.weapons.melee.MeleeWeapon;
import com.spaceRPG.weapons.ranged.RangedWeapon;

public class InteractiveEntity extends LivingEntity{
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
int energy; //The value is copied from the player character class
public InitFonts testUseFont; //To be replaced later
Player player;
AI ai;

	public InteractiveEntity() {}
	
	@Override
	void draw(){
		c.draw();
		if(tracker != null){
			tracker.draw();
		}
		
		if(testUseFont == null){
			testUseFont = new InitFonts();
		}
		
		ShapeDrawing.drawString(15, 575, "Health: " + hp, Color.white, testUseFont.testFont);
		ShapeDrawing.drawString(15, 550, "Energy: " + energy, Color.white, testUseFont.testFont);
	}
	
	public Circle getC(){
		return c;
	}
	
	public void setC(Circle c){
		this.c = c;
	}
	
	@Override
	public void pollInput(){
		boolean aCircleTrackerEngaged = false;
		for(Entity e: Constants.getCurrentMap().m.getEntityList()){
			if(e instanceof InteractiveEntity){
				if(((InteractiveEntity) e).circleTrackerEngaged == true || ((InteractiveEntity) e).needToMove == true){
					aCircleTrackerEngaged = true;
				}
			}
		}
		if(this.c.detectLeftMouseClicked() == true & this.moving == false & aCircleTrackerEngaged == false){
			tracker = new CircleTracker(this.getLocation().s.pos.getX(), this.getLocation().s.pos.getY());
			circleTrackerEngaged = true;
			Constants.isCircleTrackerActive = true;
			Constants.entityOnDeck = this;
			new Thread(new ThreadCircleTracker(this, Constants.getCurrentMap())).start();
		}
	}
	
	public void engageMove(Tile t){
		if(t.detectAcceptableMove()){
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
					((WarpTile) location).movePlayer(this);
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
		
		if(isAttacking && Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			isAttacking = false;
			target = null;
		}
	}
	
	@Override
	public void attack(Entity e){
		int i = 0;
		if(this.weapon != null){
			String validity = null;
			
			int compBonus = 0;
			switch(this.weapon.getWeaponType()){
			case MELEE:
				if(this.location.establishDistance(e.location) <= ((MeleeWeapon) weapon).getReach()){
					if(player != null){
						int dif = player.getMelee() - player.getWeapon().getLevelReq();
						if(dif < -25){
							validity = "Invalid";
						}
						else if(dif == -25){
							compBonus = -3;
						}
						else if(dif < -10 && dif >= -24){
							compBonus = -2;
						}
						else if(dif < 0 && dif >= -10){
							compBonus = -1;
						}
						else if(dif > 0 && dif <= 25){
							compBonus = 0;
						}
						else if(dif > 25 && dif <= 45){
							compBonus = 2;
						}
						else{
							compBonus = 3;
						}
					}
					
					if(ai != null){
						int dif = ai.getMelee() - ai.getWeapon().getLevelReq();
						if(dif < -25){
							validity = "Invalid";
						}
						else if(dif == -25){
							compBonus = -3;
						}
						else if(dif < -10 && dif >= -24){
							compBonus = -2;
						}
						else if(dif < 0 && dif >= -10){
							compBonus = -1;
						}
						else if(dif > 0 && dif <= 25){
							compBonus = 0;
						}
						else if(dif > 25 && dif <= 45){
							compBonus = 2;
						}
						else{
							compBonus = 3;
						}
					}
					i = Die.roll(20) + getAtkBonuses() + 10 + compBonus;
				}else{
					System.out.println("Too far away!");
				
				}
				
					int i1 = e.defend();
					System.out.println(i);
					System.out.println(i1);
					
					if(i > i1 && validity != "Invalid"){
						weapon.attack(e);
					}else if(validity == "Invalid"){
						System.out.println("Weapon skill too low to use this weapon!");
					}
					else{
						System.out.println("Attack did not connect!");
					}
				break;
			case RANGED:
				if(this.location.establishDistance(e.location) <= ((RangedWeapon) weapon).getRange()){
					
					if(player != null){
						int dif = player.getGuns() - player.getWeapon().getLevelReq();
						if(dif < -25){
							validity = "Invalid";
						}
						else if(dif == -25){
							compBonus = -3;
						}
						else if(dif < -10 && dif >= -24){
							compBonus = -2;
						}
						else if(dif < 0 && dif >= -10){
							compBonus = -1;
						}
						else if(dif > 0 && dif <= 25){
							compBonus = 0;
						}
						else if(dif > 25 && dif <= 45){
							compBonus = 2;
						}
						else{
							compBonus = 3;
						}
					}
					
					if(ai != null){
						int dif = ai.getGuns() - ai.getWeapon().getLevelReq();
						if(dif < -25){
							validity = "Invalid";
						}
						else if(dif == -25){
							compBonus = -3;
						}
						else if(dif < -10 && dif >= -24){
							compBonus = -2;
						}
						else if(dif < 0 && dif >= -10){
							compBonus = -1;
						}
						else if(dif > 0 && dif <= 25){
							compBonus = 0;
						}
						else if(dif > 25 && dif <= 45){
							compBonus = 2;
						}
						else{
							compBonus = 3;
						}
					}
					
					i = (int)(Die.roll(20) + getDefBonuses() + (((RangedWeapon) weapon).getAccuracy() * 10));
					int distance = (int) this.location.establishDistance(e.location);
					
						//Determine spacing for range bonuses
						double applicableRegion = distance - 1;
						int normal = (int) Math.ceil(applicableRegion / 2);
					
						if(distance >= normal){
							double reduction = (.25 / ((RangedWeapon)weapon).getRange() - normal) * (distance - normal);
							i -= i * reduction;
						}
					
						if(((RangedWeapon)weapon).getRange() >= 8 && (distance == 1 || distance == 0)){
							i -= i * .5;
						}
						
						if(((RangedWeapon)weapon).getRange() < 8 && (distance == 1 || distance == 0)){
							i += i * .5;
						}
						
						
					i1 = e.defend();
					System.out.println(i);
					System.out.println(i1);
					
					if(i > i1){
						weapon.attack(e);
					}
					else{
						System.out.println("Attack did not connect!");
					}
				}else{
					System.out.println("Target out of range!");
				}
				break;
			}
		}
	}
	@Override
	public void selectTarget(Entity e){
		if(target == null){
		delay = 1000 / getAttackSpeed();
		time = System.currentTimeMillis();
		secondTime = System.currentTimeMillis() + delay;
		isAttacking = true;
		target = e;
		tracker = null;
		attack(e);
		}
	}
	
	public void addController(Player player){
		this.player = player;
		this.hp = player.getHp();
		this.energy = player.getEnergy();
	}
	
	public void addController(AI ai){
		this.ai = ai;
		//TODO Add necessary fields from a finished AI class
	}
	//Getters and showers
	//{{
	@Override
	public int getDefBonuses() {
		// TODO Calculate defense bonuses for InteractiveEntity
		return 0;
	}

	@Override
	public int getAtkBonuses() {
		// TODO Calculate atttack bonuses for InteractiveEntity
		return 0;
	}

	@Override
	public void showInfoCard() {
		// TODO Add info card showing
		System.out.println(this);
		
	}
	
	@Override
	public int getDamReduction() {
	// TODO Calculate damage reduction for InteractiveEntity
		return 0;
	}

	@Override
	public int getDamBonuses() {
	// TODO Calculate damage bonuses for InteractiveEntity
		return 0;
	}
	//}}
class ThreadCircleTracker implements Runnable{
	int i = 0;
	InteractiveEntity e;
	Map m;
	@Override
	public void run() {
		while(e.circleTrackerEngaged){
			for(Tile t: m.getMapContents()){
				if(t.detectAcceptableMove() & !(e.getLocation() == t) & i == 0){
					i++;
					e.circleTrackerEngaged = false;
					e.tracker = null;
					e.engageMove(t);
					return;
				}
			}
			if(Mouse.isButtonDown(1)){
				e.circleTrackerEngaged = false;
				e.tracker = null;
				return;
			}
		}
	}
		
	ThreadCircleTracker(InteractiveEntity e, Map m){
		this.e = e;
		this.m = m;
	
		}
	}



}