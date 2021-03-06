package es.ucm.fdi.model;

import java.util.List;

public interface TrafficSimulatorObserver {
	public void onRegistered(TrafficSimulator trafficSimulator);
	public void onReset(TrafficSimulator trafficSimulator);
	public void onAdvance(TrafficSimulator t, int time);
	public void onAdvance(SimulatedObject o, int time);
	public void onError(String msg);
	public void onNewEvent(Event e, RoadMap _map, int _time);
	public void onStart(TrafficSimulator t, List<Event> events);
	
}
