package me.rockerjman222.lttp.game;

import me.rockerjman222.lttp.state.EnumStates;
import me.rockerjman222.lttp.state.Title;
import me.rockerjman222.lttp.state.menus.Controller;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StateGame extends StateBasedGame {


	public StateGame(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException {
		gameContainer.setShowFPS(true);
		this.addState(new Title());
		this.addState(new Controller());
		this.enterState(EnumStates.CONTROLLER.getId());
	}



}
