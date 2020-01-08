package level;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

import engine.Main;
import maths.Vector2D;
import physics.fusion.Fusion;
import physics.fusion.Wood;
import physics.main.Ball;
import physics.main.Interaction;
import physics.main.PolygonMain;
import physics.main.Thing;
import physics.moveable.BallM;
import physics.moveable.Moveable;
import physics.terrain.BallT;
import physics.terrain.PolygonT;

public class World {

	public Thing mouseThing;
	public ArrayList<Thing> things = new ArrayList<Thing>();
	public ArrayList<Thing> additionalthings = new ArrayList<Thing>();

	public ArrayList<Item> items = new ArrayList<Item>();

	public boolean showLine = false;

	public World() {

	}

	public void addLevel(Level level, boolean reset, boolean resetItems) {
		this.things = level.things;
		if (resetItems)
			this.items = level.items;

		if (reset)
			for (int i = 0; i < additionalthings.size(); i++) {
				this.things.add(additionalthings.get(i));
			}
		Main.active = false;
		this.mouseThing = null;

	}

	public boolean getItem() {
		Point p = MouseInfo.getPointerInfo().getLocation();

		Vector2D mouse = new Vector2D(p.x, p.y - 30);
		BallT test = new BallT("mouse", mouse, 15);

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).thing instanceof Fusion) {
				Thing[] elements = ((Fusion) items.get(i).thing).getAllThing();
				for (int j = 0; j < elements.length; j++) {
					if (((Interaction) elements[j]).gethitByBall(test).hitted) {

						if (addItemMouse(items.get(i), i))
							return true;
						else
							return false;
					}
				}
			} else if (((Interaction) items.get(i).thing).gethitByBall(test).hitted) {
				if (addItemMouse(items.get(i), i))
					return true;
				else
					return false;
			}
		}
		return false;
	}

	private boolean addItemMouse(Item item, int index) {

		mouseThing = item.thing.copy();
		mouseThing.visable = false;
		mouseThing.gravitation = 0;
		mouseThing.deletable = true;
		things.add(mouseThing);
		additionalthings.add(mouseThing);

		if (item.number > 0) {
			item.number--;
			return true;
		}

		return false;

	}

	public static boolean addItem(ArrayList<Item> items, Item item) {

		item.thing.visable = false;
		for (int i = 0; i < items.size(); i++) {
			if (item.thing.equals(items.get(i).thing)) {
				items.get(i).number += item.number;
				return false;
			}
		}
		item.thing.setPosition(new Vector2D(1700, 200 + items.size() * 200));
		items.add(item);
		return false;
	}

	// TODO
	public void addNewThing(int index) {

		Point p = MouseInfo.getPointerInfo().getLocation();

		if (index == 0) {
			Wood wood = new Wood("Wood", new Vector2D(p.x, p.y), 0);
			wood.visable = false;
			mouseThing = wood;
			things.add(wood);
			additionalthings.add(wood);
		} else if (index == 1) {
			BallM ball = new BallM("Hero", new Vector2D(p.x, p.y), new Vector2D(0, 0), 50, 1);
			ball.visable = false;
			ball.gravitation = 0;
			ball.backgroundLength = 0;
			ball.background = false;
			mouseThing = ball;
			things.add(ball);
			additionalthings.add(ball);
		}
	}

	public void deleteLast() {

		Point p = MouseInfo.getPointerInfo().getLocation();

		Vector2D mouse = new Vector2D(p.x, p.y - 30);
		BallT test = new BallT("mouse", mouse, 15);

		for (int i = 0; i < things.size(); i++) {
			if (things.get(i) instanceof Fusion) {
				Thing[] elements = ((Fusion) things.get(i)).getAllThing();
				for (int j = 0; j < elements.length; j++) {
					if (((Interaction) elements[j]).gethitByBall(test).hitted) {
						if (things.get(i).deletable) {
							addItem(items, new Item(things.get(i), 1));
							additionalthings.remove(things.get(i));
							things.remove(i);
						}
						break;
					}
				}
			} else if (((Interaction) things.get(i)).gethitByBall(test).hitted) {
				if (things.get(i).deletable) {
					addItem(items, new Item(things.get(i), 1));
					additionalthings.remove(things.get(i));
					things.remove(i);
				}
				break;
			}
		}

	}

	public boolean moveThing() {

		Point p = MouseInfo.getPointerInfo().getLocation();

		Vector2D mouse = new Vector2D(p.x, p.y - 30);
		BallT test = new BallT("mouse", mouse, 15);

		for (int i = 0; i < things.size(); i++) {
			if (things.get(i) instanceof Fusion) {
				Thing[] elements = ((Fusion) things.get(i)).getAllThing();
				for (int j = 0; j < elements.length; j++) {
					if (((Interaction) elements[j]).gethitByBall(test).hitted) {
						if (things.get(i).deletable) {
							mouseThing = things.get(i);
							mouseThing.visable = false;
							mouseThing.gravitation = 0;
							return true;

						}
					}
				}
			} else if (((Interaction) things.get(i)).gethitByBall(test).hitted) {
				if (things.get(i).deletable) {
					mouseThing = things.get(i);
					mouseThing.visable = false;
					mouseThing.gravitation = 0;
					return true;

				}
			}
		}

		return false;
	}

	public void clearLine() {
		for (Thing obj : things) {
			if (obj instanceof Moveable) {
				((Moveable) obj).line.clear();
			}
		}
	}

	public void update() {

		for (Thing obj : things) {
			if (obj instanceof Moveable) {
				((Moveable) obj).move(things);
				if (showLine)
					((Moveable) obj).line.add(obj.getPosition().clone());
			}
		}

		for (Thing obj : things) {
			if (obj instanceof Moveable) {
				((Moveable) obj).speed = ((Moveable) obj).saveSpeed;
			}
		}
	}
}
