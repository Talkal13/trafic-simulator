package es.ucm.fdi.model;

public class NewCarEvent extends NewVehicleEvent{

	public NewCarEvent(int time, String id, int max_speed, String[] intinerary) {
		super(time, id, max_speed, intinerary);
		// TODO Auto-generated constructor stub
	}
	
	//TODO: understand arguments
	public void execute(RoadMap roadTrip, int ticks) {
		
	}
	
	public String toString() {
		return null;
		
	}

}
