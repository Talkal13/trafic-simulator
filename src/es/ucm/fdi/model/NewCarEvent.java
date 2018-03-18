package es.ucm.fdi.model;

import java.util.List;

public class NewCarEvent extends NewVehicleEvent{
	
	 private int _resistance; 
	 private int _max_fault_duration;
	 private double _fault_probability; 
	 private long _seed;
	

	public NewCarEvent(int time, String id, int max_speed,  String[] intinerary, int resistance, int max_fault_duration, double fault_probability, long seed) {
		super(time, id, max_speed, intinerary);
		_resistance= resistance;
		this._max_fault_duration = max_fault_duration;
		this._fault_probability = fault_probability;
		this._seed = seed;
	}
	
	public void execute(RoadMap map, int ticks) {
		map.addVehicle(new Car(_id, _max_speed, _resistance, _max_fault_duration, _fault_probability, _seed, map.getJunctions(_itinerary)));
	}
	
	public String toString() {
		return null;
		
	}

}
