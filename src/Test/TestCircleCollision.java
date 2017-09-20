package Test;

import mightyUtil.openGL.GL_Setup;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.spaceRPG.displayElements.Circle;
import com.spaceRPG.overworld.managment.Position;

public class TestCircleCollision {
static Circle c = new Circle(new Position(500, 300), 100, -1);
static double time = System.currentTimeMillis();
static double secondTime = System.currentTimeMillis() + 500;

public static void main(String[] args){
	GL_Setup.setupGL(1000, 600, "Name");
	while(!Display.isCloseRequested()){
		double check = (1f / 2f) * 1000f;
		c.draw();
		Display.update();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		secondTime = System.currentTimeMillis();
		if(c.detectLeftMouseClicked() == true && secondTime - time >= check){
			System.out.println("Functioning");
			time = System.currentTimeMillis();
			}
		}
	System.exit(0);
	}
}
