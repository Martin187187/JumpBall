package physics.main;

import maths.Vector2D;

public class Collision {

	public boolean hitted;
	public Vector2D wall;;
	public Vector2D collisionpoint;
	
	
	public Collision(boolean hitted, Vector2D wall, Vector2D collisionpoint) {
		this.hitted = hitted;
		this.wall = wall;
		this.collisionpoint = collisionpoint;
	}
	
	
}
