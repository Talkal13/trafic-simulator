package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewRoundRobinJunctionEvent;

public class NewRoundRobinJunctionEventBuilder extends EventBuilder{

	public static final String ID = "new_junction";
	public static final String IDToString = "New Junction";
	public static final String TYPE = "rr";
	
	public NewRoundRobinJunctionEventBuilder() {
		
	}
	@Override
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") == null || !section.getValue("type").equals(TYPE)) return null;
		
		return new NewRoundRobinJunctionEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"),EventBuilder.parsePositiveInt(section, "min_time_slice"), EventBuilder.parsePositiveInt(section, "max_time_slice"));
		
	}
	
	public String toString() {
		return null;
	}

}
