package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewLanesRoadEvent;
import es.ucm.fdi.model.NewRoadEvent;

public class NewLanesRoadEventBuilder extends EventBuilder{

	public static final String ID = "new_road";
	public static final String IDToString = "New Road";
	public static final String TYPE = "lanes";
	
	public NewLanesRoadEventBuilder() {
		
	}
	
	@Override
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") == null || !section.getValue("type").equals(TYPE)) return null;
		
		return new NewLanesRoadEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), EventBuilder.parsePositiveInt(section, "length"),EventBuilder.parsePositiveInt(section, "max_speed"),
				EventBuilder.validId(section, "src"), EventBuilder.validId(section, "dest"), EventBuilder.parsePositiveInt(section, "lanes"));
	}
	
	public String toString() {
		return null;
	}

}
