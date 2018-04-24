package templates;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import es.ucm.fdi.view.TextAreaPanel;

public abstract class Template {
	
	private String _name;
	
	public Template(String name) {
		_name = name;
	}
	
	public abstract String generateTemplate();
	
	public JMenuItem generateMenuItem(JTextArea _textArea) {
		JMenuItem t = new JMenuItem(_name);
		t.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				_textArea.append(generateTemplate() + "\n");
				
			}
			
		});
		return t;
	}
}
