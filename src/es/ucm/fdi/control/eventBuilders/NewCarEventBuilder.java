package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewCarEvent;

public class NewCarEventBuilder extends EventBuilder{

	public static final String ID = "new_vehicle";
	public static final String IDToString = "New Vehicle";
	public static final String TYPE = "car";
	
	
	public NewCarEventBuilder() {
		
	}
	
	@Override
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type").equals(TYPE)) return null;
		
		return new NewCarEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), 
				EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary"), EventBuilder.parsePositiveInt(section, "resistance"),
				EventBuilder.parsePositiveInt(section, "max_fault_duration"), EventBuilder.parseNonNegDouble(section, "fault_probability"), EventBuilder.parsePositiveLong(section, "seed") );
	}
	
	public String toString() {
		return null;
	}

}
