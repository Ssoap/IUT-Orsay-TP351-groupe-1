package monstres;

import java.util.ArrayList;

import terrain.Position;

public class Monstre {
	
	public final static int NB_TYPES_MONSTRE = 2 ;
	private static ArrayList<String> typesMonstre ;
	static{
		typesMonstre = new ArrayList<String>() ;
		typesMonstre.add("monstre_basique") ;
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
	
	public final static int COUT_ACHAT_MONSTRE_PUISSANT = 125 ;
	public final static int INCOME_MONSTRE_PUISSANT = 5 ;
	public final static int PV_INITIAUX_MONSTRE_PUISSANT = 250 ;
	public final static int DPS_MONSTRE_PUISSANT = 10 ;
	public final static int GAIN_DESTRUCTION_MONSTRE_PUISSANT = 25 ;
	
	private String type ;
	private int pv ;
	private int dps ;
	private int gainDestruction ;
	private Position pos ; // en pixels, sur le terrain
	private ArrayList<Position> chemin ;
	
	public Monstre(String type, Position p){
		this.type = type ;
		switch(type){
			case "monstre_basique" :
				this.pv = PV_INITIAUX_MONSTRE_BASIQUE ;
				this.dps = DPS_MONSTRE_BASIQUE ;
				this.gainDestruction = GAIN_DESTRUCTION_MONSTRE_BASIQUE ;
				break ;
			case "monstre_puissant" :
				this.pv = PV_INITIAUX_MONSTRE_PUISSANT ;
				this.dps = DPS_MONSTRE_PUISSANT ;
				this.gainDestruction = GAIN_DESTRUCTION_MONSTRE_PUISSANT ;
				break ;
		}
		this.pos = p ;
	}

	public static String getInfosMonstre(String type){
		switch(type){
		case "monstre_basique" :
			return COUT_ACHAT_MONSTRE_BASIQUE + ":"
				+ INCOME_MONSTRE_BASIQUE + ":"
				+ PV_INITIAUX_MONSTRE_BASIQUE + ":"
				+ DPS_MONSTRE_BASIQUE + ":" ;
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
			case "monstre_puissant" : return INCOME_MONSTRE_PUISSANT ;
			default : return 0 ;
		}
	}
	
	public void blesser(int degats){
		pv -= degats ;
	}
	
	public int getPv(){
		return pv ;
	}

	public String getType(){
		return type;
	}
	
	public Position getPos(){
		return pos ;
	}
	
	public int getGainDestruction(){
		return gainDestruction ;
	}

	/**
	 * Renvoie le monstre le plus faible (qui a le moins de pv)
	 * Si plusieurs monstres ont le même nombre de pv minimum, en renvoie un au hasard
	 * 
	 * @param monstres
	 * @return un MonstreAdverse
	 */
	public static Monstre lePlusFaible(ArrayList<Monstre> monstres){
		
		ArrayList<Monstre> lesPlusFaibles = new ArrayList<Monstre>() ;
		
		lesPlusFaibles.add(monstres.get(0)) ;
		
		for(int i = 1 ; i < monstres.size(); i++){
			if(monstres.get(i).getPv() <= lesPlusFaibles.get(0).getPv()){
				if(monstres.get(i).getPv() < lesPlusFaibles.get(0).getPv()){
					lesPlusFaibles.clear() ;
				}
				lesPlusFaibles.add(monstres.get(i)) ;
			}
		}
		
		return lesPlusFaibles.get((int)(Math.random() * lesPlusFaibles.size())) ;
	}
	
	public void definirChemin(ArrayList<Position> chemin){
		this.chemin = chemin ;
	}
	
	public void avancer(){
		this.pos = chemin.get(0) ;
		chemin.remove(0) ;
	}
	
}
