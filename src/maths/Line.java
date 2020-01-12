package maths;

public class Line {

	public double x;
	public double y;

	/**
	 * gets a and b: f(x) = a*x+b
	 * 
	 * @param x
	 * @param y
	 */
	public Line(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * gets a and b as a Vector: f(x) = a*x+b
	 * 
	 * @param vector2D
	 */
	public Line(Vector2D vector2D) {
		this.x = vector2D.x;
		this.y = vector2D.y;
	}

	/**
	 * gets to position and creates an solves a and b: f(x) = a*x+b
	 * 
	 * @param vector2D
	 * @param vector2D
	 */
	public Line(Vector2D vector0, Vector2D vector1) {
		Vector2D direction = vector0.getSubtracted(vector1);


		if (direction.x == 0)
			this.x = Math.pow(10, 20);
		else
			this.x = direction.y / direction.x;

		
		this.y = vector0.y-(x*vector0.x);
		/*
		System.out.println("__________________________________________");

		System.out.println(new Vector2D(x,y));
		*/
	}

	public Crosspoint getCrosspoint(Line line) {

		Line save = new Line(x, y);
		Vector2D crosspoint = new Vector2D(0, 0);

		// gucke ob geraden parallel z.B 3x +3 == 3x+1
		if (save.x == line.x)
			// gucke ob geraden gleich sind z.B 3x +3 == 3x+3
			if (save.y == line.y)
				return new Crosspoint(true, true, null);
			else
				return new Crosspoint(false, false, null);

		// schiebe x auf line seite z.b 3x +2 == 4x-3 --> -x +2 == -3
		save.x = save.x - line.x;
		line.x = 0;

		// schiebe y auf die rechte seite z.b -x +2 == -3 --> -x == -5
		line.y = line.y - save.y;
		save.y = 0;

		// invertiere gleichung wenn negativ z.b -x == -5 --> x == 5

		double scalar = save.x;

		save.x = save.x / scalar;
		line.y = line.y / scalar;
		crosspoint.x = line.y;

		// rechne y aus:
		crosspoint.y = line.y * x + y;

		return new Crosspoint(true, false, crosspoint);
	}

}
