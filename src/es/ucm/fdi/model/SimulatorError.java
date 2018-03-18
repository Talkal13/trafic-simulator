package es.ucm.fdi.model;

/**
 * @author Pablo and Diego
 *
 * Class which implements the Exception caused during the simulation of the program, extending from the RuntimeException.
 */

public class SimulatorError extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the class which will content a describing message telling which is the cause of the error.
	 * 
	 * @param error description of the error caused.
	 */
	
	public SimulatorError(String error) {
		super(error);
	}
}
