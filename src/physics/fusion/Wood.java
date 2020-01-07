package physics.fusion;

import java.awt.Color;
import java.awt.Polygon;

import maths.Vector2D;
import physics.main.Thing;
import physics.terrain.BallT;
import physics.terrain.PolygonT;

public class Wood extends Fusion {

	public PolygonT polygon;

	public String name;
	public BallT t1;
	public BallT t2;

	private final int width = 250;
	private final int height = 15;

	private Vector2D middle;
	private double rotation;

	public Wood(String name, Vector2D middle, double rotation) {
		super(name);
		updateThing(middle, rotation);
		visable=true;
	}

	@Override
	public Thing[] getAllThing() {

		Thing[] thing = { polygon, t1, t2 };

		return thing;
	}

	@Override
	public Vector2D getPosition() {
		// TODO Auto-generated method stub
		return middle;
	}

	@Override
	public void updateThing(Vector2D position, double degree) {

		this.middle = position;
		this.rotation = degree;
		update();
	}

	@Override
	public void updateThing(Vector2D position) {
		this.middle = position;
		update();
	}

	@Override
	public void updateThing(double degree) {

		this.rotation = degree;
		update();
	}
	
	private void update() {
		Vector2D[] corner = new Vector2D[6];

		corner[0] = new Vector2D(-width / 2, -height / 2);
		corner[1] = new Vector2D(+width / 2, -height / 2);

		corner[2] = new Vector2D(+width / 2, +height / 2);
		corner[3] = new Vector2D(-width / 2, +height / 2);

		corner[4] = new Vector2D(-width * 3 / 8, 0);
		corner[5] = new Vector2D(+width * 3 / 8, 0);

		int size = 4;
		int[] x = new int[size];
		int[] y = new int[size];

		for (int i = 0; i < size; i++) {

			corner[i].rotateBy(rotation);
			x[i] = (int) (middle.x + corner[i].x);
			y[i] = (int) (middle.y + corner[i].y);
		}

		for (int i = 4; i < 6; i++) {
			corner[i].rotateBy(rotation);
		}
		polygon = new PolygonT("Wood", new Polygon(x, y, size));

		t1 = new BallT("linker Nagel", new Vector2D(corner[4].x + middle.x, corner[4].y + middle.y), height / 3);
		t2 = new BallT("rechter Nagel", new Vector2D(corner[5].x + middle.x, corner[5].y + middle.y), height / 3);

		t1.visable = false;
		t2.visable = false;

		polygon.backColor = Color.GREEN;
		polygon.mainColor = Color.CYAN;

		t1.background = false;
		t1.mainColor = Color.DARK_GRAY;

		t2.background = false;
		t2.mainColor = Color.DARK_GRAY;
	}

	@Override
	public void setPosition(Vector2D position) {
		this.middle = position;
		updateThing(middle);
	}

	@Override
	public Thing copy() {
		Wood wood = new Wood(this.name, this.middle, this.rotation);
		helpCopy(wood);
		
		wood.polygon = polygon;
		wood.t1 = t1;
		wood.t2 = t2;
		return wood;
	}


}
