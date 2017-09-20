/**
 * @date Dec 22, 2015
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.utils;

import java.util.Random;

public class Die {
private static Random random = new Random();

public static int roll(int size){
	return random.nextInt(size - 1) + 1;
	}

public static double roll(double size) {
	return random.nextDouble() * size;
	}
}
