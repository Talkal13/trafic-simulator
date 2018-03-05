package es.ucm.fdi.control;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewJunctionEvent;

public class NewJunctionEventBuilder extends EventBuilder{

	public NewJunctionEventBuilder() {
		this._id = "new_junction";
		this._keys = new String[] { "time", "id" };
	}
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(this._id) || section.getValue("type") != null)
			return null;
		else
			return null;//TODO new NewJunctionEvent();
			
	}
	
	public String toString(){
		return "New Junction";
		
	}

}
