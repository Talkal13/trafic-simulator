package templates;

import es.ucm.fdi.ini.IniSection;

public class TempNewRRJunction extends Template {

	private static final String USER_NAME = "New RR Junction";
	private static final String COMMAND = "new_junction";
	
	public TempNewRRJunction() {
		super(USER_NAME);
	}


	@Override
	public String generateTemplate() {
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("id", "");
		s.setValue("type", "rr");
		return s.toString();
	}

}
