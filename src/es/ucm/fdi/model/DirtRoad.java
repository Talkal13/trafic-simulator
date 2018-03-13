package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;

public class DirtRoad extends Road {

	public DirtRoad(String id, int lenght, int maxSpeed, Junction source, Junction destination) {
		super(id, lenght, maxSpeed, source, destination);
	}
	
	protected int calculateBaseSpeed() {
		return _maxSpeed; //TODO
	}
	
	protected int reduceSpeedFactor(int obstacles) {
		return obstacles + 1; //TODO
	}
	
	protected void fillreportDetails(IniSection is) {
		//TODO
	}
	

}
