/**
 * @date Dec 22, 2015
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons.ranged;

import com.spaceRPG.weapons.WeightClass;
import com.spaceRPG.weapons.ranged.attatchments.Attatchment;

/**
 * @author AidanTheGreat
 *
 */
public class Reciever {
	
	private AmmoType ammoType;
	
	public AmmoType getAmmoType() {
		return ammoType;
		}

	private int damage;

	public int getDamage(){
		return damage;
	}

	private int range;

	public int getRange(){
		return range;
	}

	private double rateOfFire;

	public double getROF(){
		return rateOfFire;
	}

	private double accuracy;

	public double getAccuracy(){
		return accuracy;
	}

	private WeightClass weight;

	public WeightClass getWeight(){
		return weight;
	}
	
	Attatchment attatchment;

	public Reciever(int damage, int range, double ROF, double accuracy, WeightClass weight){
		this.damage = damage;
		this.range = range;
		this.rateOfFire = ROF;
		this.accuracy = accuracy;
		this.weight = weight;
	}


}
