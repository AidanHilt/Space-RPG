package Test;

import com.spaceRPG.overworld.Map;
import com.spaceRPG.overworld.Tile;
import com.spaceRPG.overworld.WarpTile;
import com.spaceRPG.overworld.entities.InteractiveEntity;
import com.spaceRPG.overworld.managment.MapPackageWrapper;
import com.spaceRPG.overworld.managment.Position;

public class TestMapPackageWrapperVersion extends MapPackageWrapper {
	public static Map m1 = new Map("First Map", 0, 0);
	static public Map m2 = new Map("Second Map", 0, 0);
	
	
	static Tile t = new Tile(new Position(1, 1));
	static Tile t1 = new Tile(new Position(1, 2));
	static Tile t2 = new Tile(new Position(2, 1));
	static WarpTile t4 = new WarpTile(new Position(2, 2), m2, m1);
	
	static Tile t5 = new Tile(new Position(1, 1));
	static Tile t6 = new Tile(new Position(1, 2));
	static Tile t7 = new Tile(new Position(2, 2));
	static WarpTile t8 = new WarpTile(new Position(2, 1), m1, m2);
	static Tile t9 = new Tile(new Position(1, 3));
	static Tile t10 = new Tile(new Position(2, 3), new InteractiveEntity());
	
	
	public TestMapPackageWrapperVersion(){
		m1 = new Map("First Map", 2, 2, t, t1, t2, t4);
		m2 = new Map("Second Map", 2, 3, t5, t6, t7, t8, t9, t10);
		
		t4.addReceivingTile(t8);
		t8.addReceivingTile(t4);
		
		t4.alterSendingMap(m2);
		t8.alterSendingMap(m1);
		
		t4.alterCurrentMap(m1);
		t8.alterCurrentMap(m2);
	}
}