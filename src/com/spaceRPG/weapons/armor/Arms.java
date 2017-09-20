/**
 * @date Feb 22, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons.armor;

/**
 * @author AidanTheGreat
 *
 */
public class Arms extends Armor {

	/* (non-Javadoc)
	 * @see com.spaceRPG.weapons.armor.ArmorMethods#getProtection()
	 */
	@Override
	public int getProtection() {
		return protection;
	}

	/* (non-Javadoc)
	 * @see com.spaceRPG.weapons.armor.ArmorMethods#hasEffect()
	 */
	@Override
	public boolean hasEffect() {
		return hasEffect;
	}

}
