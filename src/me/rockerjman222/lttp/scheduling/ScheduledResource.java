package me.rockerjman222.lttp.scheduling;

public class ScheduledResource {

	private int startTime;
	private int endTime = -1;
	private boolean running;
	private boolean started = false;

	public ScheduledResource(int startTime) {
		this.startTime = startTime;
	}

	public ScheduledResource endTime(int time){
		this.endTime = this.startTime + time;
		return this;
	}

	public boolean update(int time, int delta){
		if(time >= this.startTime && !hasStarted())
			this.started = true;
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
		return !this.isRunning();
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
