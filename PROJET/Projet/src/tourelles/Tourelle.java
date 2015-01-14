package tourelles;

import java.util.ArrayList;

import monstres.MonstreAdverse;

public class Tourelle {
	
	public final static int NB_TYPES_TOURELLE = 2 ;
	
	private static ArrayList<String> typesTourelle ;
	static{
		typesTourelle = new ArrayList<String>() ;
		typesTourelle.add("tourelle_basique") ;
		typesTourelle.add("tourelle_puissante") ;
	}
	public static String getTypeTourelle(int i){
		return typesTourelle.get(i) ;
	}
	
	public final static int COUT_ACHAT_TOURELLE_BASIQUE = 100 ;
	public final static int COUT_AMERIORATION_TOURELLE_BASIQUE = 50 ;
	
	public final static int PORTEE_INITIALE_TOURELLE_BASIQUE = 1 ; // en nombre de cases
	public final static int BONUS_PORTEE_AMELIORATION_TOURELLE_BASIQUE = 1 ; // en nombre de cases
	public final static int DOMMAGES_INITIAUX_TOURELLE_BASIQUE = 10 ;
	public final static int BONUS_DOMMAGES_AMELIORATION_TOURELLE_BASIQUE = 5 ;
	public final static int ATTACK_SPEED_INITIALE_TOURELLE_BASIQUE = 2 ; // nombre de coups par seconde
	public final static int BONUS_ATTACK_SPEED_AMELIORATION_TOURELLE_BASIQUE = 1 ; // nombre de coups par seconde
	
	
	public final static int COUT_ACHAT_TOURELLE_PUISSANTE = 200 ;
	public final static int COUT_AMERIORATION_TOURELLE_PUISSANTE = 150 ;
	
	public final static int PORTEE_INITIALE_TOURELLE_PUISSANTE = 2 ; // en nombre de cases
	public final static int BONUS_PORTEE_AMELIORATION_TOURELLE_PUISSANTE = 2 ; // en nombre de cases
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
			case "tourelle_basique" :
				this.portee = PORTEE_INITIALE_TOURELLE_BASIQUE ;
				this.dommages = DOMMAGES_INITIAUX_TOURELLE_BASIQUE ;
				this.attackSpeed = ATTACK_SPEED_INITIALE_TOURELLE_BASIQUE ;
				break ;
			case "tourelle_puissante" :
				this.portee = PORTEE_INITIALE_TOURELLE_PUISSANTE ;
				this.dommages = DOMMAGES_INITIAUX_TOURELLE_PUISSANTE ;
				this.attackSpeed = ATTACK_SPEED_INITIALE_TOURELLE_PUISSANTE ;
				break ;
		}
	}
	
	
	public static String getInfosTourelle(String type){
		switch(type){
		case "tourelle_basique" :
			return COUT_ACHAT_TOURELLE_BASIQUE + " (+" + COUT_AMERIORATION_TOURELLE_BASIQUE + "):"
				+ PORTEE_INITIALE_TOURELLE_BASIQUE + " (+" + BONUS_PORTEE_AMELIORATION_TOURELLE_BASIQUE + "):"
				+ DOMMAGES_INITIAUX_TOURELLE_BASIQUE + " (+" + BONUS_DOMMAGES_AMELIORATION_TOURELLE_BASIQUE + "):"
				+ ATTACK_SPEED_INITIALE_TOURELLE_BASIQUE + " (+" + BONUS_ATTACK_SPEED_AMELIORATION_TOURELLE_BASIQUE + "):" ;
		case "tourelle_puissante" :
			return COUT_ACHAT_TOURELLE_PUISSANTE + " (+" + COUT_AMERIORATION_TOURELLE_PUISSANTE + "):"
			+ PORTEE_INITIALE_TOURELLE_PUISSANTE + " (+" + BONUS_PORTEE_AMELIORATION_TOURELLE_PUISSANTE + "):"
			+ DOMMAGES_INITIAUX_TOURELLE_PUISSANTE + " (+" + BONUS_DOMMAGES_AMELIORATION_TOURELLE_PUISSANTE + "):"
			+ ATTACK_SPEED_INITIALE_TOURELLE_PUISSANTE + " (+" + BONUS_ATTACK_SPEED_AMELIORATION_TOURELLE_PUISSANTE + "):" ;
		}
		return "" ;
	}

	
	public void ameliorer(){
		switch(this.type){
			case "tourelle_basique" :
				this.portee += BONUS_PORTEE_AMELIORATION_TOURELLE_BASIQUE ;
				this.dommages += BONUS_DOMMAGES_AMELIORATION_TOURELLE_BASIQUE ;
				this.attackSpeed += BONUS_ATTACK_SPEED_AMELIORATION_TOURELLE_BASIQUE ;
				break ;
			case "tourelle_puissante" :
				this.portee += BONUS_PORTEE_AMELIORATION_TOURELLE_PUISSANTE ;
				this.dommages += BONUS_DOMMAGES_AMELIORATION_TOURELLE_PUISSANTE ;
				this.attackSpeed += BONUS_ATTACK_SPEED_AMELIORATION_TOURELLE_PUISSANTE ;
				break ;
		}
		this.amelioree = true ;
	}
	
	
	public int prix(){
		switch(type){
			case "tourelle_basique" : return COUT_ACHAT_TOURELLE_BASIQUE ;
			case "tourelle_puissante" : return COUT_ACHAT_TOURELLE_PUISSANTE ;
			default : return 0 ;
		}
	}	
	
	
	public void augmenterPortee(int n){
		this.portee += n ;
	}
	
	
	public void augmenterAttackSpeed(int n){
		this.attackSpeed += n ;
	}
	
	
	public void attaquer(MonstreAdverse m){
		m.blesser(dommages*attackSpeed) ;
	}
	
	
	public int getPortee(){
		return portee ;
	}
	
	public int getDommages(){
		return dommages ;
	}
	
	public int getAS(){
		return attackSpeed ;
	}
	
	
	public String getType(){
		return type ;
	}
	
}
