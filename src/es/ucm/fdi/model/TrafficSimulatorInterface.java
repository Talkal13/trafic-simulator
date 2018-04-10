package es.ucm.fdi.model;

import java.util.List;

public interface TrafficSimulatorInterface {
	public int getTime();
	public RoadMapInterface getRoadMap();
	
	//notify errors
	public void simulatorError (int time, RoadMap map, List<Event> events, SimulatorError e);
	//notify the advance of the simulated objects 
	public void advance (int time, RoadMap map, List<Event> events);
	//notify that a new object has been generated
	public void addEvent (int time, RoadMap map, List<Event> events);
	//notify that the simulation has been reset
	public void reset (int time, RoadMap map, List<Event> events);

}
