package physics.moveable;

import java.util.ArrayList;

import maths.Vector2D;
import physics.main.Thing;
import physics.main.Visable;

public abstract class Moveable extends Visable implements MoveableInteraction{
	
	public Vector2D speed;
	public Vector2D saveSpeed;
	protected int mass;

	public ArrayList<Vector2D> line;
	public Moveable(String name, Vector2D speed, int mass) {
		super(name);

		this.saveSpeed = speed;
		this.speed = speed;
		this.mass = mass;
		
		this.line = new ArrayList<Vector2D>();
		
	}
}
