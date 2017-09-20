package com.spaceRPG.overworld.managment;

import java.io.Serializable;
import java.util.ArrayList;

import com.spaceRPG.overworld.Map;
import com.spaceRPG.overworld.Tile;
import com.spaceRPG.overworld.entities.Entity;
import com.spaceRPG.overworld.entities.InteractiveEntity;
import com.spaceRPG.playerCharacter.Player;
import com.spaceRPG.utils.Constants;

public class MapRegistry implements Serializable{
private static final long serialVersionUID = -8138977670870016717L;
private Map m;
private ArrayList<Entity> entityList = new ArrayList<Entity>();

public void init(){
	for(Tile t: m.getMapContents()){
		for(Entity e : t.entityList){
			if(!entityList.contains(e)){
				entityList.add(e);
			}
		}
	}
	for(Entity e : getEntityList()){
		e.calculateSize();
		}
	}

private void manageEntities(){
	long delta = Constants.getDelta();
	if(delta > 1000){
		delta = Constants.getDelta();
	}
	for(Entity e : entityList){
		if(e != null){
			e.update(delta);
		}
	}
}

//*Sets the fonts of the entities equal to null so that the entities can be saved*/
protected void cleanEntityText(){
	for(Entity e: entityList){
		if(e instanceof InteractiveEntity){
			((InteractiveEntity) e).testUseFont = null;
		}
	}
}

private void removeEntities(){
	ArrayList<Entity> removeList = new ArrayList<Entity>();
	for(Entity e: entityList){
		if(!e.getAlive()){
			removeList.add(e);
		}
	}
	
	for(Entity e: removeList){
		entityList.remove(e);
	}
}

public void run(){
	manageEntities();
	removeEntities();
	manageNewEntities();
}
	
public MapRegistry(Map m){
	this.m = m;
}

public ArrayList<Entity> getEntityList() {
	return entityList;
}

public void addEntity(Entity e){
	 entityList.add(e);
}
private void manageNewEntities(){
	for(Tile t: m.getMapContents()){
		for(Entity e: t.entityList){
			if(!entityList.contains(e)){
				entityList.add(e);
			}
		}
	}
}
}

