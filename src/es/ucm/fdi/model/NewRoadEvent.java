package es.ucm.fdi.model;

public class NewRoadEvent extends Event {
	
	protected String _id;
	protected Integer _MaximumSpeed;
	protected Integer _length;
	protected String _OriginJunctionId;
	protected String _DestinyJunctionId;
	
	NewRoadEvent(Event otherEvent) {
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
