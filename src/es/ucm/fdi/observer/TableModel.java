package es.ucm.fdi.observer;

import javax.swing.table.DefaultTableModel;

import es.ucm.fdi.model.TrafficSimulatorObserver;

public abstract  class TableModel<T> extends DefaultTableModel implements TrafficSimulatorObserver {
	
}
