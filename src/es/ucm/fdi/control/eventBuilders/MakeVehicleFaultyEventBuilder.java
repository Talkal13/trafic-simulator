package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.MakeVehicleFaultyEvent;

/**
 * @author Pablo & Diego
 * 
 * Event builder which extends the EventBuilder for the events when a Vehicle gets faulty.
 *
 */
public class MakeVehicleFaultyEventBuilder extends EventBuilder {
	
	public static final String ID = "make_vehicle_faulty";
	public static final String IDToString = "Make Vehicle Faulty";
	
	/**
	 * Constructor of the class
	 */
	
	public MakeVehicleFaultyEventBuilder() {
		
	}
	
	/**
	 * Parser for the MakeVehicleFaultyEventBuilder, checks if the section has the tag desired and parses its time, duration of the faulty state
	 * and which vehicle will be affected.
	 * 
	 * @param IniSection to be parse, searching the information wanted.
	 * @return the Event with the parsed attributes.
	 */
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID))
			return null;
		else
			return new MakeVehicleFaultyEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.parseListValidId(section, "vehicles"), EventBuilder.parsePositiveInt(section, "duration"));
			
	}
	
	/**
	 * return the phrase "Make Vehicle Faulty".
	 */
	public String toString(){
		return IDToString;
		
	}
}
