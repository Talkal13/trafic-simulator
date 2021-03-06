package es.ucm.fdi.view;

import java.util.List;

import es.ucm.fdi.control.Controller;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;

public class InformPanel extends TextAreaPanel implements TrafficSimulatorObserver {

	public InformPanel(String title, boolean editable, Controller ctrl) {
		super(title, editable);
		ctrl.addObserver(this);
		this._textArea.setText("");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onRegistered(TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(TrafficSimulator trafficSimulator) {
		_textArea.setText("");
		
	}

	@Override
	public void onAdvance(TrafficSimulator t, int time) {
		//this._textArea.append(t.generateReport(time));
		
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
