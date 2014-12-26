package modeles;

public class Jeu {
	
	private Joueur joueur ;
	private Adversaire adversaire ;
	
	public Jeu(String monPseudo, String pseudoAdversaire){
		Terrain t = new Terrain() ;
		ChampsDeBataille champsDeBataille = new ChampsDeBataille() ;
		
		for(int i = 0 ; i < ChampsDeBataille.HAUTEUR ; i++){
			for(int j = 0 ; j < ChampsDeBataille.LARGEUR ; j++){
				int k = (int)(Math.random() * 4) ;
				switch(k){
					case 0 : champsDeBataille.addCase(new Position(i, j), new Case<SolBonusPortee>(new SolBonusPortee())) ; break ;
					case 1 : champsDeBataille.addCase(new Position(i, j), new Case<SolBonusAttackSpeed>(new SolBonusAttackSpeed())) ; break ;
					default : champsDeBataille.addCase(new Position(i, j), new Case()) ; break ;
				}
			}
		}
		
		t.definirChampsDeBataille(champsDeBataille);
		joueur = new Joueur(monPseudo, t) ;
		t.definirJoueur(joueur) ;
		adversaire = new Adversaire(pseudoAdversaire) ;
	}
	
	public void creerMonstreBasique(){
		joueur.addMonstre(new MonstreBasique(joueur)) ;
	}

	
	public void creerMonstreRapide(){
		joueur.addMonstre(new MonstreRapide(joueur)) ;
	}

	
	public void creerMonstreResistant(){
		joueur.addMonstre(new MonstreResistant(joueur)) ;
	}
	
	
	public void creerTourelleBasique(Case c){
		TourelleBasique t = new TourelleBasique() ;
		c.placerTourelle(t) ;
		t.placer(c) ;
	}
	
	
	public void creerTourellePuissante(Case c){
		TourellePuissante t = new TourellePuissante() ;
		c.placerTourelle(t) ;
		t.placer(c) ;
	}
	
	
	public void ameliorerTourelle(Tourelle t){
		t.ameliorer() ; 
	}
	
	
	public void detruireTourelle(Tourelle t){
		t.detruire();
	}
	
	
	public void tuerMonstre(Monstre m){
		m.tuer() ;
	}
	
	
	public static void main(String[] args){
		Jeu jeu = new Jeu("Ssoap", "pseudo adversaire") ;
		// Creer la vue ?
	}
	
}
