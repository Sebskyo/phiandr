package fun.sebskyo.phiandr.state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import fun.sebskyo.phiandr.Main;
import fun.sebskyo.phiandr.entity.Player;
import fun.sebskyo.phiandr.entity.Enemy;

public class Play extends BasicGameState {

	private static int id;

	private Player player;
	private Enemy[] enemy;

	public Play(int state) {
		id = state;
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player = new Player(123, 123, 50, gc.getWidth()/2, gc.getHeight()/2, 0.1f, (float)Math.PI/2);
		enemy = new Enemy[10];
		for (int i = 0; i < enemy.length; i++)
			enemy[i] = new Enemy(10, gc.getWidth()/2, gc.getHeight()/2);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Main.BLACK);
		g.drawString("Score: " + Main.score, 10, 10);
		player.render(g);
		for (int i = 0; i < enemy.length; i++)
			enemy[i].render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Main.score += delta;
		Input input = gc.getInput();
		player.update(input);
		for (int i = 0; i < enemy.length; i++) {
			enemy[i].update(input);
			if(Math.pow(enemy[i].getX() - player.getX(), 2) + Math.pow(enemy[i].getY() - player.getY(), 2) < Math.pow((double) player.getHeight()/2, 2)) {
				Main.score /= 100;
				sbg.getState(2).init(gc, sbg);
				sbg.enterState(2);
			}
		}

		if(input.isKeyDown(input.KEY_ESCAPE)) {
			sbg.getState(0).init(gc, sbg);
			sbg.enterState(0);
		}
	}

	public int getID() {
		return id;
	}
}
