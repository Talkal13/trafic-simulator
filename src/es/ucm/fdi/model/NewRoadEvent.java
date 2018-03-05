package es.ucm.fdi.model;

public class NewRoadEvent extends Event {
	
	protected String _id;
	protected int _maximumSpeed;
	protected int _length;
	protected String _source;
	protected String _destination;
	
	NewRoadEvent(int time, String id, int lenght, int maxSpeed, String source, String destination) {
		super(time);
		_id = id;
		_length = lenght;
		_maximumSpeed = maxSpeed;
		_source = source;
		_destination = destination;
		
	}

	@Override
	public void execute(RoadMap map, int ticks) {
		Junction source = map.getJunction(_source);
		Junction destination = map.getJunction(_destination); //TODO: What to do if it doesnt exist
		map.addRoad(new Road(_id, _length, _maximumSpeed, source, destination));
	}
	
	@Override
	public String toString() {
		return "New Road " + _id;
	}

}
