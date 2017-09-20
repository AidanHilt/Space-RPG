/**
 * @date Oct 22, 2016
 * @author AidanTheGreat
 * @version Alpha 1.0
 * @function Provide skill tree for player's advancement
 */
package com.spaceRPG.advancement;

public class SkillTree {
	
	/**
	 * The integers that hold the values of the skills on the scale
	 */
	private int Melee;
	private int Guns;
	private int Casts;
	private int Strength;
	private int Agility;
	private int Constitution;
	private int Intelligence;
	private int Charisma; 
	
	/**
	 * Final, static values to pass to increaseSkill()
	 */
	
	public static final int melee = 0;
	public static final int guns = 1;
	public static final int casts = 2;
	public static final int strength = 3;
	public static final int agility = 4;
	public static final int intelligence = 5;
	public static final int charisma = 6;
	public static final int constitution = 7;
	
	private boolean meleeMax = false;
	public boolean getMeleeMax(){
		return meleeMax;
	}
	
	private boolean gunsMax = false;
	public boolean getGunsMax(){
		 return gunsMax;
	}
	
	private boolean castsMax = false;
	public boolean getCastsMax(){
		return castsMax;
	}
	
	private boolean chaMax = false;
	public boolean getChaMax(){
		return chaMax;
	}
	
	public void increaseSkill(int skill){
		switch(skill) {
		case(0): 
			if(Melee + 1 < 12){
				Melee++;
			}
		case(1): 
			if(Guns + 1 < 12){
				Guns++;
			}
		case(2): 
			if(Casts + 1 < 12){
				Casts++;
			}
		case(3): 
			if(Strength + 1 < 12){
				Strength++;
			}
		
		case(4):
			if(Constitution + 1 < 12){
				Constitution ++;
			}
			
		case(5): 
			if(Agility + 1 < 12){
				Agility++;
			}
			
		case(6): 
			if(Intelligence + 1 < 12){
				Intelligence++;
			}
		case(7): 
			if(Charisma + 1 < 12){
				Charisma++;
			}
		}
		
	}
	
	public void assignBonuses(){
		
		}
	}