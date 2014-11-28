
public class Contenu {
	Article article; 
	Resume resume;

	public Contenu(Article a, Resume r)
	{
		article = a;
		resume = r;
	}
	
	public Contenu(Article a)
	{
		article = a;
	}
	
	public Contenu(Resume r)
	{
		resume = r;
	}

	public String toStringft() {
		return "article: " + article.getArticle() + ", resume: " + resume.getResume();
	}
	
	public String toStringfto()
	{
		return "article: " + article.getArticle();
	}
	
	public String toStringsms()
	{
		return "resume: " + resume.getResume();
	}
	
	
	

}
