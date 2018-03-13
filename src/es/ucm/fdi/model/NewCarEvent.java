package es.ucm.fdi.model;

public class NewCarEvent extends NewVehicleEvent{
	
	 private int resistance; private int max_fault_duration;private double fault_probability; private long seed;
	

	public NewCarEvent(int time, String id, int max_speed,  String[] intinerary, int resistance, int max_fault_duration, double fault_probability, long seed) {
		super(time, id, max_speed, intinerary);
		this.resistance= resistance;
		this.max_fault_duration = max_fault_duration;
		this.fault_probability = fault_probability;
		this.seed = seed;
		// TODO Auto-generated constructor stub
	}
	
	//TODO: understand arguments
	public void execute(RoadMap roadTrip, int ticks) {
		roadTrip.addVehicle(new Car());
	}
	
	public String toString() {
		return null;
		
	}

}
