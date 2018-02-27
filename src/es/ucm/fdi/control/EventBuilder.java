package es.ucm.fdi.control;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;

public abstract class EventBuilder {
	public abstract Event parse(IniSection section);
		
}
