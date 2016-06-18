package me.rockerjman222.lttp.scheduling;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

/**
 * Can be used for animations and non-animations alike
 * To use with a non-animation or a background, set {@link Animation#setAutoUpdate(boolean)} to false and don't set velocity and end
 * */
public class AnimationHelper extends ScheduledResource {

	private Animation animation;
	private Vector2f velocity = null;
	private Vector2f start;
	private Vector2f end = null;

	public AnimationHelper(Animation animation, int createTime) {
		super(createTime);
		this.animation = animation;
	}

	public AnimationHelper start(Vector2f vector2f){
		this.start = vector2f;
		return this;
	}

	public AnimationHelper end(Vector2f vector2f){
		this.end = vector2f;
		return this;
	}

	public AnimationHelper velocity(Vector2f vector2f){
		this.velocity = vector2f;
		return this;
	}

	@Override
	public ScheduledResource endTime(int time) {
		return super.endTime(time);
	}

	/**
	 * @return false if the update was cancelled, true if it executed successfully
	 * */
	public boolean update(int time, int delta){
		if(!super.update(time, delta))
			return false;
		if(this.start == null){
			this.setRunning(false);
			return false;
		}
		if(this.end != null && this.velocity != null){
			if(this.start.equals(this.end)){
				if(this.getEndTime() > -1){
					if(this.getEndTime() >= time){
						this.setRunning(false);
						return false;
					}
				}
			}else{
				this.start.set(this.start.getX() + this.velocity.getX(), this.start.getY() + this.velocity.getY());
			}
		}
		if(this.getEndTime() > -1){
			if(this.getEndTime() >= time){
				this.setRunning(false);
				return false;
			}
		}
		this.animation.update(delta);
		return true;
	}

	public void draw(){
		this.draw(this.animation.getWidth(), this.animation.getHeight(), 1, Image.FILTER_LINEAR);
	}

	public void draw(int scale){
		this.draw(this.animation.getWidth(), this.animation.getHeight(), scale, Image.FILTER_NEAREST);
	}

	private void draw(int width, int height, int scale, int filter){
		this.animation.getCurrentFrame().setFilter(filter);
		this.animation.draw(this.start.getX(), this.start.getY());
	}

}
