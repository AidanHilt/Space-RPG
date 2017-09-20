/**
 * @date May 17, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package Test;

import java.awt.Font;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.spaceRPG.displayElements.Circle;
import com.spaceRPG.overworld.managment.Position;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import mightyUtil.internalUtil.Constants;
import mightyUtil.openGL.GL_Setup;
import mightyUtil.openGL.ShapeDrawing;

/**
 * @author AidanTheGreat
 *
 */
public class TextDrawing {
	public static void main(String[] args){
		Circle c = new Circle(new Position(250, 400), 50, -1);
		GL_Setup.setupGL(500, 500, "Text");
	
		while(!Display.isCloseRequested()){
			c.pos = new Position(c.pos.getX(), c.pos.getY() - 5);
			c.draw();
			drawString(100f, 100f, "Test", Color.white, new Text().font);
			Display.update();
			Display.sync(120);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			
		}
	}
	
	static void drawString(float x, float y, String text, Color color, TrueTypeFont drawFont){
		GL11.glPopMatrix();
		GL11.glLoadIdentity();
		GL11.glOrtho(0, GL_Setup.getWIDTH(), GL_Setup.getHEIGHT(), 0, 1, -1);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        drawFont.drawString(x, y, text, color);
        GL11.glPushMatrix(); 
        GL11.glLoadIdentity();
        GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ZERO);
        GL11.glOrtho(0, GL_Setup.getWIDTH(), 0, GL_Setup.getHEIGHT(), 1, 10);
	}
	
}

class Text{
	TrueTypeFont font;
	Font awtFont; 
	Text(){
		awtFont	= new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
	}
}
