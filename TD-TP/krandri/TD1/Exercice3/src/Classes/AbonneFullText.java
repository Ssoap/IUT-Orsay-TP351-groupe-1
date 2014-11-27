package Classes;

public class AbonneFullText extends Abonne {
	private Contenu SonContenu;
	
	public AbonneFullText(int n, String nom, String prenom, Contenu c){
		super(n,nom,prenom);
		SonContenu = c;
	}
	
	public String obtenirArticle(){
		return SonContenu.getTexteArticle();
	}
	
	public String obtenirResume(){
		return SonContenu.getTexteResume();
	}
	
	@Override
	public String obtenirInfos(){
		String s;
		s = obtenirArticle() +" " +obtenirResume();
		return s;
	}
}
