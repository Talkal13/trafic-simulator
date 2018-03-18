package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewJunctionEvent;

/**
 * @author Pablo & Diego
 * 
 * Event builder which extends the EventBuilder for the events when a new junction is created.
 *
 */

public class NewJunctionEventBuilder extends EventBuilder{

	public static final String ID = "new_junction";
	public static final String IDToString = "New Junction";
	
	/**
	 * Parser for the NewJunctionEventBuilder, checks if the section has the tag desired and parses its time, id.
	 * 
	 * @param IniSection to be parse, searching the information wanted.
	 * @return the Event with the parsed attributes.
	 */
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") != null) return null;
		
		return new NewJunctionEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"));
			
	}
	
	/**
	 * Returns the phrase "New Junction".
	 */
	
	public String toString(){
		return IDToString;
		
	}

}
