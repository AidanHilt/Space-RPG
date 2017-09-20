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
public class Helmet extends Armor {

	@Override
	public int getProtection() {
		return protection;
	}

	@Override
	public boolean hasEffect() {
		return hasEffect;
	}

}
