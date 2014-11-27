package Classes;

public class AbonneFullTextOnly extends Abonne {
	private Article SonArticle;
	
	public AbonneFullTextOnly(int n, String nom, String prenom, Article a){
		super(n,nom,prenom);
		SonArticle = a;
	}
	
	public String obtenirTexteArticle(){
		return SonArticle.getTexteArticle();
	}
	
	@Override
	public String obtenirInfos(){
		return obtenirTexteArticle();
	}
}
