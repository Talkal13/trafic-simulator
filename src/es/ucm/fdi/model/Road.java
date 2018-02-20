package es.ucm.fdi.model;

import java.util.List;

public class Road extends SimulatedObject {

	private int _lenght;
	private int _maxSpeed;
	private List<Vehicle> _vehicles;
	private Junction _source;
	private Junction _destination;
	
	public Road(String id, int lenght, int maxSpeed, Junction source, Junction destination) {
		super(id);
		_lenght = lenght;
		_maxSpeed = maxSpeed;
		_source = source;
		_destination = destination;
	}
	
	public Junction getSource() {
		return _source;
	}
	
	public Junction getDestination() {
		return _destination;
	}
	
	public int getLenght() {
		return _lenght;
	}
	
	public int getMaxSpeed() {
		return _maxSpeed;
	}
	
	public List<Vehicle> getVehicles() {
		return _vehicles;
	}
	
	void enter(Vehicle v) {
		//TODO: Check if in the list;
		_vehicles.add(v);
	}
	
	void exit(Vehicle v) {
		//TODO: ?
		_vehicles.remove(v);
	}
	
	protected int calculateBaseSpeed() {
		return -1;
	}
	
	protected int reduceSpeedFactor(int a) {
		//TODO: Unkown argument;
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
