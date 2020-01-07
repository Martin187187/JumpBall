package physics.main;

import maths.Vector2D;

public interface InteractionMain {

	final double GRAVITATION = 9.81/40;
	
	public String getName();
	
	public Thing copy();
	
	
	public void add();
	
	public Vector2D getPosition();
	public void setPosition(Vector2D position);
	public void updateThing(Vector2D position, double degree);
	public void updateThing(Vector2D position);
	public void updateThing(double degree);
	
	public boolean equals(Thing thing);
}
