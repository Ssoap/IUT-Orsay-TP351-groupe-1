package Classes;

public class AbonneSMS extends Abonne {
	private Resume SonResume; 
	
	public AbonneSMS(int n, String nom, String prenom,Resume r){
		super(n,nom,prenom);
		SonResume = r;
	}
	
	public String obtenirResume(){
		return (SonResume.getTexteResume());
	}
	
	@Override
	public String obtenirInfos(){
		return obtenirResume();
	}
}
