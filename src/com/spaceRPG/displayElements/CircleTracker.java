package com.spaceRPG.displayElements;

import java.io.Serializable;

import mightyUtil.openGL.ShapeDrawing;

import org.lwjgl.input.Mouse;
/**
	 * A circle tracker used after the player character is selected to move him/her around. Consists of a trail of smaller circles behind a larger circle, located at the mouse
	 * @author AidanTheGreat
	 */
public class CircleTracker implements Serializable{
	private static final long serialVersionUID = -3725861356856393573L;
	
	
	private double firstX;
	private double firstY;
	private final double sizeOfBiggerCircle = 50;
	private final double sizeOfSmallerCircle = sizeOfBiggerCircle / 2;
	private int circleNumber;
	private final double spacing = 85;
	double hypotenuse;
	
	private double red = 1;
	private double blue = 0;
	private double green = 0;

	public void draw() {
		
		ShapeDrawing.drawFilledCircle(Mouse.getX(), Mouse.getY(), sizeOfBiggerCircle, red, blue, green, -1);
		
		determineCircleNumbers();
		
		for(int count = 1; count < circleNumber + 1; count ++){
			ShapeDrawing.drawFilledCircle( ((((Mouse.getX() - firstX) / circleNumber)) * count) + firstX, ((((Mouse.getY() - firstY) / circleNumber)) * count) + firstY, sizeOfSmallerCircle, 
					red, blue, green, -1);
		}
	}
	
	public CircleTracker(double firstX, double firstY){
		this.firstX = firstX;
		this.firstY = firstY;
		determineCircleNumbers();
	}
	
	public CircleTracker(double firstX, double firstY, double red, double blue, double green){
		this.firstX = firstX;
		this.firstY = firstY;
		this.red = red;
		this.blue = blue;
		this.green = green;
		determineCircleNumbers();
	}
	
	private void determineCircleNumbers(){
		hypotenuse = Math.sqrt(Math.pow((Mouse.getX() - firstX), 2) + Math.pow((Mouse.getY() - firstY), 2));
		circleNumber = (int)(hypotenuse / (sizeOfSmallerCircle + spacing));
	}

}