package me.rockerjman222.lttp.state;

import me.rockerjman222.lttp.Main;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Title extends BasicState {

	SpriteSheet triForceSheet;
	Animation triforceSprite;

	@Override
	public int getID() {
		return EnumStates.TITLE.getId();
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.triForceSheet = new SpriteSheet("/res/titleScreen/triforceSprites.png", 45, 45);
		this.triforceSprite = new Animation(this.triForceSheet, 100);
		System.out.println("THIS IS THE TITLE STATE");
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		super.render(gameContainer, stateBasedGame, graphics);
		this.triforceSprite.getCurrentFrame().setFilter(Image.FILTER_NEAREST);
		this.triforceSprite.draw(100, 100, 45 * Main.scale, 45 * Main.scale);
		graphics.drawImage(new Image("/res/misc/controller.png"), 10, 10, 0, 0, 994, 453);

	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
		super.update(gameContainer, stateBasedGame, delta);
		this.triforceSprite.update(delta);

	}

}
