package es.ucm.fdi.view;

import java.io.IOException;
import java.io.OutputStream;

public class SimulatorOutputStream extends OutputStream {

	private TextAreaPanel _t;
	
	public SimulatorOutputStream(TextAreaPanel t) {
		_t = t;
	}
	
	
	@Override
	public void write(int arg0) throws IOException {
		_t._textArea.append(String.valueOf((char) arg0));
	}

}
