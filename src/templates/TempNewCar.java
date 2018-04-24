package templates;

import es.ucm.fdi.ini.IniSection;

public class TempNewCar extends Template {

	private static final String USER_NAME = "New car";
	private static final String COMMAND = "new_car";
	
	public TempNewCar() {
		super(USER_NAME);
	}


	@Override
	public String generateTemplate() {
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("id", "");
		s.setValue("max speed", "");
		s.setValue("itinerary", "");
		s.setValue("type", "car");
		return s.toString();
	}


}
