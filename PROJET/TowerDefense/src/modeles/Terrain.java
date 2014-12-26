package modeles;

import java.util.ArrayList;

public class Terrain {

	private Joueur sonJoueur ;
	private ChampsDeBataille champsDeBataille ;
	
	public Terrain(){}
	
	public void definirChampsDeBataille(ChampsDeBataille champsDeBataille){
		this.champsDeBataille = champsDeBataille ;
	}
	
	public void definirJoueur(Joueur j){
		this.sonJoueur = j ;
	}
	
	
	
}
