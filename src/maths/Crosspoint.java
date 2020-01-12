package maths;

public class Crosspoint {

	public boolean crossed;
	public boolean tangente;
	public Vector2D crosspoint;
	
	public Crosspoint(boolean crossed, boolean tangente, Vector2D crosspoint) {
		this.crossed = crossed;
		this.tangente = tangente;
		this.crosspoint = crosspoint;
	}
}
