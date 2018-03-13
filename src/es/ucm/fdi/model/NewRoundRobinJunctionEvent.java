package es.ucm.fdi.model;

public class NewRoundRobinJunctionEvent extends NewJunctionEvent{

	public NewRoundRobinJunctionEvent(int time, String id) {
		super(time, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(RoadMap map, int ticks) {
		
	}
	
	public String toString() {
		return null;
	}

}
