package engine;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import graphics.App;
import input.KeyBoardInput;
import input.MouseClickedInput;
import input.MouseInput;
import input.MouseWheelInput;
import level.Level;
import level.World;

public class Main {

	public static boolean active = false;
	public static double rotation = 0;
	public static boolean check = false;
	public static int checkNumber = 0;

	public static boolean pause = true;
	public static boolean editable = true;
	
	public static Level level;
	public static int levelNumber = 0;
	public static boolean finished = false;
	

	public static void main(String[] args) {

		final int fps = 60;

		World world = new World();
		App app = new App(world);

		level = new Level();
		level.generateLevel(levelNumber);
		world.addLevel(level,false,true);
		// values

		// listener
		KeyListener key = new KeyBoardInput(world);
		MouseMotionListener mouseLocation = new MouseInput(world);
		MouseListener mouseClicked = new MouseClickedInput(world);
		MouseWheelListener mouseWheel = new MouseWheelInput(world);

		app.addKeyListener(key);
		app.addMouseMotionListener(mouseLocation);
		app.addMouseListener(mouseClicked);
		app.addMouseWheelListener(mouseWheel);

		Runnable runnable = () -> {

			long firstFrame = 0;
			int frames = 0;
			int lastFrames = 0;
			long currentFrame;

			// game clock
			while (true) {

				currentFrame = System.currentTimeMillis();

				frames++;
				if (currentFrame > firstFrame + 1000) {
					firstFrame = currentFrame;
					lastFrames = frames;
					frames = 0;
				}

				// here code:
				checkData(world);
				if(!pause)
				world.update();
				app.update(lastFrames);

				// end code

				try {
					long time = 1000 / fps - (System.currentTimeMillis() - currentFrame);
					if (time > 0)
						Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		};

		Thread thread = new Thread(runnable);
		thread.start();

	}

	public static void checkData(World world) {
		if(finished) {
			finished = false;
			pause = true;
			editable = true;
			
			levelNumber++;
			level.generateLevel(levelNumber);
			world.addLevel(level, false, true);

			world.additionalthings.clear();
		}
		if (check) {
			check = false;

			if (checkNumber == 2) {

				world.deleteLast();
			} else if (checkNumber == 10) {

				
				active = world.getItem();
				if(!active) {
					active = world.moveThing();
				}
			}  else if (checkNumber == 101) {
				pause = !pause;
				editable = false;
			} else if (checkNumber == 102) {
				pause = true;
				editable = true;
				
				level.generateLevel(levelNumber);
				world.addLevel(level,true, true);
			} else if (checkNumber == 103) {
				pause = true;
				editable = true;
				
				level.generateLevel(levelNumber);
				world.addLevel(level,true, false);
			} else {
				world.addNewThing(checkNumber);
				active = true;
			}
		}
	}

}
