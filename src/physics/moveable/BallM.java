package physics.moveable;

import java.util.ArrayList;
import java.util.List;

import maths.Vector2D;
import physics.fusion.Fusion;
import physics.main.Ball;
import physics.main.Collision;
import physics.main.Interaction;
import physics.main.PolygonMain;
import physics.main.Thing;

public class BallM extends Moveable implements Ball {

	private Vector2D position;
	private double radius;

	public BallM(String name, Vector2D position, Vector2D speed, double rotationspeed, double radius, int mass) {
		super(name, speed,rotationspeed, mass);
		this.position = position;
		this.radius = radius;
	}

	@Override
	public void move(ArrayList<Thing> things) {
		position.add(speed);

		boolean hit = false;
		for (Thing obj : things) {
			if (!obj.equals(this) && (this.visable)&&(obj.visable)) {
				if (obj instanceof Fusion) {
					Thing[] elements = ((Fusion) obj).getAllThing();
					for (Thing a : elements) {
						hit=doHit(a);
					}
				} else

					hit=doHit(obj);

			}
		}

		if(!hit)

			speed.y = speed.y + gravitation;
		speed.multiply(SPEEDLOOSE);
	}

	private boolean doHit(Thing obj) {
		Collision collision;
		if ((collision = ((Interaction) obj).gethitByBall(this)).hitted) {
			position.subtract(speed);
			Vector2D u = collision.wall;
			Vector2D v = speed;

			double alpha = Math.acos((u.dot(v)) / (u.getLength() * v.getLength()));

			if (alpha > Math.PI / 2) {
				alpha = Math.PI - alpha;
				v.rotateBy(alpha * 2);
			} else {

				v.rotateBy(-alpha * 2);
			}

			if (speed.getLength() < 1)
				speed = v.getMultiplied(BOUNCELOOSE);
			else
				speed = v.getMultiplied(BOUNCELOOSE2);
		}
		return collision.hitted;
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
	public BallM copy() {
		BallM ball =new BallM(this.name, this.position, this.speed, this.rotationspeed, this.radius, this.mass);
		helpCopy(ball);
		return ball;
	}

	@Override
	public Collision gethitByBall(Ball hittingThing) {
		
		
		double distance = hittingThing.getPosition().distance(position);

		if (hittingThing.getRadius() + radius > distance) {
			
			if(hittingThing instanceof Moveable) {
				Vector2D v1 =((Moveable)hittingThing).speed;
				Vector2D v2 = speed;
				
				
				int m1 = ((Moveable)hittingThing).mass;
				int m2;
				if(Math.abs(v2.y)<0.15)

					m2 = Integer.MAX_VALUE;
				else
				m2 = mass;
				
				
				v1.x = (m1*v1.x+m2*v2.x-m2*(v1.x-v2.x))/(m1+m2);
				v1.y = (m1*v1.y+m2*v2.y-m2*(v1.y-v2.y))/(m1+m2);
				
				
			}
			Vector2D direcction = hittingThing.getPosition().getSubtracted(position);
			return new Collision(true, direcction.swap(),hittingThing.getPosition().getMultiplied(direcction.getLength()*radius));
		} else {
			return new Collision(false, null, null);
		}
	}

	@Override
	public Collision gethitByPolygon(PolygonMain hittingThing) {
		// TODO Auto-generated method stub
		return new Collision(false, null, null);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void setPosition(Vector2D position) {
		this.position = position;
	}


}
