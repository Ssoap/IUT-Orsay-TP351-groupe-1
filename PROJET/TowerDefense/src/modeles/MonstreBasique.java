package modeles;

public class MonstreBasique extends Monstre {
	

	public final static int COUT_ACHAT = 50 ;
	public final static int INCOME = 3 ; // par seconde
	public final static int GAIN_DESTRUCTION = 10 ;
	public final static int PV_INITIAUX = 100 ;
	public final static int MOVE_SPEED_INITIALE = 5 ;// en cases par seconde
	public final static int DPS_INITIAL = 5 ; // dégâts par secondes
	
	public MonstreBasique(Joueur sonMaitre){
		super(PV_INITIAUX, MOVE_SPEED_INITIALE, DPS_INITIAL, new Position(0, 0), sonMaitre) ;
	}
	
}
