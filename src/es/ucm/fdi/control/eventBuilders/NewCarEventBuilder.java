package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewCarEvent;

/**
 * @author Pablo and Diego
 * 
 * Event builder which extends the EventBuilder for the events when a Car is built.
 *
 */

public class NewCarEventBuilder extends EventBuilder{

	public static final String ID = "new_vehicle";
	public static final String TYPE = "car";
	
	/**
	 * Parser for the NewCarEventBuilder, checks if the section has the tag desired and parses its time, id, max speed, resistance, itinerary,
	 * max_fault_duration and fault_probability. it will also check if there is any seed to set the probability of it to get faulty.
	 * 
	 * @param IniSection to be parse, searching the information wanted.
	 * @return the Event with the parsed attributes.
	 */
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") == null || !section.getValue("type").equals(TYPE)) return null;
		
		long seed;
		
		if (section.getValue("seed") == null) {
			seed = System.currentTimeMillis();
		}
		else {
			seed = EventBuilder.parsePositiveLong(section, "seed");
		}
		
		return new NewCarEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), 
				EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary"), EventBuilder.parsePositiveInt(section, "resistance"),
				EventBuilder.parsePositiveInt(section, "max_fault_duration"), EventBuilder.parseNonNegDouble(section, "fault_probability"), seed);
	}

}
