package physics.main;

import maths.Vector2D;

public class Collision {

	public boolean hitted;
	public Vector2D wall;;
	
	
	public Collision(boolean hitted, Vector2D wall) {
		this.hitted = hitted;
		this.wall = wall;
	}
	
	
}
