package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewBikeEvent;
import es.ucm.fdi.model.NewCarEvent;
import es.ucm.fdi.model.NewVehicleEvent;

/**
 * @author Pablo and Diego
 * 
 * Event builder which extends the EventBuilder for the events when a new round robin junction is created.
 *
 */

public class NewVehicleEventBuilder extends EventBuilder {

	public static final String ID = "new_vehicle";

	/**
	 * Parser for the NewVehicleEventBuilder, checks if the section has the tag desired and parses its time, id,
	 * max speed and itinerary.
	 * 
	 * @param section IniSection to be parse, searching the information wanted.
	 * @return the Event with the parsed attributes.
	 */
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") != null) return null;
		
		return new NewVehicleEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"),
						EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary"));
				
	}

}
