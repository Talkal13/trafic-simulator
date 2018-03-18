package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewBikeEvent;

/**
 * @author Pablo & Diego
 * 
 * Event builder which extends the EventBuilder for the events when a Bike is built.
 *
 */

public class NewBikeEventBuilder extends EventBuilder{
	
	public static final String ID = "new_vehicle";
	public static final String IDToString = "New Vehicle";
	public static final String TYPE = "bike";
	
	/**
	 * Constructor of the class.
	 */
	public NewBikeEventBuilder() {
		
	}

	/**
	 * Parser for the NewBikeEventBuilder, checks if the section has the tag desired and parses its time, id, max speed 
	 * and itinerary.
	 * 
	 * @param IniSection to be parse, searching the information wanted.
	 * @return the Event with the parsed attributes.
	 */
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") == null || !section.getValue("type").equals(TYPE)) return null;
		
		return new NewBikeEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), 
				EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary") );
	}
	
	public String toString() {
		return null;
	}

}
