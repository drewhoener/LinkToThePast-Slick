package me.rockerjman222.lttp.scheduling;

import org.newdawn.slick.Sound;

public class SoundHelper extends ScheduledResource{

	Sound sound;

	public SoundHelper(Sound sound, int createTime) {
		super(createTime);
		this.sound = sound;
	}

	@Override
	public boolean update(int time, int delta) {
		if(!super.update(time, delta))
			return false;

		if(!this.sound.playing() && this.getStartTime() <= time)
			this.sound.play();
		if(this.sound.playing() && this.getEndTime() <= time)
			this.sound.stop();

		return true;
	}
}
