package dijkstra;

import java.util.List;

import terrain.Position;

public class Graphe {
	
	private final List<Position> sommets;
	private final List<Arc> arcs;

	public Graphe(List<Position> sommets, List<Arc> arcs) {
		this.sommets = sommets;
		this.arcs = arcs;
	}
	
	public List<Position> getSommets() {
		return sommets;
	}
	
	public List<Arc> getArcs() {
		return arcs;
	}
}