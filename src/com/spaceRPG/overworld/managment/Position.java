package com.spaceRPG.overworld.managment;

import java.io.Serializable;

public class Position implements Serializable{
private static final long serialVersionUID = -8014724594779309329L;
private double xPosition;
private double yPosition;

public double getX(){
	return this.xPosition;
	}

public double getY(){
	return this.yPosition;
	}

public double[] getPosition(){
	double[] returnInt = new double[2];
	returnInt[0] = xPosition;
	returnInt[1] = yPosition;
	return returnInt;
}

public void setX(double d){
	this.xPosition = d;
}

public void setY(double d){
	this.yPosition = d;
}


public Position(int xPosition, int yPosition){
	this.xPosition = xPosition;
	this.yPosition = yPosition;
	}

public Position(double xPosition, double yPosition) {
	this.xPosition = xPosition;
	this.yPosition = yPosition;
}
}
