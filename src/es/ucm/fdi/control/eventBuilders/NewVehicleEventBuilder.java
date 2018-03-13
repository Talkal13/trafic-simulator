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
		String type;
		if(!section.getTag().equals(ID))
			return null;
		else {
			type = section.getValue("type");
			switch (type) {
			case "car":
				//arguments doesnt fix with the constructor
				return new NewCarEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), 
						EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary"), EventBuilder.parsePositiveInt(section, "resistance"),
						EventBuilder.parsePositiveInt(section, "max_fault_duration"), EventBuilder.parseNonNegDouble(section, "fault_probability"), EventBuilder.parsePositiveLong(section, "seed") );
				
			case "bike":
				return new NewBikeEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"), 
						EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary") );
				
			default:
				return new NewVehicleEvent(EventBuilder.parseNonNegInt(section, "time", 0), EventBuilder.validId(section, "id"),
						EventBuilder.parsePositiveInt(section, "max_speed"), EventBuilder.parseListValidId(section, "itinerary") );
				
			}
			
			
		}
	}
	
	public String toString() {
		return null;
	}
	
}
