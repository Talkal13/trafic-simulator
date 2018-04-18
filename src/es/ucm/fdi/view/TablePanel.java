package es.ucm.fdi.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import es.ucm.fdi.observer.TableModel;

public class TablePanel<T> extends JPanel{
	private TableModel<T> model;
	
	public TablePanel(String bordeId, TableModel<T> modelo){
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createTitledBorder(bordeId));
		this.model = modelo;
		JTable tabla = new JTable(this.model);
		JScrollPane scroll = new JScrollPane(tabla);
		
		scroll.getViewport().setBackground(Color.WHITE);
		this.add(scroll);
	}
	
}
