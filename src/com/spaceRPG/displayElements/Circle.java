package com.spaceRPG.displayElements;

import java.io.Serializable;

import org.lwjgl.input.Mouse;

import com.spaceRPG.overworld.managment.Position;

import mightyUtil.openGL.ShapeDrawing;
/**
 * 
 * @author AidanTheGreat
 * @function Represents a circle for drawing on the screen, including having a method to draw itself automatically
 */
public class Circle implements Serializable{
	private static final long serialVersionUID = 1279192061954329525L;
	public Position pos;
	private double radius;
	
	private double red;
	private double blue;
	private double green;
	
	private double depth;
	
	/**
	 * @param x - the x coordinate of the circle
	 * @param y - the y coordinate of the circle
	 * @param radius - the radius of the circle
	 */
	public Circle(Position pos, double radius, double depth){
		this.pos = pos;
		this.radius = radius;
		this.depth = depth;
		red = 1;
		blue = 1;
		green = 1;
	}
	
	/**
	 * @param x - the x coordinate of the circle
	 * @param y - the y coordinate of the circle
	 * @param radius - the radius of the circle
	 * @param red - how red the circle is
	 * @param blue - how blue the circle is
	 * @param green - how green the circle is
	 */
	
	public Circle(Position pos, double radius, double red, double blue, double green, double depth){
		this.pos = pos;
		this.radius = radius;
		this.depth = depth;
		this.red = red;
		this.blue = blue;
		this.green = green;
	}
	
	/**
	 * Draws the circle on the screen using drawFilledCircle() method from ShapeDrawing class
	 */
	public void draw(){
		ShapeDrawing.drawFilledCircle(pos.getX(), pos.getY(), radius, red, blue, green, depth);
	}
	
	/**
	 * 
	 * @return boolean, whether or not the mouse clicked on the circle, taken by comparing the mouse x and y with the boundaries of the circle
	 */
	public boolean detectLeftMouseClicked(){
		return ( (Mouse.getX() < pos.getX() + radius & Mouse.getX() > pos.getX() - radius) & (Mouse.getY() < pos.getY() + radius & Mouse.getY() > pos.getY() - radius)
				&& Mouse.isButtonDown(0));
	}
	
	public boolean detectRightMouseClicked(){
		return ( (Mouse.getX() < pos.getX() + radius & Mouse.getX() > pos.getX() - radius) & (Mouse.getY() < pos.getY() + radius & Mouse.getY() > pos.getY() - radius)
				&& Mouse.isButtonDown(1));
	}

}
