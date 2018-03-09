package es.ucm.fdi.model;

import java.util.ArrayList;
import java.util.List;

public class NewVehicleEvent extends Event{
	
	protected String _id;
	protected Integer _MaximumSpeed;
	protected String[] _itinerary;

	public NewVehicleEvent(int time, String id, int max_speed, String[] intinerary) {
		super(time);
		_id = id;
		_MaximumSpeed = max_speed;
		_itinerary = intinerary;
	}

	@Override
	public void execute(RoadMap map, int ticks) {
		List<Junction> itinerary = new ArrayList<Junction>();
		for (String s : _itinerary) {
			itinerary.add(map.getJunction(s));
		}
		map.addVehicle(new Vehicle(_id, _MaximumSpeed, itinerary));
		
	}
	

	public String toString() {
		//TODO
		return null;
	}

}
