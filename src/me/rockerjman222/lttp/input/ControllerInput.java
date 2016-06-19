package me.rockerjman222.lttp.input;

import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class ControllerInput {

	private GameContainer gc;

	private Input input;
	private Controller controller;

	private boolean A;
	private boolean B;
	private boolean X;
	private boolean Y;
	private boolean LEFT;
	private boolean RIGHT;
	private boolean SELECT;
	private boolean START;

	private float xAxis;
	private float yAxis;

	public ControllerInput(GameContainer gc) {
		this.gc = gc;
		this.input = this.gc.getInput();
		this.controller = Controllers.getController(5);
		this.controller.setXAxisDeadZone(0);
		this.controller.setYAxisDeadZone(0);
	}


	public void update(int delta) {
		//this.controller.poll();
		this.A = this.controller.isButtonPressed(0);
		this.B = this.controller.isButtonPressed(1);
		this.X = this.controller.isButtonPressed(2);
		this.Y = this.controller.isButtonPressed(3);
		this.LEFT = this.controller.isButtonPressed(4);
		this.RIGHT = this.controller.isButtonPressed(5);
		this.SELECT = this.controller.isButtonPressed(6);
		this.START = this.controller.isButtonPressed(7);

		this.xAxis = (int)this.controller.getXAxisValue();
		this.yAxis = (int)this.controller.getYAxisValue();
	}

	public boolean isA() {
		return this.A;
	}

	public boolean isB() {
		return this.B;
	}

	public boolean isX() {
		return this.X;
	}

	public boolean isY() {
		return this.Y;
	}

	public boolean isLEFT() {
		return this.LEFT;
	}

	public boolean isRIGHT() {
		return this.RIGHT;
	}

	public boolean isSELECT() {
		return this.SELECT;
	}

	public boolean isSTART() {
		return this.START;
	}

	public float getXAxis() {
		return this.xAxis;
	}

	public float getYAxis() {
		return this.yAxis;
	}


}
