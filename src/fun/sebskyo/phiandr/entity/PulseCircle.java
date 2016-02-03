package fun.sebskyo.phiandr.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import fun.sebskyo.phiandr.Main;

public class PulseCircle extends Entity {

	private float diameter, lowerDiameter, upperDiameter;
	private boolean isGrowing;

	public PulseCircle(float x, float y, float lowerDiameter, float upperDiameter) {
		super(x, y, (int)lowerDiameter, (int)lowerDiameter);
		diameter = lowerDiameter;
		this.lowerDiameter = lowerDiameter;
		this.upperDiameter = upperDiameter;
		isGrowing = true;
	}

	public void render(Graphics g) {
		g.setColor(Main.BLACK);
		g.drawOval(x-diameter/2, y-diameter/2, diameter, diameter);
	}
	public void update(Input input) {
		diameter += isGrowing ? 0.05f : -0.05f;

		if(diameter > upperDiameter)
			isGrowing = !isGrowing;
		if(diameter < lowerDiameter)
			isGrowing = !isGrowing;
	}
}
