package physics.main;

import java.awt.Color;

public abstract class Thing implements InteractionMain{

	
	protected String name;
	public boolean visable;
	public boolean background;
	public double backgroundLength;
	
	public Color structur;
	public Color mainColor;
	public Color backColor;

	public double gravitation;
	public boolean deletable;
	
	public boolean goal;
	
	public Thing(String name) {
		this.name = name;
		
		mainColor = Color.GRAY;
		structur = Color.BLACK;
		backColor = Color.LIGHT_GRAY;
		background = true;
		backgroundLength = 0.025;
		this.gravitation = GRAVITATION;
		this.deletable = false;
		this.goal = false;
	}
	
	
	public String getName() {
		return name;
		
	}
	public void add() {
		visable = true;
	}
	
	public boolean equals(Thing thing) {
		return this.getClass().equals(thing.getClass());
	}
	
	protected void helpCopy(Thing thing) {
		thing.backColor = backColor;
		thing.background = background;
		thing.backgroundLength = backgroundLength;
		thing.gravitation = gravitation;
		thing.mainColor = mainColor;
		thing.structur = structur;
		thing.visable = visable;
		thing.deletable = deletable;
		thing.goal = goal;
	}
}
