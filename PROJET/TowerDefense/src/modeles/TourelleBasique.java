package modeles;

public class TourelleBasique extends Tourelle {
	
	public final static int COUT_ACHAT = 100 ;
	public final static int COUT_AMERIORATION = 50 ;
	public final static int PORTEE_INITIALE = 100 ; // en pixels
	public final static int BONUS_PORTEE_AMELIORATION = 50 ; // en pixels
	public final static int DOMMAGES_INITIAUX = 10 ;
	public final static int BONUS_DOMMAGES_AMELIORATION = 5 ;
	public final static int ATTACK_SPEED_INITIALE = 2 ; // nombre de coups par seconde
	public final static int BONUS_ATTACK_SPEED_AMELIORATION = 1 ; // nombre de coups par seconde
	
	public TourelleBasique(){
		super(PORTEE_INITIALE, DOMMAGES_INITIAUX, ATTACK_SPEED_INITIALE) ;
	}
	
	@Override
	public void ameliorer(){
		this.portee += BONUS_PORTEE_AMELIORATION ;
		this.dommages += BONUS_DOMMAGES_AMELIORATION ;
		this.attackSpeed += BONUS_ATTACK_SPEED_AMELIORATION ;
	}
	
}
