package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewJunctionEvent;
import es.ucm.fdi.model.NewMostCrowdedJunctionEvent;

/**
 * @author Pablo & Diego
 * 
 * Event builder which extends the EventBuilder for the events when a new Most Crowded Junction is created.
 *
 */

public class NewMostCrowdedJunctionEventBuilder extends EventBuilder{

	public static final String ID = "new_junction";
	public static final String TYPE = "mc";

	/**
	 * Parser for the NewMostCrowdedJunctionEventBuilder, checks if the section has the tag desired and parses its time, id.
	 * 
	 * @param IniSection to be parse, searching the information wanted.
	 * @return the Event with the parsed attributes.
	 */
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") == null || !section.getValue("type").equals(TYPE)) return null;
		
		return new NewMostCrowdedJunctionEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"));
	}
	
}
