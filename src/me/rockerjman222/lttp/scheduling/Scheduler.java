package me.rockerjman222.lttp.scheduling;

import me.rockerjman222.lttp.Main;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class Scheduler {

	private static Scheduler instance;
	private LinkedHashMap<UUID, ScheduledResource> scheduleList = new LinkedHashMap<>();

	public Scheduler() {
		instance = this;
	}

	public void updateResources(int programTime, int delta){

		for(Map.Entry<UUID, ScheduledResource> entry : new LinkedHashMap<>(this.scheduleList).entrySet()){

			ScheduledResource resource = entry.getValue();

			if(resource.hasFinished()){
				this.scheduleList.remove(entry.getKey());
				continue;
			}

			resource.update(programTime, delta);
		}

	}

	public void drawResources(){
		for(Map.Entry<UUID, ScheduledResource> entry : new LinkedHashMap<>(this.scheduleList).entrySet()){

			ScheduledResource resource = entry.getValue();

			if(resource.hasFinished()){
				this.scheduleList.remove(entry.getKey());
				continue;
			}

			if(resource instanceof AnimationHelper) {
				((AnimationHelper) resource).draw(Main.scale);
			}

		}
	}

	public void drawAdditionalResources(Graphics2D graphics) {
		for (Map.Entry<UUID, ScheduledResource> entry : new LinkedHashMap<>(this.scheduleList).entrySet()) {

			ScheduledResource resource = entry.getValue();

			if (resource.hasFinished()) {
				this.scheduleList.remove(entry.getKey());
				continue;
			}
			if(resource instanceof AnimationHelper)
				((AnimationHelper) resource).drawAdditional();

		}

	}

	public UUID scheduleResource(ScheduledResource schedule){
		this.scheduleList.put(schedule.getIdentifier(), schedule);
		System.out.println(schedule.getIdentifier());
		System.out.println("Entries: " + this.scheduleList.size());
		return schedule.getIdentifier();
	}

	public LinkedHashMap<UUID, ScheduledResource> getScheduleList() {
		return scheduleList;
	}

	public void clearSchedule(){
		this.scheduleList.clear();
	}

	public boolean hasSchedule(UUID key){
		return this.scheduleList.containsKey(key);
	}

	public ScheduledResource getResource(UUID uuid){

		return this.scheduleList.get(uuid);
	}

	public static Scheduler getInstance(){
		return instance;
	}

}
