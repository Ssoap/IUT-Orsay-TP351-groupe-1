package modele;

import monstres.MonstreAdverse;
import terrain.Case;
import terrain.Position;
import terrain.Terrain;
import tourelles.Tourelle;
import utilisateurs.Adversaire;
import utilisateurs.Joueur;

import communicationReseau.Serveur;

public class Modele {
	
	public final static int HAUTEUR_TERRAIN = 15 ;
	public final static int LARGEUR_TERRAIN = 25 ;
	
	private Serveur serveur ;
	private Joueur joueur ;
	private Adversaire adversaire ;
	//private Timer timer ;
	
	public Modele(String pseudoJoueur){
		joueur = new Joueur(pseudoJoueur, new Terrain(HAUTEUR_TERRAIN, LARGEUR_TERRAIN)) ;
		//serveur = new Serveur(this) ;
		//String pseudoAdversaire = serveur.getPseudoAdversaire() ; ;
		adversaire = new Adversaire(""/*pseudoAdversaire*/) ;
		//adversaire.setPv(serveur.getPvAdversaire()) ;
		
		//timer = new Timer() ;
		//timer.schedule(new TimerTask(){ @Override public void run(){ tic() ; } } , 0, 1000);
	}
	
	// A faire a chaque tic du timer (chaque seconde)
	public void tic(){
		joueur.majGold() ;
		joueur.getTerrain().faireAttaquerTourelles(adversaire.getSesMonstres()) ;
		// faire avancer les monstres (rendre "fous" ceux qui ne peuvent pas avancer)
	}
	
	public void ameliorerTourelle(Position p){
		joueur.getTerrain().get(p).getSaTourelle().ameliorer() ;
	}
	
	public boolean caseVide(Position p){
		Case c = joueur.getTerrain().get(p) ;
		return c.vide() ;
	}
	
	public String getTypeTourelle(Position p){
		Case c = joueur.getTerrain().get(p) ;
		return c.getSaTourelle().getType() ;
	}
	
	public Tourelle getTourelle(Position p){
		return joueur.getTerrain().get(p).getSaTourelle() ;
	}
	
	public void ajouterMonstreAdverse(MonstreAdverse m){
		m.asservir(adversaire) ;
		adversaire.addMonstre(m) ;
	}
	
	public void acheterTourelle(String type, Position p){
		joueur.acheterTourelle(new Tourelle(type), p) ;
	}
	
	public int getGoldJoueur(){
		return joueur.getGold() ;
	}
	
	public String getPseudoJoueur(){
		return joueur.getPseudo() ;
	}
	
	public int getPvJoueur(){
		return joueur.getPv() ;
	}
	
	public int getPvAdversaire(){
		return 0 ;
	}
	
	public String getTypeCase(Position p){
		return joueur.getTerrain().getTypeCase(p) ;
	}
	
	public String tourelleAt(Position p){
		return joueur.getTerrain().get(p).getSaTourelle().getType() ;
	}
	
}
