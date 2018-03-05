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
	EventBuilder[] _eventBuilders = {};
	private InputStream _input;
	private OutputStream _output;
	private int _ticksSimulation;

	public Controller(TrafficSimulator ts, int a, InputStream input, OutputStream output) {
		_output = output;
		
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
	 */
	public void run() {
		this.loadEvents(this._input);
		//execute the simulation
	}
	
	public void reset() {
		
	}
	
	public void setOutputStream(OutputStream outStream) {
		_output = outStream;
	}
	
	public void run(int ticks) {
		//TODO: Understand the argument
	}
	
	public void loadEvents(InputStream inStream){
		Ini ini;
		
		try {
			ini = new Ini(inStream);
		}
		catch(IOException e){
			// TODO: solve the error.
			throw new SimulatorError("Error in reading the events: " + e);
		}
		
	}
}
