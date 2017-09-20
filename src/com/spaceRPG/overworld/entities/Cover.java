package com.spaceRPG.overworld.entities;

import com.spaceRPG.displayElements.Square;
import com.spaceRPG.overworld.managment.Position;

public class Cover extends Entity{
private static final long serialVersionUID = 8146476312749867487L;
public Square s;

@Override
public void calculateSize(){
	s.pos = new Position(location.getDisplayPos().getX() + location.s.getSideLength() / 4, location.getDisplayPos().getY());
	s.setSideLength(location.s.getSideLength() / 4);
	s.setSideHeight((location.s.getSideHeight() / 4) * 3);
}

@Override
public void update(long delta){
	draw();
}

@Override
void draw(){
	s.draw();
}

public Cover(){
	this.s = new Square(new Position(0, 0), 0, 0, 0, 0, 0, -1);
}

}
