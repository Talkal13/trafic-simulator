package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Junction.IncomingRoad;
import es.ucm.fdi.model.JunctionWithTimeSlice.IncomingRoadWithTimeSlice;

public class RoundRobinJunction extends JunctionWithTimeSlice {
	
	public static final String TYPE = "rr";
	
	protected int _maxTimeSlice;
	protected int _minTimeSlice;

	/**
	 * 
	 * @param id
	 * @param minTimeSlice
	 * @param maxTimeSlice
	 */
	
	public RoundRobinJunction(String id, int minTimeSlice, int maxTimeSlice) {
		super(id);
		_maxTimeSlice = maxTimeSlice;
		_minTimeSlice = minTimeSlice;
	}
	
	protected void switchLights() {
		
		if (checkIfAllRed()  && !_incomingRoads.isEmpty()) {
			_incomingRoads.get(0).setGreen(true);
			return;
		}
		for (int i = 0; i < _incomingRoads.size(); i++) {
			if (_incomingRoads.get(i).hasGreenLight() && ((IncomingRoadWithTimeSlice) _incomingRoads.get(i)).timeConsumed()) {
				
				turnLightOff((IncomingRoadWithTimeSlice) _incomingRoads.get(i));
				try {
					_incomingRoads.get(i + 1).setGreen(true);
					break;
				} catch (IndexOutOfBoundsException e) {
					_incomingRoads.get(0).setGreen(true); 
				}
			}
		}
	}
	
	protected void turnLightOff(IncomingRoadWithTimeSlice road) {
		road.setGreen(false);
		if (road.isFullyUsed()) {
			road.setTimeSlice(Math.min(road.getTimeSlice() + 1, this._maxTimeSlice));
		}
		else if (!road.isUsed()) {
			road.setTimeSlice(Math.max(road.getTimeSlice() - 1, _minTimeSlice));
		}
		road.setUsedTimeUnits(0);
		return;
	}
	
	protected void turnLightOn(IncomingRoadWithTimeSlice road) {
		road.setGreen(true);
	}
	
	protected IncomingRoad createIncommingRoadQueue(Road r) {
		IncomingRoadWithTimeSlice s = new IncomingRoadWithTimeSlice(r);
		s.setGreen(false);
		s.setTimeSlice(_maxTimeSlice);
		return s;
	}
	
	protected void fillReportDetails(IniSection is) {
		super.fillReportDetails(is);
		is.setValue("type", TYPE);
	}

}
