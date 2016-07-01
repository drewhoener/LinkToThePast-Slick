package me.rockerjman222.lttp.game;

import me.rockerjman222.lttp.scheduling.ScheduledResource;
import me.rockerjman222.lttp.scheduling.Scheduler;
import me.rockerjman222.lttp.state.EnumStates;
import me.rockerjman222.lttp.state.Title;
import me.rockerjman222.lttp.state.menus.Controller;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StateGame extends StateBasedGame {

	private Scheduler resourceScheduler;

	public StateGame(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException {
		gameContainer.setShowFPS(true);
		this.resourceScheduler = new Scheduler();
		this.addState(new Title());
		this.addState(new Controller());
		this.enterState(EnumStates.TITLE.getId());
	}

	public void scheduleResource(ScheduledResource resource) {
		this.resourceScheduler.scheduleResource(resource);
	}

	public Scheduler getResourceScheduler() {
		return resourceScheduler;
	}
}
