package dijkstra;

import terrain.Position;

public class Arc  {
	
	private final String id;
	private final Position source;
	private final Position destination;
	private final int poids;
	  
	public Arc(String id, Position source, Position destination, int poids) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.poids = poids;
	}
	  
	public String getId() {
		return id;
	}
	
	public Position getDestination() {
		return destination;
	}
	
	public Position getSource() {
		return source;
	}
	
	public int getPoids() {
		return poids;
	}
	  
	@Override
	public String toString() {
		return source + " " + destination;
	}

}