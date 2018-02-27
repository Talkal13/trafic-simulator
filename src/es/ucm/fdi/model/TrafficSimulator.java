package es.ucm.fdi.model;

import java.io.OutputStream;
import java.util.List;

public class TrafficSimulator {
	
	private RoadMap _map;
	private int _counter;
	private List<Event> _events;
	//TODO attribute which is a data structure for storing simulated objects

	public TrafficSimulator(OutputStream flow) {
		//TODO
	}
	
	public void run (int ticks) {
		//TODO
	}
	
	public void addEvent(Event newEvent) {
		//TODO
	}
	
	public void reset() {
		//TODO
	}
	
	public void setOutStream(OutputStream flow) {
		//TODO
	}
	
	public void addObserver(TrafficSimulatorObserver observer) {
		//TODO
	}
	
	public void removerObserver(TrafficSimulatorObserver observer) {
		//TODO
	}
	
	public String toString() {
		//TODO
		return null;
	}
}
