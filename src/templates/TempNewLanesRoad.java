package templates;

import es.ucm.fdi.ini.IniSection;

public class TempNewLanesRoad extends Template {

	private static final String USER_NAME = "New Lanes Road";
	private static final String COMMAND = "new_road";
	
	public TempNewLanesRoad() {
		super(USER_NAME);
		
	}

	@Override
	public String generateTemplate() {
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("id", "");
		s.setValue("type", "lanes");
		s.setValue("src", "");
		s.setValue("dest", "");
		s.setValue("max_speed", "");
		s.setValue("lenght", "");
		s.setValue("lanes", "");
		return s.toString();
	}

}
