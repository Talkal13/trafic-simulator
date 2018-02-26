package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;

public abstract class SimulatedObject {
	
	protected String _id;
	protected int _state; //TODO
	
	/**
	 * Constructor of the class, assigns the id introduced as parameter to the class attribute
	 * 
	 * @param id all objects have an unique identifier
	 */
	
	public SimulatedObject(String id) {
		_id = id;
	}
	
	/**
	 * Get method of the attribute id of the class.
	 * 
	 * @return the id attribute of the class
	 */
	
	public String getId() {
		return _id;
	}
	
	public String toString() {
		return _id;
	}
	
	/**
	 * Generates the report of the object, TODO finish the javadoc of the function
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
	
	protected abstract void fillReportDetails(IniSection is);
	
	protected abstract String getReportSectionTag();
	
	abstract void advance();

}
