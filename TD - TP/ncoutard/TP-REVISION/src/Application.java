
public class Application {
	public static void main(String[] args)
	{
		Recipient<Liquide> r1 = new Recipient<Liquide>(.5);
		Recipient<Huile> r2 = new Recipient<Huile>(1.0);
		Recipient<Essence> r3 = new Recipient<Essence>(.5);
		Stockage stock = new Stockage();
		
		r1.ajouterUnLitre(new Eau());
		r1.ajouterUnLitre(new Huile());
		
		r2.ajouterUnLitre(new Huile());
		r2.ajouterUnLitre(new Huile());
		r2.ajouterUnLitre(new Huile());
		
		r3.ajouterUnLitre(new Essence());
		r3.ajouterUnLitre(new Essence());
		r3.ajouterUnLitre(new Essence());
		
		stock.ajouterConteneur(r1);
		stock.ajouterConteneur(r2);
		stock.ajouterConteneur(r3);
		
		System.out.println(r1.donnerMasse() + "Kg / Poids du conteneur :" + r1.masseRecipient() + "kg");
		System.out.println(r2.donnerMasse() + "Kg / Poids du conteneur :" + r2.masseRecipient() + "kg");
		System.out.println(r3.donnerMasse() + "Kg / Poids du conteneur :" + r3.masseRecipient() + "kg");
		System.out.println("Masse du stock : " + stock.donnerMasse() + "kg");
		
		
		
		
		
	}
}
