package fun.sebskyo.phiandr.state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import fun.sebskyo.phiandr.Main;

public class Over extends BasicGameState {

	private static int id;
	private long timer; // TEMPORARY
	private float shade;
	private boolean isFading;
	private Color color;

	public Over(int state) {
		id = state;
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		timer = 0;
		shade = 0xff;
		isFading = true;
		color = new Color((int)shade, (int)shade, (int)shade);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(color);
		g.setColor(Main.BLACK);
		g.drawString(String.valueOf(shade), 10, 50);
		if(!isFading) {
			g.drawString("u lost", 10, 10);
		}
		g.setColor(Main.WHITE);
		g.fillRect(50, 100, 50, 50);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		timer++;
		if(isFading)
			shade -= 0.1;
		if(shade <= 0xf3) {
			isFading = false;
		}

		color = new Color((int)shade, (int)shade, (int)shade);

		if(timer > 1000) {
			sbg.getState(0).init(gc, sbg);
			sbg.enterState(0);
		}
	}

	public int getID() {
		return id;
	}
}
