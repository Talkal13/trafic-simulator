package es.ucm.fdi.model;

import java.util.List;

import es.ucm.fdi.ini.IniSection;

public class Bike extends Vehicle{
	
	public static final String TYPE = "bike";

	public Bike(String id, int max_speed, List<Junction> itinerary) {
		super(id, max_speed, itinerary);
	}
	
	void makeFaulty(int faultyTime) {
		if (_currentSpeed <= _maxSpeed / 2) {
			return;
		}
		else {
			super.makeFaulty(faultyTime);
		}
	}
	
	protected void fillReportDetails(IniSection is) {
		is.setValue("type", TYPE);
		super.fillReportDetails(is);
	}

}
