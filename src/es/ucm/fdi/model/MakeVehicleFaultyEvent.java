package es.ucm.fdi.model;

public class MakeVehicleFaultyEvent extends Event {
	protected String[] _idVehicles;
	protected int _duration;

	/**
	 * 
	 * 
	 * @param time
	 * @param id
	 */
	
	public MakeVehicleFaultyEvent(int time, String[] idVehicles, int duration) {
		super(time);
		_idVehicles = idVehicles;
		_duration = duration;
	}

	@Override
	public void execute(RoadMap map, int ticks) {
		for (String id : _idVehicles) {
			map.getVehicle(id).makeFaulty(_duration);
		}
		
	}
	
	
	
	public String toString() {
		return "Vehicle faulty";
	}
}
