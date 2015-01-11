package terrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import monstres.MonstreAdverse;
import tourelles.Tourelle;

public class Terrain extends HashMap<Position, Case>{
	
	private int nbCasesHauteur ;
	private int nbCasesLargeur ;
	private Case spawn ;
	private Case base ;
	
	public Terrain(int nbCasesHauteur, int nbCasesLargeur){
		this.nbCasesHauteur = nbCasesHauteur ;
		this.nbCasesLargeur = nbCasesLargeur ;
		for(int j = 0 ; j < nbCasesHauteur ; j++){
			for(int i = 0 ; i < nbCasesLargeur ; i++){
				int k = (int)(Math.random() * 20) ;
				switch(k){
					case 0 : this.addCase(new Position(i, j), new Case("sol_bonus_portee")) ; break ;
					case 1 : this.addCase(new Position(i, j), new Case("sol_bonus_as")) ; break ;
					case 2 : this.addCase(new Position(i, j), new Case("sol_slow")) ; break ;
					default : this.addCase(new Position(i, j), new Case("sol_normal")) ; break ;
				}
			}
		}
		spawn = new Case("spawn") ;
		base = new Case("base") ;
		this.remplacerCase(new Position(0, 0), spawn) ;
		this.remplacerCase(new Position(nbCasesLargeur-1, nbCasesHauteur-1), base) ;
	}
	
	private void remplacerCase(Position p, Case c){
		if(p.getX() > nbCasesLargeur*Case.getLargeur() || p.getX() < 0 || p.getY() > nbCasesHauteur*Case.getHauteur() || p.getY() < 0){
			// A FAIRE : lancer une EXCEPTION
		}
		this.put(p, c) ;
	}

	
	private void addCase(Position p, Case c){
		if(p.getX() > nbCasesLargeur*Case.getLargeur() || p.getX() < 0 || p.getY() > nbCasesHauteur*Case.getHauteur() || p.getY() < 0){
			// A FAIRE : lancer une EXCEPTION
		}
		
		if(this.containsKey(p)){
			// A FAIRE : lancer une EXCEPTION (la place est déjà occupée)
		}
		this.put(p, c) ;
	}

	
	public void placerTourelle(Tourelle t, Position p){
		this.get(p).placerTourelle(t);
	}
	
	
	public String getTypeCase(Position p){
		return this.get(p).getTypeCase() ; 
	}
	
	
	public void faireAttaquerTourelles(ArrayList<MonstreAdverse> monstresAdverses){
		Set<Position> cles = this.keySet();
		Iterator<Position> it = cles.iterator() ;
		while(it.hasNext()){
			Position p = it.next() ;
			Case c = this.get(p) ;
			if(!c.vide()){
				ArrayList<MonstreAdverse> monstresAportee = new ArrayList<MonstreAdverse>() ;
				
				int porteeHauteur = c.getSaTourelle().getPortee()*Case.getHauteur() ;
				int porteeLargeur = c.getSaTourelle().getPortee()*Case.getLargeur() ;
				for(int i = (p.getY()-porteeHauteur) ; i <= (p.getY()+porteeHauteur) ; i+=Case.getHauteur()){
					if(i>=0){
						for(int j = (p.getX()-porteeLargeur) ; j <= (p.getX()+porteeLargeur) ; j+=Case.getLargeur()){
							if(j>=0){
								for(int k = 0 ; k < monstresAdverses.size(); k ++){
									MonstreAdverse m = monstresAdverses.get(k) ;
									Position posCaseMonstre = new Position( m.getPos().getX()-(m.getPos().getX()%Case.getLargeur()) , m.getPos().getY()-(m.getPos().getY()%Case.getHauteur()) ) ; // position de la case sur laquel ce trouve le monstre actuel
									if(posCaseMonstre.equals(new Position(i, j))){
										monstresAportee.add(m) ;
									}
								}
							}
						}
					}
				}
				c.faireAttaquerTourelle(MonstreAdverse.lePlusFaible(monstresAportee)) ;
			}
		}
		
	}
	
}
