package me.rockerjman222.lttp.scheduling;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Can be used for animations and non-animations alike
 * To use with a non-animation or a background, set {@link Animation#setAutoUpdate(boolean)} to false and don't set velocity and end
 */
public class AnimationHelper extends ScheduledResource {

	private Animation animation;
	private Vector2f velocity = null;
	private Vector2f start;
	private Vector2f end = null;
	private boolean isStillImage;

	Runnable drawerAdditional;

	public AnimationHelper(String image, int createTime) throws SlickException {
		this(new Animation(new Image[]{new Image(image)}, Integer.MAX_VALUE, false), createTime);
		this.isStillImage = true;
	}

	public AnimationHelper(Animation animation, int createTime) {
		super(createTime);
		this.animation = animation;
		this.animation.setAutoUpdate(false);
	}

	public AnimationHelper start(Vector2f vector2f) {
		this.start = vector2f;
		return this;
	}

	public AnimationHelper end(Vector2f vector2f) {
		this.end = vector2f;
		return this;
	}

	public AnimationHelper velocity(Vector2f vector2f) {
		this.velocity = vector2f;
		return this;
	}

	@Override
	public ScheduledResource endTime(int time) {
		return super.endTime(time);
	}

	@Override
	public boolean update(int time, int delta) {
		if (!super.update(time, delta)) {
			return false;
		}
		if (this.start == null) {
			this.setRunning(false);
			return false;
		}
		if (this.end != null && this.velocity != null) {

			this.updatePositions();
		}
		if (this.getEndTime() > -1) {
			if (this.getEndTime() <= time) {
				this.setRunning(false);
				return false;
			}
		}
		if(!this.isStillImage)
			this.animation.update(delta);
		return true;
	}

	public Runnable getDrawerAdditional() {
		return drawerAdditional;
	}

	public void setDrawerAdditional(Runnable drawerAdditional) {
		this.drawerAdditional = drawerAdditional;
	}

	public void drawAdditional() {
		if (this.drawerAdditional != null)
			this.drawerAdditional.run();
	}

	public void draw() {
		this.draw(this.animation.getWidth(), this.animation.getHeight(), 1, Image.FILTER_LINEAR);
	}

	public void draw(int scale) {
		this.draw(this.animation.getWidth(), this.animation.getHeight(), scale, Image.FILTER_NEAREST);
	}

	private void draw(int width, int height, int scale, int filter) {
		this.animation.getCurrentFrame().setFilter(filter);
		this.animation.draw(this.start.getX(), this.start.getY(), width * scale, height * scale);
	}

	private void updatePositions() {
		DirectionMoved directionX = this.velocity == null ? DirectionMoved.POSITIVE : this.velocity.getX() >= 0 ? DirectionMoved.POSITIVE : DirectionMoved.NEGATIVE;
		DirectionMoved directionY = this.velocity == null ? DirectionMoved.POSITIVE : this.velocity.getY() >= 0 ? DirectionMoved.POSITIVE : DirectionMoved.NEGATIVE;

		this.start.set(this.start.getX() + this.velocity.getX(), this.start.getY() + this.velocity.getY());

		if (directionX == DirectionMoved.POSITIVE) {
			if (this.start.getX() >= this.end.getX())
				this.start.setX(this.end.getX());
		}
		if (directionX == DirectionMoved.NEGATIVE) {
			if (this.start.getX() <= this.end.getX())
				this.start.setX(this.end.getX());

		}

		if (directionY == DirectionMoved.POSITIVE) {
			if (this.start.getY() >= this.end.getY())
				this.start.setY(this.end.getY());
		}
		if (directionY == DirectionMoved.NEGATIVE) {
			if (this.start.getY() <= this.end.getY())
				this.start.setY(this.end.getY());
		}

	}
}
