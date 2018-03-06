package es.ucm.fdi.model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class TrafficSimulator {
	
	private RoadMap _map;
	private int _time;
	private List<Event> _events;
	private OutputStream _outStream;
	//TODO attribute which is a data structure for storing simulated objects

	public TrafficSimulator(OutputStream outStream) {
		this._time = 0;
		_outStream = outStream;
	}
	
	public void run (int ticks) {
		int limit = _time + ticks - 1;
		while (_time <= limit) {
			for (Event e : _events) {
				e.execute(_map, _time);
			}
			
			for (Road e : _map.getRoads()) {
				e.advance();
			}
			
			for (Junction j : _map.getJunctions()) {
				j.advance();
			}
			_time++;
			try {
				_outStream.write(_map.generateReport(_time).getBytes());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void addEvent(Event e) {
		_events.add(e);
	}
	
	public void reset() {
		_events.clear();
		_map.clear();
		_time = 0;
	}
	
	public void setOutStream(OutputStream outStream) {
		_outStream = outStream;
	}
	/**
	public void addObserver(TrafficSimulatorObserver observer) {
		//TODO
	}
	
	public void removerObserver(TrafficSimulatorObserver observer) {
		//TODO
	}
	*/
	public String toString() {
		//TODO
		return null;
	}
}
