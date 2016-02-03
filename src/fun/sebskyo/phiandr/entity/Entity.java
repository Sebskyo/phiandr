package fun.sebskyo.phiandr.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

abstract class Entity {
	protected float x, y;
	protected int width, height;

	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	abstract public void render(Graphics g);
	abstract public void update(Input input);

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
