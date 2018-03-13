package es.ucm.fdi.model;

public class NewMostCrowdedJunctionEvent extends NewJunctionEvent{

	public NewMostCrowdedJunctionEvent(int time, String id) {
		super(time, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(RoadMap map, int ticks) {
		map.addJunction(new Junction(_id));
		
	}
	
	public String toString() {
		return "New Junction " + _id;
	}
}
