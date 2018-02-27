package es.ucm.fdi.model;

import java.io.OutputStream;
import java.util.List;

public class TrafficSimulator {
	
	private RoadMap _map;
	private int _time;
	private List<Event> _events;
	private OutputStream _outStream;
	//TODO attribute which is a data structure for storing simulated objects

	public TrafficSimulator(OutputStream outStream) {
		//TODO
	}
	
	public void run (int ticks) {
		//TODO
	}
	
	public void addEvent(Event e) {
		//TODO
	}
	
	public void reset() {
		//TODO
	}
	
	public void setOutStream(OutputStream outStream) {
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
