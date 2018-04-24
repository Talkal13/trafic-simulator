package templates;

import es.ucm.fdi.ini.IniSection;

public class TempNewJunction extends Template {

	private static final String USER_NAME = "New Junction";
	private static final String COMMAND = "new_junction";
	
	public TempNewJunction() {
		super(USER_NAME);
		
	}

	@Override
	public String generateTemplate() {
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("id", "");
		return s.toString();
	}

}
