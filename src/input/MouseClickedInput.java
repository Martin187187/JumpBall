package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import engine.Main;
import level.World;
import physics.main.InteractionMain;

public class MouseClickedInput implements MouseListener {

	World world;

	public MouseClickedInput(World world) {
		super();
		this.world = world;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (Main.active) {

				world.mouseThing.add();
				world.mouseThing.gravitation = InteractionMain.GRAVITATION;
				Main.rotation = 0;
				Main.active = false;
				world.mouseThing=null; 
			
		} else if (Main.pause&Main.editable){
			Main.checkNumber = 10;
			Main.check = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
