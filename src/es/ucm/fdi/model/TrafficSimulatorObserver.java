package es.ucm.fdi.model;

public interface TrafficSimulatorObserver {
	public void onRegistered(TrafficSimulator t);
	public void onReset(TrafficSimulator t);
	public void onNewEvent(Event e, RoadMap map, int ticks);
	public void onAdvance(SimulatedObject o);
	public void onError(TrafficSimulator t);
}
