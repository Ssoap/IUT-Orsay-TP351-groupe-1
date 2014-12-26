package modeles;

public class Case<TypeSol> {
	
	private TypeSol sonTypeSol ;
	private Tourelle saTourelle ;
	
	public Case(TypeSol typeSol){
		sonTypeSol = typeSol ;
	}
	
	public Case(){}
	
	public boolean estVide(){
		return (saTourelle != null) ;
	}
	
	public void placerTourelle(Tourelle t){
		saTourelle = t ;
	}
	
	public boolean estNormale(){
		return sonTypeSol == null ;
	}
	
	
	public TypeSol getSonTypeSol(){
		return sonTypeSol ;
	}
	
	
	public void detruireTourelle(){
		saTourelle = null ;
	}
	
	
}
