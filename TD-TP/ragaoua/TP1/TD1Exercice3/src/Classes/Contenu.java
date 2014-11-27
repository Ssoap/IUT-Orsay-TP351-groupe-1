package Classes;

public class Contenu {
	private Article SonArticle;
	private Resume SonResume;
	
	public Contenu(Article a, Resume r){
		SonArticle = a;
		SonResume = r;
	}
	
	public String getTexteArticle(){
		return SonArticle.getTexteArticle();
	}
	
	public String getTexteResume(){
		return SonResume.getTexteResume();
	}

	public void setTexteArticle(String texte){
		SonArticle.setTexteArticle(texte);
	}
	
	public void setTexteResume(String texte){
		SonResume.setTexteResume(texte);
	}
}
