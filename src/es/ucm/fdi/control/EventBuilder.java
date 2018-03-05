package es.ucm.fdi.control;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;

public abstract class EventBuilder {
	protected String _id;
	protected String[] _keys;
	
	EventBuilder(){
		this._id = null;
		this._keys = null;
	}
	
	public abstract Event parse(IniSection section);
		
}
