/**
 * @date Feb 20, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons.melee;

/**
 * @author AidanTheGreat
 *
 */
public enum MeleeWeaponTypes {
	/**Dagger, always light*/
	DAGGER,
	
	/**Shortsword, always medium*/
	SHORTSWORD,
	
	/**Longsword, always heavy*/
	LONGSWORD,
	
	/**Greatsword, always ultra-heavy*/
	GREATSWORD,
	
	/**Mace, medium or heavy*/
	MACE,
	
	/**Spear, light or medium*/
	SPEAR,
	
	/**Warhammer, heavy or ultra-heavy*/
	WARHAMMER,
	
	/**Axe, medium, heavy, or ultra-heavy*/
	AXE;
	
	int minDamage; //Type of "die" used
	int maxDamage; //Type of "die used
	
	int minRolls; //Number of times the "die" is "rolled"
	int maxRolls; //Number of times the "die" is "rolled"
	
	double minSpeed;
	double maxSpeed;
	
	int minReach;
	int maxReach;
	
	double minWeightClassVal;
	double modifier;
}
