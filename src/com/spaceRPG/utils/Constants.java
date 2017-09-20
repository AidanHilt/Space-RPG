package com.spaceRPG.utils;

import java.awt.Font;
import java.io.File;

import org.lwjgl.Sys;
import org.newdawn.slick.TrueTypeFont;

import com.spaceRPG.overworld.Map;
import com.spaceRPG.overworld.entities.InteractiveEntity;

public class Constants {
public static boolean selectableEntitySelected = false;
private static Map currentMap;

public final static File initialSaveDirectory = new File("C:/Users/" + System.getProperty("user.name") + "/Imperium Studios/SpaceRPG/");

private static long lastFrame;
public static boolean isCircleTrackerActive;

/** InteractiveEntity instance with currently active CircleTracker*/
public static InteractiveEntity entityOnDeck;

private static long getTime(){
	return (Sys.getTime() * 1000) / Sys.getTimerResolution();
}

public static long getDelta(){
	long currentTime = getTime();
	long delta = (currentTime - lastFrame);
	lastFrame = getTime();
	return delta;
}

public static Map getCurrentMap() {
	return currentMap;
}

public static void setCurrentMap(Map currentMap) {
	Constants.currentMap = currentMap;
	currentMap.manageTiles();
	currentMap.m.init();
}

public static final double mapOffset = .15;


public static final int MAP_LOAD_FAILURE = 2;
public static final int MAP_SAVE_FAILURE = 3;

//Stat alteration codes
//{{
public static final int CAST_ATTACK_SPEED = 100;
public static final int ENERGY_POOL = 101;
public static final int ENERGY_REGEN = 102;
public static final int ENERGY_COST = 103;
public static final int MELEE_DAM = 104;
public static final int CRITICAL_CHANCE = 105;
//}}

//Announcement codes
//{{
//Player actions
public static final int PLAYER_ATTACKS = 200;
public static final int PLAYER_IS_ATTACKED = 201;
public static final int PLAYER_IS_DAMAGED = 202;
public static final int PLAYER_CASTS = 203;
//}}

//Enemy actions
//{{
public static final int ENEMY_ATTACKS = 204;
public static final int ENEMY_IS_ATTACKED = 205;
public static final int ENEMY_IS_DAMAGED = 206;
public static final int ENEMY_CASTS = 207;
//}}

public static int getStatModifier(int checkedStat){
	int i = 0;
	
	if(i == 1){
		i = -5;
	}
	
	else if(i == 2 || i == 3){
		i = -4;
	}
	
	else if(i == 4 || i == 5){
		i = -3;
	}
	
	else if(i == 6 || i == 7){
		i = -2;
	}
	
	else if(i == 8 || i == 9){
		i = -1;
	}
	
	else if(i == 10 || i == 11){
		i = 0;
	}
	
	else if(i == 12 || i == 13){
		i = 1;
	}
	
	else if(i == 14 || i == 15){
		i = 2;
	}
	
	else if(i == 16 || i == 17){
		i = 3;
	}
	
	else if(i == 18 || i == 19){
		i = 4;
	}
	
	else if(i == 20 || i == 21){
		i = 5;
	}
	
	else if(i == 22 || i == 23){
		i = 6;
	}
	
	else if(i == 24 || i == 25){
		i = 7;
	}
	
	else if(i == 26 || i == 27){
		i = 8;
	}
	
	else if(i == 28 || i == 29){
		i = 9;
	}
	
	else if(i == 30 || i == 31){
		i = 10;
	}
	
	else if(i == 32 || i == 33){
		i = 11;
	}
	
	else if(i == 34 || i == 35){
		i = 12;
	}
	
	else if(i == 36 || i == 37){
		i = 13;
	}
	
	else if(i == 38 || i == 39){
		i = 14;
	}
	
	else if(i == 40 || i == 41){
		i = 15;
	}
	
	else if(i == 42 || i == 43){
		i = 16;
	}
	
	else if(i == 44 || i == 45){
		i = 17;
	}
	
	return i;
	}

//Test Font
//{{

static Font text;
public static TrueTypeFont testFont;

//}}
}


