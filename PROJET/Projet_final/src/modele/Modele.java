package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import monstres.Monstre;
import terrain.Case;
import terrain.Position;
import terrain.Terrain;
import tourelles.Tourelle;
import utilisateurs.Adversaire;
import utilisateurs.Joueur;
import couple.Couple;
import dijkstra.Arc;
import dijkstra.DijkstraAlgorithm;
import dijkstra.Graphe;

public class Modele {
	
	public final static int HAUTEUR_TERRAIN = 15 ;
	public final static int LARGEUR_TERRAIN = 20 ;
	
	private Joueur joueur ;
	private Adversaire adversaire ;
	
	public Modele(){
		joueur = new Joueur(new Terrain(HAUTEUR_TERRAIN, LARGEUR_TERRAIN)) ;
		adversaire = new Adversaire() ;
	}
	
	public void majGold(){
		joueur.majGold();
	}
		
	public void faireAttaquerTourelles(){
		Terrain terrain = joueur.getTerrain() ;
		
		Set<Position> cles = terrain.keySet();
		Iterator<Position> it = cles.iterator() ;
		while(it.hasNext()){
			Position p = it.next() ;
			Case c = terrain.get(p) ;
			
			if(!c.vide()){
				 // On recupere la portee en pixels
				int porteeHauteur = c.getSaTourelle().getPortee()*Case.getHauteur() ;
				int porteeLargeur = c.getSaTourelle().getPortee()*Case.getLargeur() ;
				// On va stocker les monstres à portee
				ArrayList<Monstre> monstresAportee = new ArrayList<Monstre>() ;
				
				for(int i = (p.getY()*Case.getHauteur()-porteeHauteur) ; i <= (p.getY()*Case.getHauteur()+porteeHauteur) ; i+=Case.getHauteur()){
					if(i>=0){
						for(int j = (p.getX()*Case.getLargeur()-porteeLargeur) ; j <= (p.getX()*Case.getLargeur()+porteeLargeur) ; j+=Case.getLargeur()){
							if(j>=0){
								for(Monstre m : adversaire.getSesMonstres()){
									Position posCaseMonstre = new Position( m.getPos().getY()*Case.getHauteur() , m.getPos().getX()*Case.getLargeur()) ;
									if(posCaseMonstre.equals(new Position(i, j))){
										monstresAportee.add(m) ;
									}
								}
							}
						}
					}
				}
				if(monstresAportee.size() > 0){
					Monstre cible = Monstre.lePlusFaible(monstresAportee) ;
					c.getSaTourelle().attaquer(cible) ;
					if(cible.getPv() <= 0){
						joueur.augmenterGold(cible.getGainDestruction());
						adversaire.tuerMonstre(cible);
					}
				}
			}
		}
	}
	
	public Position randomSpawn(){
		return joueur.getTerrain().randomSpawn() ;
	}
	
	public ArrayList<Couple<Position, String>> faireAvancerMonstres() {
		ArrayList<Couple<Position, String>> newPositionsTypesMonstre = new ArrayList<Couple<Position, String>>() ;
		ArrayList<Monstre> ontAtteintLaBase = new ArrayList<Monstre>() ;
		for(Monstre m : adversaire.getSesMonstres()){
			m.avancer() ;
			if(m.getPos().equals(joueur.getTerrain().getPosBase())){
				ontAtteintLaBase.add(m);
				joueur.blesserBase();
				if(joueur.getPv() <= 0){
					break ;
				}
			}
			newPositionsTypesMonstre.add(new Couple<Position, String>(m.getPos(), m.getType())) ;
		}
		for(Monstre m : ontAtteintLaBase){
			adversaire.tuerMonstre(m);
		}
		return newPositionsTypesMonstre ;
	}

	public Case getCase(Position p){
		return joueur.getTerrain().get(p) ;
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
	
	public void ajouterMonstre(Monstre m){
		adversaire.addMonstre(m) ;
	}
	
	public boolean acheterTourelle(String type, Position p){
		return joueur.acheterTourelle(new Tourelle(type), p) ;
	}
	
	public int getGoldJoueur(){
		return joueur.getGold() ;
	}
	
	public int getPvJoueur(){
		return joueur.getPv() ;
	}

	public String getTypeCase(Position p){
		return joueur.getTerrain().getTypeCase(p) ;
	}
	
	public String tourelleAt(Position p){
		return joueur.getTerrain().get(p).getSaTourelle().getType() ;
	}
	
	public void definirCheminsMonstres(){
		for(Monstre m : adversaire.getSesMonstres()){
			Graphe graphe = terrainToGraphe() ;
			DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graphe);
			dijkstra.execute(m.getPos()) ;
			ArrayList<Position> chemin = dijkstra.getPath(joueur.getTerrain().getPosBase()) ;
			chemin.remove(0);
			m.definirChemin(chemin) ;
		}
	}
	
	public boolean tousMonstresMorts(){
		return adversaire.getSesMonstres().isEmpty() ;
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
