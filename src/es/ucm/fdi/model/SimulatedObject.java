package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;

public abstract class SimulatedObject {
	
	protected String _id;
	protected int _state; 
	
	/**
	 * Constructor of the class, assigns the id introduced as parameter to the class attribute.
	 * 
	 * @param id all objects have an unique identifier.
	 */
	
	public SimulatedObject(String id) {
		_id = id;
	}
	
	/**
	 * Get method of the attribute id of the class.
	 * 
	 * @return the id attribute of the class.
	 */
	
	public String getId() {
		return _id;
	}
	
	/**
	 * Returns the string attribute which contains the id.
	 */
	
	public String toString() {
		return _id;
	}
	
	/**
	 * Generates the report of the object according with the information that each has.
	 * 
	 * @param time current time of the simulation.
	 * @return the string which contains the result of the report of the object.
	 */
	
	public String generateReport(int time) {
		IniSection is = new IniSection(getReportSectionTag());
		is.setValue("id", _id);
		is.setValue("time", time);
		fillReportDetails(is);
		return is.toString();
	}
	
	/**
	 * Makes the report that tells which is the result of the simulation of the object.
	 * 
	 * @param is Inisection which contains the information of the object.
	 */
	
	protected abstract void fillReportDetails(IniSection is);
	
	/**
	 * Returns the tag which describes the kind of object that is.
	 * 
	 * @return a string containing the Tag of the object.
	 */
	
	protected abstract String getReportSectionTag();
	
	/**
	 * Tells the object to advance its state according with the situation and events which will take place.
	 */
	
	abstract void advance();

}
