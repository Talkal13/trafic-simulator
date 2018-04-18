package es.ucm.fdi.model;

public class NewBikeEvent extends NewVehicleEvent{

	public NewBikeEvent(int time, String id, int max_speed, String[] intinerary) {
		super(time, id, max_speed, intinerary);
	}
	
	
	public void execute(RoadMap roadTrip, int ticks) {
		roadTrip.addVehicle(new Bike(_id, _max_speed, roadTrip.getJunctions(_itinerary)));
	}
	

}
