package es.ucm.fdi.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import es.ucm.fdi.control.Controller;
import es.ucm.fdi.control.eventBuilders.EventBuilder;
import templates.TemplatesInvoker;

public class PopUpMenu extends JPopupMenu {
	

	public PopUpMenu(MainFrame mainWindow, TextAreaPanel t) {
		super();
		addEditor(mainWindow, t);
	}

	private void addEditor(MainFrame mainWindow, TextAreaPanel t) {

		JMenu addTemplates = new JMenu("Add Template");
		TemplatesInvoker i = new TemplatesInvoker();
		i.addTemplates(addTemplates, t._textArea);
		
		JMenuItem load = new JMenuItem("Load");
		load.setActionCommand(ButtonConstants.LOAD);
		load.addActionListener(mainWindow);
		load.setMnemonic(KeyEvent.VK_L);
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));

		JMenuItem save = new JMenuItem("Save");
		save.setActionCommand(ButtonConstants.SAVE);
		save.addActionListener(mainWindow);
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		
		JMenuItem clear = new JMenuItem("Clear");
		clear.setActionCommand(ButtonConstants.CLEAR);
		clear.addActionListener(mainWindow);
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
		ActionEvent.CTRL_MASK));


		
		this.add(addTemplates);
		this.addSeparator();
		this.add(load);
		this.add(save);
		this.add(clear);
		// connect the popup menu to the text area _editor

	}
}
