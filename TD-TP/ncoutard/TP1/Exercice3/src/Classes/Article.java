package Classes;

public class Article {
	private String texteArticle ;
	
	public String getTexteArticle(){
		return texteArticle;
	}
	
	public void setTexteArticle(String txt){
		texteArticle = txt;
	}
	
	public Article (String texteArticle){
		this.texteArticle = texteArticle;
	}
}
