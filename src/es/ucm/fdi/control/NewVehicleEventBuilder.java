package es.ucm.fdi.control;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewVehicleEvent;

public class NewVehicleEventBuilder extends EventBuilder {

	public static final String ID = "new_vehicle";
	public static final String IDToString = "New Vehicle";
	
	@Override
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID))
			return null;
		else
			return new NewVehicleEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary") );
	}
	
}
