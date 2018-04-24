package es.ucm.fdi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.SimulatorError;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;

@SuppressWarnings("serial")
public class EventsTable extends JPanel implements TrafficSimulatorObserver, GuiViewObserver {
	
	public static Border defaultBorder = BorderFactory.createLineBorder(Color.black, 2);

	class EventsTableModel extends AbstractTableModel{

		private final String[] header = {"#", "Time", "Type"};
		
		public String getColumnName(int pos) {
			return header[pos];	
		}
		
		@Override
		public int getColumnCount() {
			return header.length;
		}

		@Override
		public int getRowCount() {
			if (_events == null) return 0;
			return _events.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0:	return rowIndex;
				case 1:	return _events.get(rowIndex).getScheduledTime();
				case 2:	return  _events.get(rowIndex).toString();
				default: return null;
			}
		}
		
		void refresh() {
			fireTableDataChanged();
		}
		
	}
	
	
	private List<Event> _events;
	private EventsTableModel _eventsModel;

	EventsTable(MainFrame mainWindow ){
		_events = new ArrayList<Event>();
		mainWindow.addObserver(this);
		initGUI();
		
	}
	
	private void initGUI() {
		this.setBorder(new TitledBorder(defaultBorder, "Events Queue"));
		this.setLayout(new BorderLayout());
		_eventsModel = new EventsTableModel();
		
		JTable t = new JTable(_eventsModel);
		t.setShowGrid(false);
		JScrollPane s = new JScrollPane(t);
		s.getViewport().setBackground(Color.WHITE);
		this.add(s, BorderLayout.CENTER); //check
		this.setVisible(true);
	}
	

	@Override
	public void onRegistered(es.ucm.fdi.model.TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(es.ucm.fdi.model.TrafficSimulator trafficSimulator) {
		_events = null;
		_eventsModel.refresh();
		
	}

	@Override
	public void onAdvance(es.ucm.fdi.model.TrafficSimulator t, int time) {
		for (Iterator<Event> it = _events.iterator(); it.hasNext(); ) {
		    Event e = it.next();
		    if (e.getScheduledTime() <= time) {
		        it.remove();
		    }
		}
		_eventsModel.refresh();
	}

	@Override
	public void onAdvance(SimulatedObject o, int time) {
		
	}

	@Override
	public void onError(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewEvent(es.ucm.fdi.model.Event e, es.ucm.fdi.model.RoadMap map, int time) {

	}

	@Override
	public void onStart(TrafficSimulator t, List<Event> events) {
		_events = new ArrayList<Event>(events);
		_eventsModel.refresh();		
	}

	@Override
	public void onLoadFile(File file) {
		
	}

	@Override
	public void onSaveFile(File file) {
		// TODO Auto-generated method stub
		
	}


	
	
}
