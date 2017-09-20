/**
 * @date Dec 22, 2015
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.weapons.ranged;

/**
 * @author AidanTheGreat
 *
 */
public class Magazine {
	
	private AmmoType ammoType;
	
	public AmmoType getAmmoType(){
		return ammoType;
	}
	
	private int clipSize;
	
	public int getClipSize(){
		return clipSize;
	}
	
	public Magazine(int clipSize, AmmoType ammoType){
		this.clipSize = clipSize;
		this.ammoType = ammoType;
	}

}
