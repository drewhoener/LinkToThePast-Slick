package me.rockerjman222.lttp.state.menus;

import me.rockerjman222.lttp.Main;
import me.rockerjman222.lttp.input.ControllerInput;
import me.rockerjman222.lttp.state.BasicState;
import me.rockerjman222.lttp.state.EnumStates;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;


public class Controller extends BasicState {

	private TiledMap map;

	private int x;
	private int y;

	private ControllerInput input;

	@Override
	public int getID() {
		return EnumStates.CONTROLLER.getId();
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.input = new ControllerInput(gameContainer);
		this.map = new TiledMap("res/maps/test.tmx");

		this.x = 10;
		this.y = 1;
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
		super.render(gameContainer, stateBasedGame, g);
		//g.drawImage(new Image("/res/misc/controller.png"), 10, 10);
		this.map.render(0, 0);

		g.fillRect(this.x * 16, this.y * 16, 16, 16);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
		super.update(gc, stateBasedGame, delta);
		this.input.update(delta);

		int objectLayer = map.getLayerIndex("Tile Layer 1");
		this.map.getTileId(0, 0, objectLayer);

		if(gc.getInput().isKeyPressed(Input.KEY_D)) {
			if(map.getTileId(this.x + 1 , this.y, objectLayer) != 503) {
				x += 1;
			}
		}

		if(gc.getInput().isKeyPressed(Input.KEY_A)) {
			if(this.x - 1 < 0 || map.getTileId(this.x - 1, this.y, objectLayer) != 503) {
				x -= 1;
			}
		}


		if(gc.getInput().isKeyPressed(Input.KEY_S)) {
			if(map.getTileId(this.x, this.y + 1, objectLayer) != 503) {
				y += 1;
			}
		}

		if(gc.getInput().isKeyPressed(Input.KEY_W)) {
			if(map.getTileId(this.x, this.y - 1, objectLayer) != 503) {
				y -= 1;
			}
		}


	}


}