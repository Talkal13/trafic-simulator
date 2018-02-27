package es.ucm.fdi.model;

import java.util.List;

public class Junction extends SimulatedObject {

	private boolean _trafficLight;
	protected List<IncomingRoad> _incomingRoads;
	protected List<Road> _outgoingRoads;
	
	public Junction(String id) {
		super(id);
	}
	
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
		
	}
	
	protected void switchLights() {
		_trafficLight = !_trafficLight;
	}
	
	protected IncomingRoad createIncommingRoadQueue(Road r) {
		//TODO: :(
	}

	@Override
	protected void fillReportDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getReportSectionTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void advance() {
		// TODO Auto-generated method stub
		
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
			
		}
		
		/**
		 * Add vehicle v to the queue.
		 * 
		 * @param v vehicle to be added to the queue.
		 */
		
		protected void addVehicle(Vehicle v) {
			
		}
		
		/**
		 * return a string that represents the queue as require in the junction report.
		 */
		
		public String toString() {
			return null; //TODO
		}
		
	}

}
