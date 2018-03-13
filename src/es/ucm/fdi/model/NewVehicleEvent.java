package es.ucm.fdi.model;

import java.util.ArrayList;
import java.util.List;

public class NewVehicleEvent extends Event{
	
	protected String _id;
	protected Integer _max_speed;
	protected String[] _itinerary;

	public NewVehicleEvent(int time, String id, int max_speed, String[] intinerary) {
		super(time);
		_id = id;
		_max_speed = max_speed;
		_itinerary = intinerary;
	}

	@Override
	public void execute(RoadMap map, int ticks) {
		
		map.addVehicle(new Vehicle(_id, _max_speed, map.getJunctions(_itinerary)));
		
	}
	

	public String toString() {
		//TODO
		return null;
	}

}
