package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JPanel;

import level.Item;
import level.World;
import maths.Vector2D;
import physics.fusion.Fusion;
import physics.fusion.Wood;
import physics.main.Ball;
import physics.main.PolygonMain;
import physics.main.Thing;
import physics.moveable.BallM;
import physics.terrain.BallT;

public class Renderer extends JPanel {

	private final Dimension screenSize = new Dimension(1920, 1080);

	private World world;
	private int fps;

	public Renderer(World world) {
		this.world = world;
	}

	public void repaint(int fps) {
		this.fps = fps;
		repaint();
	}

	@Override
	public void paint(Graphics g) {

		Graphics2D gr = (Graphics2D) g;

		gr.setColor(Color.WHITE);
		gr.fillRect(0, 0, screenSize.width, screenSize.height);
		gr.setColor(Color.BLACK);


		

		for (Thing obj : world.things) {
			if (obj instanceof Fusion) {
				Thing[] elements = ((Fusion) obj).getAllThing();
				for (Thing a : elements) {
					decideBasics(gr, a);
				}
			} else
				decideBasics(gr, obj);
		}
		
		for (Item item : world.items) {
			if (item.number > 0) {

				if (item.thing instanceof Fusion) {
					Thing[] elements = ((Fusion) item.thing).getAllThing();
					for (Thing a : elements) {
						decideBasics(gr, a);
					}
				} else
					decideBasics(gr, item.thing);

				Vector2D position = item.thing.getPosition();
				gr.drawString("[" + item.number + "]", (int) position.x + 50, (int) position.y + 50);
			}
		}


		gr.setColor(Color.BLUE);
		gr.drawRect(1580-1, 780-1, 270+1, 210+1);
		gr.setColor(Color.WHITE);
		gr.fillRect(1580, 780, 270, 210);
		gr.setColor(Color.BLACK
				);
		gr.drawString("FPS: " + fps, 1600, 800);
		gr.drawString("P: start/stop", 1600, 815);
		gr.drawString("R: neustart", 1600, 830);
		gr.drawString("shift + R: reset", 1600, 845);
		gr.drawString("<-/->: level zurück/vorwärts", 1600, 860);
		
		gr.drawString("Erklärung:", 1600, 900);
		gr.drawString("Klicke auf einen Gegenstand in", 1600, 915);
		gr.drawString("dieser Tabelle und drücke ", 1600, 930);
		gr.drawString("nochmal um diesen zu platzieren.", 1600, 945);
		gr.drawString("Nun drücke \"P\" um zu starten.", 1600, 960);
		gr.drawString("Ziel ist es das rote Brett zu treffen.", 1600, 975);
	}

	private void decideBasics(Graphics2D gr, Thing obj) {
		if (obj instanceof Ball) {
			drawBall(gr, obj);
		} else if (obj instanceof PolygonMain) {
			drawPolygon(gr, obj);
		}
	}

	private void drawBall(Graphics2D gr, Thing obj) {
		Vector2D background = null;
		Vector2D main = null;
		if (obj.background) {
			background = drawCenteredCircle(gr, obj, false);
		}
		main = drawCenteredCircle(gr, obj, true);

		if (background != null) {
			double radius = ((Ball) obj).getRadius();

			background.x += radius;
			main.x += radius;

			gr.setColor(obj.backColor);
			gr.drawLine((int) main.x, (int) main.y, (int) background.x, (int) background.y);

			background.y += radius * 2;
			main.y += radius * 2;

			gr.drawLine((int) main.x, (int) main.y, (int) background.x, (int) background.y);

			background.y -= radius * 2;
			main.y -= radius * 2;
		}
	}

	private void drawPolygon(Graphics2D gr, Thing obj) {
		Polygon poly = ((PolygonMain) obj).getPolygon();

		int[] x = poly.xpoints.clone();
		int[] y = poly.ypoints.clone();
		int size = poly.npoints;

		int[] x1 = new int[size];
		int[] y1 = new int[size];

		int[] x2 = new int[size];
		int[] y2 = new int[size];

		if (obj.background) {

			for (int j = 0; j < size; j++) {

				x1[j % size] = (int) (x[j % size] - (x[j % size] - screenSize.width / 2) * obj.backgroundLength);
				y1[j % size] = (int) (y[j % size] - (y[j % size] - screenSize.height / 2) * obj.backgroundLength);

				x1[(j + 1) % size] = (int) (x[(j + 1) % size]
						- (x[(j + 1) % size] - screenSize.width / 2) * obj.backgroundLength);
				y1[(j + 1) % size] = (int) (y[(j + 1) % size]
						- (y[(j + 1) % size] - screenSize.height / 2) * obj.backgroundLength);

				x2[j % size] = (int) (x[j % size] + (x[j % size] - screenSize.width / 2) * obj.backgroundLength);
				y2[j % size] = (int) (y[j % size] + (y[j % size] - screenSize.height / 2) * obj.backgroundLength);

				x2[(j + 1) % size] = (int) (x[(j + 1) % size]
						+ (x[(j + 1) % size] - screenSize.width / 2) * obj.backgroundLength);
				y2[(j + 1) % size] = (int) (y[(j + 1) % size]
						+ (y[(j + 1) % size] - screenSize.height / 2) * obj.backgroundLength);

				int[] combineX = { x1[j % size], x1[(j + 1) % size], x2[(j + 1) % size], x2[j % size] };
				int[] combineY = { y1[j % size], y1[(j + 1) % size], y2[(j + 1) % size], y2[j % size] };

				gr.setColor(obj.backColor);
				gr.fillPolygon(combineX, combineY, 4);

				gr.setColor(obj.structur);
				gr.drawPolygon(combineX, combineY, 4);
			}

			for (int i = 0; i < size; i++) {

				x2[i] = (int) (x[i] + (x[i] - screenSize.width / 2) * obj.backgroundLength);
				y2[i] = (int) (y[i] + (y[i] - screenSize.height / 2) * obj.backgroundLength);

			}

			gr.setColor(obj.mainColor);
			gr.fillPolygon(x2, y2, size);

			gr.setColor(obj.structur);
			gr.drawPolygon(x2, y2, size);

		} else {

			gr.setColor(obj.structur);
			gr.drawPolygon(x, y, size);

			gr.setColor(obj.mainColor);
			gr.fillPolygon(x, y, size);
		}
	}

	private Vector2D drawCenteredCircle(Graphics2D gr, Thing ball, boolean background) {

		double radius = ((Ball) ball).getRadius();

		Vector2D vector0 = ((Ball) ball).getPosition().getSubtracted(new Vector2D(radius, radius));
		if (background) {
			if (ball instanceof BallM) {
				gr.setColor(ball.structur);
				gr.drawOval((int) vector0.x, (int) vector0.y, (int) radius * 2, (int) radius * 2);

				gr.setColor(ball.mainColor);
				gr.fillOval((int) vector0.x, (int) vector0.y, (int) radius * 2, (int) radius * 2);

			} else {

				vector0.x = vector0.x + (vector0.x - screenSize.width / 2) * ball.backgroundLength;
				vector0.y = vector0.y + (vector0.y - screenSize.height / 2) * ball.backgroundLength;

				gr.setColor(ball.mainColor);
				gr.fillOval((int) vector0.x, (int) vector0.y, (int) radius * 2, (int) radius * 2);

				gr.setColor(ball.structur);
				gr.drawOval((int) vector0.x, (int) vector0.y, (int) radius * 2, (int) radius * 2);
			}
		} else {
			vector0.x = vector0.x - (vector0.x - screenSize.width / 2) * ball.backgroundLength;
			vector0.y = vector0.y - (vector0.y - screenSize.height / 2) * ball.backgroundLength;

			gr.setColor(ball.structur);
			gr.drawOval((int) vector0.x, (int) vector0.y, (int) radius * 2, (int) radius * 2);

			gr.setColor(ball.backColor);
			gr.fillOval((int) vector0.x, (int) vector0.y, (int) radius * 2, (int) radius * 2);

		}
		return vector0;
	}
}
