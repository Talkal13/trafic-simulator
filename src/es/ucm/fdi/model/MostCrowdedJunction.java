package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Junction.IncomingRoad;
import es.ucm.fdi.model.JunctionWithTimeSlice.IncomingRoadWithTimeSlice;

public class MostCrowdedJunction extends JunctionWithTimeSlice{

	public static final String TYPE = "mc";
	
	public MostCrowdedJunction(String id) {
		super(id);
		
	}
	
	@Override
	protected IncomingRoad createIncommingRoadQueue(Road r) {
		IncomingRoadWithTimeSlice s = new IncomingRoadWithTimeSlice(r);
		s.setGreen(false);
		return s;
	}
	
	protected IncomingRoadWithTimeSlice getMostCrowded() {
		IncomingRoadWithTimeSlice max;

		if (_incomingRoads.isEmpty()) return null;
		max = (IncomingRoadWithTimeSlice) _incomingRoads.get(0);
		if (_incomingRoads.size() > 1) {
			if (max.hasGreenLight())
				max = (IncomingRoadWithTimeSlice) _incomingRoads.get(1);
		}
		for (int i = 0; i < _incomingRoads.size(); i++) {
			if (max.getQueueSize() < _incomingRoads.get(i).getQueueSize() && !_incomingRoads.get(i).hasGreenLight()) {
				max = (IncomingRoadWithTimeSlice) _incomingRoads.get(i);
			}
		}
		return max;
	}
	
	protected void switchLights() {
		
		if (checkIfAllRed()  && !_incomingRoads.isEmpty()) {
			turnLightOn();
		}
		for (int i = 0; i < _incomingRoads.size(); i++) {
			if (_incomingRoads.get(i).hasGreenLight() && ((IncomingRoadWithTimeSlice) _incomingRoads.get(i)).timeConsumed()) {
				
				
				if (!_incomingRoads.get(i).equals(turnLightOn()))
					_incomingRoads.get(i).setGreen(false);
			}
		}
			
	}
	
	protected void turnLightOff() {
		
	}
	
	protected IncomingRoadWithTimeSlice turnLightOn() {
		IncomingRoadWithTimeSlice max = getMostCrowded();
		
		max.setTimeSlice(Math.max((int) (max.getQueueSize() / 2), 1));
		max.setUsedTimeUnits(0);
		max.setGreen(true);
		return max;
	}
	
	protected void fillReportDetails(IniSection is) {
		super.fillReportDetails(is);
		is.setValue("type", TYPE);
	}
}
