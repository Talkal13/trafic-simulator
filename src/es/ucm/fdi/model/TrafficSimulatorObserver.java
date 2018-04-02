package es.ucm.fdi.model;

public interface TrafficSimulatorObserver {
	public void onRegistered(TrafficSimulator t);
	public void onReset(TrafficSimulator t);
	public void onNewEvent(Event e);
	public void onAdvance(TrafficSimulator t);
	public void onError(TrafficSimulator t);
}
