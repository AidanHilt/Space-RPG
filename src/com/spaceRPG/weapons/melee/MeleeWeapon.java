/**
 * @date Feb 20, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons.melee;

import com.spaceRPG.weapons.RangedOrMelee;
import com.spaceRPG.weapons.Weapon;
import com.spaceRPG.weapons.WeightClass;

/**
 * @author AidanTheGreat
 *
 */
public class MeleeWeapon extends Weapon {
	WeightClass weightClass;
	
	private double attackSpeed;
	private int reach;
	MeleeWeaponTypes melWeaTyp;


	public MeleeWeapon(int damage, int rolls, double attackSpeed,
			int reach, MeleeWeaponTypes melWeaType,
			WeightClass weightClass){
		this.damage = damage;
		this.rolls = rolls;
		this.attackSpeed = attackSpeed;
		this.reach = reach;
		this.melWeaTyp = melWeaType;
		this.weightClass = weightClass;
		this.weaponType = RangedOrMelee.MELEE;
	}


	public double getAttackSpeed() {
		return attackSpeed;
	}

	public int getReach() {
		return reach;
	}

}
