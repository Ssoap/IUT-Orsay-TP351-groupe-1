package utilisateurs;

import java.util.ArrayList;

import monstres.Monstre;

public class Adversaire{

	private ArrayList<Monstre> sesMonstres ;
	
	public Adversaire(){
		sesMonstres = new ArrayList<Monstre>() ;
	}
	
	public ArrayList<Monstre> getSesMonstres(){
		return sesMonstres ;
	}
	
	public void addMonstre(Monstre m){
		sesMonstres.add(m) ;
	}
	
	public void tuerMonstre(Monstre m){
		sesMonstres.remove(m) ;
	}
	
}
