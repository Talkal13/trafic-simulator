package es.ucm.fdi.model;

import java.util.List;

public interface RoadMapInterface {
	public Vehicle getVehicle(String idVehicle);
	public Road getRoad(String idRoad);
    public Junction getJunction(String idJunction);
	public List<Vehicle> getVehicles();
	public List<Road> getRoads();
	public List<Junction> getJunctions();
	public List<Junction> getJunctions(String[] junctions);
	void addJunction(Junction newJunction);
	void addVehicle(Vehicle newVehicle);
	void addRoad(Road newRoad);
	void clear();
	public String generateReport(int time);
}
