package monstres;

public class MonstreAllie extends Monstre {
	
	public final static int COUT_ACHAT_MONSTRE_BASIQUE = 50 ;
	public final static int INCOME_MONSTRE_BASIQUE = 3 ;
	public final static int PV_INITIAUX_MONSTRE_BASIQUE = 100 ;
	public final static int MOVE_SPEED_MONSTRE_BASIQUE = 5 ;
	public final static int DPS_MONSTRE_BASIQUE = 5 ;
	public final static int GAIN_DESTRUCTION_MONSTRE_BASIQUE = 10 ;
	
	public final static int COUT_ACHAT_MONSTRE_RAPIDE = 75 ;
	public final static int INCOME_MONSTRE_RAPIDE = 4 ;
	public final static int PV_INITIAUX_MONSTRE_RAPIDE = 75 ;
	public final static int MOVE_SPEED_MONSTRE_RAPIDE = 10 ;
	public final static int DPS_MONSTRE_RAPIDE = 3 ;
	public final static int GAIN_DESTRUCTION_MONSTRE_RAPIDE = 10 ;
	
	public final static int COUT_ACHAT_MONSTRE_PUISSANT = 125 ;
	public final static int INCOME_MONSTRE_PUISSANT = 5 ;
	public final static int PV_INITIAUX_MONSTRE_PUISSANT = 250 ;
	public final static int MOVE_SPEED_MONSTRE_PUISSANT = 3 ;
	public final static int DPS_MONSTRE_PUISSANT = 10 ;
	public final static int GAIN_DESTRUCTION_MONSTRE_PUISSANT = 25 ;
	
	
	public MonstreAllie(String type){
		super() ;
		switch(type){
			case "basique" :
				this.pv = PV_INITIAUX_MONSTRE_BASIQUE ;
				this.moveSpeed = MOVE_SPEED_MONSTRE_BASIQUE ;
				this.dps = DPS_MONSTRE_BASIQUE ;
				this.gainDestruction = GAIN_DESTRUCTION_MONSTRE_BASIQUE ;
				break ;
			case "rapide" :
				this.pv = PV_INITIAUX_MONSTRE_RAPIDE ;
				this.moveSpeed = MOVE_SPEED_MONSTRE_RAPIDE ;
				this.dps = DPS_MONSTRE_RAPIDE ;
				this.gainDestruction = GAIN_DESTRUCTION_MONSTRE_RAPIDE ;
				break ;
			case "puissant" :
				this.pv = PV_INITIAUX_MONSTRE_PUISSANT ;
				this.moveSpeed = MOVE_SPEED_MONSTRE_PUISSANT ;
				this.dps = DPS_MONSTRE_PUISSANT ;
				this.gainDestruction = GAIN_DESTRUCTION_MONSTRE_PUISSANT ;
				break ;
		}
	}
	
}
