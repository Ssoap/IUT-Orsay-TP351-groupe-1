package modeles;

public abstract class Utilisateur {
	
	protected String pseudo ;
	protected int gold ;
	protected int pvActuels ;
	
	public Utilisateur(){}
	
	public Utilisateur(String pseudo){
		this.pseudo = pseudo ;
	}

	public String getPseudo() {
		return pseudo;
	}

	public int getGold(){
		return gold ;
	}

	public int getPvActuels(){
		return pvActuels ;
	}
	
}
