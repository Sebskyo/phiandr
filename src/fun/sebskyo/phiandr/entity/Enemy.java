package fun.sebskyo.phiandr.entity;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import fun.sebskyo.phiandr.Main;

public class Enemy extends CCEntity {

	Random r;
	float speed;

	public Enemy(float x, float y, int diameter, float xCenter, float yCenter, float length, float angle) {
		super(x, y, diameter, xCenter, yCenter, length, angle);
		r = new Random();
	}
	public Enemy(int diameter, float xCenter, float yCenter) {
		this(0, 0, diameter, xCenter, yCenter, 0, 0);
		genVar();
	}

	public void render(Graphics g) {
		g.setColor(Main.BLACK);
		g.fillOval(x-diameter/2, y-diameter/2, diameter, diameter);
	}
	public void update(Input input) {
		length -= speed;
		if(length < 0.1f)
			genVar();

		x = (float)Math.cos(angle)*length + 320;
		y = -(float)Math.sin(angle)*length + 180;
	}
	public void genVar() {
		length = 350;
		angle = r.nextFloat()*(float)Math.PI*2;
		speed = r.nextFloat()+0.3f;
	}
}
