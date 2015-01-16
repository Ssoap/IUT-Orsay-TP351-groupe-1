package terrain;


public class Position {
	private int x ;
	private int y ;
	
	public Position(int x, int y){
		this.x = x ;
		this.y = y ;
	}
	
	public Position(){}
	
	public int getX(){
		return x ;
	}

	public int getY(){
		return y ;
	}
	
	public void setX(int x){
		this.x = x ;
	}
	
	public void setY(int y){
		this.y = y ;
	}

	@Override
	public boolean equals(Object o){
		if(this == o){
			return true ;
		}
		if(!(o instanceof Position)){
			return false ;
		}
		Position p = (Position) o ;
		return (this.x == p.getX() && this.y == p.getY()) ;
	}
	
	@Override
	public int hashCode(){
	    return (((7*17)+x)*17)+y ;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
