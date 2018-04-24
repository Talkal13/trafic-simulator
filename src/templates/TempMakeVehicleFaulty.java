package templates;

import es.ucm.fdi.ini.IniSection;

public class TempMakeVehicleFaulty extends Template {

	private static final String USER_NAME = "Make Vehicle Faulty";
	private static final String COMMAND = "make_vehicle_faulty";
	
	public TempMakeVehicleFaulty() {
		super(USER_NAME);
	}


	@Override
	public String generateTemplate() {
		IniSection s = new IniSection(COMMAND);
		s.setValue("time", "");
		s.setValue("vehicles", "");
		s.setValue("duration", "");
		return s.toString();
	}

}
