package es.ucm.fdi.model;

public class NewRoundRobinJunctionEvent extends NewJunctionEvent{
	
	protected int _maxValueInterval;
	protected int _minValueInterval;
		
	public NewRoundRobinJunctionEvent(int time, String id, int minValue, int max, int min ) {
		super(time, id);
		_maxValueInterval = max;
		_minValueInterval = min;
	}
	
	@Override
	public void execute(RoadMap map, int ticks) {
		
	}
	
	public String toString() {
		return null;
	}

}
