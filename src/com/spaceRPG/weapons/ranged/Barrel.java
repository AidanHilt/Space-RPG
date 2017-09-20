/**
 * @date Dec 22, 2015
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons.ranged;

/**
 * @author AidanTheGreat
 *
 */
public class Barrel {
	private double accuracy;
	
	public double getAccuracy(){
		return accuracy;
	}
	
	private double range;
	
	public double getRange(){
		return range;
	}
	
	private AmmoType ammoType;
	
	public AmmoType getAmmoType(){
		return ammoType;
	}
	
	public Barrel(double accuracy, int range, AmmoType ammoType){
		this.accuracy = accuracy;
		this.range = range;
		this.ammoType = ammoType;
	}
}
