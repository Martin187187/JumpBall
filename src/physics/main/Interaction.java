package physics.main;

import physics.moveable.Moveable;

public interface Interaction extends InteractionMain{
	
	
	final static int distance = 1;

	Collision gethitByBall(Ball hittingThing);
	Collision gethitByPolygon(PolygonMain hittingThing);
	
	
}
