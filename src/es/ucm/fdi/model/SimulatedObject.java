package es.ucm.fdi.model;

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
		return null; //TODO
	}
	
	public String generateReport(int id) {
		return null; //TODO
	}
	
	protected abstract void fillReportDetails();
	
	protected abstract String getReportSectionTag();
	
	abstract void advance();

}
