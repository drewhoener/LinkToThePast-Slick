package me.rockerjman222.lttp;

import me.rockerjman222.lttp.game.StateGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static final int scale = 4;
	public static final int height = 224 * scale;
	public static final int width = 256 * scale;

	public static void main(String[] args) {
		if(isWindows())
			System.setProperty("java.library.path", "lib/natives/natives-windows/");
		else if(isMac())
			System.setProperty("java.library.path", "lib/natives/natives-mac/");
		else if(isLinux())
			System.setProperty("java.library.path", "lib/natives/natives-linux/");

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

	public static boolean isWindows() {
		return System.getProperty("os.name").startsWith("Windows");
	}

	public static boolean isMac() {
		return System.getProperty("os.name").startsWith("Mac");
	}

	public static boolean isLinux() {
		return System.getProperty("os.name").startsWith("Linux");
	}

}
