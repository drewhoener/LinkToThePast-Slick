package me.rockerjman222.lttp.state;

import me.rockerjman222.lttp.Main;
import me.rockerjman222.lttp.assets.Resources;
import me.rockerjman222.lttp.game.StateGame;
import me.rockerjman222.lttp.scheduling.AnimationHelper;
import me.rockerjman222.lttp.scheduling.MusicHelper;
import me.rockerjman222.lttp.scheduling.SoundHelper;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

import static me.rockerjman222.lttp.assets.AudioCache.ItemEffect;
import static me.rockerjman222.lttp.assets.AudioCache.MusicEffect;

public class Title extends BasicState {

	SpriteSheet triForceSheet;
	@Override
	public int getID() {
		return EnumStates.TITLE.getId();
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.triForceSheet = new SpriteSheet("/res/titleScreen/triforceSprites.png", 45, 45);
		//this.triforceSprite = new Animation(this.triForceSheet, 100);
		//new ResourceSchedule(24, new AnimationPath(new Animation(this.triforceSprites, 5), Lttp.width - (45 * Lttp.scale), Lttp.height, -1, -1, Lttp.width / 2, Lttp.height / 2), 111);
		if(stateBasedGame instanceof StateGame){
			super.init(gameContainer, stateBasedGame);
			StateGame game = ((StateGame) stateBasedGame);
			game.scheduleResource(new AnimationHelper(new Animation(this.triForceSheet, 10), 17)
					.start(new Vector2f(Main.width - (45 * Main.scale), Main.height))
					.velocity(new Vector2f(-1.5f, -1.5f))
					.end(new Vector2f(Main.width / 2, Main.height / 2)));
			game.scheduleResource(new AnimationHelper(new Animation(this.triForceSheet, 10), 17)
					.start(new Vector2f(0, Main.height))
					.velocity(new Vector2f(1.5f, -1.5f))
					.end(new Vector2f(Main.width / 2 - (45 * Main.scale), Main.height / 2)));
			game.scheduleResource(new AnimationHelper(new Animation(this.triForceSheet, 10), 17)
					.start(new Vector2f(Main.width / 2 - (45 / 2 * Main.scale), -(45 * Main.scale)))
					.velocity(new Vector2f(0, 1.5f))
					.end(new Vector2f(Main.width / 2 - (45 / 2 * Main.scale), Main.height / 2 - (45 * Main.scale))));
			game.scheduleResource(new SoundHelper(ItemEffect.RUPEE_1, 15));
			game.scheduleResource(new AnimationHelper(Resources.nintendo, 15)
					.start(new Vector2f(Main.width / 2 - (56 * Main.scale / 2), Main.height / 2 - (16 * Main.scale / 2)))
					.endTime(40));
			game.scheduleResource(new MusicHelper(MusicEffect.TITLE, 65, -1));
			//game.scheduleResource();
		}
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		super.render(gameContainer, stateBasedGame, graphics);

	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
		super.update(gameContainer, stateBasedGame, delta);
		//this.triforceSprite.update(delta);
	}

}
