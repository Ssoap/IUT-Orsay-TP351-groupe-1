package application;

import terrain.Case;
import terrain.Terrain;
import tourelles.Tourelle;
import utilisateurs.Adversaire;
import utilisateurs.Joueur;

public class Jeu {
	
	private Joueur joueur ;
	private Adversaire adversaire ;
	
	public Jeu(String pseudoJoueur, String pseudoAdversaire){
		Terrain t = new Terrain() ;
		joueur = new Joueur(pseudoJoueur, t) ;
		adversaire = new Adversaire(pseudoAdversaire) ;
	}
	
	
	public static void main(String[] args){
		Jeu jeu = new Jeu("pseudo du joueur", "pseudo de l'adversaire") ;
		// Creer la vue ?
	}
	
}
