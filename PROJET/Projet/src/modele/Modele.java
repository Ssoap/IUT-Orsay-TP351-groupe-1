package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import monstres.MonstreAdverse;
import terrain.Case;
import terrain.Position;
import terrain.Terrain;
import tourelles.Tourelle;
import utilisateurs.Adversaire;
import utilisateurs.Joueur;
import communicationReseau.Serveur;
import couple.Couple;
import dijkstra.Arc;
import dijkstra.DijkstraAlgorithm;
import dijkstra.Graphe;

public class Modele {
	
	public final static int HAUTEUR_TERRAIN = 15 ;
	public final static int LARGEUR_TERRAIN = 20 ;
	
	private Serveur serveur ;
	private Joueur joueur ;
	private Adversaire adversaire ;
	
	public Modele(String pseudoJoueur){
		joueur = new Joueur(pseudoJoueur, new Terrain(HAUTEUR_TERRAIN, LARGEUR_TERRAIN)) ;
		//serveur = new Serveur(this) ;
		//String pseudoAdversaire = serveur.getPseudoAdversaire() ; ;
		adversaire = new Adversaire(""/*pseudoAdversaire*/) ;
		//adversaire.setPv(serveur.getPvAdversaire()) ;
	}
	
	public void majGold(){
		joueur.majGold();
	}
		
	public void faireAttaquerTourelles(){
		joueur.getTerrain().faireAttaquerTourelles(adversaire.getSesMonstres()) ;
	}
	
	public ArrayList<Couple<Position, Position>> faireAvancerMonstres() {
		ArrayList<Couple<Position, Position>> OldAndNewPositions = new ArrayList<Couple<Position, Position>>() ;
		for(MonstreAdverse m : adversaire.getSesMonstres()){
			Couple<Position, Position> c = new Couple<Position, Position>() ;
			c.setT1(m.getPos()) ;
			m.avancer() ;
			c.setT2(m.getPos());
			OldAndNewPositions.add(c) ;
		}
		return OldAndNewPositions ;
	}
	
	public Position getPosSpawn(){
		return joueur.getTerrain().getPosSpawn() ;
	}

	public Position getPosBase(){
		return joueur.getTerrain().getPosBase() ;
	}
	
	public boolean ameliorerTourelle(Position p){
		if(joueur.reduireGold(joueur.getTerrain().get(p).getSaTourelle().prix())){
			joueur.getTerrain().get(p).getSaTourelle().ameliorer() ;
			return true ;
		}
		else{
			return false ;
		}
	}
	
	public boolean caseVide(Position p){
		Case c = joueur.getTerrain().get(p) ;
		return c.vide() ;
	}
	
	public String getTypeTourelle(Position p){
		Case c = joueur.getTerrain().get(p) ;
		return c.getSaTourelle().getType() ;
	}
	
	public boolean niSpawnNiBaseNiMorte(Position p){
		return !(joueur.getTerrain().get(p).getTypeCase().equals("spawn") || joueur.getTerrain().get(p).getTypeCase().equals("base") || joueur.getTerrain().get(p).getTypeCase().equals("morte"));
	}
	
	public Tourelle getTourelle(Position p){
		return joueur.getTerrain().get(p).getSaTourelle() ;
	}
	
	public void ajouterMonstreAdverse(MonstreAdverse m){
		m.asservir(adversaire) ;
		adversaire.addMonstre(m) ;
	}
	
	public boolean acheterTourelle(String type, Position p){
		return joueur.acheterTourelle(new Tourelle(type), p) ;
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
	
	public void definirCheminMonstres(){
		for(MonstreAdverse m : adversaire.getSesMonstres()){
			Graphe graphe = terrainToGraphe() ;
			DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graphe);
			dijkstra.execute(m.getPos()) ;
			ArrayList<Position> chemin = dijkstra.getPath(joueur.getTerrain().getPosBase()) ;
			chemin.remove(0);
			m.definirChemin(chemin) ;
		}
	}
	
	private Graphe terrainToGraphe(){
		Terrain t = joueur.getTerrain();
		
		ArrayList<Position> sommets = new ArrayList<Position>();
		ArrayList<Arc> arcs = new ArrayList<Arc>();
		
		Set<Position> cles = t.keySet();
		Iterator<Position> it = cles.iterator() ;
		while(it.hasNext()){
			Position p = it.next() ;
			sommets.add(p) ;
		}
		
		it = cles.iterator() ;
		while(it.hasNext()){
			Position p = it.next();
			
			if(p.getX() > 0){
				Position posGauche = new Position(p.getX()-1, p.getY()) ;
				if(t.get(posGauche).vide()){
					arcs.add(new Arc("arc", p, posGauche, 1));
				}
			}
			
			if(p.getY() > 0){
				Position posHaut = new Position(p.getX(), p.getY()-1) ;
				if(t.get(posHaut).vide()){
					arcs.add(new Arc("arc", p, posHaut, 1));
				}
			}
			
			if(p.getY() < HAUTEUR_TERRAIN-1){
				Position posBas = new Position(p.getX(), p.getY()+1) ;
				if(t.get(posBas).vide()){
					arcs.add(new Arc("arc", p, posBas, 1));
				}
			}
			
			if(p.getX() < LARGEUR_TERRAIN-1){
				Position posDroite = new Position(p.getX()+1, p.getY()) ;
				if(t.get(posDroite).vide()){
					arcs.add(new Arc("arc", p, posDroite, 1));
				}
			}
		}
		
		return new Graphe(sommets, arcs) ;
	}
	
}
