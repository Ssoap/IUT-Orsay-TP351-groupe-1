package utilisateurs;

import terrain.Position;
import terrain.Terrain;
import tourelles.Tourelle;

public class Joueur extends Utilisateur {
	
	public final static int GOLD_INITIAL = 1000 ;
	public final static int INCOME_INITIAL = 5 ; // par seconde
	public final static int PV_INITIAUX = 100 ;

	private int gold ;
	private Terrain terrain ;
	
	public Joueur(String pseudo, Terrain terrain){
		super(pseudo) ;
		this.terrain = terrain ;
		this.gold = GOLD_INITIAL ;
		this.pv = PV_INITIAUX ;
	}
	
	
	public int getGold(){
		return gold ;
	}
	
	public int getPv(){
		return pv ;
	}
	
	public String getPseudo(){
		return pseudo ;
	}

	
	public void majGold() {
		gold += INCOME_INITIAL ;
	}
	
	public Terrain getTerrain(){
		return terrain ;
	}
	
	public void augmenterGold(int valeur){
		gold += valeur ;
	}
	
	public boolean reduireGold(int valeur){
		if(gold >= valeur){
			gold -= valeur;
			return true ;
		}
		else{
			return false ;
		}
	}
	
	public boolean acheterTourelle(Tourelle t, Position p){
		if(this.gold >= t.prix()){
			this.terrain.placerTourelle(t, p) ;
			this.gold -= t.prix() ;
			return true ;
		}
		else{
			return false ;
		}
		
	}
	
}
