package es.ucm.fdi.extra;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

import es.ucm.fdi.extra.panels.TextEditorPanel;
import es.ucm.fdi.extra.toolbar.MainToolbar;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, TrafficSimulatorObserver, ItemListener {

	public final String LOAD = "load";
	public final String SAVE = "save";
	public final String SAVE_REPORT = "save_report";
	public final String QUIT = "quit";
	public final String RUN = "run";
	public final String CLEAR = "clear";
	public final String RESET = "reset";
	//public final String REDIRECT = "redirect";
	public final String GENERATE = "generate";
	public final String CLEAR_REPORTS = "clear_reports";
	
	JCheckBoxMenuItem redirect;
	
	TextEditorPanel text_editor;
	
	public MainFrame() {
		super("Traffic Simulator");
		initGUI();
	}
	
	public void initGUI() {
		JPanel mainPanel = new JPanel( new BorderLayout(5,5) );
		mainPanel.add(new MainToolbar(this), BorderLayout.PAGE_START);
		mainPanel.setOpaque(true);
			
		text_editor = new TextEditorPanel();
		mainPanel.add(text_editor, BorderLayout.LINE_START);
		
		//text_editor.addA
		
		this.setJMenuBar(createMenuBar());
		
		this.setContentPane(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 900);
		this.setVisible(true);
	}
	
	public JMenuBar createMenuBar() {
		JMenuItem load, save, save_report, quit;
		JMenuItem run, reset;
		
		JMenuItem generate, clear;

		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenu simulator  = new JMenu("Simulator");
		JMenu reports  = new JMenu("Reports");
		
		menuBar.add(file);
		menuBar.add(simulator);
		menuBar.add(reports);
		file.setMnemonic(KeyEvent.VK_F);

		load = new JMenuItem("Load Events");
		load.setActionCommand(LOAD);
		load.addActionListener(this);
		load.setMnemonic(KeyEvent.VK_L);
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.ALT_MASK));

		save = new JMenuItem("Save Events");
		save.setActionCommand(SAVE);
		save.addActionListener(this);
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.ALT_MASK));

		save_report = new JMenuItem("Save Report");
		save_report.setActionCommand(SAVE_REPORT);
		save_report.addActionListener(this);
		save_report.setMnemonic(KeyEvent.VK_R);
		save_report.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				ActionEvent.ALT_MASK));

		quit = new JMenuItem("Exit");
		quit.setActionCommand(QUIT);
		quit.addActionListener(this);
		quit.setMnemonic(KeyEvent.VK_E);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.ALT_MASK));

		file.add(load);
		file.add(save);
		file.addSeparator();
		file.add(save_report);
		file.addSeparator();
		file.add(quit);
		
		run = new JMenuItem("Run");
		run.setActionCommand(RUN);
		run.addActionListener(this);
		
		reset = new JMenuItem("Reset");
		reset.setActionCommand(RESET);
		reset.addActionListener(this);
		
		redirect = new JCheckBoxMenuItem("Redirect");
		redirect.addItemListener(this);
		
		simulator.add(run);
		simulator.add(reset);
		simulator.add(redirect);
		
		generate = new JMenuItem("Generate");
		generate.setActionCommand(GENERATE);
		generate.addActionListener(this);
		
		clear = new JMenuItem("Clear");
		clear.setActionCommand(CLEAR_REPORTS);
		clear.addActionListener(this);
		
		reports.add(generate);
		reports.add(clear);
		
		return menuBar;
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
	public void onAdvance(SimulatedObject o, int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(String msg) {
		System.err.println(msg);
		
	}

	@Override
	public void onNewEvent(Event e, RoadMap _map, int _time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (LOAD.equals(e.getActionCommand()))
			text_editor.loadFile();
		else if (SAVE.equals(e.getActionCommand()))
			text_editor.saveFile();
		else if (CLEAR.equals(e.getActionCommand()))
			text_editor.setText("");
		else if (QUIT.equals(e.getActionCommand()))
			System.exit(0);
		
	}
	
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == redirect) {
			//TODO
		}
		
	}
	
	
}
