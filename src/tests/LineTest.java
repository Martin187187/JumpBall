package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import maths.Crosspoint;
import maths.Line;
import maths.Vector2D;

public class LineTest {

	private final double toleranz = Math.pow(10, -10);
	 @Test
	 public void testLine0() {

		 Line a = new Line(3,4);
		 Line b = new Line(4,9);
		 
		 Crosspoint solution = new Crosspoint(true, false, new Vector2D(-5,-11));
		 
		 Crosspoint testData = a.getCrosspoint(b);

		 assertEquals(solution.crossed, testData.crossed);
		 assertEquals(solution.tangente, testData.tangente);
		 assertEquals(solution.crosspoint.x, testData.crosspoint.x, toleranz);
		 assertEquals(solution.crosspoint.y, testData.crosspoint.y, toleranz);
	 }
	 
	 @Test
	 public void testLine1() {

		 Line a = new Line(3,4);
		 Line b = new Line(3,9);
		 
		 Crosspoint solution = new Crosspoint(false, false, null);
		 
		 Crosspoint testData = a.getCrosspoint(b);

		 assertEquals(solution.crossed, testData.crossed);
		 assertEquals(solution.tangente, testData.tangente);
	 }
	 
	 @Test
	 public void testLine2() {

		 Line a = new Line(3,9);
		 Line b = new Line(3,9);
		 
		 Crosspoint solution = new Crosspoint(true, true, null);
		 
		 Crosspoint testData = a.getCrosspoint(b);

		 assertEquals(solution.crossed, testData.crossed);
		 assertEquals(solution.tangente, testData.tangente);
	 } 
	 @Test
	 public void testLine3() {

		 Line a = new Line(new Vector2D(1,2),new Vector2D(3,4));
		 Line b = new Line(new Vector2D(1,4),new Vector2D(3,2));
		 
		 Crosspoint solution = new Crosspoint(true, false, new Vector2D(2,3));
		 
		 Crosspoint testData = a.getCrosspoint(b);

		 assertEquals(solution.crossed, testData.crossed);
		 assertEquals(solution.tangente, testData.tangente);
		 assertEquals(solution.crosspoint.x, testData.crosspoint.x, toleranz);
		 assertEquals(solution.crosspoint.y, testData.crosspoint.y, toleranz);
	 }
	 
	 @Test
	 public void testLine4() {

		 Line a = new Line(new Vector2D(0,0),new Vector2D(2,0));
		 Line b = new Line(new Vector2D(0,1),new Vector2D(2,-1));
		 
		 Crosspoint solution = new Crosspoint(true, false, new Vector2D(1,0));
		 
		 Crosspoint testData = a.getCrosspoint(b);

		assertEquals(solution.crossed, testData.crossed);
		 assertEquals(solution.tangente, testData.tangente);
		 assertEquals(solution.crosspoint.x, testData.crosspoint.x, toleranz);
		 assertEquals(solution.crosspoint.y, testData.crosspoint.y, toleranz);
	 }
	 
	 @Test
	 public void testLine5() {

		 Line a = new Line(new Vector2D(1,1),new Vector2D(1,-1));
		 Line b = new Line(new Vector2D(-1,0),new Vector2D(3,0));
		 
		 Crosspoint solution = new Crosspoint(true, false, new Vector2D(1,0));
		 
		 Crosspoint testData = a.getCrosspoint(b);

		 assertEquals(solution.crossed,testData.crossed);
		 assertEquals(solution.tangente, testData.tangente);
		 assertEquals(solution.crosspoint.x, testData.crosspoint.x, toleranz);
		 assertEquals(solution.crosspoint.y, testData.crosspoint.y, toleranz);
	 }
}
