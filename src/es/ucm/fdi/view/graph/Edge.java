package es.ucm.fdi.view.graph;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.extra.graphlayout.Node;

public class Edge {
	private String _id;
	private Node _source;
	private Node _target;
	private int _length;
	private List<Dot> _dots;
	private boolean _color;
	
	public Edge(String id, Node source, Node target, int length, boolean color) {
		_source = source;
		_target = target;
		_id = id;
		_length = length;
		_dots = new ArrayList<>();
		_color = color;
	}
	
	public void addDot(Dot e) {
		_dots.add(e);
	}
	public String getId() {
		return _id;
	}
	
	public boolean getColor() {
		return _color;
	}
	
	public Node getSource() {
		return _source;
	}
	
	public Node getTarget() {
		return _target;
	}

	public int getLength() {
		return _length;
	}
	
	public List<Dot> getDots() {
		return _dots;
	}
}
