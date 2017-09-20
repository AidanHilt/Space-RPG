/**
 * @date Feb 20, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons.melee;
import java.util.Random;

import com.spaceRPG.weapons.WeightClass;

/**
 * @author AidanTheGreat
 *
 */
public class MeleeWeaponGenerator {
	static Random r = new Random();
	
	public MeleeWeapon generateMeleeWeapon(){
		MeleeWeapon w = null;
		
		MeleeWeaponTypes t = null;
		
		//Determine weapon type
		int max = 7;
		int i = r.nextInt(max);
		
		switch(i){
			case 0: t = MeleeWeaponTypes.DAGGER;
					break;
			case 1: t = MeleeWeaponTypes.SHORTSWORD;
					break;
			case 2: t = MeleeWeaponTypes.LONGSWORD;
					break;
			case 3: t = MeleeWeaponTypes.GREATSWORD;
					break;
			case 4: t = MeleeWeaponTypes.MACE;
					break;
			case 5: t = MeleeWeaponTypes.SPEAR;
					break;
			case 6: t = MeleeWeaponTypes.WARHAMMER;
					break;
			case 7: t = MeleeWeaponTypes.AXE;
					break;
		}
		
		// XdY
		//Determine the damage, both the X = rolls, and Y = damage
		int damage = r.nextInt(t.maxDamage - t.minDamage) + t.minDamage;
		int rolls = r.nextInt(t.maxRolls - t.minRolls) + t.minRolls;
			
		//Determine reach
		int reach = r.nextInt(t.maxReach - t.minReach) + t.minReach;
		
		//Determine base attack speed
		double speed = t.minSpeed + (t.maxSpeed - t.minSpeed) * r.nextDouble();
		
		//Determine weight class
		double percOfRolls = rolls/t.maxRolls;
		double percOfDamage = damage/t.maxDamage;
		double percOfReach = reach/t.maxReach;
		
		double average = (percOfRolls + percOfDamage + percOfReach)
				/ 3;
		
		average *= t.modifier;
		
		if(average < t.minWeightClassVal){
			average = t.minWeightClassVal;
		}
		
		WeightClass weightClass = null;
		
		if(average >= .9){
			weightClass = WeightClass.ULTRA_HEAVY;
		}
		else if(average < .9 && average >= .6){
			weightClass = WeightClass.HEAVY;
		}
		else if(average < .6 && average >= .3){
			weightClass = WeightClass.MEDIUM;
		}
		else if(average > .3){
			weightClass = WeightClass.SMALL;
		}
		
		w = new MeleeWeapon(damage, rolls, speed, reach, t,
				weightClass);
		
		return w;
	}
}
