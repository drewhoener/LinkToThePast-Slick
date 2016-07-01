package me.rockerjman222.lttp.state;

import me.rockerjman222.lttp.game.StateGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class BasicState implements GameState {

	//before I forget
	/**
	 * How much update time should go by before incrementing
	 * */
	private int deltaThreshold = 15;
	/**
	 * Holder for how many update delta ticks have gone by
	 * */
	private int deltaCounter = 0;
	/**
	 * The actual counter to be incremented
	 * */
	private int resourceTimer = 0;

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		if(stateBasedGame instanceof StateGame){
			StateGame game = ((StateGame) stateBasedGame);
			game.getResourceScheduler().clearSchedule();
		}

	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		if(stateBasedGame instanceof StateGame){
			StateGame game = ((StateGame) stateBasedGame);
			game.getResourceScheduler().drawResources();
		}
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		this.deltaCounter += i;
		if(this.deltaCounter >= this.deltaThreshold){
			this.deltaCounter = 0;
			if(stateBasedGame instanceof StateGame){
				StateGame game = ((StateGame) stateBasedGame);
				game.getResourceScheduler().updateResources(++this.resourceTimer, i);
			}
		}
	}

	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

	}

	@Override
	public void leave(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

	}

	@Override
	public void controllerLeftPressed(int i) {

	}

	@Override
	public void controllerLeftReleased(int i) {

	}

	@Override
	public void controllerRightPressed(int i) {

	}

	@Override
	public void controllerRightReleased(int i) {

	}

	@Override
	public void controllerUpPressed(int i) {

	}

	@Override
	public void controllerUpReleased(int i) {

	}

	@Override
	public void controllerDownPressed(int i) {

	}

	@Override
	public void controllerDownReleased(int i) {

	}

	@Override
	public void controllerButtonPressed(int i, int i1) {

	}

	@Override
	public void controllerButtonReleased(int i, int i1) {

	}

	@Override
	public void keyPressed(int i, char c) {

	}

	@Override
	public void keyReleased(int i, char c) {

	}

	@Override
	public void mouseWheelMoved(int i) {

	}

	@Override
	public void mouseClicked(int i, int i1, int i2, int i3) {

	}

	@Override
	public void mousePressed(int i, int i1, int i2) {

	}

	@Override
	public void mouseReleased(int i, int i1, int i2) {

	}

	@Override
	public void mouseMoved(int i, int i1, int i2, int i3) {

	}

	@Override
	public void mouseDragged(int i, int i1, int i2, int i3) {

	}

	@Override
	public void setInput(Input input) {

	}

	@Override
	public boolean isAcceptingInput() {
		return false;
	}

	@Override
	public void inputEnded() {

	}

	@Override
	public void inputStarted() {

	}

	public int getResourceTimer(){
		return this.resourceTimer;
	}

}
