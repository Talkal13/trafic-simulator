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

public class TrafficSimulator implements Observable<TrafficSimulatorObserver> {
	
	private RoadMap _map;
	private int _time;
	private List<Event> _events;
	private OutputStream _outStream;
	
	private List<TrafficSimulatorObserver> obs;
	
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
			//try {
				for (Event e : _events) {
					if (_time == e.getScheduledTime()) {
						//NotifyNewEvent(e);
						e.execute(_map, _time);
					}
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			//} catch (Exception e) {
				//NotifyError();
			//}
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
		NotifyReset();
	}
	
	/**
	 * Notify to the observers the simulator has been reseted
	 */
	public void NotifyReset() {
		for (TrafficSimulatorObserver o : obs) {
			o.onReset(this);
		}
	}
	
	/**
	 * Notify to the observers the simulator has a new event
	 */
	public void NotifyNewEvent(Event e) {
		for (TrafficSimulatorObserver o : obs) {
			o.onNewEvent(e, _map, _time);
		}
	}
	
	/**
	 * Notify to the observers the simulator has advanced
	 */
	public void NotifyAdvance(SimulatedObject k) {
		for (TrafficSimulatorObserver o : obs) {
			o.onAdvance(k);
		}
	}
	
	/**
	 * Notify to the observers the simulator had an error
	 */
	public void NotifyError() {
		for (TrafficSimulatorObserver o : obs) {
			o.onError(this);
		}
	}
	
	
	/**
	 * Setter method of the outStream class attribute.
	 * 
	 * @param outStream new value that our attribute will be set to.
	 */
	
	public void setOutStream(OutputStream outStream) {
		_outStream = outStream;
	}

	/**
	 * 
	 * Adds a class to the list of observers
	 * 
	 * @param observer
	 */
	@Override
	public void addObserver(TrafficSimulatorObserver observer) {
		obs.add(observer);
		observer.onRegistered(this);
	}
	
	/**
	 * 
	 * Removes a class from the list of observers
	 * 
	 * @param observer
	 */
	@Override
	public void removeObserver(TrafficSimulatorObserver observer) {
		obs.remove(observer);
		
	}
	
	public String toString() {
		//TODO
		return null;
	}
}
