package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;

public class DirtRoad extends Road {
	
	public static final String TYPE = "dirt";

	public DirtRoad(String id, int lenght, int maxSpeed, Junction source, Junction destination) {
		super(id, lenght, maxSpeed, source, destination);
	}
	
	protected int calculateBaseSpeed() {
		return _maxSpeed; //TODO
	}
	
	protected int reduceSpeedFactor(int obstacles) {
		return obstacles + 1; //TODO
	}
	
	@Override
	protected void fillReportDetails(IniSection is) {
		is.setValue("type", TYPE);
		super.fillReportDetails(is);
	}
	

}
