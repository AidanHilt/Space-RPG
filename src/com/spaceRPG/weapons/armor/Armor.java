/**
 * @date Feb 22, 2016
 * @author AidanTheGreat
 * @version 1.0
 * @function Abstract base for all items of type ARMOR
 */
package com.spaceRPG.weapons.armor;

import com.spaceRPG.items.Item;
import com.spaceRPG.weapons.WeightClass;

/**
 * @author AidanTheGreat
 *
 */
public abstract class Armor extends Item implements ArmorMethods  {
	
	protected int protection;
	protected boolean hasEffect;
	
	protected WeightClass weightClass;
	
	public WeightClass getWeightClass(){
		return weightClass;
	}
}
