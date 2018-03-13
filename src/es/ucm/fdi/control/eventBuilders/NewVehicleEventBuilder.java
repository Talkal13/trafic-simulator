package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.NewBikeEvent;
import es.ucm.fdi.model.NewCarEvent;
import es.ucm.fdi.model.NewVehicleEvent;

public class NewVehicleEventBuilder extends EventBuilder {

	public static final String ID = "new_vehicle";
	public static final String IDToString = "New Vehicle";
	
	
	public NewVehicleEventBuilder() {
		
	}
	
	@Override
	public Event parse(IniSection section) {
		if(!section.getTag().equals(ID)) return null;
		if (section.getValue("type") != null) return null;
		
		return new NewVehicleEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"),
						EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary"));
				
	}
	
	public String toString() {
		return null;
	}
	
}
