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

public class Controller {
	
	protected TrafficSimulator _sim;
	//this static is to avoid problems in parserEvent Magic, maybe in incorrect
	static EventBuilder[] _eventBuilders = {};
	private InputStream _input;
	private OutputStream _output;
	private int _ticksSimulation;

	public Controller(TrafficSimulator ts) {
		_sim = ts;
	}
	
	public Controller(TrafficSimulator ts, OutputStream output) {
		
	}
	
	public void setEventBuilders(EventBuilder[] eventBuilders) {
		_eventBuilders = eventBuilders;
	}
	
	public EventBuilder[] getEventBuilders() {
		return null;
		
	}
	
	/**
	 * Reads the events and send them to the simulator
	 * @throws SimulatorError 
	 */
	public void run() throws SimulatorError {
		this.loadEvents(this._input);
		//execute the simulation
	}
	
	public void reset() {
		
	}
	
	public void setOutputStream(OutputStream outStream) {
		_output = outStream;
	}
	
	public void run(int ticks) {
		_sim.run(ticks);
	}
	
	public void loadEvents(InputStream inStream) throws SimulatorError {
		Ini ini;
		
		try {
			ini = new Ini(inStream);
		}
		catch(IOException e){
			throw new SimulatorError("Error in reading the events: " + e);
		}
		//Goes throw all the elements of iniSectins to generate the corresponding element
		for (IniSection sec : ini.getSections()) {
			Event e = parserEvent(sec);
			if(e != null) this._sim.addEvent(e);
			else throw new SimulatorError("Unkown event: " +  sec.getTag());
		}
		
		
	}
	
	//Like Samir does 
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
}
