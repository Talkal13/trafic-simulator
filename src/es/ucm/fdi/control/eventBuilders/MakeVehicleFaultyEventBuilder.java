package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.MakeVehicleFaultyEvent;

public class MakeVehicleFaultyEventBuilder extends EventBuilder {
	
	public static final String ID = "make_vehicle_faulty";
	public static final String IDToString = "Make Vehicle Faulty";
	
	
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID))
			return null;
		else
			return new MakeVehicleFaultyEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.parseListValidId(section, "vehicles"), EventBuilder.parsePositiveInt(section, "duration"));
			
	}
	
	public String toString(){
		return IDToString;
		
	}
}
