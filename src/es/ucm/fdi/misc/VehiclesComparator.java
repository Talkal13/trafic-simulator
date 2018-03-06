package es.ucm.fdi.misc;

import java.util.Comparator;

import es.ucm.fdi.model.Vehicle;

public class VehiclesComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		return o1.getLocation() - o2.getLocation();
	}
	
}
