
public class Lecteur {
	private String nom;
	private String prenom;
	private String numeroTel;
	private Article a;
	private Resume r;
	private Contenu c = new Contenu(a,r);
	
	public Lecteur(String n, String pren, String tel, Article a, Resume r)
	{
		nom = n;
		prenom = pren;
		numeroTel = tel;
		this.a = a;
		this.r = r;
	}
	
	public Lecteur(String n, String pren, String tel)
	{
		nom = n;
		prenom = pren;
		numeroTel = tel;
	}
	
	public Lecteur(String n, String pren, String tel, Article a)
	{
		nom = n;
		prenom = pren;
		numeroTel = tel;
		this.a = a;
	}

	public Lecteur(String n, String pren, String tel, Resume r)
	{
		nom = n;
		prenom = pren;
		numeroTel = tel;
		this.r = r;
	}
	
	public String toString() {
		return "Bienvenu a OrsayNews " + nom +" "+ prenom ;
	}
	
	public String toStringsms()
	{
		return "Un résumé a été envoyés au: "+numeroTel;
	}
	
	public String toStringft()
	{
		return "Un article et un résumé ont été envoyés au: "+numeroTel;
	}
	
	public String toStringfto()
	{
		return "Un article a été envoyé au: "+numeroTel;
	}
	
	
	
}
