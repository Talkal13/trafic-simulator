package es.ucm.fdi.model;

public class NewVehicleEvent extends Event{
	
	protected String _id;
	protected Integer _MaximumSpeed;
	protected String[] _itinerary;

	NewVehicleEvent(Event otherEvent) {
		super(otherEvent);
		// TODO Auto-generated constructor stub
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
