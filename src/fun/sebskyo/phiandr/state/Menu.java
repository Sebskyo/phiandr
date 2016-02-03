package fun.sebskyo.phiandr.state;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import fun.sebskyo.phiandr.Main;
import fun.sebskyo.phiandr.entity.PulseCircle;

public class Menu extends BasicGameState {

	private static int id;

	private Image img;
	private PulseCircle pulse, playerP; // pulse pulses, playerP is the player projection (invisible at first)
	private boolean isExpanding;

	public Menu(int state) {
		id = state;
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		try {
			img = new Image("res/logo.png");
		}
		catch (SlickException e) {
			e.printStackTrace();
		}
		pulse = new PulseCircle(gc.getWidth()/2, gc.getHeight()/2, 45, 55);
		playerP = new PulseCircle(gc.getWidth()/2, gc.getHeight()/2, 0, 0);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Main.WHITE);
		g.setColor(Main.BLACK);
		img.drawCentered(320, 75);
		pulse.render(g);
		playerP.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();

		pulse.update(input, 0.05f, 3f, isExpanding);
		playerP.update(input, 0, 0.18f, isExpanding);

		if(isExpanding)
			img.setAlpha(img.getAlpha()-0.005f);

		if((Math.pow(Mouse.getX() - pulse.getX(), 2) + Math.pow(Mouse.getY() - pulse.getY(), 2) < Math.pow((double) pulse.getRadius(), 2) && Mouse.isButtonDown(0)) || input.isKeyDown(input.KEY_ENTER)) {
			isExpanding = true;
		}
		if(playerP.getRadius() > 25) {
			isExpanding = false;
			sbg.getState(Main.PLAY).init(gc, sbg);
			sbg.enterState(Main.PLAY);
		}
	}

	public int getID() {
		return id;
	}
}
