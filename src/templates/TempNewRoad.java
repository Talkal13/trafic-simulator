package templates;

import es.ucm.fdi.ini.IniSection;

public class TempNewRoad extends Template {

	private static final String USER_NAME = "New Road";
	private static final String COMMAND = "new_road";
	
	public TempNewRoad() {
		super(USER_NAME);
		
	}

	@Override
	public String generateTemplate() {
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("id", "");
		s.setValue("src", "");
		s.setValue("dest", "");
		s.setValue("max_speed", "");
		s.setValue("lenght", "");
		return s.toString();
	}
}
