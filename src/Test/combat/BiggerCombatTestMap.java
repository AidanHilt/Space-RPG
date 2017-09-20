/**
 * @date May 17, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package Test.combat;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import mightyUtil.openGL.GL_Setup;

import com.spaceRPG.overworld.Map;
import com.spaceRPG.overworld.Tile;
import com.spaceRPG.overworld.entities.InteractiveEntity;
import com.spaceRPG.overworld.entities.LivingEntity;
import com.spaceRPG.overworld.managment.Position;
import com.spaceRPG.utils.Constants;
import com.spaceRPG.weapons.ranged.RangedWeaponGenerator;

import Test.TestMapPackageWrapperVersion;

/**
 * @author AidanTheGreat
 *
 */
public class BiggerCombatTestMap {
	
	static Tile t1 = new Tile(new Position(1, 1), new LivingEntity());
	static Tile t2 = new Tile(new Position(1, 2));
	static Tile t3 = new Tile(new Position(1, 3));
	static Tile t18 = new Tile(new Position(1, 4));
	static Tile t4 = new Tile(new Position(1, 5));
	static Tile t5 = new Tile(new Position(1, 6));
	
	static Tile t6 = new Tile(new Position(2, 1));
	static Tile t7 = new Tile(new Position(2, 2));
	static Tile t8 = new Tile(new Position(2, 3));
	static Tile t9 = new Tile(new Position(2, 4));
	static Tile t10 = new Tile(new Position(2, 5));
	static Tile t11 = new Tile(new Position(2, 6));
	
	static Tile t12 = new Tile(new Position(3, 1));
	static Tile t13 = new Tile(new Position(3, 2));
	static Tile t14 = new Tile(new Position(3, 3));
	static Tile t15 = new Tile(new Position(3, 4));
	static Tile t16 = new Tile(new Position(3, 5));
	static Tile t17 = new Tile(new Position(3, 6), new InteractiveEntity());
	
	public static void main(String[] args){
		Map m = new Map("Bigger Combat Test", 3, 6, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10,
				t11, t12, t13, t14, t15, t16, t17, t18);
		Constants.setCurrentMap(m);
		GL_Setup.setupGL(1350, 600, "Game");
		Constants.getCurrentMap().manageTiles();
		Constants.getCurrentMap().m.init();
		
		((LivingEntity)t17.entityList.get(0)).addWeapon(RangedWeaponGenerator.generateWeapon());
		
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