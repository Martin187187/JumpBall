package graphics;

import javax.swing.JFrame;

import level.World;

public class App extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Renderer renderer;
	public App(World world) {
		
		renderer = new Renderer(world);
		add(renderer);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void update(int fps) {
		renderer.repaint(fps);
		setVisible(true);
	}
}
