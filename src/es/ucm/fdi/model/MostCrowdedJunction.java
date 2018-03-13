package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;

public class MostCrowdedJunction extends JunctionWithTimeSlice{

	public MostCrowdedJunction(String id) {
		super(id);
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
