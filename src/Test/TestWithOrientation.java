/**
 * @date May 20, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package Test;

import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import com.spaceRPG.displayElements.Circle;
import com.spaceRPG.overworld.managment.Position;

/**
 * @author AidanTheGreat
 *
 */
public class TestWithOrientation {
	public static void main(String[] args){
		try {
			Display.setDisplayMode(new DisplayMode(500, 500));
			Display.setTitle("Display");
			Display.create();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);
	        GL11.glShadeModel(GL11.GL_SMOOTH);        
	        GL11.glDisable(GL11.GL_DEPTH_TEST);
	        GL11.glDisable(GL11.GL_LIGHTING); 
	        
	        GL11.glEnable(GL11.GL_BLEND);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		
		GL11.glOrtho(0, 500, 500, 0, 1, -5);
		Circle c = new Circle(new Position(250, 250), 50, -1);
		//Font awtFont = new Font("Times New Roman", Font.BOLD, 24);; 
		//TrueTypeFont font = new TrueTypeFont(awtFont, false);; 
		
		
		
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT| GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ZERO);
			c.draw();
			GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glVertex2d(250,  500);
				GL11.glVertex2d(150, 300);
				GL11.glVertex2d(350, 300);
		 	GL11.glEnd();
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			new TextSetup().font.drawString(100, 100, "Test", Color.white);
			//font.drawString(100, 100, "Test", Color.white);
			
			Display.update();
			Display.sync(30);
		}
		System.exit(0);
	}

}

class TextSetup{
	Font awtFont; 
	TrueTypeFont font; 
	
	TextSetup(){
		awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
	}
}
