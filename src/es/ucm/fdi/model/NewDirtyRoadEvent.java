package es.ucm.fdi.model;

public class NewDirtyRoadEvent extends NewRoadEvent{

	public NewDirtyRoadEvent(int time, String id, int lenght, int maxSpeed, String source, String destination) {
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
