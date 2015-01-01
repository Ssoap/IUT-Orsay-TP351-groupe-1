package terrain;

import java.util.HashMap;

public class Terrain {

	HashMap<Integer, HashMap<Integer, Case>> champsDeBataille ;
	public final static int HAUTEUR = 15 ; // en nombre de cases
	public final static int LARGEUR = 25 ; // en nombre de cases
	public Case spawn ;
	public Case base ;
	
	public Terrain(){
		champsDeBataille = new HashMap<Integer, HashMap<Integer, Case>>() ;
		for(int i = 0 ; i < HAUTEUR ; i++){
			for(int j = 0 ; j < LARGEUR ; j++){
				int k = (int)(Math.random() * 4) ;
				switch(k){
					case 0 : this.addCase(new Position(i, j), new Case(new SolBonusPortee())) ; break ;
					case 1 : this.addCase(new Position(i, j), new Case(new SolBonusAttackSpeed())) ; break ;
					default : this.addCase(new Position(i, j), new Case(new SolNormal())) ; break ;
				}
			}
		}
		spawn = new Case(new SolNormal()) ;
		base = new Case(new SolNormal()) ;
		this.remplacerCase(new Position(0, 0), spawn) ;
		this.remplacerCase(new Position(14, 24), base) ;
	}
	
	private void remplacerCase(Position p, Case c){
		champsDeBataille.get(p.getY()).put(p.getX(), c) ;
	}

	private void addCase(Position p, Case c){
		
		if(p.getX() > LARGEUR || p.getX() < 0 || p.getY() > HAUTEUR || p.getY() < 0){
			// A FAIRE : lancer une EXCEPTION
		}
		
		if(champsDeBataille.containsKey(p.getY())){
			if(champsDeBataille.get(p.getY()).containsKey(p.getX())){
				// A FAIRE : lancer une EXCEPTION (la place est déjà occupée)
			}
			champsDeBataille.get(p.getY()).put(p.getX(), c) ;
		}
		else{
			HashMap<Integer, Case> hash = new HashMap<Integer, Case>() ;
			hash.put(p.getX(), c) ;
			champsDeBataille.put(p.getY(), hash) ;
		}
	}

}
