package es.ucm.fdi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoadMap {
	
	List<Vehicle> _vehiclesList;
	List<Road> _roadsList;
	List<Junction> _junctionsList;
	
	Map<String, Vehicle> _vehicles;
	Map<String, Road> _roads;
	Map<String, Junction> _junctions;
	
	
	RoadMap(){
		_vehicles = new HashMap<String, Vehicle>();
		_roads = new HashMap<String, Road>();
		_junctions = new HashMap<String, Junction>();
		
		_vehiclesList = new ArrayList<Vehicle>();
		_roadsList = new ArrayList<Road>();
		_junctionsList = new ArrayList<Junction>();
		
	}
	
	public Vehicle getVehicle(String idVehicle) {
		Vehicle v =  _vehicles.get(idVehicle);
		if (v == null) throw new SimulatorError("Vehicle " + idVehicle + " does not exist in the map");
		return v;
	}
	
	public Road getRoad(String idRoad) {
		Road r = _roads.get(idRoad);
		if (r == null) throw new SimulatorError("Road " + idRoad + " does not exist in the map");
		return r;
	}
	
	public Junction getJunction(String idJunction) {
		Junction r = _junctions.get(idJunction);
		if (r == null) throw new SimulatorError("Road " + idJunction + " does not exist in the map");
		return r;
	}
	
	//TODO: List or Map?
	public List<Vehicle> getVehicles() {
		return _vehiclesList;
	}
	
	public List<Road> getRoads() {
		return _roadsList;
	}
	
	public List<Junction> getJunctions() {
		return _junctionsList;
	}
	
	public List<Junction> getJunctions(String[] junctions) {
		List<Junction> itinerary = new ArrayList<Junction>();
		for (String s : junctions) {
			itinerary.add(this.getJunction(s));
		}
		return itinerary;
	}
	
	void addJunction(Junction newJunction) {
		if (!_junctions.containsKey(newJunction.getId())) {
			_junctions.put(newJunction.getId(), newJunction);
			_junctionsList.add(newJunction);
		}
	}
	
	void addVehicle(Vehicle newVehicle) {
		if (!_vehicles.containsKey(newVehicle.getId())) {
			_vehicles.put(newVehicle.getId(), newVehicle);
			newVehicle.moveToNextRoad();
			_vehiclesList.add(newVehicle);
		}
			
	}

	void addRoad(Road newRoad) {
		if (!_roads.containsKey(newRoad.getId())) {
			_roads.put(newRoad.getId(), newRoad);
			getJunction(newRoad.getSource().getId()).addOutgoingRoad(newRoad);
			getJunction(newRoad.getDestination().getId()).addIncomingRoad(newRoad);
			_roadsList.add(newRoad);
		}
	}
	
	void clear() {
		_vehicles.clear();
		_vehiclesList.clear();
		_roads.clear();
		_roadsList.clear();
		_junctions.clear();
		_junctionsList.clear();
	}

	public String generateReport(int time) {
		String report = "";
		for (Junction j : getJunctions()) {
			report += j.generateReport(time) + "\n";
		}
		
		for (Road r : getRoads()) {
			report += r.generateReport(time) + "\n";
		}
		
		for (Vehicle v : getVehicles()) {
			report += v.generateReport(time) + "\n";
		}
		return report;
	}
}
