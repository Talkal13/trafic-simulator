package es.ucm.fdi.model;

import java.util.Comparator;
import java.util.List;

import es.ucm.fdi.ini.IniSection;

/**
 * 
 * @author Pablo & Diego
 * 
 * Class of the object vehicle, extension of the SimulatedObject. this class represent the vehicles which will traverse the roads and junctions of the 
 * simulation.
 *
 */

public class Vehicle extends SimulatedObject {

	private int _maxSpeed;
	private int _currentSpeed;
	private List<Junction> _itinerary;
	private Road _currentRoad;
	private int _currentLocation;
	private int _kilometers;
	private int _faulty;
	private boolean _inJunction;
	private int _index;
	
	/**
	 * Constructor of the class. Calls the constructor of SimulatedObject with the id introduced as parameter, 
	 * and assigns the other two parameters to the class attributes, also set _inJuctin as is not in a junction.
	 * 
	 * @param id unique identifier of the object vehicle
	 * @param max_speed maximun speed which the vehicle could reach
	 * @param itinerary list of junctions which the vehicle has as itinerary to go through.
	 */
	
	public Vehicle(String id, int max_speed, List<Junction> itinerary) {
		super(id);
		_maxSpeed = max_speed;
		_itinerary = itinerary;
		_inJunction = false;
		_index = 0;
		
	}
	
	/**
	 * Getter of the class attribute _currentRoad
	 *  
	 * @return the road where the vehicle is at the moment.
	 */
	
	public Road getRoad() {
		return _currentRoad;
	}
	
	/**
	 * Getter of the class attribute _maxSpeed
	 * 
	 * @return the maximum speed the car could reach
	 */
	
	public int getMaxSpeed() {
		return _maxSpeed;
	}
	
	/**
	 * Getter of the class attribute _currentSpeed
	 * 
	 * @return the current speed of the vehicle.
	 */
	
	public int getSpeed() {
		return _currentSpeed;
	}
	
	/**
	 * Getter of the class attribute _currentLocation 
	 * 
	 * @return the current location of the vehicle in the system.
	 */
	
	public int getLocation() {
		return _currentLocation;
	}
	
	/**
	 * Getter of the class attribute _kilometers
	 * 
	 * @return the total amount of kilometers the vehicle has driven.
	 */
	
	public int getKilometrage() {
		return _kilometers;
	}
	
	/**
	 * Getter of the class attribute _faulty
	 * 
	 * @return the number of ticks the object will be faulty, if is faulty.
	 */
	
	public int getFaultyTime() {
		return _faulty;
	}
	
	/**
	 * Boolean function which checks if the vehicle has reach it�s destiny.
	 * 
	 * @return true if the vehicle is in it�s destination or false if doesn't.
	 */
	
	public boolean atDestination() {
		return (_currentRoad.getLenght() <= _currentLocation && _itinerary.get(_itinerary.size() - 1).equals(_currentRoad.getDestination()));
	}
	
	/**
	 * Getter of the list which contains the itinerary the vehicle has to traverse.
	 * 
	 * @return List of the Junctions the vehicle has yet to go through.
	 */
	
	public List<Junction> getItineray() {
		return _itinerary;
	}
	
	/**
	 * Puts the vehicle in a faulty state for faultyTime ticks.
	 * If the vehicle is already faulty, then faultyTime is accumulated to the _faulty counter.
	 * 
	 * @param faultyTime time meanwhile the vehicle will be faulty.
	 */
	
	void makeFaulty(int faultyTime) {
		_faulty += faultyTime;
		_currentSpeed = 0;
	}
	
	/**
	 * Sets the speed of a vehicle.
	 * If the provided speed, exceeds the maximum speed of the vehicle, the speed is set to the maximum speed.
	 * 
	 * @param speed new speed the vehicle will drive.
	 */
	
	void setSpeed(int speed) {
		if (_faulty != 0) { // if is faulty, the speed will be 0.
			_currentSpeed = 0;
			return;
		}
		if (_maxSpeed < speed) {// if the attribute is greater than maximum of the vehicle, it will drive at _maxSpeed.
			_currentSpeed = _maxSpeed;
			return;
		}
		_currentSpeed = speed;	//if not faulty and attribute not greater than the maximum, it drives at that speed.
	}
	
	/**
	 * Ask the vehicle to move on the next road, 
	 */
	
	void moveToNextRoad() {
		if (_currentRoad != null) {	//first time is called, it hasn't entered in any road yet, so no road to exit from.
			_currentRoad.exit(this);
			if (atDestination())
				return;
			_currentRoad = _currentRoad.getDestination().roadTo(_itinerary.get(_index));
		} else {
			_currentRoad = _itinerary.get(_index).roadTo(_itinerary.get(_index + 1));
			_index++;
		}
		_inJunction = false;
		
		_currentLocation = 0;
		_currentRoad.enter(this);
	}
	

	@Override
	protected void fillReportDetails(IniSection is) {
		is.setValue("speed", _currentSpeed);
		is.setValue("kilometrage", _kilometers);
		is.setValue("faulty", _faulty);
		is.setValue("location", "(" + _currentRoad + "," + _currentLocation + ")");
	}

	@Override
	protected String getReportSectionTag() {
		return "vehicle_report";
	}

	/**
	 * Ask the vehicle to advance.
	 */
	
	void advance() {
		if (_faulty != 0) {	//if faulty, counter decreased by one but doesn't move
			_faulty--;
			return;
		}
		if (_inJunction) { //vehicles waiting in a junction can not advance
			return;
		}
		 
		_currentLocation += _currentSpeed;
		_kilometers += _currentSpeed;
		
		if (_currentLocation > _currentRoad.getLenght()) {
			_currentLocation = _currentRoad.getLenght();
			moveToNextRoad();
			_kilometers += _currentRoad.getLenght() - _currentLocation - _currentSpeed;
			return;
		}
		
		
		
	}
	


	

	
	

}
