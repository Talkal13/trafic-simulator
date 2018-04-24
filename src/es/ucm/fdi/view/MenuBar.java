package es.ucm.fdi.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import es.ucm.fdi.control.Controller;

public class MenuBar extends JMenuBar  {

	private JCheckBoxMenuItem redirect;
	
	public MenuBar(MainFrame mainWindow, Controller _ctrl) {
		super();
		JMenuItem load, save, save_report, quit;
		JMenuItem run, reset;
		
		JMenuItem generate, clear;

		JMenu file = new JMenu("File");
		JMenu simulator  = new JMenu("Simulator");
		JMenu reports  = new JMenu("Reports");
		
		this.add(file);
		this.add(simulator);
		this.add(reports);
		file.setMnemonic(KeyEvent.VK_F);

		load = new JMenuItem("Load Events");
		load.setActionCommand(ButtonConstants.LOAD);
		load.addActionListener(mainWindow);
		load.setMnemonic(KeyEvent.VK_L);
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));

		save = new JMenuItem("Save Events");
		save.setActionCommand(ButtonConstants.SAVE);
		save.addActionListener(mainWindow);
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));

		save_report = new JMenuItem("Save Report");
		save_report.setActionCommand(ButtonConstants.SAVE_REPORT);
		save_report.addActionListener(mainWindow);
		save_report.setMnemonic(KeyEvent.VK_R);
		save_report.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				ActionEvent.CTRL_MASK));

		quit = new JMenuItem("Exit");
		quit.setActionCommand(ButtonConstants.QUIT);
		quit.addActionListener(mainWindow);
		quit.setMnemonic(KeyEvent.VK_E);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));

		file.add(load);
		file.add(save);
		file.addSeparator();
		file.add(save_report);
		file.addSeparator();
		file.add(quit);
		
		run = new JMenuItem("Run");
		run.setActionCommand(ButtonConstants.RUN);
		run.addActionListener(mainWindow);
		
		reset = new JMenuItem("Reset");
		reset.setActionCommand(ButtonConstants.RESET);
		reset.addActionListener(mainWindow);
		
		redirect = new JCheckBoxMenuItem("Redirect");
		redirect.setSelected(true);
		redirect.addItemListener(mainWindow);
		
		simulator.add(run);
		simulator.add(reset);
		simulator.add(redirect);
		
		generate = new JMenuItem("Generate");
		generate.setActionCommand(ButtonConstants.GENERATE);
		generate.addActionListener(mainWindow);
		
		clear = new JMenuItem("Clear");
		clear.setActionCommand(ButtonConstants.CLEAR_REPORTS);
		clear.addActionListener(mainWindow);
		
		reports.add(generate);
		reports.add(clear);
		
		this.setBackground(Color.WHITE);
	}
	
	public JCheckBoxMenuItem getRedirect() {
		return redirect;
	}
	
}
