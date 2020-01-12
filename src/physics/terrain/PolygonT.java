package physics.terrain;

import java.awt.Polygon;

import engine.Main;
import maths.Crosspoint;
import maths.Line;
import maths.Route;
import maths.Vector2D;
import physics.main.Ball;
import physics.main.Collision;
import physics.main.PolygonMain;
import physics.main.Thing;
import physics.moveable.BallM;
import physics.moveable.Moveable;

public class PolygonT extends Terrain implements PolygonMain {

	protected Polygon polygon;

	private int width = 200;
	private int height = 15;

	public PolygonT(String name, Polygon polygon) {
		super(name);
		this.polygon = polygon;
	}

	public PolygonT(String name, Vector2D middle, int rotation) {
		super(name);

		int[] x = { (int) (middle.x - width / 2), (int) (middle.x + width / 2), (int) (middle.x + width / 2),
				(int) (middle.x - width / 2) };
		int[] y = { (int) (middle.y - height / 2), (int) (middle.y - height / 2), (int) (middle.y + height / 2),
				(int) (middle.y + height / 2) };
		int size = 4;
		this.polygon = new Polygon(x, y, size);

	}

	@Override
	public Polygon getPolygon() {
		// TODO Auto-generated method stub
		return polygon;
	}

	@Override
	public PolygonT copy() {
		PolygonT poly = new PolygonT(this.name, polygon);
		helpCopy(poly);

		return poly;
	}

	/**
	 * Ball hits PolygonT
	 */
	public Collision gethitByBall(Ball hittingThing) {

		Vector2D a;
		Vector2D b;

		for (int i = 0; i < polygon.npoints; i++) {
			a = new Vector2D(polygon.xpoints[i], polygon.ypoints[i]);
			b = new Vector2D(polygon.xpoints[(i + 1) % polygon.npoints], polygon.ypoints[(i + 1) % polygon.npoints]);
			b = b.getSubtracted(a);

			double length = b.getLength();
			Vector2D size = b;
			if (length < distance) {
				length = distance;
			} else {
				size = b.getMultiplied(distance / length);
				b = size;
			}

			double stepSize = size.getLength();
			for (double j = 0; j < length; j = j + stepSize) {

				if (hittingThing.getPosition().distance(a) < hittingThing.getRadius()) {
					if (goal && ((Thing) hittingThing).goalable)
						Main.finished = true;
					return new Collision(true, b.getSubtracted(a),a);
				}
				a = a.getAdded(size);
				b = a.getAdded(size);

			}
		}

		return new Collision(false, null, null);

	}

	/**
	 * Polygon hits PolygonT
	 */
	public Collision gethitByPolygon(PolygonMain hittingThing) {

		Vector2D a;
		Vector2D b;

		Vector2D k;
		Vector2D m;


		int size0 = polygon.npoints;
		int size1 = hittingThing.getPolygon().npoints;

		for (int i = 0; i < size0; i++) {
			a = new Vector2D(polygon.xpoints[i % size0], polygon.ypoints[i % size0]);
			b = new Vector2D(polygon.xpoints[(i + 1) % size0], polygon.ypoints[(i + 1) % size0]);

			
			Route first = new Route(a, b);

			for (int j = 0; j < size1; j++) {
				k = new Vector2D(hittingThing.getPolygon().xpoints[j % size1],
						hittingThing.getPolygon().ypoints[j % size1]);
				m = new Vector2D(hittingThing.getPolygon().xpoints[(j + 1) % size1],
						hittingThing.getPolygon().ypoints[(j + 1) % size1]);

				Route second = new Route(k, m);

				Collision col = first.getCollision(second);

				if (col.hitted) {
					System.out.println("--");
					return col;
				}
				
			}
		}
		return new Collision(false, null, null);
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
