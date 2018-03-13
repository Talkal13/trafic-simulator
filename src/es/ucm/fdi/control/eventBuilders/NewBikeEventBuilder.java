package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewBikeEvent;

public class NewBikeEventBuilder extends EventBuilder{
	
	public static final String ID = "new_vehicle";
	public static final String IDToString = "New Vehicle";
	public static final String TYPE = "bike";
	
	public NewBikeEventBuilder() {
		
	}

	@Override
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type").equals(TYPE)) return null;
		
		return new NewBikeEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), 
				EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary") );
	}
	
	public String toString() {
		return null;
	}

}
