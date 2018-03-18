package es.ucm.fdi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.misc.SortedArrayList;
import es.ucm.fdi.model.Junction.IncomingRoad;

/**
 * 
 * @author Pablo and Diego
 * 
 * Class of the object junction, extension of the SimulatedObject. This class represent the junction which are used by vehicles, 
 * to go from one road to other.
 *
 */

public class Junction extends SimulatedObject {

	private boolean _trafficLight;
	protected List<IncomingRoad> _incomingRoads;
	protected List<Road> _outgoingRoads;
	
	/**
	 * Constructor of the class, given a certain identification, passed as parameter, a new instance of the object junction is created.
	 * 
	 * @param id identifier of the current road
	 */
	
	public Junction(String id) {
		super(id);
		_incomingRoads = new ArrayList<IncomingRoad>();
		_outgoingRoads = new ArrayList<Road>();
	}
	
	/**
	 * 
	 * @param j Destination Junction of the road to find
	 * @return The road with the destination Junction j
	 */
	public Road roadTo(Junction j) {
		for (Road r : _outgoingRoads) {
			if (r.getDestination().equals(j)) return r;
		}
		throw new SimulatorError("Road not found from " + this.getId() + " to " + j.getId());
	}
	
	//never used?
	public Road roadFrom(Junction j) {
		for (Road r : _outgoingRoads) {
			if (r.getSource().equals(j)) return r;
		}
		throw new SimulatorError("Road not found from " + j.getId() + " to " + this.getId());
	}
	
	public List<IncomingRoad> getRoadsInfo() {
		return _incomingRoads;
	}
	
	void addIncomingRoad(Road r) {
		_incomingRoads.add(createIncommingRoadQueue(r));
	}
	
	void addOutgoingRoad(Road r) {
		_outgoingRoads.add(r);
	}
	
	void enter(Vehicle v) {
		for (IncomingRoad r : _incomingRoads) {
			if (v.getRoad().equals(r.getRoad())) {
				r.addVehicle(v);
				v.setSpeed(0);
				return;
			}
		}
		//TODO: Maybe throw exception
	}
	
	protected void switchLights() {
		
		if (checkIfAllRed() && !_incomingRoads.isEmpty()) {
			_incomingRoads.get(0).setGreen(true);
			return;
		}
		
		for (int i = 0; i < _incomingRoads.size(); i++) {
			if (_incomingRoads.get(i).hasGreenLight()) {
				_incomingRoads.get(i).setGreen(false);
				try {
					_incomingRoads.get(i + 1).setGreen(true);
					break;
				} catch (IndexOutOfBoundsException e) {
					_incomingRoads.get(0).setGreen(true); //Un poco guarro
				}
			}
		}
	}
	
	protected IncomingRoad createIncommingRoadQueue(Road r) {
		return new IncomingRoad(r);
	}

	@Override
	protected void fillReportDetails(IniSection is) {
		String report = "";
		if (!_incomingRoads.isEmpty()) {
			for (int i = 0; i < _incomingRoads.size() - 1; i++) {
				report += _incomingRoads.get(i).toString().replace(" ", "") + ",";
			}
			report += _incomingRoads.get(_incomingRoads.size() - 1).toString();
		}
		
		is.setValue("queues", report);
	}

	@Override
	protected String getReportSectionTag() {
		return "junction_report";
	}
	
	protected boolean checkIfAllRed() {
		for (IncomingRoad road : _incomingRoads) {
			if (road.hasGreenLight()) {
				return false;
			}
		}
		return true;
	}

	@Override
	void advance() {
		
		
		
		for (IncomingRoad road : _incomingRoads) {
			if (road.hasGreenLight()) {
				road.advanceFirstVehicle();
				break;
			}
		}
		switchLights();
		
	}
	
	static public class IncomingRoad {
		
		protected Road _road;
		protected List<Vehicle> _queue;
		protected boolean _green;
		
		/**
		 * Create an empty queue and set the light to red.
		 * 
		 * @param road
		 */
		protected IncomingRoad(Road road) {
			_queue = new SortedArrayList<Vehicle>();
			_green = false;
			_road = road;
		}
		
		protected int getQueueSize() {
			return _queue.size();
		}
		
		/**
		 * returns the road.
		 * 
		 * @return the incoming road
		 */
		
		public Road getRoad() { 
			return _road;
		}
		/**
		 * Consult the light.
		 * 
		 * @return true if is green, false otherwise
		 */
		
		public boolean hasGreenLight() {
			return _green;
		}
		
		/**
		 * Sets the light.
		 * 
		 * @param green new value the light will have.
		 */
		
		protected void setGreen(boolean green) {
			_green = green;
			return;
		}
		
		/**
		 * Tell the first vehicle in _queue if any, to moveToNextRoad and remove it from the queue
		 */
		
		protected void advanceFirstVehicle() {
			try {
				Vehicle v = _queue.remove(0);
				v.moveToNextRoad();
			} catch (IndexOutOfBoundsException e) {
				return;
			}
		}
		
		/**
		 * Add vehicle v to the queue.
		 * 
		 * @param v vehicle to be added to the queue.
		 */
		
		protected void addVehicle(Vehicle v) {
			_queue.add(v);
		}
		
		/**
		 * return a string that represents the queue as require in the junction report.
		 */
		
		public String toString() {
			String st = "";
			st += "(" + _road.getId() + ",";
			if (_green)
				st +=  "green," +  _queue + ")";
			else
				st += "red," + _queue + ")";
			return st;
		}
		
	}

}
