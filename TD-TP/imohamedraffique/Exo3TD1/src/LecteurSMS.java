
public class LecteurSMS extends Lecteur{
	
	String nom, prenom, tel;
	Resume resume;
	Contenu sms = new Contenu(resume);
	
	public LecteurSMS(String n, String p, String t, Resume r)
	{
		super(n,p,t,r);
	}

}
