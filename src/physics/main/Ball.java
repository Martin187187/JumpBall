package physics.main;

import maths.Vector2D;

public interface Ball{

	/**
	 * 
	 * @return position
	 */
	Vector2D getPosition();
	
	/**
	 * 
	 * @return radius
	 */
	double getRadius();
}
