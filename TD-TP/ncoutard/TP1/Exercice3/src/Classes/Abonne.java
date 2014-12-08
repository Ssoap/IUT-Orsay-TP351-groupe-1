package Classes;

public abstract class Abonne {
	private int num;
	private String nom;
	private String prenom;
	
	public Abonne(int n, String nom, String prenom){
		num = n;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public abstract String obtenirInfos();
	
}
