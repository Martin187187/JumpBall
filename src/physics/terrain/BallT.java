package physics.terrain;

import maths.Vector2D;
import physics.main.Ball;
import physics.main.Collision;
import physics.main.PolygonMain;
import physics.main.Thing;
import physics.moveable.BallM;
import physics.moveable.Moveable;

public class BallT extends Terrain implements Ball {

	private Vector2D position;
	private double radius;
	
	public BallT(String name, Vector2D position, double radius) {
		super(name);
		this.position = position;
		this.radius = radius;
	}

	@Override
	public Vector2D getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public double getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}
	@Override
	public BallT copy() {
		BallT ball =new BallT(this.name, this.position, this.radius);
		helpCopy(ball);
		return ball;
	}

	@Override
	public Collision gethitByBall(Ball hittingThing) {
		
		
		double distance = hittingThing.getPosition().distance(position);
		
		if (hittingThing.getRadius()+radius> distance) {
			return new Collision(true, hittingThing.getPosition().getSubtracted(position).swap());
		} else {
			return new Collision(false, null);
		}
	}

	@Override
	public Collision gethitByPolygon(PolygonMain hittingThing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateThing(Vector2D position, double degree) {
		this.position = position;
	}

	@Override
	public void updateThing(Vector2D position) {
		this.position = position;
	}

	@Override
	public void updateThing(double degree) {
		
	}

	@Override
	public void setPosition(Vector2D position) {
		this.position = position;
	}


}
