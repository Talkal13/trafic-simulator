package es.ucm.fdi.model;

import java.util.List;
import java.util.Random;

import es.ucm.fdi.ini.IniSection;

public class Car extends Vehicle{

	private int _resistance;
	private int _resistance_kilometers;
	private int _max_fault_duration;
	private double _fault_probability;
	private long _seed;
	private Random _rand;
	
	public static final String TYPE = "car";
	
	public Car(String id, int max_speed, int resistance, int max_fault_duration, double fault_probability, long seed, List<Junction> itinerary) {
		super(id, max_speed, itinerary);
		_resistance = resistance;
		_max_fault_duration = max_fault_duration;
		_fault_probability = fault_probability;
		_seed = seed;
		_rand = new Random(seed);
		
	}
	
	void advance() {
		if (_faulty > 0) {
			_resistance_kilometers = _kilometers;
			_faulty--;
		}
		
		else if (_resistance_kilometers >= _resistance + _kilometers) {
			if (_rand.nextDouble() < _fault_probability) {
				super.makeFaulty(_rand.nextInt(_max_fault_duration) + 1);
				super.advance();
			}
		}
		
		
	}
	
	protected void fillReportDetails(IniSection is) {
		is.setValue("type", TYPE);
		super.fillReportDetails(is);
	}

}
