package es.ucm.fdi.model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo and Diego
 *
 * Class which represents the simulator of the traffic, running it according to the events parsed and generating the output.
 */

public class TrafficSimulator {
	
	private RoadMap _map;
	private int _time;
	private List<Event> _events;
	private OutputStream _outStream;
	
	/**
	 * Constructor of the class, sets the time to 0 and create new objects ArrayList and  Road map.
	 * 
	 * @param outStream stream flow to show the information generated.
	 */

	public TrafficSimulator(OutputStream outStream) {
		this._time = 0;
		_outStream = outStream;
		_events = new ArrayList<Event>();
		_map = new RoadMap();
	}
	
	/**
	 * Runs the simulation during the ticks passed as argument.
	 * 
	 * @param ticks units of time while the simulation will still running.
	 */
	
	public void run (int ticks) {
		int limit = _time + ticks - 1;
		
		while (_time <= limit) {
			for (Event e : _events) {
				if (_time == e.getScheduledTime())
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
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * Adds a certain element to the class attribute that contains the list of elements to take place during the simulation.
	 * 
	 * @param e event to be added to the ArrayList.
	 */
	
	public void addEvent(Event e) {
		_events.add(e);
	}
	
	/**
	 * Resets the current simulation by restoring the time back to 0 and clearing the road map and the array list of elements.
	 */
	
	public void reset() {
		_events.clear();
		_map.clear();
		_time = 0;
	}
	
	/**
	 * Setter method of the outStream class attribute.
	 * 
	 * @param outStream new value that our attribute will be set to.
	 */
	
	public void setOutStream(OutputStream outStream) {
		_outStream = outStream;
	}
	
	//Will be used in the GUI
	/**
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
	*/
}
