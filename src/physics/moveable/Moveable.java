package physics.moveable;

import java.util.ArrayList;

import maths.Vector2D;
import physics.main.Thing;
import physics.main.Visable;

public abstract class Moveable extends Visable implements MoveableInteraction{

	public Vector2D speed;
	

	public double rotationspeed;
	protected int mass;

	public ArrayList<Vector2D> line;
	public Moveable(String name, Vector2D speed, double rotationspeed,int mass) {
		super(name);

		this.speed = speed;
		
		this.rotationspeed = 0;
		this.mass = mass;
		
		this.line = new ArrayList<Vector2D>();
		
	}
}
