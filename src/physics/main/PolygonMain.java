package physics.main;

import java.awt.Polygon;

import maths.Vector2D;


public interface PolygonMain {

	/**
	 * 
	 * @return polygon
	 */
	Polygon getPolygon();
	
	public default Vector2D getMidpoint(Polygon polygon) {
		
		Vector2D midpoint = new Vector2D(0,0);
		
		for(int i = 0; i < polygon.npoints; i++) {
			midpoint.x+=polygon.xpoints[i];
			midpoint.y+=polygon.ypoints[i];
		}
		
		midpoint.x = midpoint.x/polygon.npoints;
		midpoint.y = midpoint.y/polygon.npoints;
		
		return midpoint;
	}
	
	public default void addSpeed(Vector2D speed) {
		for (int i = 0; i < getPolygon().npoints; i++) {
			getPolygon().xpoints[i] += (int) speed.x;
			getPolygon().ypoints[i] += (int) speed.y;
		}
	}
	public default void rotatePolygon(Polygon polygon, double rotation, Vector2D midPoint) {

		for (int i = 0; i < polygon.npoints; i++) {

			Vector2D point = new Vector2D(polygon.xpoints[i],polygon.ypoints[i]);
			point.subtract(midPoint);
			point.rotateBy(rotation);
			point.add(midPoint);
			
			polygon.xpoints[i] = (int) (point.x);
			polygon.ypoints[i] = (int) (point.y);
		}
	}
}
