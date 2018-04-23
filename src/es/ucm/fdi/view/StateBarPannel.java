package es.ucm.fdi.view;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;

public class StateBarPannel extends JPanel implements TrafficSimulatorObserver{

	private JLabel _label;
	
	public StateBarPannel() {
		_label = new JLabel("Welcome to the trafficSimulator");
		_label.setHorizontalAlignment(SwingConstants.LEFT);
		this.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED));

		this.add(_label);
	}

	public void setBorder(String title) {
		
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

	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(TrafficSimulator t, List<Event> events) {
		// TODO Auto-generated method stub
		
	}

}
