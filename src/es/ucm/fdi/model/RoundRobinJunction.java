package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Junction.IncomingRoad;

public class RoundRobinJunction extends JunctionWithTimeSlice{
	
	protected int _maxTimeSlice;
	protected int _minTimeSlice;

	public RoundRobinJunction(String id, int minTimeSlice, int maxTimeSlice) {
		super(id);
		_maxTimeSlice = minTimeSlice;
		_minTimeSlice = maxTimeSlice;
	}
	
	protected IncomingRoad createIncomingRoadQueue(Road incoming) {
		return null;
	}
	
	protected void switchLights() {
		
	}
	
	protected void turnLightOff() {
		
	}
	protected void turnLightOn() {
		
	}
	
	protected void fillReportDetails(IniSection is) {
	
	}

}
