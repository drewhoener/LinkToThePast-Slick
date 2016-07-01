package me.rockerjman222.lttp.scheduling;

import me.rockerjman222.lttp.assets.AudioCache;
import org.newdawn.slick.Sound;

public class SoundHelper extends ScheduledResource{

	private Sound sound;
	private int intendedLoops;
	private int currentLoops = 0;
	private float volume = .7F;

	public SoundHelper(AudioCache.ItemEffect sound, int createTime){
		this(sound.getSound(), createTime, sound.getCounts());
	}

	public SoundHelper(Sound sound, int createTime, int loops) {
		super(createTime);
		this.sound = sound;
		this.intendedLoops = loops;
	}

	@Override
	public boolean update(int time, int delta) {
		if(!super.update(time, delta)) {
			return false;
		}

		if(!this.sound.playing() && this.getStartTime() <= time)
			this.sound.play(1F, this.volume);
		if(this.sound.playing() && this.getEndTime() != -1 && this.getEndTime() <= time) {
			this.sound.stop();
			this.setRunning(false);
			return true;
		}
		if(this.sound.playing() && this.currentLoops >= this.intendedLoops){
			this.sound.stop();
			this.setRunning(false);
			return true;
		}

		this.currentLoops++;

		return true;
	}

	public SoundHelper volume(float volume) {
		this.volume = volume;
		return this;
	}
}
