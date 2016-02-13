package fun.sebskyo.phiandr.state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.FontUtils;

import fun.sebskyo.phiandr.Main;

public class Over extends BasicGameState {

	private static int id;
	private long timer; // TEMPORARY
	private long start;
	private float shade;
	private boolean isFading;
	private Color color;

	public Over(int state) {
		id = state;
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		timer = System.currentTimeMillis();
		start = System.currentTimeMillis();
		shade = 0xff;
		isFading = true;
		color = new Color((int)shade, (int)shade, (int)shade);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(color);
		g.setColor(Main.BLACK);
		if(!isFading) {
			FontUtils.drawCenter(Main.font, String.valueOf(Main.score), gc.getWidth() / 2, 50, 0, Main.BLACK);
			FontUtils.drawCenter(Main.font, String.valueOf(((1000-(timer-start))/1000)+5), gc.getWidth()/2, 80, 0, Main.BLACK);
		}
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();

		if(isFading) {
			shade -= 0.1;
		}
		if(shade <= 0xf3) {
			isFading = false;
		}

		color = new Color((int)shade, (int)shade, (int)shade);

		timer = System.currentTimeMillis();
		if(timer - start > 6000) {
			sbg.getState(0).init(gc, sbg);
			sbg.enterState(0);
		}
	}

	public int getID() {
		return id;
	}
}
