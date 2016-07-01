package me.rockerjman222.lttp.scheduling;

import me.rockerjman222.lttp.assets.AudioCache;
import org.newdawn.slick.Music;

public class MusicHelper extends ScheduledResource {


	private Music music;
	private float intendedTime;
	private float volume = .7F;

	public MusicHelper(AudioCache.MusicEffect music, int createTime){
		this(music, createTime, 1);
	}

	public MusicHelper(AudioCache.MusicEffect music, int createTime, int loops) {
		super(createTime);
		this.music = music.getMusic();
		this.intendedTime = music.getSecondsTime() == -1 ? -1 : loops * music.getSecondsTime();
	}

	@Override
	public boolean update(int time, int delta) {
		if(!super.update(time, delta)) {
			return false;
		}

		if(!this.music.playing() && this.getStartTime() <= time)
			this.music.play(1F, this.volume);
		if(this.music.playing() && this.getEndTime() != -1 && this.getEndTime() <= time) {
			this.music.stop();
			this.setRunning(false);
			return true;
		}
		if(this.music.playing() && this.intendedTime != -1 && this.music.getPosition() >= this.intendedTime){
			this.music.stop();
			this.setRunning(false);
			return true;
		}

		return true;
	}

	public MusicHelper volume(float volume) {
		this.music.setVolume(volume);
		return this;
	}
	
}
