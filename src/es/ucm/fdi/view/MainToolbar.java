package es.ucm.fdi.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.util.List;

import javax.swing.*;

import es.ucm.fdi.control.Controller;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.SimulatorError;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;

@SuppressWarnings("serial")
public class MainToolbar extends JToolBar implements TrafficSimulatorObserver{
	
	private int _time;
	private JTextField _timefield;
	private SpinnerModel model;
	private JSpinner spinner;
	private SpinnerModel model_delay;
	private JSpinner spinner_delay;
	private JTextField time;
	private JButton load, save, clear, events, run, stop, reset, generate, clear_report, save_report, quit;

	
	
	public MainToolbar(MainFrame frame, Controller crtl){
		super();
		_time = 0;
		crtl.addObserver(this);
		
		//LOAD
		load = new JButton();
		load.setActionCommand(ButtonConstants.LOAD);
		load.setToolTipText("Load a file");
		load.addActionListener((ActionListener) frame);

		load.setIcon(new ImageIcon(loadImage("resources/icons/open.png")));
		this.add(load);

		//SAVE
		save = new JButton();
		save.setActionCommand(ButtonConstants.SAVE);
		save.setToolTipText("Save a file");
		save.addActionListener((ActionListener) frame);
		save.setIcon(new ImageIcon(loadImage("resources/icons/save.png")));
		this.add(save);

		clear = new JButton();
		clear.setActionCommand(ButtonConstants.CLEAR);
		clear.setToolTipText("Clear Text");
		clear.addActionListener((ActionListener) frame);
		clear.setIcon(new ImageIcon(loadImage("resources/icons/clear.png")));
		this.add(clear);
		
		//this.add(loadP);
		
		this.addSeparator();
		
		events = new JButton();
		events.setActionCommand(ButtonConstants.CHECK_IN_EVENTS);
		events.setToolTipText("Add events to the simulator");
		events.addActionListener((ActionListener) frame);
		events.setIcon(new ImageIcon(loadImage("resources/icons/events.png")));
		this.add(events);
		
		run = new JButton();
		run.setActionCommand(ButtonConstants.RUN);
		run.setToolTipText("Run the simulator");
		run.addActionListener((ActionListener) frame);
		run.setIcon(new ImageIcon(loadImage("resources/icons/play.png")));
		this.add(run);
		
		stop = new JButton();
		stop.setActionCommand(ButtonConstants.STOP);
		stop.setToolTipText("Stop the simulator");
		stop.addActionListener((ActionListener) frame);
		stop.setIcon(new ImageIcon(loadImage("resources/icons/stop.png")));
		this.add(stop);
		
		reset = new JButton();
		reset.setActionCommand(ButtonConstants.RESET);
		reset.setToolTipText("Reset the simulator");
		reset.addActionListener((ActionListener) frame);
		reset.setIcon(new ImageIcon(loadImage("resources/icons/reset.png")));
		this.add(reset);
		
		this.addSeparator();
		
		this.add(new JLabel ("Delay: "));
		model_delay = new SpinnerNumberModel(500, 1, 1000000, 100);   
		spinner_delay = new JSpinner(model_delay);
		spinner_delay.setMaximumSize(new Dimension(70, 30));
		this.add(spinner_delay);
		
		this.addSeparator();
		
		
		this.add(new JLabel ("Steps: "));
		model = new SpinnerNumberModel(5, 1, 10000, 1);   
		spinner = new JSpinner(model);
		spinner.setMaximumSize(new Dimension(70, 30));
		this.add(spinner);
		
		this.addSeparator();
		
		JLabel text_time = new JLabel("Time:");
		this.add(text_time);
		
		this.addSeparator();
		
		_timefield = new JTextField();
		_timefield.setEditable(false);
		_timefield.setText(""+_time);
		_timefield.setBackground(Color.WHITE);
	    _timefield.setHorizontalAlignment(JTextField.RIGHT);
		_timefield.setMaximumSize(new Dimension(70, 30));
		this.add(_timefield);
		
		this.addSeparator();
		
		generate = new JButton();
		generate.setActionCommand(ButtonConstants.GENERATE);
		generate.setToolTipText("Generate Report");
		generate.addActionListener((ActionListener) frame);
		generate.setIcon(new ImageIcon(loadImage("resources/icons/report.png")));
		this.add(generate);
		
		clear_report = new JButton();
		clear_report.setActionCommand(ButtonConstants.CLEAR_REPORTS);
		clear_report.setToolTipText("Clear report area");
		clear_report.addActionListener((ActionListener) frame);
		clear_report.setIcon(new ImageIcon(loadImage("resources/icons/delete_report.png")));
		this.add(clear_report);
		
		save_report = new JButton();
		save_report.setActionCommand(ButtonConstants.SAVE_REPORT);
		save_report.setToolTipText("Save the report to a file");
		save_report.addActionListener((ActionListener) frame);
		save_report.setIcon(new ImageIcon(loadImage("resources/icons/save_report.png")));
		this.add(save_report);
		
		this.addSeparator();
		
		quit = new JButton();
		quit.setActionCommand(ButtonConstants.QUIT);
		quit.setToolTipText("Exit the program");
		quit.addActionListener((ActionListener) frame);
		quit.setIcon(new ImageIcon(loadImage("resources/icons/exit.png")));
		this.add(quit);
		
		
	}
	
	private static Image loadImage(String path) {
		return Toolkit.getDefaultToolkit().createImage(path);
	}

	public int getTime() {
		return (Integer) spinner.getValue();
	}

	@Override
	public void onRegistered(TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(TrafficSimulator trafficSimulator) {
		_time = 0;
		_timefield.setText(""+_time);

	}

	@Override
	public void onAdvance(TrafficSimulator t, int time) {
		_timefield.setText(""+time);

		
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
	
	public void enableAll(boolean enable) {
		load.setEnabled(enable);
		save.setEnabled(enable);
		clear.setEnabled(enable);
		events.setEnabled(enable);
		run.setEnabled(enable);
		reset.setEnabled(enable);
		generate.setEnabled(enable);
		clear_report.setEnabled(enable);
		save_report.setEnabled(enable);
		quit.setEnabled(enable);
		spinner_delay.setEnabled(enable);
		spinner.setEnabled(enable);
		
	}

	public int getDelay() {
		return (Integer) spinner_delay.getValue();
	}

	public void setTime(int i) {
		spinner.setValue((Integer) i);
		
	}
	

}
