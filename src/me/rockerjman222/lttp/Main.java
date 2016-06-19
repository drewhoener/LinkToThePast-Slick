package me.rockerjman222.lttp;

import me.rockerjman222.lttp.game.StateGame;
import me.rockerjman222.lttp.state.EnumStates;
import me.rockerjman222.lttp.state.Title;
import me.rockerjman222.lttp.state.menus.Controller;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static final int scale = 3;
	private static final int height = 224 * scale;
	private static final int width = 256 * scale;

	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new StateGame("Link To The Past"));
			appgc.setDisplayMode(width, height, false);
			appgc.setIcon("res/misc/icon.png");
			appgc.start();
		} catch (SlickException e) {
			Logger.getLogger(StateGame.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
