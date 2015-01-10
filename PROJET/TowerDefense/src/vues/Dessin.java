package vues;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dessin extends JLabel {
	
	private Image image ;
	private int hauteur ;
	private int largeur ;
	
	
	public Dessin(String type, int hauteur, int largeur) {
		super() ;
		this.largeur = largeur ;
		this.hauteur = hauteur ;
		//this.type = type ;
		String cheminImage = "" ;
		switch(type){
			
			case "sol_normal" : cheminImage = "sol_normal.jpg" ; break ;
			case "spawn" : cheminImage = "sol_normal.jpg" ; break ;
			case "base" : cheminImage = "sol_normal.jpg" ; break ;
			case "sol_slow" : cheminImage = "sol_slow.jpg" ; break ;
			case "sol_bonus_portee" : cheminImage = "sol_bonus_portee.jpg" ; break ;
			case "sol_bonus_as" : cheminImage = "sol_bonus_as.jpg" ; break ;
			
			case "monstre_basique" : cheminImage = "monstre_basique.png" ; break ;
			case "monstre_rapide" : cheminImage = "monstre_rapide.png" ; break ;
			case "monstre_puissant" : cheminImage = "monstre_puissant.png" ; break ;
			
			case "tourelle_basique" : cheminImage = "tourelle_basique.png" ; break ;
			case "tourelle_puissante" : cheminImage = "tourelle_puissante.png" ; break ;
			
		}
		
		try {
			image = ImageIO.read(new File(cheminImage));
			this.setIcon(new ImageIcon(image.getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void modifImage(String typeImage){
		String cheminImage = "" ;
		switch(typeImage){
			case "sol_normal" : cheminImage = "sol_normal.jpg" ; break ;
			case "spawn" : cheminImage = "sol_normal.jpg" ; break ;
			case "base" : cheminImage = "sol_normal.jpg" ; break ;
			case "sol_slow" : cheminImage = "sol_slow.jpg" ; break ;
			case "sol_bonus_portee" : cheminImage = "sol_bonus_portee.jpg" ; break ;
			case "sol_bonus_as" : cheminImage = "sol_bonus_as.jpg" ; break ;
			
			case "monstre_basique" : cheminImage = "monstre_basique.png" ; break ;
			case "monstre_rapide" : cheminImage = "monstre_rapide.png" ; break ;
			case "monstre_puissant" : cheminImage = "monstre_puissant.png" ; break ;
			
			case "tourelle_basique" : cheminImage = "tourelle_basique.png" ; break ;
			case "tourelle_puissante" : cheminImage = "tourelle_puissante.png" ; break ;
		}
		
		try {
			image = ImageIO.read(new File(cheminImage));
			this.setIcon(new ImageIcon(image.getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void redimensionner(int hauteur, int largeur){
		this.hauteur = hauteur ;
		this.largeur = largeur ;
		System.out.println("ok");
		this.setIcon(new ImageIcon(image.getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT)));
	}
}
