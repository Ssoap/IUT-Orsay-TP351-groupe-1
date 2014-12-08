
public abstract class Liquide {
	protected String nom;
	protected double masseVolumique;
	
	Liquide(String nom, double masseVolumique)
	{
		this.nom = nom;
		this.masseVolumique = masseVolumique;
	}
	
	public String donnerNomLiquide()
	{
		return this.nom;
	}
	
	public void definirNomLiquide(String nom)
	{
		this.nom = nom;
	}
	
	public double donnerMasseVolumique()
	{
		return this.masseVolumique;
	}
	
	public void definirMasseVolumique(double masseVolumique)
	{
		this.masseVolumique = masseVolumique;
	}
}
