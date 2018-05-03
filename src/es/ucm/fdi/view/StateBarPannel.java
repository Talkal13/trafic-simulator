package es.ucm.fdi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
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

public class StateBarPannel extends JPanel implements TrafficSimulatorObserver, GuiViewObserver{

	private JLabel _label;
	
	public StateBarPannel() {
		this.setLayout(new BorderLayout());
		_label = new JLabel("Welcome to the trafficSimulator", SwingConstants.LEFT);
		_label.setHorizontalAlignment(SwingConstants.LEFT);
		this.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED));

		this.add(_label);
	}

	public void setBorder(String title) {
		
	}
	
	public void printMessage(String message) {
		_label.setText(message);
	}
	
	public void printError(String error) {
		_label.setText(error);
		_label.setForeground(Color.RED);
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
		printError(msg);
		
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

	@Override
	public void onLoadFile(File file) {
		printMessage("Successfull load of file " + file.getName());
		
	}

	@Override
	public void onSaveFile(File file) {
		printMessage("Successfull save of file " + file.getName());
		
	}

}
