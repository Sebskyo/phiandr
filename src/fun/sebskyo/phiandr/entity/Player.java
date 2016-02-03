package fun.sebskyo.phiandr.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import fun.sebskyo.phiandr.Main;

public class Player extends CCEntity {

	public Player(float x, float y, int diameter, float xCenter, float yCenter, float length, float angle) {
		super(x, y, diameter, xCenter, yCenter, length, angle);
	}

	public void render(Graphics g) {
		g.setColor(Main.BLACK);
		g.drawOval(x-diameter/2, y-diameter/2, diameter, diameter);
	}
	public void update(Input input) {
		if(input.isKeyDown(input.KEY_UP)) {
			length += 1.0f;
		}
		if(input.isKeyDown(input.KEY_DOWN)) {
			length -= 1.0f;
		}
		if(input.isKeyDown(input.KEY_LEFT)) {
			angle += 1.0f/length;
		}
		if(input.isKeyDown(input.KEY_RIGHT)) {
			angle -= 1.0f/length;
		}

		if(length < 0.1f)
			length = 0.1f;
		if(length > 150.0f)
			length = 150.0f;
		if(angle > 2*Math.PI)
			angle = 0;
		if(angle < 0)
			angle = 2*(float)Math.PI;

		x = (float)Math.cos(angle)*length + 320;
		y = -(float)Math.sin(angle)*length + 180;
	}
}
