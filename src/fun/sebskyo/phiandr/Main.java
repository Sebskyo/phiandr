package fun.sebskyo.phiandr;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;

import fun.sebskyo.phiandr.state.Menu;
import fun.sebskyo.phiandr.state.*;


public class Main extends StateBasedGame {

	public static final int MENU = 0;
	public static final int PLAY = 1;
	public static final int OVER = 2;

	public static final Color WHITE = new Color(0xf3, 0xf3, 0xf3);
	public static final Color BLACK = new Color(0x33, 0x33, 0x33);
	public static TrueTypeFont font;

	public static int score = 0;

	public Main() {
		super("φ and r");
		addState(new Menu(MENU));
		addState(new Play(PLAY));
		addState(new Over(OVER));
	}
	public void initStatesList(GameContainer gc) throws SlickException {
		initFonts();
		this.getState(MENU).init(gc, this);
		this.getState(PLAY).init(gc, this);
		this.getState(OVER).init(gc, this);
		enterState(MENU);
	}

	public void initFonts() {
		try {
			InputStream in = ResourceLoader.getResourceAsStream("res/DejaVuSans-ExtraLight.ttf");
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, in);
			font = new TrueTypeFont(awtFont.deriveFont(24f), true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Main(), 640, 360, false);
			appgc.setShowFPS(false);
			appgc.setVSync(true);
			appgc.start();
		}
		catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
