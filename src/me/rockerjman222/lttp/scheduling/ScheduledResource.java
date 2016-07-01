package me.rockerjman222.lttp.scheduling;

import java.util.UUID;

public class ScheduledResource {

	private int startTime;
	private int endTime = -1;
	private boolean running;
	private boolean started = false;
	private UUID identifier;


	Runnable updaterAdditional;

	public ScheduledResource(int startTime) {
		this.startTime = startTime;
		this.identifier = UUID.randomUUID();
	}

	public ScheduledResource endTime(int time){
		this.endTime = this.startTime + time;
		return this;
	}

	/**
	 * @return false if the update was cancelled, true if it executed successfully
	 * */
	public boolean update(int time, int delta){
		if(time >= this.startTime && !hasStarted()) {
			this.started = true;
			this.running = true;
		}
		if(!hasStarted() || (hasStarted() && hasFinished()))
			return false;

		return true;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public boolean hasStarted() {
		return started;
	}

	public boolean isRunning(){
		return this.running;
	}

	public boolean hasFinished(){
		return !this.isRunning() && this.started;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public UUID getIdentifier() {
		return identifier;
	}

	public Runnable getUpdaterAdditional() {
		return updaterAdditional;
	}

	public void setUpdaterAdditional(Runnable updaterAdditional) {
		this.updaterAdditional = updaterAdditional;
	}

	protected enum DirectionMoved{
		POSITIVE,
		NEGATIVE
	}

}

