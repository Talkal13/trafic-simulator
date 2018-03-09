package es.ucm.fdi.model;

import java.util.List;

import es.ucm.fdi.ini.IniSection;

public class Car extends Vehicle{

	public Car(String id, int max_speed, List<Junction> itinerary) {
		super(id, max_speed, itinerary);
		// TODO Auto-generated constructor stub
	}
	
	void advance() {
		//TODO
	}
	
	protected void fillReportDetails(IniSection is) {
		//TODO
	}

}
