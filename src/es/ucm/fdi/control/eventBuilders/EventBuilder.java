package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;

public abstract class EventBuilder {
	
	EventBuilder(){
		//TODO
	}
	
	public abstract Event parse(IniSection section);
	
	public String template() {
		return null;
	}

}
