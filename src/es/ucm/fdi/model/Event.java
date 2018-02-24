package es.ucm.fdi.model;

import java.util.List;

public abstract class Event {

	Event(Event otherEvent) {
		//TODO
	}

	public Event(Integer num) {
		//TODO
	}
	
	public int getScheduledTime() {
		//TODO
		return 0;
	}
	
	public int compareTo (Event otherEvent) {
		//TODO
		return 0;
	}
	
	protected Junction checkIfJunctionExist(RoadMap map, String idJunction) {
		//TODO
		return null;
	}
	
	protected Vehicle checkIfVehicleExist(RoadMap map, String idVehicle) {
		//TODO
		return null;
	}
	
	protected Road checkIfRoadExist(RoadMap map, String idRoad) {
		//TODO
		return null;
	}
	
	protected List<Junction> parseListOfJunctions(RoadMap map, String[] arrayJunctions){
		//TODO
		return null;
	}
	
	protected List<Vehicle> parseListOfvehicles(RoadMap map, String[] arrayVehicles){
		//TODO
		return null;
	}
	
	public abstract void execute(RoadMap map, int ticks);
	
}
