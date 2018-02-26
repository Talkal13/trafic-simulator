package es.ucm.fdi.model;

import java.util.List;

import es.ucm.fdi.ini.IniSection;

public class Road extends SimulatedObject {

	private int _lenght;
	private int _maxSpeed;
	private List<Vehicle> _vehicles;
	private Junction _source;
	private Junction _destination;
	
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
		return -1;
	}
	
	protected int reduceSpeedFactor(int a) {
		return a;
		//TODO: Unkown argument;
	}

	@Override
	protected void fillReportDetails(IniSection is) {
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
