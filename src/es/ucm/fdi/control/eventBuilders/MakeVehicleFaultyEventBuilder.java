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
	

	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID))
			return null;
		else
			return new MakeVehicleFaultyEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.parseListValidId(section, "vehicles"), EventBuilder.parsePositiveInt(section, "duration"));
			
	}
	
	public String toString(){
		return IDToString;
		
	}
}
