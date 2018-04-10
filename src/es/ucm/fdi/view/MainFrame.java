package es.ucm.fdi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;// appartently no in the *

import es.ucm.fdi.control.Controller;
import es.ucm.fdi.extra.panels.TextEditorPanel;
import es.ucm.fdi.extra.toolbar.MainToolbar;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.Junction;
import es.ucm.fdi.model.Road;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;
import es.ucm.fdi.model.Vehicle;
import javafx.scene.control.ToolBar;


@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, TrafficSimulatorObserver, ItemListener {

	//Strings 
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
	
	//Attributes
	
	
	public static Border _defaultBorder = BorderFactory.createLineBorder(Color.black, 2);
	
	//Upper Panel ------
	static private final String[] columnIdEvents = { "#", "Time", "Kind"};
	
	
	private TextAreaPanel _eventsEditorPannel;
	private TextAreaPanel _informPanned;
	private TablePannel<Event> _eventQueuePannel;
	
	//Menu and Tool bar ------
	private JFileChooser _fc;
	private ToolBar _toolbar;
	
	//Graphic panel ------
	private MapComponent _mapComponent;
	
	//Status bar (info at the bottom of the window) ------
	private StateBarPannel _stateBarPannel;
	
	//Lower Panel ------
	static private final String[] columnIdVehicle = { "ID", "Road", "Location", "Speed", "Km", "Faulty time", "Itinenary"};
	static private final String[] columnIdRoad = { "ID", "From", "To", "Length", "Max speed", "Vehicles"};
	static private final String[] columnIdJunction = { "ID", "Green", "Red"};

	private TablePannel<Vehicle> _vehiclesPanel;
	private TablePannel<Road> _roadsPanel;
	private TablePannel<Junction> _junctionsPanel;
	
	//Report dialog
	private InformDialog _informDialog;
	
	// MODEL PART -VIEW CONTROLLER MODEL
	private File _currentFile;
	private Controller _controller;
	
	//¿?
	JCheckBoxMenuItem redirect;
	TextEditorPanel text_editor;
	
	public MainFrame() {
		super("Traffic Simulator");
		initGUI();
	}
	
	//constructor with arguments
	public MainFrame(String inputFile, Controller ctrl) throws FileNotFoundException{
		super("Traffic Simulator");
		_controller = ctrl;
		_currentFile = inputFile != null ? new File(inputFile) : null;
		initGUI();
		//we add to the main window as observer
		ctrl.addObserver(this);
	}
	
	public void initGUI() {
		/*	MADE BY PABLO
		JPanel mainPanel = new JPanel( new BorderLayout(5,5) );
		mainPanel.add(new MainToolbar(this), BorderLayout.PAGE_START);
		mainPanel.setOpaque(true);
		
		JPanel content = new JPanel(new GridBagLayout());
		
		text_editor = new TextEditorPanel();
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 100;
		c.gridheight = 100;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		content.add(text_editor, c);
		
		this.add(content, BorderLayout.CENTER);
		//text_editor.addA
		
		this.setJMenuBar(createMenuBar());
		
		content.setOpaque(true);
		
		this.setContentPane(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 900);
		this.setVisible(true);
		*/
		// FOLLOWING THE PDF
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowListener() {//when exit ask for confirmation
			//TODO clean understand this mess

			@Override
			public void windowActivated(WindowEvent e) {	
			}

			public void windowClosed(WindowEvent e) {
			}

			public void windowClosing(WindowEvent e) {	
			}

			public void windowDeactivated(WindowEvent e) {	
			}

			public void windowDeiconified(WindowEvent e) {	
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowOpened(WindowEvent e) {		
			}
			
		});
		
		JPanel mainPanel = this.createMainPanel();
		this.setContentPane(mainPanel);
		
		
		//Lower state bar
		//Contains a Jlabel to show the state of the simulator
		this.addStateBar(mainPanel);
		
		//Panel which contains the rest of components (divided in 2 lower and upper)
		JPanel centralPanel = this.createCentralPanel();
		mainPanel.add(centralPanel, BorderLayout.CENTER);
		
		
		//upper panel
		this.createUpperPanel(centralPanel);
		
		//Menu
		MenuBar barMenu = new MenuBar(this, _controller);
		this.setJMenuBar(barMenu);
		
		//lower panel
		this.createLowerPanel(centralPanel);
		//tool bar
		this.addToolBar(mainPanel);//not a default method ?¿? probably a new class...
		//file chooser
		_fc = new JFileChooser();
		//report dialog
		_informDialog = new InformDialog (this, _controller);
		this.pack();
		this.setVisible(true);
	
	}
	
	private void addToolBar(JPanel mainPanel) {
		// TODO Auto-generated method stub
		
	}

	private void createLowerPanel(JPanel centralPanel) {
		// TODO Auto-generated method stub
		
	}

	private void createUpperPanel(JPanel centralPanel) {
		// TODO Auto-generated method stub
		
	}

	private JPanel createCentralPanel() {
		JPanel centralPanel = new JPanel();
		//to set the lower and upper panel 
		centralPanel.setLayout(new GridLayout(2,1));
		return centralPanel;
	}

	private void addStateBar(JPanel mainPanel) {
		// TODO Auto-generated method stub
		
	}

	private JPanel createMainPanel() {
		
		return null;
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

	@Override
	public void onAdvance(TrafficSimulator t, int time) {
		// TODO Auto-generated method stub
		
	}
	
	
}
