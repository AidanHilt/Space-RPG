/**
 * @date Feb 22, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.overworld.entities;

/**
 * @author AidanTheGreat
 *
 */
public interface LivingEntityMethods {
	
	public int getDefBonuses();
	
	public int getAtkBonuses();
	
	public void attack(Entity e);
	
	public int defend();
	
	public void showInfoCard();
	
	public int getDamReduction();
	
	public int getDamBonuses();
	
}
