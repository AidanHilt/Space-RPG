package com.spaceRPG.overworld;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import com.spaceRPG.overworld.managment.MapRegistry;
import com.spaceRPG.overworld.managment.Position;
import com.spaceRPG.utils.Constants;

import mightyUtil.openGL.GL_Setup;
/**
 * 
 * @author AidanTheGreat
 * A class that is used to hold a collection of Tiles, as well as providing ways for entities and tiles to interact, and supporting saving and loading features
 */
public class Map implements Serializable{
private static final long serialVersionUID = -6932401632178736270L;
private ArrayList<Tile> mapContents = new ArrayList<Tile>();
private String name;
private int length;
private int width;
public MapRegistry m;
File data = new File("C:/Users/" + System.getProperty("user.name") + "/Imperium Studios/SpaceRPG/Map Saves/" + this.name);


public File getData(){
	return data;
}
/**
 * 
 * @param name: The name that the map will be referred to as
 * @param length: The length of the map
 * @param width: The width of the map
 * @param mapContents: The tiles that will make up the map
 */
public Map(String name, int length, int width, Tile... mapContents){
	this.setLength(length);
	this.setWidth(width);
	this.name = name;
	data = new File("C:/Users/" + System.getProperty("user.name") + "/Imperium Studios/SpaceRPG/Map Saves/" + this.name);
	m = new MapRegistry(this);
	if(mapContents.length > length * width){
		throw new IllegalArgumentException("Number of tiles exceeded dimensions of the map" + " " + name);
	}
	else{
		for(Tile t: mapContents){
			this.mapContents.add(t);
		}
	}
}
/**
 * Iterates over the tile list and invokes the draw() methd of each
 */
public void draw(){
	for(Tile t: getMapContents()){
		t.draw();
	}
}
/**
 * Determines the size of each tile based on the current size of the display, and assigns each Tile's square object accordingly, taking into account the Tile's mapPos
 */
public void manageTiles(){
	int sideLength = GL_Setup.getWIDTH() / length;
	int sideHeight = (int) ((GL_Setup.getHEIGHT() - GL_Setup.getHEIGHT() * Constants.mapOffset) / width);
	double xForConstructor;
	double yForConstructor;
	for(Tile t: mapContents){
		if(t.mapPos.getX() == 1){
			xForConstructor = (sideLength / 2);
		}else{
			xForConstructor = (( GL_Setup.getWIDTH()  / getLength()) * t.mapPos.getX()) - sideLength / 2;
		}
		if(t.mapPos.getY() == 1){
			yForConstructor = (sideHeight / 2);
		}else{
			yForConstructor = (( (GL_Setup.getHEIGHT() - GL_Setup.getHEIGHT() * Constants.mapOffset) / getWidth()) * t.mapPos.getY()) - sideHeight / 2;
		}
		
		t.setDisplayPos(new Position(xForConstructor, yForConstructor));
		t.s.pos = t.getDisplayPos();
		t.s.setSideLength(sideLength);
		t.s.setSideHeight(sideHeight);
		t.m = this;
		
		/**
		System.out.println("--------------New Tile---------------");
		System.out.println("Square X: " + t.s.pos.getX());
		System.out.println("Square Y: " + t.s.pos.getY());
		System.out.println("Square length: " + t.s.getSideLength());
		System.out.println("Square height: " + t.s.getSideHeight());
		*/
		}
	}

public ArrayList<Tile> getMapContents(){
	return mapContents;
}

public void addTile(Tile t){
	mapContents.add(t);
}

/**
public void saveMap(){
	FileOutputStream o = null;
	ObjectOutputStream out = null;
	
	try{
		o = new FileOutputStream(data);
		out = new ObjectOutputStream(o);
		out.writeObject(this);
	} catch(FileNotFoundException e){
			try {	
				Files.createFile(data.toPath());
				out.writeObject(this);
			} catch (IOException e1) {
				e1.printStackTrace();}
	
	}catch(FileAlreadyExistsException e){
		
	}
	catch (IOException e) {
		e.printStackTrace();
		System.exit(Constants.MAP_SAVE_FAILURE);
	}
}

public void loadMap(){
	try(FileInputStream i = new FileInputStream(data); ObjectInputStream in = new ObjectInputStream(i)){
		Constants.setCurrentMap((Map) in.readObject());
		Constants.getCurrentMap().manageTiles();
		Constants.getCurrentMap().m.init();
	} catch (IOException e) {
		e.printStackTrace();
		System.exit(Constants.MAP_LOAD_FAILURE);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.exit(Constants.MAP_LOAD_FAILURE);
	}
}
*/

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getLength() {
	return length;
}

public void setLength(int length) {
	this.length = length;
}

public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}
public void setMapContents(ArrayList<Tile> mapContents) {
	this.mapContents = mapContents;
	
}

}

