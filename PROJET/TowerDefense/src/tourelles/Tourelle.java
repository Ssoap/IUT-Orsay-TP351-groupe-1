package tourelles;

public class Tourelle {
	
	public final static int COUT_ACHAT_TOURELLE_BASIQUE = 100 ;
	public final static int COUT_AMERIORATION_TOURELLE_BASIQUE = 50 ;
	
	public final static int PORTEE_INITIALE_TOURELLE_BASIQUE = 100 ; // en pixels
	public final static int BONUS_PORTEE_AMELIORATION_TOURELLE_BASIQUE = 50 ; // en pixels
	public final static int DOMMAGES_INITIAUX_TOURELLE_BASIQUE = 10 ;
	public final static int BONUS_DOMMAGES_AMELIORATION_TOURELLE_BASIQUE = 5 ;
	public final static int ATTACK_SPEED_INITIALE_TOURELLE_BASIQUE = 2 ; // nombre de coups par seconde
	public final static int BONUS_ATTACK_SPEED_AMELIORATION_TOURELLE_BASIQUE = 1 ; // nombre de coups par seconde
	
	
	public final static int COUT_ACHAT_TOURELLE_PUISSANTE = 200 ;
	public final static int COUT_AMERIORATION_TOURELLE_PUISSANTE = 150 ;
	
	public final static int PORTEE_INITIALE_TOURELLE_PUISSANTE = 100 ; // en pixels
	public final static int BONUS_PORTEE_AMELIORATION_TOURELLE_PUISSANTE = 25 ; // en pixels
	public final static int DOMMAGES_INITIAUX_TOURELLE_PUISSANTE = 25 ;
	public final static int BONUS_DOMMAGES_AMELIORATION_TOURELLE_PUISSANTE = 25 ;
	public final static int ATTACK_SPEED_INITIALE_TOURELLE_PUISSANTE = 1 ; // nombre de coups par seconde
	public final static int BONUS_ATTACK_SPEED_AMELIORATION_TOURELLE_PUISSANTE = 1 ; // nombre de coups par seconde
	
	public final static int PV_INITIAUX = 100 ;
	
	private String type ;
	private int portee ; // en cases
	private int dommages ; // par coup
	private int attackSpeed ; // nombre de coups par seconde
	private int pv ;
	private boolean amelioree ;
	
	public Tourelle(String type){
		this.type = type ;
		this.pv = PV_INITIAUX ;
		amelioree = false ;
		switch(type){
			case "basique" :
				this.portee = PORTEE_INITIALE_TOURELLE_BASIQUE ;
				this.dommages = DOMMAGES_INITIAUX_TOURELLE_BASIQUE ;
				this.attackSpeed = DOMMAGES_INITIAUX_TOURELLE_BASIQUE ;
				break ;
			case "puissante" :
				this.portee = PORTEE_INITIALE_TOURELLE_PUISSANTE ;
				this.dommages = DOMMAGES_INITIAUX_TOURELLE_PUISSANTE ;
				this.attackSpeed = ATTACK_SPEED_INITIALE_TOURELLE_PUISSANTE ;
				break ;
		}
	}

	
	public void ameliorer(){
		switch(this.type){
			case "basique" :
				this.portee += BONUS_PORTEE_AMELIORATION_TOURELLE_BASIQUE ;
				this.dommages += BONUS_DOMMAGES_AMELIORATION_TOURELLE_BASIQUE ;
				this.attackSpeed += BONUS_ATTACK_SPEED_AMELIORATION_TOURELLE_BASIQUE ;
				break ;
			case "puissante" :
				this.portee += BONUS_PORTEE_AMELIORATION_TOURELLE_PUISSANTE ;
				this.dommages += BONUS_DOMMAGES_AMELIORATION_TOURELLE_PUISSANTE ;
				this.attackSpeed += BONUS_ATTACK_SPEED_AMELIORATION_TOURELLE_PUISSANTE ;
				break ;
		}
		this.amelioree = true ;
	}
	
}
