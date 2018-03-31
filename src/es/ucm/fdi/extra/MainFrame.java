package es.ucm.fdi.extra;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

import es.ucm.fdi.extra.panels.TextEditorPanel;
import es.ucm.fdi.extra.toolbar.MainToolbar;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {
	
	private final String LOAD = "load";
	private final String SAVE = "save";
	private final String CLEAR = "clear";
	private final String QUIT = "quit";
	
	private JFileChooser fc;
	
	
	private JToolBar toolbar;
	private JPanel text_editor;
	
	public MainFrame() {
		super("[=] Traffic Simulator [=]");
		initGUI();
	}
	
	private void initGUI() {

		Container c = new Container();
		JPanel j = new JPanel(new GridLayout());
		text_editor = new TextEditorPanel();
		this.setContentPane(j);

		c.add(text_editor);
		this.add(c);
		// tool bar
		toolbar = new MainToolbar(this);
		this.add(toolbar, BorderLayout.PAGE_START);

		// menu bar
		//this.setJMenuBar(createMenuBar());

		// we create the file chooser only once
		fc = new JFileChooser();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (LOAD.equals(e.getActionCommand()))
			loadFile();
		else if (SAVE.equals(e.getActionCommand()))
			saveFile();
		else if (CLEAR.equals(e.getActionCommand()))
			textArea.setText("");
		else if (QUIT.equals(e.getActionCommand()))
			System.exit(0);
	}
	
	private void saveFile() {
		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			writeFile(file, textArea.getText());
		}
	}

	private void loadFile() {
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			String s = readFile(file);
			textArea.setText(s);
		}
	}

	public static String readFile(File file) {
		String s = "";
		try {
			s = new Scanner(file).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return s;
	}

	public static void writeFile(File file, String content) {
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.print(content);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
