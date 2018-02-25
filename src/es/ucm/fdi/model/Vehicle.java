package es.ucm.fdi.model;

import java.util.List;

import es.ucm.fdi.ini.IniSection;


public class Vehicle extends SimulatedObject {

	private int _maxSpeed;
	private int _currentSpeed;
	private List<Junction> _itinerary;
	private Road _currentRoad;
	private int _currentLocation;
	private int _kilometers;
	private int _faulty;
	private boolean _inJunction;
	
	public Vehicle(String id, int max_speed, List<Junction> itinerary) {
		super(id);
		_maxSpeed = max_speed;
		_itinerary = itinerary;
		_inJunction = false;
		
	}
	
	public Road getRoad() {
		return _currentRoad;
	}
	
	public int getMaxSpeed() {
		return _maxSpeed;
	}
	
	public int getSpeed() {
		return _currentSpeed;
	}
	
	public int getLocation() {
		return _currentLocation;
	}
	
	public int getKilometrage() {
		return _kilometers;
	}
	
	public int getFaultyTime() {
		return _faulty;
	}
	
	public boolean atDestination() {
		//TODO: If vehicle is at the last point of the itineray (Road and location)
		return false;
	}
	
	public List<Junction> getItineray() {
		return _itinerary;
	}
	
	void makeFaulty(int faultyTime) {
		//TODO: Make sure that is += and not =
		_faulty += faultyTime;
		_currentSpeed = 0;
	}
	
	void setSpeed(int speed) {
		if (_faulty != 0) {
			_currentSpeed = 0;
			return;
		}
		if (_maxSpeed < speed) {
			_currentSpeed = _maxSpeed;
			return;
		}
		_currentSpeed = speed;
	}
	
	void moveToNextRoad() {
		if (_currentRoad != null)
			_currentRoad.exit(this);
		_currentLocation = 0;
	}
	

	@Override
	protected void fillReportDetails(IniSection is) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getReportSectionTag() {
		return "Vehicle";
	}

	@Override
	void advance() {
		if (_faulty != 0) {
			_faulty--;
			return;
		}
		if (_inJunction) { 
			return;
		}
		 
		_currentLocation += _currentSpeed;
		_kilometers += _currentSpeed;
		if (_currentLocation > _currentRoad.getLenght()) {
			_currentRoad.exit(this);
			_inJunction = true;
			_kilometers += _currentRoad.getLenght() - _currentLocation - _currentSpeed;
			_currentLocation = 0;
			_currentSpeed = 0;
			return;
		}
		
		
		
	}
	
	

}
