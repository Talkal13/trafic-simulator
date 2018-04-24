package templates;

import es.ucm.fdi.ini.IniSection;

public class TempNewVehicle extends Template {

	private static final String USER_NAME = "New vehicle";
	private static final String COMMAND = "new_vehicle";
	
	public TempNewVehicle() {
		super(USER_NAME);
	}


	@Override
	public String generateTemplate() {
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("id", "");
		s.setValue("max speed", "");
		s.setValue("itinerary", "");
		return s.toString();
	}

}
