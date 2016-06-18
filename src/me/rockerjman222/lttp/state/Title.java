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
		return 0;
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.triForceSheet = new SpriteSheet("/res/titleScreen/triforceSprites.png", 45, 45);
		this.triforceSprite = new Animation(this.triForceSheet, 100);
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		super.render(gameContainer, stateBasedGame, graphics);
		this.triforceSprite.getCurrentFrame().setFilter(Image.FILTER_NEAREST);
		this.triforceSprite.draw(100, 100, 45 * Main.scale, 45 * Main.scale);

	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
		super.update(gameContainer, stateBasedGame, delta);
		this.triforceSprite.update(delta);
	}

}
