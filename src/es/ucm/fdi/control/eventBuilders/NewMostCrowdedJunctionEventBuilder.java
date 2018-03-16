package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewJunctionEvent;
import es.ucm.fdi.model.NewMostCrowdedJunctionEvent;

public class NewMostCrowdedJunctionEventBuilder extends EventBuilder{

	public static final String ID = "new_junction";
	public static final String IDToString = "New Junction";
	public static final String TYPE = "mc";
	
	public NewMostCrowdedJunctionEventBuilder(){
		
	}

	@Override
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") == null || !section.getValue("type").equals(TYPE)) return null;
		
		return new NewMostCrowdedJunctionEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"));
	}
	
	public String toString(){
		return null;
		
	}
}
