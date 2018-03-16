package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Junction.IncomingRoad;
import es.ucm.fdi.model.JunctionWithTimeSlice.IncomingRoadWithTimeSlice;

public class RoundRobinJunction extends JunctionWithTimeSlice {
	
	public static final String TYPE = "rr";
	
	protected int _maxTimeSlice;
	protected int _minTimeSlice;

	public RoundRobinJunction(String id, int minTimeSlice, int maxTimeSlice) {
		super(id);
		_maxTimeSlice = minTimeSlice;
		_minTimeSlice = maxTimeSlice;
	}
	
	protected void switchLights() {
		
		if (checkIfAllRed()) {
			_incomingRoads.get(0).setGreen(true);
		}
		for (int i = 0; i < _incomingRoads.size(); i++) {
			if (_incomingRoads.get(i).hasGreenLight() && ((IncomingRoadWithTimeSlice) _incomingRoads.get(i)).timeConsumed()) {
				_incomingRoads.get(i).setGreen(false);
				try {
					_incomingRoads.get(i + 1).setGreen(true);
					break;
				} catch (IndexOutOfBoundsException e) {
					_incomingRoads.get(0).setGreen(true); //Un poco guarro
				}
			}
		}
	}
	
	protected void turnLightOff() {
		
	}
	
	protected void turnLightOn() {
		
	}
	
	
	
	protected void fillReportDetails(IniSection is) {
		super.fillReportDetails(is);
		is.setValue("type", TYPE);
	}

}
