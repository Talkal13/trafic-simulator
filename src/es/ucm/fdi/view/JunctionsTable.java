package es.ucm.fdi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.Junction;
import es.ucm.fdi.model.Junction.IncomingRoad;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.SimulatorError;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;
import es.ucm.fdi.model.Vehicle;

@SuppressWarnings("serial")
public class JunctionsTable extends JPanel implements TrafficSimulatorObserver{
	
	public static Border defaultBorder = BorderFactory.createLineBorder(Color.black, 2);

	class VehiclesTableModel extends AbstractTableModel {

		private final String[] header = {"ID", "Green", "Red"};
		
		public String getColumnName(int pos) {
			return header[pos];	
		}
		
		@Override
		public int getColumnCount() {
			return header.length;
		}

		@Override
		public int getRowCount() {
			if (_map == null) return 0;
			return _map.getJunctions().size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			List<IncomingRoad> green = new ArrayList<IncomingRoad>();
			List<IncomingRoad> red = new ArrayList<IncomingRoad>();
			for (IncomingRoad r : _map.getJunctions().get(rowIndex).getRoadsInfo()) {
				if (r.hasGreenLight())
					green.add(r);
				else
					red.add(r);
			}
			switch(columnIndex) {
				case 0:	return _map.getJunctions().get(rowIndex).getId();
				case 1: return green;
				case 2:	return  red;
				default: return null;
			}
		}
		
		void refresh() {
			fireTableDataChanged();
		}
		
		public VehiclesTableModel() {
				
		}
		
	}
	
	
	private RoadMap _map;
	private VehiclesTableModel _vehiclesModel;
	private JTable _t;
	JunctionsTable(){
		_map = null;
		initGUI();
		
	}
	
	private void initGUI() {
		this.setBorder(new TitledBorder(defaultBorder, "Junctions"));
		this.setLayout(new BorderLayout());
		_vehiclesModel = new VehiclesTableModel();
		_t = new JTable(_vehiclesModel);
		_t.setShowGrid(false);
		JScrollPane s = new JScrollPane(_t);
		s.getViewport().setBackground(Color.WHITE);
		this.add(s, BorderLayout.CENTER); //check
		this.setVisible(true);
	}
	
	public List<Junction> getSelected() {
		int[] data =  _t.getSelectedRows();
		List<Junction> l = new ArrayList<Junction>();
		for (int i = 0; i < data.length; i++) {
			l.add(_map.getJunctions().get(data[i]));
		}
		
		return l;
		
	}
	

	@Override
	public void onRegistered(es.ucm.fdi.model.TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(es.ucm.fdi.model.TrafficSimulator trafficSimulator) {
		_map = null;
		_vehiclesModel.refresh();
	}

	@Override
	public void onAdvance(es.ucm.fdi.model.TrafficSimulator t, int time) {
		_map = (RoadMap) t.getRoadMap();
		_vehiclesModel.refresh();
		
	}

	@Override
	public void onAdvance(SimulatedObject o, int time) {
		
	}

	@Override
	public void onError(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewEvent(es.ucm.fdi.model.Event e, es.ucm.fdi.model.RoadMap _map, int _time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(TrafficSimulator t, List<Event> events) {
		// TODO Auto-generated method stub
		
	}

	
	
}
