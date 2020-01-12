package tests;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import maths.Line;
import maths.Route;
import maths.Vector2D;
import physics.main.Collision;

public class RouteTest {

	private final double toleranz = Math.pow(10, -10);
	@Test
	public void routeTest0() {

		Route a = new Route(new Vector2D(1,2),new Vector2D(3,4));
		Route b = new Route(new Vector2D(1,4),new Vector2D(3,2));
		
		Collision solution = new Collision(true, new Vector2D(-4,0), null);
		Collision testData = a.getCollision(b);
		
		assertEquals(testData.hitted, solution.hitted);
		assertEquals(testData.wall, solution.wall);
	}
	
	@Test
	public void routeTest1() {

		Route a = new Route(new Vector2D(1,2),new Vector2D(3,4));
		Route b = new Route(new Vector2D(3,2),new Vector2D(5,0));
		
		Collision solution = new Collision(false, null, null);
		Collision testData = a.getCollision(b);
		
		assertEquals(testData.hitted, solution.hitted);
		assertEquals(testData.wall, solution.wall);
	}
	
	@Test
	public void routeTest2() {

		Route a = new Route(new Vector2D(0,0),new Vector2D(2,0));
		Route b = new Route(new Vector2D(0,1),new Vector2D(2,-1));
		
		Collision solution = new Collision(true, new Vector2D(-4,2), null);
		Collision testData = a.getCollision(b);
		
		assertEquals(testData.hitted, solution.hitted);
		assertEquals(testData.wall, solution.wall);
	}
	
	@Test
	public void routeTest3() {

		Route a = new Route(new Vector2D(0,1),new Vector2D(0,-1));
		Route b = new Route(new Vector2D(-1,1),new Vector2D(1,-1));
		
		Collision solution = new Collision(true, new Vector2D(-2,4), null);
		Collision testData = a.getCollision(b);
		
		assertEquals(testData.hitted, solution.hitted);
		assertEquals(testData.wall, solution.wall);
	}
}
