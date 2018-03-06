package es.ucm.fdi.control;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewJunctionEvent;

public class NewJunctionEventBuilder extends EventBuilder{

	public static final String ID = "new_junction";
	public static final String IDToString = "New Junction";
	
	public NewJunctionEventBuilder() {
		
	}
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID))
			return null;
		else
			return new NewJunctionEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"));
			
	}
	
	public String toString(){
		return IDToString;
		
	}

}
