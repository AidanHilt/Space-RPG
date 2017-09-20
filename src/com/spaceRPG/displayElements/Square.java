package com.spaceRPG.displayElements;

import java.io.Serializable;

import mightyUtil.openGL.ShapeDrawing;

import com.spaceRPG.overworld.managment.Position;
/**
 * 
 * @author AidanTheGreat
 * A class used to represent squares to be drawn on the display. Is used by Tile class, among others
 */
public class Square implements Serializable{
	private static final long serialVersionUID = 7971448408765211103L;
	public Position pos;
	private double sideLength;
	private double sideHeight;
	
	private double red;
	private double blue;
	private double green;
	
	private double depth;
	/**
	 * 
	 * @param centerX - the x coordinate that the center of the square will be
	 * @param centerY = the y coordinate that the center of the square will be
	 * @param sideLength - how long each side of the square will be
	 * @param depth - how deep the square will be drawn
	 */
	public Square(Position pos, double sideLength, double sideHeight, double depth){
		this.pos = pos;
		this.setSideLength(sideLength);
		this.setSideHeight(sideHeight);
		this.setDepth(depth);
		
		this.red = 1;
		this.blue = 1;
		this.green = 1;
	}
	/**
	 * 
	 * @param centerX - the x coordinate that the center of the square will be
	 * @param centerY = the y coordinate that the center of the square will be
	 * @param sideLength - how long each side of the square will be
	 * @param depth - how deep the square will be drawn
	 * @param red - the redness of the square
	 * @param blue - the blueness of the square
	 * @param green - the greeness of the square
	 */
	public Square(Position pos, double sideLength, double sideHeight, double red, double blue, double green, double depth){
		this.pos = pos;
		this.setSideLength(sideLength);
		this.setSideHeight(sideHeight);
		this.setDepth(depth);
		
		this.red = red;
		this.blue = blue;
		this.green = green;
	}
	
	public Square(Position pos){
		this.pos = pos;
		this.red = 1;
		this.blue = 1;
		this.green = 1;
		
		this.setDepth(-2);
	}
	
	public Square(){
		this.red = 1;
		this.blue = 1;
		this.green = 1;
		
		this.setDepth(-3);
	}
	
	public void draw(){
		ShapeDrawing.drawSquare(pos.getX() - getSideLength() / 2 + 2.5, pos.getX() + getSideLength() / 2 - 2.5, pos.getY() + getSideHeight() / 2 - 2.5, pos.getY() - getSideHeight() / 2 + 2.5,
			red, blue, green, getDepth());
	}
	public double getSideLength() {
		return sideLength;
	}
	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}
	public double getSideHeight() {
		return sideHeight;
	}
	public void setSideHeight(double sideHeight) {
		this.sideHeight = sideHeight;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		this.depth = depth;
	}
}
