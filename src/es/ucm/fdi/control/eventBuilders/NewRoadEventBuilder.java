package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewRoadEvent;

public class NewRoadEventBuilder extends EventBuilder {

	public static final String ID = "new_road";
	public static final String IDToString = "New Road";
	
	public NewRoadEventBuilder() {
		
	}
	@Override
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID))
			return null;
		else
			return new NewRoadEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), EventBuilder.parsePositiveInt(section, "length"),EventBuilder.parsePositiveInt(section, "max_speed"),
					EventBuilder.validId(section, "src"), EventBuilder.validId(section, "dest"));
	}
	
	public String toString() {
		return null;
	}

}
