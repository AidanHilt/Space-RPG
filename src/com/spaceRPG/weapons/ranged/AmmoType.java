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
public enum AmmoType {

/** 50 caliber ammunition*/
CAL_50,

/** 75 caliber ammunition*/
CAL_75,

/** 22 caliber ammunition*/
TWENTY_TWO,

/** 9 millimieter ammunition*/
MIL_9,

/** 5.56 NATO ammunition*/
MIL_556,

/** Small plasma capsule*/
PLASMA_CAPSULE_SMALL,

/** Medium plasma capsule*/
PLASMA_CAPSULE_MEDIUM,

/** Large plasma capsule*/
PLASMA_CAPSULE_LARGE,

/** Small laser matrix*/
LASER_MATRIX_SMALL,

/** Medium laser matrix*/
LASER_MATRIX_MEDIUM,

/** Large laser matrix*/
LASER_MATRIX_LARGE,

/** Light rocket*/
ROCKET_LIGHT,

/** Heavy rocket*/
ROCKET_HEAVY,

/** 25 mm grenade*/
GRENADE_25MM,

/** 40 mm grenade*/
GRENADE_40MM,

/** 12 gauge slug*/
SLUG_12_GAUGE,

/** 20 gauge slug*/
SLUG_20_GAUGE,

/** 12 gauge buckshot*/
SHOT_12_BUCK,

/** 12 gauge birdshot*/
SHOT_12_BIRD,

/** 20 gauge buckshot*/
SHOT_20_BUCK,

/** 20 gauge birdshot*/
SHOT_20_BIRD;

int minimumClip;

int maximumClip;

int damage; //Damage dealt
int minRolls; //Number of rolls
int maxRolls;

double accuracy;

double rateOfFire;

int range;

double weightClassMinVal;

int selectionNumber;

public int getDamage(){
	return 5;
}

public static AmmoType getAmmoType(){
	return SHOT_20_BIRD;
}

public int getMinClip(){
	return 0;
}

public int getMaxClip(){
	return 5;
}

public double getAccuracy(){
	return 1;
}

public double getRateOfFire(){
	return .5;
}

public int getRange(){
	return 4;
}

public double getWeightClassMinVal(){
	return .5;
}

public int getMaxRolls(){
	return 5;
}

public int getMinRolls(){
	return 1;
}

/**
private AmmoType(int minimumClip, int maximumClip){
	this.minimumClip = minimumClip;
	this.maximumClip = maximumClip;
}
*/

}
