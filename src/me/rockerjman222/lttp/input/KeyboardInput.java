package me.rockerjman222.lttp.input;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class KeyboardInput {

	private GameContainer gc;

	private Input input;

	public KeyboardInput(GameContainer gc) {
		this.gc = gc;
		this.input = this.gc.getInput();
	}

	public void update(int delta) {

	}
}
