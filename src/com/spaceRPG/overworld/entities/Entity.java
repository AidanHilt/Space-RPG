package com.spaceRPG.overworld.entities;

import java.io.Serializable;

import com.spaceRPG.overworld.Tile;

public abstract class Entity implements Serializable{
private static final long serialVersionUID = 2523256705825616191L;
Tile location;
double hp;
boolean alive = true;

void draw(){
	
}

public void update(long delta){
	
}

public void pollInput(){
	
}

public void calculateSize(){
	
}

public Tile getLocation() {
	return location;
}

public void setLocation(Tile location) {
	this.location = location;
}

public boolean getAlive(){
	return alive;
}

public int defend(){
	return 0;
}

public int getArmorRating(){
	return 0;
}

public void takeDamage(double total){
	
}

public void announce(int announcementCode){
	//TODO Add call to armor, weapons, and all other possible equipment
}
}
