package es.ucm.fdi.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Event {
	
	protected int _time;

	Event(Event otherEvent) {
		_time = otherEvent.getScheduledTime();
	}

	public Event(int num) {
		_time = num;
	}
	
	/**
	 * Allow us to consult the time f an event.
	 * 
	 * @return time which is supposed to be executed
	 */
	
	public int getScheduledTime() {
		return _time;
	}
	
	public int compareTo (Event otherEvent) {
		return _time;
	}
	
	protected Junction checkIfJunctionExist(RoadMap map, String idJunction) {
		return map.getJunction(idJunction);
	}
	
	protected Vehicle checkIfVehicleExist(RoadMap map, String idVehicle) {
		return map.getVehicle(idVehicle);
	}
	
	protected Road checkIfRoadExist(RoadMap map, String idRoad) {
		return map.getRoad(idRoad);
	}
	
	protected List<Junction> parseListOfJunctions(RoadMap map, String[] arrayJunctions){
		List<Junction> j = new ArrayList<Junction>();
		for (String s : arrayJunctions) {
			j.add(map.getJunction(s));
		}
		return j;
	}
	
	protected List<Vehicle> parseListOfvehicles(RoadMap map, String[] arrayVehicles){
		List<Vehicle> j = new ArrayList<Vehicle>();
		for (String s : arrayVehicles) {
			j.add(map.getVehicle(s));
		}
		return j;
	}
	
	public abstract void execute(RoadMap map, int ticks);
	
}
