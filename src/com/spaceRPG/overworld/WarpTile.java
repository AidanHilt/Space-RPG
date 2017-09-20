package com.spaceRPG.overworld;

import com.spaceRPG.displayElements.Square;
import com.spaceRPG.overworld.entities.InteractiveEntity;
import com.spaceRPG.overworld.managment.MapIO;
import com.spaceRPG.overworld.managment.Position;


public class WarpTile extends Tile {
private static final long serialVersionUID = 7368088799888164944L;
public Map sendingMap;
Map currentMap;
WarpTile receivingTile;
	
	public WarpTile(Position mapPos, Map sendingMap, Map currentMap, WarpTile receivingTile) {
		super(mapPos);
		this.sendingMap = sendingMap;
		this.receivingTile = receivingTile;
		this.currentMap = currentMap;
		this.s = new Square(new Position(0, 0), 0, 0, 0, 1, 0, -3);
		}
	
	public WarpTile(Position mapPos, Map sendingMap, Map currentMap) {
		super(mapPos);
		this.sendingMap = sendingMap;
		this.currentMap = currentMap;
		this.s = new Square(new Position(0, 0), 0, 0, 0, 1, 0, -3);
		}
	
	public void moveEntity(InteractiveEntity e){
		e.warpInstantly(receivingTile);
		sendingMap.m.addEntity(e);
	}
	
	private void changeMaps(){
		MapIO.saveMap(currentMap);
		MapIO.loadMap(sendingMap);
	}
	
	public void movePlayer(InteractiveEntity e){
		changeMaps();
		moveEntity(e);
		//System.out.println("Player Changed");
	}
	
	public WarpTile getReceivingTile(){
		return receivingTile;
	}
	
	public void alterSendingMap(Map m){
		this.sendingMap = m;
	}
	
	public void alterCurrentMap(Map m){
		this.currentMap = m;
	}
	
	public void addReceivingTile(WarpTile t){
		this.receivingTile = t;
	}

}
