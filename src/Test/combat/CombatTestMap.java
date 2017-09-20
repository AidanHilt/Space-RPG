/**
 * @date Feb 23, 2016
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
import com.spaceRPG.weapons.WeightClass;
import com.spaceRPG.weapons.melee.MeleeWeapon;
import com.spaceRPG.weapons.melee.MeleeWeaponTypes;

/**
 * @author AidanTheGreat
 *
 */
public class CombatTestMap{

	static Tile t1 = new Tile(new Position(1, 1), new InteractiveEntity());
	static Tile t2 = new Tile(new Position(1, 2));
	static Tile t3 = new Tile(new Position(2, 1));
	static Tile t4 = new Tile(new Position(2, 2), new LivingEntity());
	
	public static void main(String[] args){
		Map m = new Map("Combat Test Map", 2, 2, t1, t2, t3, t4);
		((LivingEntity) t1.entityList.get(0)).addWeapon(new MeleeWeapon(10, 2, 1, 1, 
				MeleeWeaponTypes.AXE, WeightClass.HEAVY));
		GL_Setup.setupGL(1000, 600, "Combat Test");
		Constants.setCurrentMap(m);
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
