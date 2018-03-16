package es.ucm.fdi.model;

public class NewRoundRobinJunctionEvent extends NewJunctionEvent{
	
	protected int _maxValueInterval;
	protected int _minValueInterval;
		
	public NewRoundRobinJunctionEvent(int time, String id, int min, int max ) {
		super(time, id);
		_maxValueInterval = max;
		_minValueInterval = min;
	}
	
	@Override
	public void execute(RoadMap map, int ticks) {
		map.addJunction(new RoundRobinJunction(_id, _minValueInterval, _maxValueInterval));
	}
	
	public String toString() {
		return null;
	}

}
