package com.spaceRPG.overworld;

import java.io.Serializable;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;

import com.spaceRPG.displayElements.Square;
import com.spaceRPG.overworld.entities.Entity;
import com.spaceRPG.overworld.entities.InteractiveEntity;
import com.spaceRPG.overworld.entities.LivingEntity;
import com.spaceRPG.overworld.managment.Position;
/**
 * 
 * @author AidanTheGreat
 * The tiles that entities walk/stand on
 */
public class Tile implements Serializable{
private static final long serialVersionUID = -5L;
public Square s;
private Position displayPos;
Position mapPos;
public ArrayList<Entity> entityList = new ArrayList<Entity>();
public Map m;

public Map getM(){
	return m;
}

public Tile(Position mapPos){
	this.mapPos = mapPos;
	s = new Square();
}

public Tile(Position mapPos, Entity e){
	this.mapPos = mapPos;
	s = new Square();
	entityList.add(e);
	e.setLocation(this);
	
}
public void draw(){
	s.draw();
}

public void determineInhabited(InteractiveEntity... entities){
	int i = 0;
	for(InteractiveEntity e: entities){
		if((e.getC().pos.getX() < this.getDisplayPos().getX() + this.s.getSideLength() / 2) ||
				(e.getC().pos.getX() > this.getDisplayPos().getX() - this.s.getSideLength() / 2) ||
				(e.getC().pos.getY() < this.getDisplayPos().getY() + this.s.getSideHeight() / 2) ||
				(e.getC().pos.getY() > this.getDisplayPos().getY() + this.s.getSideHeight() / 2)){
			this.entityList.add(i, e);
			i ++;
			}
		}
	}

public boolean detectClickWithTracker(){
	if((Mouse.getX() < this.getDisplayPos().getX() + this.s.getSideLength() / 2) &
	   (Mouse.getX() > this.getDisplayPos().getX() - this.s.getSideLength() / 2) &
	   (Mouse.getY() < this.getDisplayPos().getY() + this.s.getSideHeight() / 2) &
	   (Mouse.getY() > this.getDisplayPos().getY() - this.s.getSideHeight() / 2) &
	   Mouse.isButtonDown(0)){
			return true;
		}
	else{
			return false;	
		}
	}
public boolean detectAcceptableMove(){
	ArrayList<Entity> checkList = new ArrayList<Entity>(entityList);
	boolean interactiveEntityPresent = false;
	for(Entity e: checkList){
		if(e instanceof LivingEntity){
			interactiveEntityPresent = true;
		}
	}
	
	if(interactiveEntityPresent == false && detectClickWithTracker()){
		return true;
	}else{
		return false;
	}
}

public Position getDisplayPos() {
	return displayPos;
}

public void setDisplayPos(Position displayPos) {
	this.displayPos = displayPos;
}

public void addEntity(Entity e){
	entityList.add(e);
}

public Position getMapPos(){
	return mapPos;
}

public double establishDistance(Tile t){
	return Math.sqrt((Math.pow(Math.abs(mapPos.getX() - t.mapPos.getX()), 2) +
			Math.pow(Math.abs(mapPos.getY() - t.mapPos.getY()), 2))); 
}
}

