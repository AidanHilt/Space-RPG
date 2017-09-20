package Test;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.spaceRPG.overworld.managment.MapIO;
import com.spaceRPG.utils.Constants;
import com.spaceRPG.utils.fonts.InitFonts;

import mightyUtil.openGL.GL_Setup;

public class TestMaps {
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		TestMapPackageWrapperVersion m = new TestMapPackageWrapperVersion();
		Constants.setCurrentMap(m.m2);
		GL_Setup.setupGL(600, 600, "Name");
		Constants.getCurrentMap().manageTiles();
		Constants.getCurrentMap().m.init();
		while(!Display.isCloseRequested()){
			Constants.getCurrentMap().draw();
			Constants.getCurrentMap().m.run();
			Display.update();
			Display.sync(120);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		}
		System.exit(0);
	
	}
}
