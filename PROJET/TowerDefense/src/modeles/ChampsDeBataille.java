package modeles;

import java.util.HashMap;

public class ChampsDeBataille {
	
	HashMap<Integer, HashMap<Integer, Case>> matrice ;
	public final static int HAUTEUR = 15 ; // en nombre de cases
	public final static int LARGEUR = 25 ; // en nombre de cases
	
	public ChampsDeBataille(){
		matrice = new HashMap<Integer, HashMap<Integer, Case>>() ;
	}
	
	public void addCase(Position p, Case c){
		
		if(p.getX() > LARGEUR || p.getX() < 0 || p.getY() > HAUTEUR || p.getY() < 0){
			// A FAIRE : lancer une EXCEPTION
		}
		
		if(matrice.containsKey(p.getY())){
			if(matrice.get(p.getY()).containsKey(p.getX())){
				// A FAIRE : lancer une EXCEPTION (la place est déjà occupée)
			}
			matrice.get(p.getY()).put(p.getX(), c) ;
		}
		else{
			HashMap<Integer, Case> hash = new HashMap<Integer, Case>() ;
			hash.put(p.getX(), c) ;
			matrice.put(p.getY(), hash) ;
		}
	}
	
}
