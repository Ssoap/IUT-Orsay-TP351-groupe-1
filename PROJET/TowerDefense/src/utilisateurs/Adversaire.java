package utilisateurs;

import java.util.ArrayList;
import monstres.MonstreAdverse;

public class Adversaire extends Utilisateur{

	private ArrayList<MonstreAdverse> sesMonstres ;
	
	public Adversaire(String pseudo){
		super(pseudo) ;
		sesMonstres = new ArrayList<MonstreAdverse>() ;
		miseAjourGold() ;
	}

	@Override
	public void miseAjourGold() {
		// RESEAU
	}
	
}
