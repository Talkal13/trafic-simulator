package es.ucm.fdi.model;

import java.util.List;

import es.ucm.fdi.ini.IniSection;

public class Road extends SimulatedObject {

	protected int _lenght;
	protected int _maxSpeed;
	protected int _baseSpeed;
	protected List<Vehicle> _vehicles;
	protected Junction _source;
	protected Junction _destination;
	
	/**
	 * Constructor of the class. Calls the constructor of SimulatedObject with the id introduced as parameter, 
	 * and assigns the other four parameters to the class attributes.
	 * 
	 * @param id unique identifier of the road.
	 * @param lenght the kilometers of the road.
	 * @param maxSpeed maximum speed allowed in the road.
	 * @param source junction which is the origin of the road.
	 * @param destination junction which is the destination of the road.
	 */
	
	public Road(String id, int lenght, int maxSpeed, Junction source, Junction destination) {
		super(id);
		_lenght = lenght;
		_maxSpeed = maxSpeed;
		_source = source;
		_destination = destination;
	}
	
	/**
	 * Getter of the class attribute _source
	 * 
	 * @return junction which is the origin of the road.
	 */
	
	public Junction getSource() {
		return _source;
	}
	
	/**
	 * Getter of the class attribute _destination
	 * 
	 * @return junction which is the destiny of the road.
	 */
	
	public Junction getDestination() {
		return _destination;
	}
	
	/**
	 * Getter of the class attribute _lenght
	 * 
	 * @return length of the road
	 */
	
	public int getLenght() {
		return _lenght;
	}
	
	/**
	 * Getter of the class attribute _maxSpeed
	 * 
	 * @return junction which is the maximum speed allowed in the road.
	 */
	
	public int getMaxSpeed() {
		return _maxSpeed;
	}
	
	/**
	 * Getter of the class attribute _vehicles
	 * 
	 * @return list which contains the vehicles contained in the road.
	 */
	
	public List<Vehicle> getVehicles() {
		return _vehicles;
	}
	
	/**
	 * Adds the vehicle passed as parameter to list of vehicles in the road.
	 * 
	 * @param v vehicle to be added to the road
	 */
	
	void enter(Vehicle v) {
		//TODO: Check if in the list;
		_vehicles.add(v);
	}
	
	/**
	 * Removes the vehicle passed as parameter from the list of vehicles in the road. 
	 * 
	 * @param v vehicle to be removed from the road
	 */
	
	void exit(Vehicle v) {
		//TODO: ?
		_vehicles.remove(v);
	}
	
	protected int calculateBaseSpeed() {
		_baseSpeed = Math.min(_maxSpeed, (Integer) (_maxSpeed / Math.max(_vehicles.size(), 1)) + 1);
		return _baseSpeed;
	}
	
	protected int reduceSpeedFactor(int obstacles) {
		if (obstacles == 0) return 1;
		else return 2;
	}

	@Override
	protected void fillReportDetails(IniSection is) {
		is.setValue("state", _vehicles);
	}

	@Override
	protected String getReportSectionTag() {
		return "road_report";
	}

	@Override
	void advance() {
		calculateBaseSpeed();
		int obstacles = 0;
		for (Vehicle e : _vehicles) {
			if (e.getFaultyTime() > 0) {
				obstacles++;
			}
			e.setSpeed(_baseSpeed / reduceSpeedFactor(obstacles));
			e.advance();
		}
		
	}

}
