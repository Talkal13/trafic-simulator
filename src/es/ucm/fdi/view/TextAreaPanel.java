package es.ucm.fdi.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import es.ucm.fdi.extra.panels.TextEditorPanel;


abstract public class TextAreaPanel extends JPanel {
	protected JTextArea _textArea;
	
	public static Border defaultBorder = BorderFactory.createLineBorder(Color.black, 2);

	
	public TextAreaPanel(String title, boolean editable) {
		this.setLayout(new GridLayout(1,1));
		_textArea = new JTextArea(40, 30);
		_textArea.setEditable(editable);
		this.add(_textArea);
		this.add(new JScrollPane(_textArea));
		this.setTheBorder(title);
		//this.setVisible(true);
	}

	private void setTheBorder(String title) {
		this.setBorder(new TitledBorder(defaultBorder, title));
	}
	
	public String getText() {
		return _textArea.getText();
	}
	
	public void setText(String newText) {
		_textArea.setText(newText);
	}
	
	public void cleanUp() {
		_textArea.setText("");
	}
	
	public void insert(String value) {
		_textArea.insert(value, _textArea.getCaretPosition());
	}

	public void setBorder(String name) {
		// TODO Auto-generated method stub
		
	}

}
