package terrain;

import monstres.MonstreAdverse;
import tourelles.Tourelle;

public class Case {
	
	private static int hauteur = 25 ;
	private static int largeur = 25 ;
	
	public final static int BONUS_ATTACK_SPEED = 20 ;
	public final static int BONUS_PORTEE = 20 ;
	public final static double TX_RALENTISSEMENT_MOVE_SPEED = 0.4 ;
	
	private String typeCase ;
	private Tourelle saTourelle ;
	
	public Case(String typeCase){
		this.typeCase = typeCase ;
	}
	
	public String getTypeCase(){
		return typeCase ;
	}
	
	public boolean vide(){
		return (saTourelle == null) ;
	}
	
	public void placerTourelle(Tourelle t){
		saTourelle = t ;
		switch(typeCase){
			case "bonus portee" : saTourelle.augmenterPortee(BONUS_PORTEE) ; break ;
			case "bonus attack Speed" : saTourelle.augmenterAttackSpeed(BONUS_ATTACK_SPEED) ; break ;
		}
	}
	
	public boolean estNormale(){
		return typeCase.equals("aucun") ;
	}
	
	public void detruireTourelle(){
		saTourelle = null ;
	}
	
	public Tourelle getSaTourelle(){
		return saTourelle ;
	}
	
	public void faireAttaquerTourelle(MonstreAdverse m){
		saTourelle.attaquer(m);
	}
	
	public static int getHauteur(){
		return hauteur ;
	}
	
	public static int getLargeur(){
		return largeur ;
	}
	
	public static void setHauteur(int h){
		hauteur = h ;
	}
	
	public static void setLargeur(int l){
		largeur = l ;
	}
	
	
}
