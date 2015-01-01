package utilisateurs;

import terrain.Terrain;

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

	@Override
	public void miseAjourGold() {
		// A FAIRE
	}
	
}
