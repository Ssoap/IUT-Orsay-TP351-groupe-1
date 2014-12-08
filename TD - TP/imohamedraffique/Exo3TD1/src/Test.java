import java.util.Scanner;

public class Test {
	
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir choisir votre type d'abonnement: (saisir ft, fto ou sms)");
	String rep = sc.nextLine();
	if(rep.equals("ft"))
	{
		String a = "Vous etes en train de lire un article";
		String r = "Vous etes en train de lire un résumé";
		Article article= new Article(a);
		Resume res = new Resume(r);
		Contenu cft = new Contenu(article, res);
		System.out.println("Veuillez saisir votre nom:");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir votre prenom");
		String prenom = sc.nextLine();
		System.out.println("Veuillez saisir votre numero de telephone");
		String num = sc.nextLine();
		LecteurFT lft = new LecteurFT(nom, prenom, num, article, res);
		System.out.println(lft.toString());
		System.out.println(lft.toStringft());
		System.out.println(cft.toStringft());

	}
	
	else if(rep.equals("fto"))
	{
		String a = "Vous etes en train de lire un article";
		Article article= new Article(a);
		Contenu cft = new Contenu(article);
		System.out.println("Veuillez saisir votre nom:");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir votre prenom");
		String prenom = sc.nextLine();
		System.out.println("Veuillez saisir votre numero de telephone");
		String num = sc.nextLine();
		LecteurFTO lfto = new LecteurFTO(nom, prenom, num, article);
		System.out.println(lfto.toString());
		System.out.println(lfto.toStringfto());
		System.out.println(cft.toStringfto());
	}
	else if(rep.equals("sms"))
	{
		String r = "Vous etes en train de lire un resume";
		Resume resume= new Resume(r);
		Contenu cft = new Contenu(resume);
		System.out.println("Veuillez saisir votre nom:");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir votre prenom");
		String prenom = sc.nextLine();
		System.out.println("Veuillez saisir votre numero de telephone");
		String num = sc.nextLine();
		LecteurSMS lfto = new LecteurSMS(nom, prenom, num, resume);
		System.out.println(lfto.toString());
		System.out.println(lfto.toStringsms());
		System.out.println(cft.toStringsms());
	}
	else 
	{
		System.out.println("ERREUR SAISIE");
	}
	

}


	
}
