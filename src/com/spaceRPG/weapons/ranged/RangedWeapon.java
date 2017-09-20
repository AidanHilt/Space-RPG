/**
 * @date Dec 22, 2015
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons.ranged;

import com.spaceRPG.weapons.RangedOrMelee;
import com.spaceRPG.weapons.Weapon;
import com.spaceRPG.weapons.WeightClass;



/**
 * @author AidanTheGreat
 *
 */
public class RangedWeapon extends Weapon{
Reciever reciever;
Magazine magazine;
Barrel barrel;

private double fireRate;
WeightClass weightClass;
int range;
double accuracy;

AmmoType ammoType = null;



public RangedWeapon(Reciever reciever, Magazine magazine, Barrel barrel, int rolls){
	this.reciever = reciever;
	this.magazine = magazine;
	this.barrel = barrel;
	this.rolls = rolls;
	this.fireRate = reciever.getROF();
	this.damage = reciever.getDamage();
	this.range = (int) ((reciever.getRange() * .9) + (barrel.getRange() * .1));
	this.accuracy = ((reciever.getAccuracy() * .1) + (barrel.getAccuracy() * .9));
	this.weaponType = RangedOrMelee.RANGED;
}

public double getFireRate() {
	return fireRate;
}

public double getAccuracy(){
	return accuracy;
	
}

public int getRange(){
	return range;
}
}
