package es.ucm.fdi.model;

public class NewLanesRoadEvent extends NewRoadEvent{

	public NewLanesRoadEvent(int time, String id, int lenght, int maxSpeed, String source, String destination) {
		super(time, id, lenght, maxSpeed, source, destination);
		// TODO Auto-generated constructor stub
	}
	
	//TODO: understand arguments
	public void execute(RoadMap roadTrip, int ticks) {
		
	}
	
	public String toString() {
		return null;
		
	}

}
