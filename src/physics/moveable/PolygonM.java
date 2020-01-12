package physics.moveable;

import java.awt.Polygon;
import java.util.ArrayList;


import maths.Line;
import maths.Vector2D;
import physics.fusion.Fusion;
import physics.main.Ball;
import physics.main.Collision;
import physics.main.Interaction;
import physics.main.PolygonMain;
import physics.main.Thing;

public class PolygonM extends Moveable implements PolygonMain {

	private Polygon polygon;
	
	private boolean[] hits = new boolean[60];

	public PolygonM(String name, Vector2D speed, double rotationspeed, int mass, Polygon polygon) {
		super(name, speed, rotationspeed, mass);
		this.polygon = polygon;
		
		for(int i = 0; i < hits.length; i++) {
			hits[i] = false;
		}
	}

	
	private int countHint() {
		int count = 0;
		for(int i = 0; i < hits.length; i++) {
			if(hits[i])
				count++;
		}
		
		return count;
	}
	private void updateHit(boolean hit) {
		for(int i = 0; i < hits.length-1; i++) {
			hits[i] = hits[i+1];
		}
		hits[hits.length-1] = hit;
	}
	@Override
	public void move(ArrayList<Thing> things) {


		
		rotatePolygon(polygon, rotationspeed, getMidpoint(polygon));
		addSpeed(speed);
		

		boolean hit = false;
		for (Thing obj : things) {
			if (!obj.equals(this) && (this.visable) && (obj.visable)) {
				if (obj instanceof Fusion) {
					Thing[] elements = ((Fusion) obj).getAllThing();
					for (Thing a : elements) {
						hit = doHit(a);
					}
				} else

					hit = doHit(obj);

			}
		}


		if(countHint()>5) {
			this.gravitation = 0;
			this.speed.setZero();
			this.rotationspeed = 0;
		}
			speed.y = speed.y + gravitation;
		speed.multiply(0.99);
		rotationspeed*=0.99;
	}

	private boolean doHit(Thing obj) {
		Collision collision;
		if ((collision = ((Interaction) obj).gethitByPolygon(this)).hitted) {
			addSpeed(speed.getReversed());
			System.out.println("HIT");

			Vector2D midPoint = getMidpoint(polygon);
			Vector2D v1 = speed;
			Vector2D v2;
			
			
			int m1 = mass;
			int m2;
			

			if(obj instanceof Moveable) {
				v2 =((Moveable)obj).speed;
				m2 = ((Moveable)obj).mass;
			} else {
				v2 = new Vector2D(0,0);
				m2 = Integer.MAX_VALUE;
			}
			Vector2D collisionpoint;
			double alpha;
			Vector2D g;
			
			
			if(collision.collisionpoint==null) {

				Line a = new Line(midPoint, midPoint.getAdded(collision.wall.swap()));
				Line b = new Line(collision.wall);
				
				collisionpoint = a.getCrosspoint(b).crosspoint;
			} else {
				collisionpoint = collision.collisionpoint;
			}
			
			g = collisionpoint.getSubtracted(midPoint);

			alpha = g.dot(v1)/(g.getLength()+v1.getLength());

			
			
			if(g.x<0)
				alpha = -alpha;
			this.rotationspeed+=Math.toRadians(-alpha);
			if (alpha > Math.PI / 2) {
				alpha = Math.PI - alpha;
				v1.rotateBy(alpha * 2);
			} else {

				v1.rotateBy(-alpha * 2);
			}

				speed = v1.getMultiplied(0.8);
				rotationspeed*=0.6;

		}
		updateHit(collision.hitted);
		return collision.hitted;
	}

	@Override
	public Polygon getPolygon() {
		// TODO Auto-generated method stub
		return polygon;
	}

	@Override
	public Moveable copy() {
		// TODO Auto-generated method stub
		return new PolygonM(this.name, this.speed, this.rotationspeed, this.mass, this.polygon);
	}

	@Override
	public Collision gethitByBall(Ball hittingThing) {
		// TODO Auto-generated method stub
		return new Collision(false, null, null);
	}

	@Override
	public Collision gethitByPolygon(PolygonMain hittingThing) {
		// TODO Auto-generated method stub
		return new Collision(false, null, null);
	}

	@Override
	public Vector2D getPosition() {
		// TODO Auto-generated method stub
		return getMidpoint(polygon);
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
