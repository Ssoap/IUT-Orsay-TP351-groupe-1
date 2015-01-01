package terrain;

import tourelles.Tourelle;

public class Case {
	
	private TypeSol typeSol ;
	private Tourelle saTourelle ;
	
	public Case(TypeSol typeSol){
		this.typeSol = typeSol ;
	}
	
	public boolean estVide(){
		return (saTourelle == null) ;
	}
	
	public void placerTourelle(Tourelle t){
		saTourelle = t ;
	}
	
	public boolean estNormale(){
		return typeSol.getNomType().equals("normal") ;
	}
	
	public void detruireTourelle(){
		saTourelle = null ;
	}
	
	
}
