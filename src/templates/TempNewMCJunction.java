package templates;

import es.ucm.fdi.ini.IniSection;

public class TempNewMCJunction extends Template {

	private static final String USER_NAME = "New RR Junction";
	private static final String COMMAND = "new_junction";
	
	public TempNewMCJunction() {
		super(USER_NAME);
	}

	@Override
	public String generateTemplate() {
		//check correct fields
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("id", "");
		s.setValue("type", "mc");
		return s.toString();
	}

}