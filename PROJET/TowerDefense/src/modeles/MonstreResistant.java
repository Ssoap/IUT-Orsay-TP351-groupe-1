package modeles;

public class MonstreResistant extends Monstre {
	

	public final static int COUT_ACHAT = 125 ;
	public final static int INCOME = 5 ; // par seconde
	public final static int GAIN_DESTRUCTION = 25 ;
	public final static int PV_INITIAUX = 250 ;
	public final static int MOVE_SPEED_INITIALE = 3 ; // en cases par seconde
	public final static int DPS_INITIAL = 10 ; // dégâts par secondes
	
	public MonstreResistant(Joueur sonMaitre){
		super(PV_INITIAUX, MOVE_SPEED_INITIALE, DPS_INITIAL, new Position(0, 0), sonMaitre) ;
	}
	
}