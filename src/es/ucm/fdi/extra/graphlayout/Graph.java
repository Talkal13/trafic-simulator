package es.ucm.fdi.extra.graphlayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.Junction;
import es.ucm.fdi.model.NewJunctionEvent;
import es.ucm.fdi.model.NewRoadEvent;
import es.ucm.fdi.model.Road;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;
import es.ucm.fdi.model.Vehicle;

public class Graph implements TrafficSimulatorObserver {
	private List<Edge> _edges;
	private List<Node> _nodes;
	private HashMap<String, Node> _map_node;
	private HashMap<String, Edge> _map_edge;
	
	public Graph() {
		_edges = new ArrayList<>();
		_nodes = new ArrayList<>();
		_map_node = new HashMap<String, Node>();
		_map_edge = new HashMap<String, Edge>();
	}
	
	public void addEdge(Edge e) {
		_edges.add(e);
		_map_edge.put(e.getId(), e);
	}
	
	public void addNode(Node n) {
		_nodes.add(n);
		_map_node.put(n.getId(), n);
	}
	
	public List<Edge> getEdges() {
		return _edges;
	}
	
	public List<Node> getNodes() {
		return _nodes;
	}

	@Override
	public void onRegistered(TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(TrafficSimulator trafficSimulator) {
		
		_nodes.clear();
		_edges.clear();
		_map_node.clear();
		_map_edge.clear();
		
	}

	@Override
	public void onAdvance(TrafficSimulator t, int time) {
		_nodes.clear();
		_edges.clear();
		_map_node.clear();
		_map_edge.clear();
		for (Junction j : t.getRoadMap().getJunctions()) {
			addNode(new Node(j.getId()));
		}
		
		for (Road r : t.getRoadMap().getRoads()) {
			addEdge(new Edge(r.getId(), _map_node.get(r.getSource().getId()), _map_node.get(r.getDestination().getId()), r.getLenght()));
		}
		
		for (Vehicle v : t.getRoadMap().getVehicles()) {
			_map_edge.get(v.getRoad().getId()).addDot(new Dot(v.getId(), v.getLocation()));
		}
		
	}

	@Override
	public void onAdvance(SimulatedObject o, int time) {
		
	}

	@Override
	public void onError(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewEvent(Event e, RoadMap _map, int _time) {
	}
}
