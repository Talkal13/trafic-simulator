package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewRoundRobinJunctionEvent;

/**
 * @author Pablo & Diego
 * 
 * Event builder which extends the EventBuilder for the events when a new round robin junction is created.
 *
 */

public class NewRoundRobinJunctionEventBuilder extends EventBuilder{

	public static final String ID = "new_junction";
	public static final String TYPE = "rr";
	
	/**
	 * Parser for the NewRoundRobinJunctionEventBuilder, checks if the section has the tag desired and parses its time, id,
	 * max time slice and min time slice.
	 * 
	 * @param IniSection to be parse, searching the information wanted.
	 * @return the Event with the parsed attributes.
	 */

	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") == null || !section.getValue("type").equals(TYPE)) return null;
		
		return new NewRoundRobinJunctionEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"),EventBuilder.parsePositiveInt(section, "min_time_slice"), EventBuilder.parsePositiveInt(section, "max_time_slice"));
		
	}

}
