package physics.moveable;

import java.awt.Polygon;
import java.util.ArrayList;

import maths.Vector2D;
import physics.main.Ball;
import physics.main.Collision;
import physics.main.PolygonMain;
import physics.main.Thing;

public class PolygonM extends Moveable implements PolygonMain {

	private Polygon polygon;
	
	public PolygonM(String name, Vector2D speed, int mass, Polygon polygon) {
		super(name, speed, mass);
		this.polygon = polygon;
	}

	@Override
	public void move(ArrayList<Thing> things) {
		// TODO Auto-generated method stub

	}


	@Override
	public Polygon getPolygon() {
		// TODO Auto-generated method stub
		return polygon;
	}

	@Override
	public Moveable copy() {
		// TODO Auto-generated method stub
		return new PolygonM(this.name, this.speed, this.mass, this.polygon);
	}

	@Override
	public Collision gethitByBall(Ball hittingThing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collision gethitByPolygon(PolygonMain hittingThing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector2D getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateThing(Vector2D position, double degree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateThing(Vector2D position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateThing(double degree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(Vector2D position) {
	}

}
