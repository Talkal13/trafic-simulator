package es.ucm.fdi.model;

import java.util.List;

public class Junction extends SimulatedObject {

	private boolean _trafficLight;
	private List<IncomingRoads> _incomingRoads;
	private List<Road> _outgoingRoads;
	
	public Junction(String id) {
		super(id);
	}
	
	public Road roadTo(Junction j) {
		for (Road r : _outgoingRoads) {
			if (r.getDestination().equals(j)) return r;
		}
		return null; //TODO: THROW EXCEPTION;
	}
	
	public Road roadFrom(Junction j) {
		for (Road r : _outgoingRoads) {
			if (r.getSource().equals(j)) return r;
		}
		return null; //TODO: THROW EXCEPTION;
	}
	
	public List<IncomingRoads> getRoadsInfo() {
		//TODO: no clue xd
		return null;
	}
	
	void addIncomingRoad(Road r) {
		_incomingRoads.add(r);
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

}
