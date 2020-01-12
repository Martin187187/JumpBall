package maths;

import physics.main.Collision;

public class Route {

	public Vector2D a;
	public Vector2D b;

	public Vector2D g;
	public Line line;

	public Vector2D low;
	public Vector2D high;

	private final double toleranz = Math.pow(10, -10);
	
	public Route(Vector2D a, Vector2D b) {
		this.a = a;
		this.b = b;

		this.g = a.getSubtracted(b);
		this.line = new Line(a,b);

		this.low = new Vector2D(0, 0);
		this.high = new Vector2D(0, 0);

		// fügt den kleineren x und y Wert und den größeren Wert zusammen
		if (a.x < b.x) {
			low.x = a.x;
			high.x = b.x;
		} else {
			low.x = b.x;
			high.x = a.x;
		}
		if (a.y < b.y) {
			low.y = a.y;
			high.y = b.y;
		} else {
			low.y = b.y;
			high.y = a.y;
		}
		
		/*
		System.out.println("__________________________________________");

		System.out.println("low-high");
		System.out.println(low);
		System.out.println(high);
		*/
	}

	private boolean isSmaller(double a, double b) {
		if(a<=b-toleranz||a<=b+toleranz)
			return true;
		else
		return false;
	}
	public Collision getCollision(Route route) {

		Crosspoint cross = line.getCrosspoint(route.line);

		if (cross.crossed) {
			Vector2D corner0 = new Vector2D(0, 0);
			Vector2D corner1 = new Vector2D(0, 0);

			Vector2D cp = cross.crosspoint;

			if (cross.tangente) {
				if (high.x > route.low.x || low.x < route.high.x)
					return new Collision(true, g, null);
				else
					return new Collision(false, null, null);
			}
			/*
			 * nimmt das maximum der kleinen Werte und das Minimum der großen Werte zwische
			 * den beiden Strecken
			 */
			corner0.x = Math.max(low.x, route.low.x);
			corner1.x = Math.min(high.x, route.high.x);

			corner0.y = Math.max(low.y, route.low.y);
			corner1.y = Math.min(high.y, route.high.y);
			

			/*
			System.out.println("__________________________________________");
			System.out.println(corner0);
			System.out.println(cp);
			System.out.println(corner1);
			*/
			
			if(isSmaller(corner0.x,cp.x) &&isSmaller(corner0.y, cp.y)&&isSmaller(cp.x, corner1.x)&&isSmaller(cp.y,  corner1.y)) {
				return new Collision(true, g.getAdded(route.g), cp);
			}
		}
		return new Collision(false, null, null);
	}
}
