package templates;

import es.ucm.fdi.ini.IniSection;

public class TempNewDirtRoad extends Template {

	private static final String USER_NAME = "New Dirt Road";
	private static final String COMMAND = "new_road";
	
	public TempNewDirtRoad() {
		super(USER_NAME);
		
	}

	@Override
	public String generateTemplate() {
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("id", "");
		s.setValue("type", "dirt");
		s.setValue("src", "");
		s.setValue("dest", "");
		s.setValue("max_speed", "");
		s.setValue("lenght", "");
		return s.toString();
	}

}
