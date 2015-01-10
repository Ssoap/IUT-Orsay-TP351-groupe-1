package utilisateurs;

import java.util.ArrayList;
import monstres.MonstreAdverse;

public class Adversaire extends Utilisateur{

	private ArrayList<MonstreAdverse> sesMonstres ;
	
	public Adversaire(String pseudo){
		super(pseudo) ;
		sesMonstres = new ArrayList<MonstreAdverse>() ;
	}
	
	public void setPv(int pv){
		this.pv = pv ;
	}
	
	public ArrayList<MonstreAdverse> getSesMonstres(){
		return sesMonstres ;
	}
	
	public void addMonstre(MonstreAdverse m){
		sesMonstres.add(m) ;
	}
	
	public void tuerMonstre(MonstreAdverse m){
		sesMonstres.remove(m) ;
	}
	
}
