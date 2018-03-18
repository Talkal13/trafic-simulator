package es.ucm.fdi.control.eventBuilders;

import es.ucm.fdi.ini.IniError;
import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.SimulatorError;

/**
 * @author Pablo & Diego
 *
 * Abstract class which will extend all the different events that could happen during the execution.
 * 
 */

public abstract class EventBuilder {
	
	/**
	 * Parser of each of the different Event Builders that will extends from this class.
	 *  
	 * @param section Ini file to be parsed.
	 * @return the resulting Event of the parse.
	 */
	
	public abstract Event parse(IniSection section);
	
	/**
	 * Parses integers in the ini file.
	 * 
	 * @param section ini file to be parsed.
	 * @param key key-value line of the ini file.
	 * @param i the resulting value of the parse.
	 * @return the integer which will be in a correct format.
	 * @throws NumberFormatException in the case it doesn't accomplish the expected format (unsigned int)
	 */

	public static int parseNonNegInt(IniSection section, String key, int i) {
		String tempTime = section.getValue(key);
		if (tempTime == null) {
			return i;
		}
		try {
			return Integer.parseUnsignedInt(tempTime);
		} catch (NumberFormatException e) {
			throw new SimulatorError("Expected a non negative integer, none found");
		}
	}

	/**
	 * Makes sure the section has an id key valid and returns it.
	 * 
	 * @param section ini section to check.
	 * @param key key-value line of the ini file.
	 * @return the id value of the event to be built.
	 * @throws SimulatorError in case there is no tempId or there is but isn't valid.
	 */
	
	public static String validId(IniSection section, String key) throws SimulatorError {
		String tempId = section.getValue(key);
		if (tempId == null) { // case there is no id in the event when expected
			throw new SimulatorError("Missing " + key + " in the section " + section.getTag());
		}
		if (tempId.matches("^[a-zA-Z0-9_]+$"))
			return tempId;
		else
			throw new SimulatorError("Id of the event doesnt match"); 
	}
	
	/**
	 * Parses a number which should be positive in order to don't throw any exception, and accomplish the expected.
	 * 
	 * @param section ini section to be check.
	 * @param key key-value line of the ini file.
	 * @return the positive integer in the right format.
	 * @throws NumberFormatException when worn format and SimulatorError when doesn't exist or not a positive integer
	 */
	
	public static int parsePositiveInt(IniSection section, String key) {
		String tempValue = section.getValue(key);
		if (tempValue == null) {
			throw new SimulatorError("Missing " + key + " in the section " + section.getTag());
		}
		try {
			int tempNum = Integer.parseUnsignedInt(tempValue);
			if (tempNum > 0) {
				return tempNum;
			}
			else {
				throw new SimulatorError("The number expected to be positive was not.");
			}
		} catch (NumberFormatException e) {
			throw new SimulatorError("Expected a positive integer, none found");
		}
	}
	
	/**
	 * Parses a list of ids making sure that all of them accomplish the expected format.
	 * 
	 * @param section ini section to be check.
	 * @param key key-value line of the ini file.
	 * @return the list of ids in the right format.
	 * @throws SimulatorError in case the list doesn't exist or any of the elements contained in it hasn�t expected format.
	 */

	public static String[] parseListValidId(IniSection section, String key) throws SimulatorError{
		String[] tempValidList = section.getValue(key).split(",");
		if (tempValidList == null) {
			throw new SimulatorError("Missing " + key + " in the section " + section.getTag());
		}
		for (String s : tempValidList) {
			if (!s.matches("^[a-zA-Z0-9_]+$"))
				throw new SimulatorError("An element with an incorrect ini format was found.");
		}
		return tempValidList;
	}
	
	/**
	 * Parses a double which should be non negative in order to don't throw any exception, and accomplish the expected.
	 * 
	 * @param section ini section to be check.
	 * @param key key-value line of the ini file.
	 * @return the non negative double in the right format.
	 * @throws Exception SimulatorError if there weren't such a double and NumberFormatException if the format wasn't correct.
	 */

	public static double parseNonNegDouble(IniSection section, String key) {
		String tempTime = section.getValue(key);
		if (tempTime == null) {
			throw new SimulatorError("Missing " + key + " in the section " + section.getTag());
		}
		try {
			Double d = Double.parseDouble(tempTime);
			if (d < 0) return -1;
			else return d;
		} catch (NumberFormatException e) {
			throw new SimulatorError("Expected a non negative double, none found");
		}
	}
	
	/**
	 * Parses a long which should be positive in order to don't throw any exception, and accomplish the expected.
	 * 
	 * @param section ini section to be check.
	 * @param key key-value line of the ini file.
	 * @return the positive long in the right format.
	 * @throws Exception SimulatorError if there weren't such a long or wasn't positive and NumberFormatException if the format wasn't correct.
	 */
	
	public static long parsePositiveLong(IniSection section, String key) {
		String tempValue = section.getValue(key);
		if (tempValue == null) {
			throw new SimulatorError("Missing " + key + " in the section " + section.getTag());
		}
		try {
			long tempNum = Long.parseUnsignedLong(tempValue);
			if (tempNum > 0) {
				return tempNum;
			}
			else {
				throw new SimulatorError("Not positive long found when expected.");
			}
		} catch (NumberFormatException e) {
			throw new SimulatorError("Expected a positive long, none found");
		}
	}

		
}
