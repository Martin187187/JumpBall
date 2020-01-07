package input;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import engine.Main;
import level.World;
import maths.Vector2D;
import physics.fusion.Wood;

public class MouseInput implements MouseMotionListener {

	World world;

	public MouseInput(World world) {
		this.world = world;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
			if (Main.active) {
				Point p = MouseInfo.getPointerInfo().getLocation();
				world.mouseThing.updateThing(new Vector2D(p.x, p.y));

			}

	}

}
