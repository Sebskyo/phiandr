package fun.sebskyo.phiandr.state;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import fun.sebskyo.phiandr.Main;
import fun.sebskyo.phiandr.entity.Player;
import fun.sebskyo.phiandr.entity.Enemy;

public class Play extends BasicGameState {

	private static int id;

	private static int enemyAddCounter; // Confusing name, I know. Whenever this value is above 10000 (10 secs) it adds an enemy to the enemy list

	private Player player;
	private Enemy[] enemy;
	private ArrayList<Enemy> enemies;

	public Play(int state) {
		id = state;
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player = new Player(123, 123, 50, gc.getWidth()/2, gc.getHeight()/2, 0.1f, (float)Math.PI/2);
		enemy = new Enemy[10];
		enemies = new ArrayList<>();
		enemyAddCounter = 0;
		for (int i = 0; i < 10; i++)
			enemies.add(new Enemy(10, gc.getWidth()/2, gc.getHeight()/2));
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Main.BLACK);
		player.render(g);
		for (int i = 0; i < enemies.size(); i++)
			enemies.get(i).render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Main.score += delta;
		if(enemyAddCounter > 1000) {
			enemies.add(new Enemy(10, gc.getWidth()/2, gc.getHeight()/2));
			enemyAddCounter = 0;
		}
		else {
			enemyAddCounter += delta;
		}
		Input input = gc.getInput();
		player.update(input);
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update(input);
			if(Math.pow(enemies.get(i).getX() - player.getX(), 2) + Math.pow(enemies.get(i).getY() - player.getY(), 2) < Math.pow((double) player.getHeight()/2, 2)) {
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
