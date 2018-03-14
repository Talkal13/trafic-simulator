package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;

public class LanesRoad extends Road {
	
	private int _numLanes;
	
	public static final String TYPE = "lanes";

	public LanesRoad(String id, int lenght, int maxSpeed, int lanes,  Junction source,
			Junction destination) {
		super(id, lenght, maxSpeed, source, destination);
		_numLanes = lanes;
	}
	
	public int getNumLanes() {
		return _numLanes;
	}
	
	@Override
	protected int calculateBaseSpeed() {
		_baseSpeed = Math.min(_maxSpeed, (Integer) ((_maxSpeed * _numLanes) / Math.max(_vehicles.size(), 1)) + 1);
		return _baseSpeed;
	}
	
	@Override
	protected int reduceSpeedFactor(int obstacles) {
		return obstacles < _numLanes ? 1 : 2;
	}
	
	@Override
	protected void fillReportDetails(IniSection is) {
		is.setValue("type", TYPE);
		super.fillReportDetails(is);
	}
	

}
