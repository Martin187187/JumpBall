package physics.moveable;

import java.util.ArrayList;

import physics.main.Ball;
import physics.main.Collision;
import physics.main.Interaction;
import physics.main.PolygonMain;
import physics.main.Thing;

public interface MoveableInteraction extends Interaction{

	final double SPEEDLOOSE = 0.998;
	final double BOUNCELOOSE = 0.8;
	final double BOUNCELOOSE2 = 0.97;
	final double MINSPEED = 2;
	//TODO die 60 können später mit der fps Zahl verrechnet werden. Dazu muss auch Speed abhängig von der fpszahl werden.
	
	/**
	 * moves one step into the direction of the speed attribute
	 * if there would be a collision, calculate a new speed with entering hit() and retry. 
	 * This can happen multiple times.
	 * 
	 * @param things
	 * 
	 */

	
	void move(ArrayList<Thing> things);
	
}
