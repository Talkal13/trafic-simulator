package es.ucm.fdi.model;

public class NewLanesRoadEvent extends NewRoadEvent{
	
	private int _numLanes;

	public NewLanesRoadEvent(int time, String id, int lenght, int maxSpeed, String source, String destination, int numLanes) {
		super(time, id, lenght, maxSpeed, source, destination);
		_numLanes = numLanes;
	}
	
	//TODO: understand arguments
	public void execute(RoadMap map, int ticks) {
		Junction source = map.getJunction(_source);
		if (source == null) throw new SimulatorError("Junction " + _source + " doesn't exist");
		Junction destination = map.getJunction(_destination);
		if (destination == null) throw new SimulatorError("Junction " + _destination + " doesn't exist");
		map.addRoad(new LanesRoad(_id, _length, _maximumSpeed, _numLanes, source, destination));
	}
	
	public String toString() {
		return null;
		
	}

}
