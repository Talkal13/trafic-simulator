package es.ucm.fdi.model;

import es.ucm.fdi.ini.IniSection;

public abstract class SimulatedObject {
	
	protected String _id;
	protected int _state; //TODO
	
	/**
	 * Constructor
	 * 
	 * @param id
	 */
	public SimulatedObject(String id) {
		_id = id;
	}
	
	public String getId() {
		return _id;
	}
	
	public String toString() {
		return _id;
	}
	
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
