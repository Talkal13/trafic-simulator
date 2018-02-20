package es.ucm.fdi.model;

import java.util.List;


public class Vehicle extends SimulatedObject {

	private int _maxSpeed;
	private int _currentSpeed;
	private List<Junction> _itinerary;
	private Road _currentRoad;
	private int _currentLocation;
	private int _kilometers;
	private int _faulty;
	
	public Vehicle(String id, int max_speed, List<Junction> itinerary) {
		super(id);
		_maxSpeed = max_speed;
		_itinerary = itinerary;
		
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
	
	void makeFaulty(int faulty) {
		//TODO: Make sure that is += and not =
		_faulty += faulty;
	}
	
	void setSpeed(int speed) {
		if (_maxSpeed < speed) {
			_currentSpeed = _maxSpeed;
		}
		_currentSpeed = speed;
	}
	
	void moveToNextRoad() {
		
	}
	

	@Override
	protected void fillReportDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getReportSectionTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void advance() {
		// TODO Auto-generated method stub
		
	}
	
	

}
