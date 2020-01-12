package physics.fusion;

import java.awt.Polygon;

import maths.Vector2D;
import physics.main.Ball;
import physics.main.Collision;
import physics.main.PolygonMain;
import physics.terrain.PolygonT;

public class Trampolin extends PolygonT{

	private double springEnergy;
	private double currentEnergy;
	public Trampolin(String name, Polygon polygon, double springEnergy) {
		super(name, polygon);
		// TODO Auto-generated constructor stub
		this.springEnergy = springEnergy;
		this.currentEnergy = 0;
	}


	@Override
	public Collision gethitByBall(Ball hittingThing) {
		
		Vector2D a;
		Vector2D b;

		
		for(int i = 0; i < polygon.npoints; i++) {
			a = new Vector2D(polygon.xpoints[i], polygon.ypoints[i]);
			b = new Vector2D(polygon.xpoints[(i+1)%polygon.npoints], polygon.ypoints[(i+1)%polygon.npoints]);
			b = b.getSubtracted(a);
			
			double length = b.getLength();
			Vector2D size = b;
			if(length < distance) {
				length = distance;
			} else {
				size = b.getMultiplied(distance/length);
				b = size;
			}

			double stepSize = size.getLength();
			for(double j = 0; j < length; j=j+stepSize) {
				
				if(hittingThing.getPosition().distance(a)<hittingThing.getRadius()) {
					
					if(i==0) {
						
						
						return new Collision(false, null, null);
					}
					return new Collision(true, b.getSubtracted(a),a);
				}
				a = a.getAdded(size);
				b = a.getAdded(size);
				
			}
		}
		
		return new Collision(false, null, null);
	}

	@Override
	public Collision gethitByPolygon(PolygonMain hittingThing) {
		// TODO Auto-generated method stub
		return null;
	}

}
