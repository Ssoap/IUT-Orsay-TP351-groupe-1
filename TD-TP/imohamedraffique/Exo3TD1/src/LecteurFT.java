
public class LecteurFT extends Lecteur{

	
	String nom, prenom, tel;
	Article article; 
	Resume res;
	Contenu ft = new Contenu(article, res);
	
	public LecteurFT(String n, String p, String t, Article a, Resume r)
	{
		super(n, p, t, a, r);

	}

		
}
