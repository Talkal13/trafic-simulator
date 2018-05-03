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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;// appartently no in the *

import es.ucm.fdi.control.Controller;
import es.ucm.fdi.extra.graphlayout.Node;
import es.ucm.fdi.extra.panels.TextEditorPanel;
import es.ucm.fdi.view.MainToolbar;
import es.ucm.fdi.view.graph.Dot;
import es.ucm.fdi.view.graph.Edge;
import es.ucm.fdi.view.graph.Graph;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.Junction;
import es.ucm.fdi.model.Observable;
import es.ucm.fdi.model.Road;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;
import es.ucm.fdi.model.Vehicle;
import es.ucm.fdi.observer.TableModel;
import javafx.scene.control.ToolBar;


@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, TrafficSimulatorObserver, ItemListener, Observable<GuiViewObserver> {
	
	//Attributes
	
	
	public static Border _defaultBorder = BorderFactory.createLineBorder(Color.black, 2);
	
	//Upper Panel ------
	static private final String[] columnIdEvents = { "#", "Time", "Kind"};
	
	
	private EventsEditorPanel _eventsEditorPanel;
	private InformPanel _informPanel;
	private EventsTable _eventQueuePanel;
	
	//Menu and Tool bar ------
	private JFileChooser _fc;
	private MainToolbar _toolbar;
	private MenuBar _menuBar;
	
	//Graphic panel ------
	private Graph _graph;
	
	//Status bar (info at the bottom of the window) ------
	private StateBarPannel _stateBarPanel;
	
	//Lower Panel ------
	static private final String[] columnIdVehicle = { "ID", "Road", "Location", "Speed", "Km", "Faulty time", "Itinenary"};
	static private final String[] columnIdRoad = { "ID", "From", "To", "Length", "Max speed", "Vehicles"};
	static private final String[] columnIdJunction = { "ID", "Green", "Red"};

	private VehiclesTable _vehiclesPanel;
	private RoadsTable _roadsPanel;
	private JunctionsTable _junctionsPanel;
	
	//Report dialog
	private InformDialog _informDialog;
	
	// MODEL PART -VIEW CONTROLLER MODEL
	private File _currentFile;
	private Controller _controller;
	private SimulatorOutputStream _out;
	//�?

	TextEditorPanel text_editor;
	
	private GraphComponent _graphComp;
    Random _rand;
    
	private List<GuiViewObserver> _obs;

	private GridBagConstraints _c;

	
	public MainFrame(Controller ctrl) {
		super("Traffic Simulator");
		_controller = ctrl;
		_obs = new ArrayList<GuiViewObserver>();
		initGUI();
	}
	
	//constructor with arguments
	public MainFrame(String inputFile, Controller ctrl) throws FileNotFoundException{
		super("Traffic Simulator");
		_controller = ctrl;
		_currentFile = inputFile != null ? new File(inputFile) : null;
		_obs = new ArrayList<GuiViewObserver>();
		initGUI();
		//we add to the main window as observer
		ctrl.addObserver(this);
	}
	
	public void initGUI() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		
		
		
		//Menu
		_menuBar = new MenuBar(this, _controller);
		this.setJMenuBar(_menuBar);
		
		//upper panel
		this.createUpperPanel(centralPanel);
		
		//lower panel
		this.createLowerPanel(centralPanel);
		//tool bar
		this.addToolBar(mainPanel);//not a default method ?�? probably a new class...
		//file chooser
		_fc = new JFileChooser(System.getProperty("user.dir"));
		//report dialog
		_informDialog = new InformDialog (this, _controller);
		this.pack();
		this.setVisible(true);
		this.setSize(1200, 900);
	
	}
	
	/*
	 * 
	 * Generate the parts of the gui
	 * 
	 */
	
	private void addToolBar(JPanel mainPanel) {
		_toolbar = new MainToolbar(this,_controller);
		mainPanel.add(_toolbar, BorderLayout.PAGE_START);
		
	}

	private void createLowerPanel(JPanel centralPanel) {
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(0, 2));
		JPanel tables = new JPanel();
		tables.setLayout(new GridLayout(3, 0));
		grid.add(tables);
		
		/*
		 * Insert Tables
		 */
		
		_vehiclesPanel = new VehiclesTable();
		_controller.addObserver(_vehiclesPanel);
		_roadsPanel = new RoadsTable();
		_controller.addObserver(_roadsPanel);
		_junctionsPanel = new JunctionsTable();
		_controller.addObserver(_junctionsPanel);
		tables.add(_vehiclesPanel);
		tables.add(_roadsPanel);
		tables.add(_junctionsPanel);
		
		/*
		 * Insert the grafic view
		 */
		grid.setBackground(Color.WHITE);

		
		_graph = new Graph();
		_controller.addObserver(_graph);
		this._graphComp = new GraphComponent();
		_graphComp.setGraph(_graph);
		grid.add(_graphComp);
		_c.gridx = 0;
		_c.gridy = GridBagConstraints.RELATIVE;
		_c.weighty = 0.5;
		centralPanel.add(grid, _c);
		
	}

	private void createUpperPanel(JPanel centralPanel) {
		JPanel upperPanel = new JPanel(new GridLayout(0, 3));
		String texto = "";
		_eventsEditorPanel = new EventsEditorPanel((_currentFile == null) ? "Empty file" : "Events: " + _currentFile.getName(), "", true, this);
		if (_currentFile != null) NotifyLoad(_currentFile);
		_controller.addObserver(_eventsEditorPanel);
		_eventQueuePanel = new EventsTable(this);
		_controller.addObserver(_eventQueuePanel);
		this._informPanel = new InformPanel("Reports", false, this._controller);
		_controller.addObserver(_informPanel);
		_out = new SimulatorOutputStream(_informPanel);
		if (_menuBar.getRedirect().isSelected()) {
			_controller.setOutputStream(_out);
		}
		else {
			_controller.setOutputStream(null);
		}
		_c.weightx = 0.5;
		_c.weighty = 3;
		_c.gridx = 0;
		_c.gridy = 0;
		//_c.anchor = GridBagConstraints.PAGE_START;
		centralPanel.add(upperPanel, _c);
		upperPanel.add(_eventsEditorPanel);
		upperPanel.add(_eventQueuePanel);
		upperPanel.add(_informPanel);
		
	}

	private JPanel createCentralPanel() {
		JPanel centralPanel = new JPanel();
		//to set the lower and upper panel 
		centralPanel.setLayout(new GridBagLayout());
		_c = new GridBagConstraints();
		_c.fill = GridBagConstraints.BOTH;
		return centralPanel;
	}

	private void addStateBar(JPanel mainPanel) {
		this._stateBarPanel = new StateBarPannel();
		this.addObserver(_stateBarPanel);
		mainPanel.add(_stateBarPanel, BorderLayout.PAGE_END);
		
	}

	private JPanel createMainPanel() {
		return new JPanel( new BorderLayout() );
	}

	
	/*
	 * Traffic Simulator Observer Methods
	 * 
	 * (non-Javadoc)
	 * @see es.ucm.fdi.model.TrafficSimulatorObserver#onRegistered(es.ucm.fdi.model.TrafficSimulator)
	 */
	
	@Override
	public void onRegistered(TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(TrafficSimulator trafficSimulator) {
		this._graphComp.refresh();
		
	}

	@Override
	public void onAdvance(SimulatedObject o, int time) {
		
	}

	@Override
	public void onError(String msg) {
		System.err.println(msg);
		
	}

	@Override
	public void onNewEvent(Event e, RoadMap _map, int _time) {
	}
	
	@Override
	public void onAdvance(TrafficSimulator t, int time) {
		_graphComp.setGraph(_graph);
		
	}

	/*
	 * Actions Observer
	 * 
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (ButtonConstants.LOAD.equals(e.getActionCommand()))
			try {
				loadFile();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (ButtonConstants.SAVE.equals(e.getActionCommand()))
			saveFile(_eventsEditorPanel);
		else if (ButtonConstants.CLEAR.equals(e.getActionCommand())) {
			this._stateBarPanel.printMessage("The editor is clear now for you to do your magic :)");
			clearArea(_eventsEditorPanel);
		}
		else if (ButtonConstants.QUIT.equals(e.getActionCommand())) {
			System.exit(0);
		}
		else if (ButtonConstants.RUN.equals(e.getActionCommand())) {
			this._stateBarPanel.printMessage("Running the simulator");
			_controller.run(_toolbar.getTime());
			this._stateBarPanel.printMessage("Successfull run on time " + _toolbar.getTime());
		}
		else if (ButtonConstants.RESET.equals(e.getActionCommand())) {
			this._stateBarPanel.printMessage("The simulation was reset.");
			_controller.reset();
		} 
		else if (ButtonConstants.CHECK_IN_EVENTS.equals(e.getActionCommand())) {
			String text = _eventsEditorPanel.getText();
			_controller.reset();
			_eventsEditorPanel.setText(text);
			_controller.loadEvents(new ByteArrayInputStream(text.getBytes()));
		}
		else if (ButtonConstants.SAVE_REPORT.equals(e.getActionCommand())) {
			this._stateBarPanel.printMessage("The report was saved successfully.");
			saveFile(_informPanel);
		}
		else if (ButtonConstants.CLEAR_REPORTS.equals(e.getActionCommand())) {
			this._stateBarPanel.printMessage("The report was cleaned successfully.");
			clearArea(_informPanel);
		}
		else if (ButtonConstants.GENERATE.equals(e.getActionCommand())) {
			generateReport();
		}
		//

		//TODO: do all the comands
		
	}
	
	/*
	 * 
	 * Helper Methods
	 * 
	 */
	
	private void saveFile(TextAreaPanel t) {
		int returnVal = _fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = _fc.getSelectedFile();
			writeFile(file, t.getText());
		}
	}

	private void loadFile() throws FileNotFoundException {
		int returnVal = _fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = _fc.getSelectedFile();
			_controller.reset();
			_controller.loadEvents(new FileInputStream(file.getPath()));
			NotifyLoad(file);
			
		}
	}
	
	public static void writeFile(File file, String content) {
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.print(content);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clearArea(TextAreaPanel t) {
		t.cleanUp();
	}
	
	private void generateReport() {
		_informPanel.cleanUp();
		for (Vehicle v : _vehiclesPanel.getSelected()) {
			_informPanel._textArea.append(v.generateReport(_toolbar.getTime()) + "\n");
		}
		
		for (Road v : _roadsPanel.getSelected()) {
			_informPanel._textArea.append(v.generateReport(_toolbar.getTime()) + "\n");
		}
		
		for (Junction v : _junctionsPanel.getSelected()) {
			_informPanel._textArea.append(v.generateReport(_toolbar.getTime()) + "\n");
		}
	}
	
	/**
	 * Notify to the observers a new load file
	 */
	public void NotifyLoad(File file) {
		for (GuiViewObserver o : _obs) {
			o.onLoadFile(file);
		}
	}
	
	
	
	/*
	 * Item change to redirect
	 * 
	 * (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == _menuBar.getRedirect()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				_controller.setOutputStream(_out);
			} else {
				_controller.setOutputStream(null);
			}
		}
		
	}


	@Override
	public void addObserver(GuiViewObserver o) {
		//_obs.add(observer);
		//observer.onRegistered(this);
		if(o != null && !_obs.contains(o))
			_obs.add(o);
		
	}

	@Override
	public void removeObserver(GuiViewObserver o) {
		//_obs.remove(observer);
		if(o != null &&  _obs.contains(o))
			_obs.remove(o);
		
	}

	@Override
	public void onStart(TrafficSimulator t, List<Event> events) {
		// TODO Auto-generated method stub
		
	}
	
}
