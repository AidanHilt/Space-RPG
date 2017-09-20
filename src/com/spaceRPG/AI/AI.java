/**
 * @date Jun 15, 2016
 * @author AidanTheGreat
 * @version Pre-alpha 1.0
 * @function Currently only a placeholder class, will be used as the AI engine that runs the InteractiveEntities representing
 * enemies
 */
package com.spaceRPG.AI;

import com.spaceRPG.weapons.Weapon;

/**
 * @author AidanTheGreat
 *
 */
public abstract class AI {

	/**
	 * @arguments none
	 * @author AidanTheGreat
	 * @function Return the melee skill of the enemy AI
	 * @returnType int
	 */
	public int getMelee() {
		// TODO Provide melee skill score
		return 0;
	}

	/**
	 * @arguments none
	 * @author AidanTheGreat
	 * @function Return the weapon possessed by the enemy AI
	 * @returnType Weapon
	 */
	public Weapon getWeapon() {
		// TODO Make it return the weapon of the AI
		return null;
	}

	/**
	 * @arguments none
	 * @author AidanTheGreat
	 * @function Return the guns skill of the enemy AI
	 * @returnType int
	 */
	public int getGuns() {
		// TODO Have it return the guns skill
		return 0;
	}

}
