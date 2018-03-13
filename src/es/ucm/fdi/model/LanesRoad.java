package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;

public class LanesRoad extends Road {
	
	private int _numLanes;

	public LanesRoad(String id, int lenght, int maxSpeed, int lanes,  Junction source,
			Junction destination) {
		super(id, lenght, maxSpeed, source, destination);
		_numLanes = lanes;
	}
	
	public int getNumLanes() {
		return _numLanes;
	}
	
	protected int calculateBaseSpeed() {
		return _maxSpeed; //TODO
	}
	
	protected int reduceSpeedFactor(int obstacles) {
		return obstacles < _numLanes ? 1 : 2;
		//return _maxSpeed; //I think it would be like this
	}
	
	protected void fillreportDetails(IniSection is) {
		//TODO
	}
	

}
