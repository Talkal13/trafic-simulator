package es.ucm.fdi.model;

import java.util.List;
import es.ucm.fdi.misc.SortedArrayList;
import es.ucm.fdi.misc.VehiclesComparator;
import es.ucm.fdi.ini.IniSection;

/**
 * 
 * @author Pablo and Diego
 * 
 * Class of the object road, extension of the SimulatedObject. this class represent the road which are traverse by vehicles, 
 * it goes from one junctions to other.
 *
 */

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
		_vehicles = new SortedArrayList<Vehicle>(new VehiclesComparator());
	}
	
	/**
	 * Getter of the class attribute _source.
	 * 
	 * @return junction which is the origin of the road.
	 */
	
	public Junction getSource() {
		return _source;
	}
	
	/**
	 * Getter of the class attribute _destination.
	 * 
	 * @return junction which is the destiny of the road.
	 */
	
	public Junction getDestination() {
		return _destination;
	}
	
	/**
	 * Getter of the class attribute _lenght.
	 * 
	 * @return length of the road.
	 */
	
	public int getLenght() {
		return _lenght;
	}
	
	/**
	 * Getter of the class attribute _maxSpeed.
	 * 
	 * @return junction which is the maximum speed allowed in the road.
	 */
	
	public int getMaxSpeed() {
		return _maxSpeed;
	}
	
	/**
	 * Getter of the class attribute _vehicles.
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
		if (!_vehicles.contains(v))
			_vehicles.add(v);
	}
	
	/**
	 * Removes the vehicle passed as parameter from the list of vehicles in the road. 
	 * 
	 * @param v vehicle to be removed from the road.
	 */
	
	void exit(Vehicle v) {
		_vehicles.remove(v);
	}
	
	/**
	 * Calculates the base speed of the road. According to the provided formula.
	 * 
	 * @return the base speed of the road.
	 */
	
	protected int calculateBaseSpeed() {
		_baseSpeed = Math.min(_maxSpeed, (Integer) (_maxSpeed / Math.max(_vehicles.size(), 1)) + 1);
		return _baseSpeed;
	}
	
	/**
	 * Calculates the factor if speed reduction of the road.
	 * 
	 * @param obstacles number of faulty cars in the road.
	 * @return 1 if there are no obstacles or 2 in other case.
	 */
	
	protected int reduceSpeedFactor(int obstacles) {
		if (obstacles == 0) return 1;
		else return 2;
	}

	/**
	 * Fills the report telling which is the current state of the road.
	 * 
	 * @param IniSection section that contains the information to get.
	 */
	
	protected void fillReportDetails(IniSection is) {
		String report = "";
		if (!_vehicles.isEmpty()) {
			for (int i = 0; i < _vehicles.size()- 1; i++) {
				report += "(" + _vehicles.get(i).getId() + "," + _vehicles.get(i).getLocation() + ")" + ",";
			}
			report += "(" + _vehicles.get(_vehicles.size() - 1).getId() + "," + _vehicles.get(_vehicles.size() - 1).getLocation() + ")";
		}
		is.setValue("state", report);
	}

	/**
	 * Returns the tag which identifies the object road.
	 * 
	 * @return the tag of the road.
	 */
	
	protected String getReportSectionTag() {
		return "road_report";
	}

	/**
	 * Makes the road to advance, calculating the obstacles, setting the new speed of the vehicles that are on it and telling them then to advance.
	 */
	
	void advance() {
		calculateBaseSpeed();
		int obstacles = 0;
		for (int i = 0; i < _vehicles.size(); i++) {
			if (_vehicles.get(i).getFaultyTime() > 0) {
				obstacles++;
			}
			_vehicles.get(i).setSpeed(calculateBaseSpeed() / reduceSpeedFactor(obstacles));
			_vehicles.get(i).advance();
		}
		_vehicles.sort(new VehiclesComparator());
		
	}

}
