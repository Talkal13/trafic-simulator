package es.ucm.fdi.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import es.ucm.fdi.control.eventBuilders.EventBuilder;
import es.ucm.fdi.ini.Ini;
import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.SimulatorError;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;

/**
 * @author Pablo and Diego
 * 
 * Class Controller which stores the information about the input and output streams and invokes the trafficSimulatoronce is established the number of ticks
 */

public class Controller {
	
	protected TrafficSimulator _sim;
	static EventBuilder[] _eventBuilders = {};//this static is to avoid problems in parserEvent Magic, maybe incorrect
	private InputStream _input;
	private OutputStream _output;
	private int _ticksSimulation;
	private boolean _reset;
	
	/**
	 * Constructor of the class, assigns to the class attribute TrafficSimulator the one passed as parameter.
	 * 
	 * @param ts traffic simulator which will be use in order to simulate the behave of the application.
	 */

	public Controller(TrafficSimulator ts) {
		_sim = ts;
	}
	
	/**
	 * Constructor of the class, this time also with the outstream as output parameter.
	 * 			
	 * @param ts traffic simulator which will be use in order to simulate the behave of the application.
	 * @param output outstream which is use to show the information resulted from the application.
	 */
	
	public Controller(TrafficSimulator ts, OutputStream output) {
		_sim = ts;
		_output = output;
	}
	
	/**
	 * Setter of the class attribute eventBuilder.
	 * 
	 * @param eventBuilders new event builder of the controller.
	 */
	
	public void setEventBuilders(EventBuilder[] eventBuilders) {
		_eventBuilders = eventBuilders;
	}
	
	/**
	 * Getter of the class attribute eventBuilder.
	 * 
	 * @return the current event builder of the class.
	 */
	
	public EventBuilder[] getEventBuilders() {
		return _eventBuilders;
	}
	
	/**
	 * Reads the events and send them to the simulator in order to run the application.
	 * 
	 * @throws SimulatorError in case the simulation has thrown any exception during the loading, here it will be catch.
	 */
	
	public void run() {
		try {
			this.loadEvents(this._input);
			_reset = false;
		} catch (SimulatorError e) {
			_sim.NotifyError(e.getMessage());
		}
	}
	
	/**
	 * Resets the simulator, starting a new simulation, probably will be use in the GUI.
	 */
	
	public void reset() {
		_sim.reset();
		_reset = true;
	}
	
	/**
	 * Setter of the class attribute outStream.
	 * 
	 * @param outStream new output flow to display the result of the simulation.
	 */
	
	public void setOutputStream(OutputStream outStream) {
		_output = outStream;
	}
	
	/**
	 * Receives as parameter the number of steps(ticks) that the simulation will last.
	 * 
	 * @param ticks number of ticks meanwhile the simulation will be run.
	 */
	
	public void run(int ticks) {
		if (_reset == true) {
			_sim.NotifyError("No input file selected");
			return;
		}
		try {
			_sim.run(ticks);
		} catch (SimulatorError e) {
			_sim.NotifyError(e.getMessage());
		}	
	}
	
	/**
	 * Loads an Ini file, first construct an instance of class Ini from the inStream, then try to parse each ini section in 
	 * ini.getSections(), by calling their parse method of the Event, the first one that succeeds will return an event.
	 * 
	 * @param inStream stream which contains the set of events in INI format.
	 * @throws SimulatorError if there is an error, here it will be catch.
	 */
	
	public boolean loadEvents(InputStream inStream) {
		Ini ini;
		_reset = false;
		try {
			ini = new Ini(inStream);
		}
		catch(IOException e){
			_sim.NotifyError("Error in reading the events: " + e);
			return false;
		}
	
		try {
			for (IniSection sec : ini.getSections()) {
				Event e = parserEvent(sec);
				this._sim.addEvent(e);
			}
		} catch (SimulatorError e) {
			System.err.print(e.getMessage() + "\n");
			return false;
		}
		
		_sim.NotifyStart();
		
		return true;
		
		
	}
	
	/**
	 * Will parse which is the Event from the Ini file has to be returned.
	 * 
	 * @param sec Ini file to be parsed.
	 * @return the event to be added in the event loading process.
	 */
	
	public static Event parserEvent(IniSection sec) {
		int i = 0;
		boolean go = true;
		Event e = null;
		
		while (i < _eventBuilders.length && go ) {
			e = _eventBuilders[i].parse(sec);
			if (e!=null) go = false;
			else i++;
		}
		return e;
	}
	
	
	public void addObserver(TrafficSimulatorObserver o) {
		_sim.addObserver(o);
	}
	
	public void removeObserver(TrafficSimulatorObserver o) {
		_sim.removeObserver(o);
	}
}
