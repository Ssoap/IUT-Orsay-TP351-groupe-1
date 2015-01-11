package monstres;

import java.util.ArrayList;

import terrain.Position;
import utilisateurs.Adversaire;

public class MonstreAdverse extends Monstre {

	private Adversaire maitre ;
	private Position pos ; // en pixels, sur le terrain
	
	
	public MonstreAdverse(int pv, int moveSpeed, int dps, int gainDestruction, Position pos){
		super() ;
		this.pv = pv ;
		this.moveSpeed = moveSpeed ;
		this.dps = dps ;
		this.gainDestruction = gainDestruction ;
		this.pos = pos ;
	}

	
	public void blesser(int degats){
		pv -= degats ;
		if(pv<=0){
			maitre.tuerMonstre(this) ;
		}
	}

	
	public void asservir(Adversaire maitre){
		this.maitre = maitre ;
	}
	
	
	public int getPv(){
		return pv ;
	}

	
	public Position getPos(){
		return pos ;
	}
	
	
	/**
	 * Renvoie le monstre le plus faible (qui a le moins de pv)
	 * Si plusieurs monstres ont le même nombre de pv minimum, en renvoie un au hasard
	 * 
	 * @param monstres
	 * @return un MonstreAdverse
	 */
	public static MonstreAdverse lePlusFaible(ArrayList<MonstreAdverse> monstres){
		
		ArrayList<MonstreAdverse> lesPlusFaibles = new ArrayList<MonstreAdverse>() ;
		
		lesPlusFaibles.add(monstres.get(0)) ;
		
		for(int i = 1 ; i < monstres.size(); i++){
			if(monstres.get(i).getPv() <= lesPlusFaibles.get(0).getPv()){
				if(monstres.get(i).getPv() < lesPlusFaibles.get(0).getPv()){
					lesPlusFaibles.clear() ;
				}
				lesPlusFaibles.add(monstres.get(i)) ;
			}
		}
		
		return lesPlusFaibles.get((int)(Math.random() * lesPlusFaibles.size())) ;
	}
	
}
