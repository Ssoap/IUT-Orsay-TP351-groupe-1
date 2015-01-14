package monstres;

import java.util.ArrayList;

public class MonstreAllie extends Monstre {
	
	public final static int NB_TYPES_MONSTRE = 3 ;
	
	private static ArrayList<String> typesMonstre ;
	static{
		typesMonstre = new ArrayList<String>() ;
		typesMonstre.add("monstre_basique") ;
		typesMonstre.add("monstre_rapide") ;
		typesMonstre.add("monstre_puissant") ;
	}
	public static String getTypeMonstre(int i){
		return typesMonstre.get(i) ;
	}
	
	public final static int COUT_ACHAT_MONSTRE_BASIQUE = 50 ;
	public final static int INCOME_MONSTRE_BASIQUE = 3 ;
	public final static int PV_INITIAUX_MONSTRE_BASIQUE = 100 ;
	public final static int DPS_MONSTRE_BASIQUE = 5 ;
	public final static int GAIN_DESTRUCTION_MONSTRE_BASIQUE = 10 ;
	
	public final static int COUT_ACHAT_MONSTRE_RAPIDE = 75 ;
	public final static int INCOME_MONSTRE_RAPIDE = 4 ;
	public final static int PV_INITIAUX_MONSTRE_RAPIDE = 75 ;
	public final static int DPS_MONSTRE_RAPIDE = 3 ;
	public final static int GAIN_DESTRUCTION_MONSTRE_RAPIDE = 10 ;
	
	public final static int COUT_ACHAT_MONSTRE_PUISSANT = 125 ;
	public final static int INCOME_MONSTRE_PUISSANT = 5 ;
	public final static int PV_INITIAUX_MONSTRE_PUISSANT = 250 ;
	public final static int DPS_MONSTRE_PUISSANT = 10 ;
	public final static int GAIN_DESTRUCTION_MONSTRE_PUISSANT = 25 ;
	
	private String type ;
	
	public MonstreAllie(String type){
		super() ;
		this.type = type ;
		switch(type){
			case "monstre_basique" :
				this.pv = PV_INITIAUX_MONSTRE_BASIQUE ;
				this.dps = DPS_MONSTRE_BASIQUE ;
				this.gainDestruction = GAIN_DESTRUCTION_MONSTRE_BASIQUE ;
				break ;
			case "monstre_rapide" :
				this.pv = PV_INITIAUX_MONSTRE_RAPIDE ;
				this.dps = DPS_MONSTRE_RAPIDE ;
				this.gainDestruction = GAIN_DESTRUCTION_MONSTRE_RAPIDE ;
				break ;
			case "monstre_puissant" :
				this.pv = PV_INITIAUX_MONSTRE_PUISSANT ;
				this.dps = DPS_MONSTRE_PUISSANT ;
				this.gainDestruction = GAIN_DESTRUCTION_MONSTRE_PUISSANT ;
				break ;
		}
	}

	public static String getInfosMonstre(String type){
		switch(type){
		case "monstre_basique" :
			return COUT_ACHAT_MONSTRE_BASIQUE + ":"
				+ INCOME_MONSTRE_BASIQUE + ":"
				+ PV_INITIAUX_MONSTRE_BASIQUE + ":"
				+ DPS_MONSTRE_BASIQUE + ":" ;
		case "monstre_rapide" :
			return COUT_ACHAT_MONSTRE_RAPIDE + ":"
				+ INCOME_MONSTRE_RAPIDE + ":"
				+ PV_INITIAUX_MONSTRE_RAPIDE + ":"
				+ DPS_MONSTRE_RAPIDE + ":" ;
		case "monstre_puissant" :
			return COUT_ACHAT_MONSTRE_PUISSANT + ":"
				+ INCOME_MONSTRE_PUISSANT + ":"
				+ PV_INITIAUX_MONSTRE_PUISSANT + ":"
				+ DPS_MONSTRE_PUISSANT + ":" ;
		}
		return "" ;
	}
	
	public int getIncome(){
		switch(this.type){
			case "monstre_basique" : return INCOME_MONSTRE_BASIQUE ;
			case "monstre_rapide" : return INCOME_MONSTRE_RAPIDE ;
			case "monstre_puissant" : return INCOME_MONSTRE_PUISSANT ;
			default : return 0 ;
		}
	}
	
}
