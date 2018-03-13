package es.ucm.fdi.model;

import java.util.List;
import java.util.Random;

import es.ucm.fdi.ini.IniSection;

public class Car extends Vehicle{

	private int _resistance;
	private int _max_fault_duration;
	private double _fault_probability;
	private long _seed;
	private Random _rand;
	
	public Car(String id, int max_speed, int resistance, int max_fault_duration, double fault_probability, long seed, List<Junction> itinerary) {
		super(id, max_speed, itinerary);
		_resistance = resistance;
		_max_fault_duration = max_fault_duration;
		_fault_probability = fault_probability;
		_seed = seed;
		_rand = new Random(seed);
		
	}
	
	void advance() {
		//TODO
	}
	
	protected void fillReportDetails(IniSection is) {
		//TODO
	}

}
