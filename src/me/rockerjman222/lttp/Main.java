package me.rockerjman222.lttp;

import me.rockerjman222.lttp.game.StateGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static final int scale = 3;
	private static final int height = 224 * scale;
	private static final int width = 256 * scale;

	public static void main(String[] args) {
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new StateGame("Link To The Past"));
			appgc.setDisplayMode(width, height, false);
			appgc.setIcon("/res/window/icon.png");
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(StateGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
