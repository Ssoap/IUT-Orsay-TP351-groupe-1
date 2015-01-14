package poubelle;

import terrain.Position;

public class Sommet {
	
	final private Position p;
	  
	public Sommet(Position p) {
		this.p = p;
	}
	  
	public Position getPos() {
		return p;
	}
	  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		return result;
	}
	  
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Sommet other = (Sommet) obj;
		if (p == null) {
			if (other.p != null)
			return false;
		} 
		else if (!p.equals(other.p)){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "(" + p.getX() + ", " + p.getY() + ")";
	}
  
} 