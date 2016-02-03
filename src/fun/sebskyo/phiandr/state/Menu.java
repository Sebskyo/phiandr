package fun.sebskyo.phiandr.state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import fun.sebskyo.phiandr.Main;
import fun.sebskyo.phiandr.entity.PulseCircle;

public class Menu extends BasicGameState {

	private static int id;

	private Image img;
	private PulseCircle pulse;

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
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Main.WHITE);
		g.setColor(Main.BLACK);
		img.drawCentered(320, 75);
		pulse.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();

		pulse.update(input);

		if(input.isKeyDown(input.KEY_ENTER)) {
			sbg.enterState(Main.PLAY);
		}
	}

	public int getID() {
		return id;
	}
}
