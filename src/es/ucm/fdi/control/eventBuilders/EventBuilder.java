package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;

public abstract class EventBuilder {
	
	
	public abstract Event parse(IniSection section);

	public static int parseNonNegInt(IniSection section, String key, int i) {
		String tempTime = section.getValue(key);
		if (tempTime == null) {
			return i;
		}
		try {
			return Integer.parseUnsignedInt(tempTime);
		} catch (NumberFormatException e) {
			return -1; //TODO: Throw exception
		}
	}

	public static String validId(IniSection section, String key) {
		String tempId = section.getValue(key);
		if (tempId == null) {
			return null; //TODO: Throw exception
		}
		if (tempId.matches("^[a-zA-Z0-9_]+$"))
			return tempId;
		else
			return null; //TODO: Throw exception
	}
	
	public static int parsePositiveInt(IniSection section, String key) {
		String tempValue = section.getValue(key);
		if (tempValue == null) {
			return 0; //TODO: Throw exception
		}
		try {
			int tempNum = Integer.parseUnsignedInt(tempValue);
			if (tempNum > 0) {
				return tempNum;
			}
			else {
				return 0; //TODO: throw exception
			}
		} catch (NumberFormatException e) {
			return -1; //TODO: Throw exception
		}
	}

	public static String[] parseListValidId(IniSection section, String key) {
		String[] tempValidList = section.getValue(key).split(",");
		if (tempValidList == null) {
			return null; //TODO: Throw exception
		}
		for (String s : tempValidList) {
			if (!s.matches("^[a-zA-Z0-9_]+$"))
				return null; //TODO: throw exception
		}
		return tempValidList;
	}

	public static double parseNonNegDouble(IniSection section, String key) {
		String tempTime = section.getValue(key);
		if (tempTime == null) {
			return -1;
		}
		try {
			Double d = Double.parseDouble(tempTime);
			if (d < 0) return -1;
			else return d;
		} catch (NumberFormatException e) {
			return -1; //TODO: Throw exception
		}
	}

	public static long parsePositiveLong(IniSection section, String key) {
		String tempValue = section.getValue(key);
		if (tempValue == null) {
			return 0; //TODO: Throw exception
		}
		try {
			long tempNum = Long.parseUnsignedLong(tempValue);
			if (tempNum > 0) {
				return tempNum;
			}
			else {
				return 0; //TODO: throw exception
			}
		} catch (NumberFormatException e) {
			return -1; //TODO: Throw exception
		}
	}

		
}
