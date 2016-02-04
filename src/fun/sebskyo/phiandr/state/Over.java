package fun.sebskyo.phiandr.state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.FontUtils;

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
		if(!isFading) {
			FontUtils.drawCenter(Main.font, String.valueOf(Main.score), gc.getWidth() / 2, 50, 0, Main.BLACK);
		}
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();

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
