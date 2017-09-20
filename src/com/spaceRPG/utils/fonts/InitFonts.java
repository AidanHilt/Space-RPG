/**
 * @date Jun 4, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.utils.fonts;

import java.awt.Font;
import java.io.Serializable;

import org.newdawn.slick.TrueTypeFont;

/**
 * @author AidanTheGreat
 *
 */
public class InitFonts implements Serializable{
	public TrueTypeFont testFont;
	
	public InitFonts(){
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		testFont = new TrueTypeFont(awtFont, false);
	}
}
