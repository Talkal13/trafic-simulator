package es.ucm.fdi.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


abstract public class TextAreaPanel extends JPanel {
	protected JTextArea _textArea;
	
	public TextAreaPanel(String title, boolean editable) {
		this.setLayout(new GridLayout(1,1));
		_textArea = new JTextArea(40, 30);
		_textArea.setEditable(editable);
		
		this.add(new JScrollPane(_textArea));
		this.setTheBorder(title);
	}

	private void setTheBorder(String title) {
		this.setBorder(BorderFactory.createTitledBorder(title));
	}
	
	public String getText() {
		return null;
	}
	
	public void setText(String newText) {
		
	}
	
	public void cleanUp() {
		
	}
	
	public void insert(String value) {
		_textArea.insert(value, _textArea.getCaretPosition());
	}

}
