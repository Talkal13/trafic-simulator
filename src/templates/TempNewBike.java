package templates;

import es.ucm.fdi.ini.IniSection;

public class TempNewBike extends Template {

	private static final String USER_NAME = "New bike";
	private static final String COMMAND = "new_bike";
	
	public TempNewBike() {
		super(USER_NAME);
	}


	@Override
	public String generateTemplate() {
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("id", "");
		s.setValue("max speed", "");
		s.setValue("itinerary", "");
		s.setValue("type", "bike");
		return s.toString();
	}


}
