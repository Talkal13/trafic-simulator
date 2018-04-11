package es.ucm.fdi.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import es.ucm.fdi.control.Controller;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;

@SuppressWarnings("serial")
public class MainToolbar extends JToolBar implements TrafficSimulatorObserver{
	
	private final String LOAD = "load";
	private final String SAVE = "save";
	private final String CLEAR = "clear";
	public final String SAVE_REPORT = "save_report";
	public final String QUIT = "quit";
	public final String RUN = "run";
	public final String RESET = "reset";
	//public final String REDIRECT = "redirect";
	public final String CHECK_IN_EVENTS = "check";
	public final String GENERATE = "generate";
	public final String CLEAR_REPORTS = "clear_reports";
	
	private SpinnerModel model;
	private JSpinner spinner;
	private JTextField time;
	
	public MainToolbar(MainFrame frame, Controller crtl){
		super();
		
		crtl.addObserver(this);
		
		//LOAD
		JButton load = new JButton();
		load.setActionCommand(LOAD);
		load.setToolTipText("Load a file");
		load.setIcon(new ImageIcon(loadImage("resources/icons/open.png")));
		load.addActionListener(new ActionListener() {
			//todo finish
			public void actionPerformed(ActionEvent e) {
				frame.loadFile();	
			}
			
		});
		this.add(load);

		//SAVE
		JButton save = new JButton();
		save.setActionCommand(SAVE);
		save.setToolTipText("Save a file");
		save.addActionListener((ActionListener) frame);
		save.setIcon(new ImageIcon(loadImage("resources/icons/save.png")));
		this.add(save);

		JButton clear = new JButton();
		clear.setActionCommand(CLEAR);
		clear.setToolTipText("Clear Text");
		clear.addActionListener((ActionListener) frame);
		clear.setIcon(new ImageIcon(loadImage("resources/icons/clear.png")));
		this.add(clear);
		
		//this.add(loadP);
		
		this.addSeparator();
		
		JButton events = new JButton();
		events.setActionCommand(CHECK_IN_EVENTS);
		events.setToolTipText("Save Report to a file");
		events.addActionListener((ActionListener) frame);
		events.setIcon(new ImageIcon(loadImage("resources/icons/events.png")));
		this.add(events);
		
		JButton run = new JButton();
		run.setActionCommand(RUN);
		run.setToolTipText("Run the simulator");
		run.addActionListener((ActionListener) frame);
		run.setIcon(new ImageIcon(loadImage("resources/icons/play.png")));
		this.add(run);
		
		JButton reset = new JButton();
		reset.setActionCommand(RESET);
		reset.setToolTipText("Reset the simulator");
		reset.addActionListener((ActionListener) frame);
		reset.setIcon(new ImageIcon(loadImage("resources/icons/reset.png")));
		this.add(reset);
		
		this.addSeparator();
		
		JLabel text_steps = new JLabel("Steps:");
		this.add(text_steps);
		
		this.addSeparator();
		
		model = new SpinnerNumberModel(0, 0, 10000, 1);     
		spinner = new JSpinner(model);
		spinner.setMaximumSize(new Dimension(70, 30));
		this.add(spinner);
		
		this.addSeparator();
		
		JLabel text_time = new JLabel("Time:");
		this.add(text_time);
		
		this.addSeparator();
		
		JTextField time = new JTextField();
		time.setEditable(false);
		time.setText("0");
	    time.setHorizontalAlignment(JTextField.RIGHT);
		time.setMaximumSize(new Dimension(70, 30));
		this.add(time);
		
		this.addSeparator();
		
		JButton generate = new JButton();
		generate.setActionCommand(GENERATE);
		generate.setToolTipText("Generate Report");
		generate.addActionListener((ActionListener) frame);
		generate.setIcon(new ImageIcon(loadImage("resources/icons/report.png")));
		this.add(generate);
		
		JButton clear_report = new JButton();
		clear_report.setActionCommand(CLEAR_REPORTS);
		clear_report.setToolTipText("Clear report area");
		clear_report.addActionListener((ActionListener) frame);
		clear_report.setIcon(new ImageIcon(loadImage("resources/icons/delete_report.png")));
		this.add(clear_report);
		
		JButton save_report = new JButton();
		save_report.setActionCommand(SAVE_REPORT);
		save_report.setToolTipText("Save the report to a file");
		save_report.addActionListener((ActionListener) frame);
		save_report.setIcon(new ImageIcon(loadImage("resources/icons/save_report.png")));
		this.add(save_report);
		
		this.addSeparator();
		
		JButton quit = new JButton();
		quit.setActionCommand(QUIT);
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
	

}
