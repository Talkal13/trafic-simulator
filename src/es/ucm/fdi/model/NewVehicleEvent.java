package es.ucm.fdi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo & Diego
 * 
 * Class which creates a new object vehicle to be placed in the simulation.
 */

public class NewVehicleEvent extends Event{
	
	protected String _id;
	protected Integer _max_speed;
	protected String[] _itinerary;

	/**
	 * Constructor of the class, sets the class attributes to the arguments.
	 * 
	 * @param tick number which the vehicle will be introduced to the road map.
	 * @param id unique identifier of vehicle.
	 * @param max_speed maximun speed that the vehicle could reach.
	 * @param intinerary list of junctions to traverse in order to reach its destiny.
	 */
	
	public NewVehicleEvent(int time, String id, int max_speed, String[] intinerary) {
		super(time);
		_id = id;
		_max_speed = max_speed;
		_itinerary = intinerary;
	}

	/**
	 * Adds to the road map the vehicle with the attributes of the class.
	 * 
	 * @param RoadMap map of roads which where the simulation takes place.
	 * @param ticks number of ticks.
	 */
	
	public void execute(RoadMap map, int ticks) {
		map.addVehicle(new Vehicle(_id, _max_speed, map.getJunctions(_itinerary)));	
	}


}
