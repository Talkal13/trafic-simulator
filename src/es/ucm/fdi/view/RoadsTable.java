package es.ucm.fdi.view;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class RoadsTable extends JPanel implements TrafficSimulatorObserver{
	
	public static Border defaultBorder = BorderFactory.createLineBorder(Color.black, 2);

	class VehiclesTableModel extends AbstractTableModel{

		private final String[] header = {"ID", "Source", "Target", "Lenght", "Max Speed", "Vehicles"};
		
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
			return _map.getRoads().size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0:	return _map.getRoads().get(rowIndex).getId();
				case 1:	return _map.getRoads().get(rowIndex).getSource();
				case 2:	return  _map.getRoads().get(rowIndex).getDestination();
				case 3: return _map.getRoads().get(rowIndex).getLenght();
				case 4: return _map.getRoads().get(rowIndex).getMaxSpeed();
				case 5: return _map.getRoads().get(rowIndex).getVehicles();
				default: return null;
			}
		}
		
		void refresh() {
			fireTableDataChanged();
		}
		
	}
	
	
	private RoadMap _map;
	private VehiclesTableModel _vehiclesModel;

	RoadsTable(){
		_map = null;
		initGUI();
		
	}
	
	private void initGUI() {
		this.setBorder(new TitledBorder(defaultBorder, "Roads"));
		this.setLayout(new BorderLayout());
		_vehiclesModel = new VehiclesTableModel();
		
		JTable t = new JTable(_vehiclesModel);
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
