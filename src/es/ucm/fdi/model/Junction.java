package es.ucm.fdi.model;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.misc.SortedArrayList;

/**
 * 
 * @author Pablo & Diego
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
	 * @param j
	 * @return
	 */
	public Road roadTo(Junction j) {
		for (Road r : _outgoingRoads) {
			if (r.getDestination().equals(j)) return r;
		}
		return null; //TODO: THROW EXCEPTION;
	}
	
	//never used?
	public Road roadFrom(Junction j) {
		for (Road r : _outgoingRoads) {
			if (r.getSource().equals(j)) return r;
		}
		return null; //TODO: THROW EXCEPTION;
	}
	
	public List<IncomingRoad> getRoadsInfo() {
		//TODO: no clue xd
		return null;
	}
	
	void addIncomingRoad(Road r) {
		_incomingRoads.add(new IncomingRoad(r));
	}
	
	void addOutgoingRoad(Road r) {
		_outgoingRoads.add(r);
	}
	
	void enter(Vehicle v) {
		for (IncomingRoad r : _incomingRoads) {
			if (v.getRoad().equals(r.getRoad())) {
				r.addVehicle(v);
				return;
			}
		}
		//TODO: Maybe throw exception
	}
	
	protected void switchLights() {
		for (int i = 0; i < _incomingRoads.size(); i++) {
			if (_incomingRoads.get(i)._green) {
				_incomingRoads.get(i).setGreen(false);
				try {
					_incomingRoads.get(i + 1).setGreen(true);
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
		is.setValue("queues", _incomingRoads);
	}

	@Override
	protected String getReportSectionTag() {
		return "junction_report";
	}

	@Override
	void advance() {
		for (IncomingRoad road : _incomingRoads) {
			if (road.hasGreenLight()) {
				road.advanceFirstVehicle();
				switchLights();
				break;
			}
		}
		
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
			st += "(" + _road.getId() + "," + _green + _queue;
			return st;
		}
		
	}

}
