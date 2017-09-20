/**
 * @date Dec 22, 2015
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons;

import com.spaceRPG.items.Item;
import com.spaceRPG.overworld.entities.Entity;
import com.spaceRPG.utils.Die;

/**
 * @author AidanTheGreat
 *
 */
public abstract class Weapon extends Item{
protected RangedOrMelee weaponType;

protected int rolls;
protected double damage;
protected int levelRequirement;

public int getLevelReq(){
	return levelRequirement;
}

public RangedOrMelee getWeaponType(){
	return weaponType;
}

public void attack(Entity e, double... bonuses){
	double total = 0;
	
	for(int i = 0; i < rolls; i++){
		total += Die.roll(damage);
	}
	
	for(double d: bonuses){
		total += total * d;
	}
	
	e.takeDamage(total);
	System.out.println("Attack landed, did " + total + " damage");
}
}
