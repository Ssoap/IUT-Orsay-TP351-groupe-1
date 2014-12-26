package modeles;

public class MonstreRapide extends Monstre {
	

	public final static int COUT_ACHAT = 75 ;
	public final static int INCOME = 4 ; // par seconde
	public final static int GAIN_DESTRUCTION = 10 ;
	public final static int PV_INITIAUX = 75 ;
	public final static int MOVE_SPEED_INITIALE = 10 ; // en cases par seconde
	public final static int DPS_INITIAL = 3 ; // dégâts par secondes
	
	public MonstreRapide(Joueur sonMaitre){
		super(PV_INITIAUX, MOVE_SPEED_INITIALE, DPS_INITIAL, new Position(0, 0), sonMaitre) ;
	}
	
}