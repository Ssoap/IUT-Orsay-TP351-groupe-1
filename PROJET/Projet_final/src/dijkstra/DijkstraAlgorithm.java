package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import terrain.Position;

public class DijkstraAlgorithm {

	private final List<Position> nodes;
	private final List<Arc> arcs;
	private Set<Position> settledNodes;
	private Set<Position> unSettledNodes;
	private Map<Position, Position> predecesseurs;
	private Map<Position, Integer> distance;
	
	public DijkstraAlgorithm(Graphe graph) {
		// create a copy of the array so that we can operate on this array
		this.nodes = new ArrayList<Position>(graph.getSommets());
		this.arcs = new ArrayList<Arc>(graph.getArcs());
	}
	
	public void execute(Position source) {
		settledNodes = new HashSet<Position>();
		unSettledNodes = new HashSet<Position>();
		distance = new HashMap<Position, Integer>();
		predecesseurs = new HashMap<Position, Position>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Position node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}
	
	private void findMinimalDistances(Position node) {
		List<Position> adjacentNodes = getNeighbors(node);
		for (Position target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecesseurs.put(target, node);
				unSettledNodes.add(target);
			}
		}
	}
	
	private int getDistance(Position node, Position target) {
		for (Arc edge : arcs) {
			if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				return edge.getPoids();
			}
		}
		throw new RuntimeException("Should not happen");
	}
	
	private List<Position> getNeighbors(Position node) {
		List<Position> neighbors = new ArrayList<Position>();
		for (Arc edge : arcs) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}
	
	private Position getMinimum(Set<Position> vertexes) {
		Position minimum = null;
		for (Position vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			}
			else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}
	
	private boolean isSettled(Position vertex) {
		return settledNodes.contains(vertex);
	}
	
	private int getShortestDistance(Position destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} 
		else {
			return d;
		}
	}
	
	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public ArrayList<Position> getPath(Position target) {
		ArrayList<Position> path = new ArrayList<Position>();
		Position step = target;
		// check if a path exists
		if (predecesseurs.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecesseurs.get(step) != null) {
			step = predecesseurs.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path) ;
		return path;
	}

}
