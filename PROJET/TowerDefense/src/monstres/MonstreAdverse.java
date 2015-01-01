package monstres;

import terrain.Position;

public class MonstreAdverse extends Monstre {

	private Position pos ;
	
	public MonstreAdverse(int pv, int moveSpeed, int dps, int gainDestruction, Position pos){
		super() ;
		this.pv = pv ;
		this.moveSpeed = moveSpeed ;
		this.dps = dps ;
		this.gainDestruction = gainDestruction ;
		this.pos = pos ;
	}

}
