package es.ucm.fdi.model;

import java.util.List;

import es.ucm.fdi.ini.IniSection;

public class Bike extends Vehicle{

	public Bike(String id, int max_speed, List<Junction> itinerary) {
		super(id, max_speed, itinerary);
		// TODO Auto-generated constructor stub
	}
	
	void makeFaulty(int faultyTime) {
		//TODO
	}
	
	protected void fillReportDetails(IniSection is) {
		//TODO
	}

}
