package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewLanesRoadEvent;
import es.ucm.fdi.model.NewRoadEvent;

/**
 * @author Pablo & Diego
 * 
 * Event builder which extends the EventBuilder for the events when a new Lanes Road is created.
 *
 */

public class NewLanesRoadEventBuilder extends EventBuilder{

	public static final String ID = "new_road";
	public static final String TYPE = "lanes";
	
	/**
	 * Parser for the NewLanesRoadEventBuilder, checks if the section has the tag desired and parses its time, id, length, 
	 * max speed, source, destination and lanes.
	 * 
	 * @param IniSection to be parse, searching the information wanted.
	 * @return the Event with the parsed attributes.
	 */
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") == null || !section.getValue("type").equals(TYPE)) return null;
		
		return new NewLanesRoadEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), EventBuilder.parsePositiveInt(section, "length"),EventBuilder.parsePositiveInt(section, "max_speed"),
				EventBuilder.validId(section, "src"), EventBuilder.validId(section, "dest"), EventBuilder.parsePositiveInt(section, "lanes"));
	}

}
