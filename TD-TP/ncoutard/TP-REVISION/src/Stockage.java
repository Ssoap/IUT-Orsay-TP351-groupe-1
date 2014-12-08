import java.util.ArrayList;


public class Stockage {
	private ArrayList<Conteneur> stock;
	
	public Stockage()
	{
		stock = new ArrayList<Conteneur>();
	}
	
	public double donnerMasse()
	{
		double masseStock = 0.0;
		for(Conteneur conteneur : stock)
		{
			masseStock += conteneur.donnerMasse() + conteneur.masseRecipient();
		}
		return masseStock;
	}
	
	public void ajouterConteneur(Conteneur contenu)
	{
		stock.add(contenu);
	}
}
