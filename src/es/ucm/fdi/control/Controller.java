package es.ucm.fdi.control;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import es.ucm.fdi.control.eventBuilders.EventBuilder;
import es.ucm.fdi.model.TrafficSimulator;

public class Controller {
	
	protected TrafficSimulator _sim;
	EventBuilder[] _eventBuilders = {};
	private OutputStream _output;

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

	public void run() {
		
	}
	
	public void reset() {
		
	}
	
	public void setOutputStream(OutputStream outStream) {
		_output = outStream;
	}
	
	public void run(int ticks) {
		//TODO: Understand the argument
	}
	
	public void loadEvents(InputStream inStream) {
		
	}
}
