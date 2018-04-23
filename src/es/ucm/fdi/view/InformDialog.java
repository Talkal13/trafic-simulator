package es.ucm.fdi.view;

import java.util.List;

import javax.swing.JDialog;

import es.ucm.fdi.control.Controller;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;

public class InformDialog extends JDialog implements TrafficSimulatorObserver{

	public InformDialog(MainFrame mainFrame, Controller _controller) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onRegistered(TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdvance(TrafficSimulator t, int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdvance(SimulatedObject o, int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewEvent(Event e, RoadMap _map, int _time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(TrafficSimulator t, List<Event> events) {
		// TODO Auto-generated method stub
		
	}

}
