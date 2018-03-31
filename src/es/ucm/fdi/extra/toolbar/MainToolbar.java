package es.ucm.fdi.extra.toolbar;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainToolbar extends JToolBar {
	
	private final String LOAD = "load";
	private final String SAVE = "save";
	private final String CLEAR = "clear";
	private final String QUIT = "quit";
	
	public MainToolbar(JFrame frame) {
		super();
		JButton load = new JButton();
		load.setActionCommand(LOAD);
		load.setToolTipText("Load a file");
		load.addActionListener((ActionListener) frame);
		load.setIcon(new ImageIcon(loadImage("resources/icons/open.png")));
		this.add(load);

		JButton save = new JButton();
		save.setActionCommand(SAVE);
		save.setToolTipText("Save a file");
		save.addActionListener((ActionListener) frame);
		save.setIcon(new ImageIcon(loadImage("resources/icons/save.png")));
		this.add(save);

		JButton clear = new JButton();
		clear.setActionCommand(CLEAR);
		clear.setToolTipText("Clear Text");
		clear.addActionListener((ActionListener) frame);
		clear.setIcon(new ImageIcon(loadImage("resources/icons/clear.png")));
		this.add(clear);
	}
	
	private static Image loadImage(String path) {
		return Toolkit.getDefaultToolkit().createImage(path);
	}

	

}
