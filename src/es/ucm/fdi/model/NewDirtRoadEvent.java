package es.ucm.fdi.model;

public class NewDirtRoadEvent extends NewRoadEvent{

	public NewDirtRoadEvent(int time, String id, int lenght, int maxSpeed, String source, String destination) {
		super(time, id, lenght, maxSpeed, source, destination);
	}
	
	//TODO: understand arguments
	public void execute(RoadMap map, int ticks) {
		Junction source = map.getJunction(_source);
		if (source == null) throw new SimulatorError("Junction " + _source + " doesn't exist");
		Junction destination = map.getJunction(_destination);
		if (destination == null) throw new SimulatorError("Junction " + _destination + " doesn't exist");
		map.addRoad(new DirtRoad(_id, _length, _maximumSpeed, source, destination));
	}
	
	public String toString() {
		return null;
		
	}

}
