import java.util.ArrayList;


public class Recipient<Produit extends Liquide> implements Conteneur{
	private ArrayList<Produit> contenu;
	private double masseVide;
	
	public Recipient(double masseVide)
	{
		this.masseVide = masseVide;
		contenu = new ArrayList<Produit>();
	}
	
	public double donnerMasse()
	{
		double sommeMasse = 0.0;
		for(Produit produit : contenu)
		{
			sommeMasse = produit.masseVolumique;
		}
		
		return sommeMasse*contenu.size();
	}
	
	public double masseRecipient()
	{
		return this.masseVide;
	}
	
	public void ajouterUnLitre(Liquide produit)
	{
		contenu.add((Produit)produit);
	}

	

}
