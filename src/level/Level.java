package level;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

import maths.Vector2D;
import physics.fusion.Wood;
import physics.main.PolygonMain;
import physics.main.Thing;
import physics.moveable.BallM;
import physics.moveable.PolygonM;
import physics.terrain.BallT;
import physics.terrain.PolygonT;

public class Level {
	public ArrayList<Thing> things;

	public ArrayList<Item> items;

	public Level() {
	}

	public void generateLevel(int level) {

		things = new ArrayList<Thing>();
		items = new ArrayList<Item>();

		BallM ball;
		PolygonT floor0;
		PolygonT floor1;
		PolygonT floor2;
		PolygonT floor3;
		Wood wood;
		BallT block;

		Item item0;
		Item item1;
		Item item2;
		if (level == 0) {
			ball = new BallM("Hero", new Vector2D(399, 300), new Vector2D(0, -4), 0, 50, 100);
			ball.visable = true;
			ball.goalable = true;
			floor0 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 0, 0, 100, 100 }, 4));
			floor1 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 980, 980, 1080, 1080 }, 4));
			floor2 = new PolygonT("floor",
					new Polygon(new int[] { 0, 100, 100, 0 }, new int[] { 100, 100, 980, 980 }, 4));
			floor3 = new PolygonT("floor",
					new Polygon(new int[] { 1480, 1980, 1980, 1480 }, new int[] { 100, 100, 980, 980 }, 4));

			wood = new Wood("Wood", new Vector2D(250, 900), 0);
			block = new BallT("Test", new Vector2D(400, 800), 30);

			Wood goal = new Wood("goal", new Vector2D(1300, 800), 0);
			goal.polygon.goal = true;
			goal.polygon.mainColor = Color.RED;

			things.add(floor0);
			things.add(floor1);
			things.add(floor2);
			things.add(floor3);
			things.add(ball);
			things.add(goal);

			item0 = new Item(wood, 2);

			World.addItem(items, item0);

		} else if (level == 1) {
			ball = new BallM("Hero", new Vector2D(399, 300), new Vector2D(0, -4), 0, 50, 100);
			ball.visable = true;
			ball.goalable = true;
			floor0 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 0, 0, 100, 100 }, 4));
			floor1 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 980, 980, 1080, 1080 }, 4));
			floor2 = new PolygonT("floor",
					new Polygon(new int[] { 0, 100, 100, 0 }, new int[] { 100, 100, 980, 980 }, 4));
			floor3 = new PolygonT("floor",
					new Polygon(new int[] { 1480, 1980, 1980, 1480 }, new int[] { 100, 100, 980, 980 }, 4));

			wood = new Wood("Wood", new Vector2D(250, 900), 0);
			block = new BallT("Test", new Vector2D(400, 800), 30);

			Wood goal = new Wood("goal", new Vector2D(1300, 400), 0);
			goal.polygon.goal = true;
			goal.polygon.mainColor = Color.RED;

			things.add(floor0);
			things.add(floor1);
			things.add(floor2);
			things.add(floor3);
			things.add(ball);
			things.add(goal);

			item0 = new Item(wood, 2);
			item1 = new Item(block, 10);

			World.addItem(items, item0);
			World.addItem(items, item1);

		} else if (level == 2) {
			ball = new BallM("Hero", new Vector2D(399, 300), new Vector2D(0, -4), 0, 50, 100);
			ball.visable = true;
			ball.goalable = true;
			floor0 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 0, 0, 100, 100 }, 4));
			floor1 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 980, 980, 1080, 1080 }, 4));
			floor2 = new PolygonT("floor",
					new Polygon(new int[] { 0, 100, 100, 0 }, new int[] { 100, 100, 980, 980 }, 4));
			floor3 = new PolygonT("floor",
					new Polygon(new int[] { 1480, 1980, 1980, 1480 }, new int[] { 100, 100, 980, 980 }, 4));

			wood = new Wood("Wood", new Vector2D(250, 900), 0);
			block = new BallT("Test", new Vector2D(400, 800), 30);

			Wood goal = new Wood("goal", new Vector2D(1300, 400), 0);

			Wood wall0 = new Wood("wall", new Vector2D(1920 / 2, 1080 / 2), Math.PI / 2);
			Wood wall1 = new Wood("wall", new Vector2D(1920 / 2, 1080 / 2 - 250), Math.PI / 2);

			goal.polygon.goal = true;
			goal.polygon.mainColor = Color.RED;

			things.add(floor0);
			things.add(floor1);
			things.add(floor2);
			things.add(floor3);
			things.add(wall1);
			things.add(wall0);
			things.add(ball);
			things.add(goal);

			item0 = new Item(wood, 5);
			item1 = new Item(block, 10);

			World.addItem(items, item0);
			World.addItem(items, item1);

		} else if(level==3){

			ball = new BallM("Hero", new Vector2D(399, 300), new Vector2D(0, -4), 0, 50, 100);
			ball.background = false;
			floor0 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 0, 0, 100, 100 }, 4));
			floor1 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 980, 980, 1080, 1080 }, 4));
			floor2 = new PolygonT("floor",
					new Polygon(new int[] { 0, 100, 100, 0 }, new int[] { 100, 100, 980, 980 }, 4));
			floor3 = new PolygonT("floor",
					new Polygon(new int[] { 1880, 1980, 1980, 1880 }, new int[] { 100, 100, 980, 980 }, 4));

			PolygonMain structur = new PolygonT("structur", new Polygon(
					new int[] { 1980 / 2 - 400, 1980 / 2, 1980 / 2 + 400, 1980 / 2 + 400, 1980 / 2, 1980 / 2 - 400 },
					new int[] { 1080 / 2 + 100, 1080 / 2 - 300, 1080 / 2 + 100, 1080 / 2 + 200, 1080 / 2 - 200,
							1080 / 2 + 200 },
					6));

			PolygonM poly = new PolygonM("bam", new Vector2D(0, 0), 0, 200,
					new Polygon(new int[] { 200, 400, 400, 200 }, new int[] { 250, 250, 200, 200 }, 4));
			poly.deletable=true;
			poly.visable = true;
			block = new BallT("Test", new Vector2D(400, 800), 30);
			wood = new Wood("Wood", new Vector2D(250, 900), 0);

			things.add((Thing) floor0);
			things.add((Thing) floor1);
			things.add((Thing) floor2);
			things.add((Thing) floor3);

//			things.add((Thing) structur);

			things.add((Thing) block);
			things.add((Thing) wood);
			things.add(poly);

			item0 = new Item(wood, 2);
			item1 = new Item(ball, 3);
			item2 = new Item(block, 10);

			World.addItem(items, item0);
			World.addItem(items, item1);
			World.addItem(items, item2);
		}else {

			ball = new BallM("Hero", new Vector2D(399, 300), new Vector2D(0, -4), 0, 50, 100);
			ball.background = false;
			floor0 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 0, 0, 100, 100 }, 4));
			floor1 = new PolygonT("floor",
					new Polygon(new int[] { 0, 1980, 1980, 0 }, new int[] { 980, 980, 1080, 1080 }, 4));
			floor2 = new PolygonT("floor",
					new Polygon(new int[] { 0, 100, 100, 0 }, new int[] { 100, 100, 980, 980 }, 4));
			floor3 = new PolygonT("floor",
					new Polygon(new int[] { 1880, 1980, 1980, 1880 }, new int[] { 100, 100, 980, 980 }, 4));

			PolygonMain structur = new PolygonT("structur", new Polygon(
					new int[] { 1980 / 2 - 400, 1980 / 2, 1980 / 2 + 400, 1980 / 2 + 400, 1980 / 2, 1980 / 2 - 400 },
					new int[] { 1080 / 2 + 100, 1080 / 2 - 300, 1080 / 2 + 100, 1080 / 2 + 200, 1080 / 2 - 200,
							1080 / 2 + 200 },
					6));

			
			block = new BallT("Test", new Vector2D(400, 800), 30);
			wood = new Wood("Wood", new Vector2D(250, 900), 0);

			things.add((Thing) floor0);
			things.add((Thing) floor1);
			things.add((Thing) floor2);
			things.add((Thing) floor3);

			things.add((Thing) structur);

			things.add((Thing) block);
			things.add((Thing) wood);

			item0 = new Item(wood, 2);
			item1 = new Item(ball, 3);
			item2 = new Item(block, 10);

			World.addItem(items, item0);
			World.addItem(items, item1);
			World.addItem(items, item2);
		}
	}

}
