package utilisateurs;

import java.util.ArrayList;

import monstres.MonstreAdverse;
import monstres.MonstreAllie;
import terrain.Position;
import terrain.Terrain;
import tourelles.Tourelle;

public class Joueur extends Utilisateur {
	
	public final static int GOLD_INITIAL = 1000 ;
	public final static int INCOME_INITIAL = 5 ; // par seconde
	public final static int PV_INITIAUX = 100 ;

	private int gold ;
	private Terrain terrain ;
	private ArrayList<MonstreAllie> sesMonstres ;
	
	public Joueur(String pseudo, Terrain terrain){
		super(pseudo) ;
		this.terrain = terrain ;
		this.gold = GOLD_INITIAL ;
		this.pv = PV_INITIAUX ;
		sesMonstres = new ArrayList<MonstreAllie>() ;
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
		gold += gold + INCOME_INITIAL ;
		for(MonstreAllie m : sesMonstres){
			gold += m.getIncome() ;
		}
	}
	
	public Terrain getTerrain(){
		return terrain ;
	}
	
	public void acheterTourelle(Tourelle t, Position p){
		this.terrain.placerTourelle(t, p) ;
		this.gold -= t.prix() ;
	}
	
}
