package es.ucm.fdi.misc;

import java.util.Comparator;

import es.ucm.fdi.model.Vehicle;

/**
 * @author Pablo & Diego
 * 
 * Comparator class which implements the interface comparator of vehicles.
 */

public class VehiclesComparator implements Comparator<Vehicle> {

	/**
	 * Compares two vehicles passed as arguments.
	 * 
	 * @param Vehicle first vehicle in the comparator.
	 * @param Vehicle second vehicle to compare with.
	 * @return the number of units between the location of both vehicles.
	 */
	
	public int compare(Vehicle o1, Vehicle o2) {
		return -1 * Integer.signum(o1.getLocation() - o2.getLocation());
	}
	
}
