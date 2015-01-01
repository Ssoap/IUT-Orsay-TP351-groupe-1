package terrain;

public abstract class TypeSol {
	
	protected String nomType ;
	
	public TypeSol(String nomType){
		this.nomType = nomType ;
	}
	
	public String getNomType(){
		return nomType ;
	}
	
}
