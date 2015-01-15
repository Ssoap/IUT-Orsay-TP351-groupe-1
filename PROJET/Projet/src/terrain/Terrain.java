package terrain;

import java.util.HashMap;
import tourelles.Tourelle;

public class Terrain extends HashMap<Position, Case>{
	
	private int nbCasesHauteur ;
	private int nbCasesLargeur ;
	private Case base ;
	
	public Terrain(int nbCasesHauteur, int nbCasesLargeur){
		this.nbCasesHauteur = nbCasesHauteur ;
		this.nbCasesLargeur = nbCasesLargeur ;
		for(int j = 0 ; j < nbCasesHauteur ; j++){
			for(int i = 1 ; i < nbCasesLargeur ; i++){
				int k = (int)(Math.random() * 15) ;
				switch(k){
					case 0 : this.put(new Position(i, j), new Case("sol_bonus_portee")) ; break ;
					case 1 : this.put(new Position(i, j), new Case("sol_bonus_as")) ; break ;
					default : this.put(new Position(i, j), new Case("sol_normal")) ; break ;
				}
			}
		}
		for(int j = 0 ; j < nbCasesHauteur ; j++){
			this.put(new Position(0, j), new Case("spawn")) ;
		}
		base = new Case("base") ;
		this.put(new Position(nbCasesLargeur-1, nbCasesHauteur-1), base) ;
	}
	
	public Position getPosBase(){
		return new Position(nbCasesLargeur-1, nbCasesHauteur-1);
	}

	public Position randomSpawn(){
		int k = (int)(Math.random() * nbCasesHauteur) ;
		return new Position(0, k) ;
	}
	
	public int getNbcaselargeur(){
		return nbCasesLargeur;
	}
	
	public int getNbcasehauteur(){
		return nbCasesHauteur;
	}
	
	public void placerTourelle(Tourelle t, Position p){
		this.get(p).placerTourelle(t);
	}
	
	public String getTypeCase(Position p){
		return this.get(p).getTypeCase() ; 
	}

}
