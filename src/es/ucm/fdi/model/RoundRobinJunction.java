package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Junction.IncomingRoad;

public class RoundRobinJunction extends JunctionWithTimeSlice{

	public RoundRobinJunction(String id, int r1, int r2) {
		super(id);
		// TODO Auto-generated constructor stub
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
