package es.ucm.fdi.view;

import java.awt.PopupMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;

public class EventsEditorPanel extends TextAreaPanel implements TrafficSimulatorObserver, GuiViewObserver {

	public EventsEditorPanel(String title,String text, boolean editable, MainFrame mainWindow ) {
		super(title, editable);
		this.setText(text);
		mainWindow.addObserver(this);
		
		PopUpMenu popUp = new PopUpMenu(mainWindow, this);
		//this._textArea.add(popUp);
		
		
		_textArea.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}

			private void showPopup(MouseEvent e) {
				if (e.isPopupTrigger() && _textArea.isEnabled()) {
					popUp.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			
		});
	}
	

	@Override
	public void onRegistered(TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(TrafficSimulator trafficSimulator) {
		_textArea.setText("");
		
	}

	@Override
	public void onAdvance(TrafficSimulator t, int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdvance(SimulatedObject o, int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewEvent(Event e, RoadMap _map, int _time) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onLoadFile(File file) {
		try {
			super.setTitle("Events: " + file.getName());
			this._textArea.setText(readFile(file));
			
		} catch (FileNotFoundException e) {
		
		}
		
	}

	
	public static String readFile(File file) throws FileNotFoundException {
		String s = "";
		s = new Scanner(file).useDelimiter("\\A").next();

		return s;
	}
	

	@Override
	public void onSaveFile(File file) {
		// TODO Auto-generated method stub
		
	}
	
	public void onStart(TrafficSimulator t, List<Event> events) {
		// TODO Auto-generated method stub
		
	}

}
