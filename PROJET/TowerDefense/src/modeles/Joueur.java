package modeles;

import java.util.ArrayList;

public class Joueur extends Utilisateur {
	
	public final static int GOLD_INITIAL = 1000 ;
	public final static int INCOME_INITIAL = 5 ; // par seconde
	public final static int PV_INITIAUX = 100 ;

	private ArrayList<Monstre> sesMonstres ;
	private Terrain sonTerrain ;
	
	
	public Joueur(String pseudo, Terrain terrain){
		super(pseudo) ;
		this.sonTerrain = terrain ;
		this.gold = GOLD_INITIAL ;
		this.pvActuels = PV_INITIAUX ;
		sesMonstres = new ArrayList<Monstre>() ;
	}
	
	public Monstre getMonstre(int i){
		return sesMonstres.get(i) ;
	}
	
	public void addMonstre(Monstre m){
		sesMonstres.add(m) ;
	}
	
	public void removeMonstre(Monstre m){
		sesMonstres.remove(m) ;
	}
	
	public void blesser(int degats){
		if(this.pvActuels <= degats){
			// A FAIRE
			// l'adversaire gagne
		}
		else{
			this.pvActuels -= degats ;
		}
	}
	
	
	public Terrain getSonTerrain(){
		return this.sonTerrain ;
	}
	
}
