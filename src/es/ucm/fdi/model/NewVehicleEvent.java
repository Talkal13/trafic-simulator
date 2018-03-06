package es.ucm.fdi.model;

public class NewVehicleEvent extends Event{
	
	protected String _id;
	protected Integer _MaximumSpeed;
	protected String[] _itinerary;

	public NewVehicleEvent(int time, String _id, int max_speed, String[] intinerary) {
		super(time);
		
	}

	@Override
	public void execute(RoadMap map, int ticks) {
		// TODO Auto-generated method stub
		
	}
	public String toString() {
		//TODO
		return null;
	}

}
