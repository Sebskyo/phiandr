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
		player = new Player(123, 123, 50, gc.getWidth()/2, gc.getHeight()/2, 0.1f, 0);
		enemy = new Enemy[10];
		for (int i = 0; i < enemy.length; i++)
			enemy[i] = new Enemy(10, gc.getWidth()/2, gc.getHeight()/2);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Main.BLACK);
		player.render(g);
		for (int i = 0; i < enemy.length; i++)
			enemy[i].render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		player.update(input);
		for (int i = 0; i < enemy.length; i++)
			enemy[i].update(input);
	}

	public int getID() {
		return id;
	}
}
