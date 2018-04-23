package es.ucm.fdi.view;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.model.Event;
import es.ucm.fdi.model.Junction;
import es.ucm.fdi.model.NewJunctionEvent;
import es.ucm.fdi.model.Road;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatedObject;
import es.ucm.fdi.model.TrafficSimulator;
import es.ucm.fdi.model.TrafficSimulatorObserver;
import es.ucm.fdi.view.graph.Graph;

public class GraphRoadMap extends Graph implements TrafficSimulatorObserver {
	private List<Road> _roads;
	private List<Junction> _junctions;
	
	public GraphRoadMap() {
		_roads = new ArrayList<>();
		_junctions = new ArrayList<>();
	}
	
	public void addRoad(Road e) {
		_roads.add(e);
	}
	
	public void addJunction(Junction n) {
		_junctions.add(n);
	}
	
	public List<Road> getRoads() {
		return _roads;
	}
	
	public List<Junction> getJunction() {
		return _junctions;
	}

	@Override
	public void onRegistered(TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(TrafficSimulator trafficSimulator) {
		// TODO Auto-generated method stub
		
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
		if (e.getClass().equals(NewJunctionEvent.class)) {
			_map.getJunction(((NewJunctionEvent) e).getId());
		}
	}
}
