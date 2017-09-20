/**
 * @date Jan 17, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons.ranged;

import java.util.Random;

import com.spaceRPG.weapons.WeightClass;

/**
 * @author AidanTheGreat
 *
 */
public class RangedWeaponGenerator {
	private static Reciever reciever;
	private static Barrel barrel;
	private static Magazine magazine;
	private static AmmoType ammoType;
	
	private static Random r = new Random();
	
	public static RangedWeapon generateWeapon(){
		//Determine the ammo type of the weapon
		ammoType = AmmoType.getAmmoType();
		
		//Determine the size of the clip and generate the object
		int clipSize = r.nextInt(ammoType.getMaxClip() - ammoType.getMinClip())
				+ ammoType.getMinClip();
		magazine = new Magazine(clipSize, ammoType);
		
		//Determine the barrel and generate
		
		//Accuracy stat for barrel
		double minVal = .8;
		double maxVal = 1.3;
		double modifier = minVal + (maxVal - minVal) * r.nextDouble();
		double accuracyBa = ammoType.getAccuracy() * modifier;
		
		//Range stat for barrel
		double minVal1 = .25;
		double maxVal1 = 1.75;
		modifier = minVal1 + (maxVal1 - minVal1) * r.nextDouble();
		int rangeBa = (int) (ammoType.getRange() * modifier);
		
		barrel = new Barrel(accuracyBa, rangeBa, ammoType);
		
		//Determine the reciever and generate
		
		//Damage stat for reciever
		modifier = minVal + (maxVal - minVal) * r.nextDouble();
		int damageRe = (int) (ammoType.getDamage() * modifier);
		
		//Range stat for reciever
		modifier = minVal + (maxVal - minVal) * r.nextDouble();
		int rangeRe = (int) (ammoType.getRange() * modifier);
		
		//Accuracy stat for reciever
		modifier = minVal + (maxVal - minVal) * r.nextDouble();
		double accuracyRe = ammoType.getAccuracy() * modifier;
		
		//Rate of fire for reciever
		modifier = minVal + (maxVal - minVal) * r.nextDouble();
		double rateOfFire = ammoType.getRateOfFire() * modifier;
		
		//Rolls for damage
		int rolls = r.nextInt(ammoType.getMaxRolls() - ammoType.getMinRolls())
				+ ammoType.getMinRolls();
		
		//Weight class calculation
		WeightClass weightClass = null;
		double i = damageRe / ammoType.getDamage();
		double i2 = clipSize / ammoType.getMaxClip();
		double i3 = rolls / ammoType.getMaxRolls();
		double value = ((i + i2 + i3) / 3);
		
		if(value < ammoType.weightClassMinVal){
			value = ammoType.weightClassMinVal;
		}
		
		if(value <= 1 && value > .9){
			weightClass = WeightClass.ULTRA_HEAVY;
		}
		else if(value <= .9 && value > .65){
			weightClass = WeightClass.HEAVY;
		}
		else if(value <= .65 && value > .3){
			weightClass = WeightClass.MEDIUM;
		}
		else if(value <= .3){
			weightClass = WeightClass.SMALL;
		}
		
		
		
		reciever = new Reciever(damageRe, rangeRe, rateOfFire, accuracyRe, weightClass);
		
		return new RangedWeapon(reciever, magazine, barrel, rolls);

	}
}
