package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import engine.Main;
import graphics.App;
import level.World;

public class KeyBoardInput implements KeyListener {

	World world;


	public KeyBoardInput(World world) {
		super();
		this.world = world;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyChar() == 'n') {
			Main.checkNumber = 0;
			Main.check = true;
		}
		if (arg0.getKeyChar() == 'b') {
			Main.checkNumber = 1;
			Main.check = true;
		}
		if (Main.pause&Main.editable) 
		if (arg0.getKeyChar() == 'd') {
			Main.checkNumber = 2;
			Main.check = true;
		}
		if (arg0.getKeyChar() == 'l') {
			world.showLine = !world.showLine;
			world.clearLine();
		}
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			Main.checkNumber = 101;
			Main.check = true;
		}
		if (arg0.getKeyChar() == 'r') {
			Main.checkNumber = 103;
			Main.check = true;
		}
		if (arg0.getKeyChar() == 'R') {
			Main.checkNumber = 102;
			world.additionalthings.clear();
			Main.check = true;
		}
		
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			Main.levelNumber++;
			world.additionalthings.clear();
			Main.checkNumber = 102;
			Main.check = true;
		}
		
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			if(Main.levelNumber>0)
			Main.levelNumber--;
			world.additionalthings.clear();
			Main.checkNumber = 102;
			Main.check = true;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
