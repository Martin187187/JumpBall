package input;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import engine.Main;
import level.World;
import maths.Vector2D;

public class MouseWheelInput implements MouseWheelListener {

	World world;

	public MouseWheelInput(World world) {
		this.world = world;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
			if (Main.active) {
				if (arg0.getWheelRotation() > 0)
					Main.rotation = Main.rotation + arg0.getScrollAmount();
				else
					Main.rotation = Main.rotation - arg0.getScrollAmount();
				world.mouseThing.updateThing(Main.rotation);

			}
	}

}
