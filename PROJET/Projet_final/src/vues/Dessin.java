package vues;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Dessin extends JLabel {
	
	private Image imageTerrain ;
	private ArrayList<Image> imagesForeground ;
	private String typeImagesForegrounds ;
	private String type ;
	private int hauteur ;
	private int largeur ;
	
	
	public Dessin(String type, int hauteur, int largeur) {
		super() ;
		imagesForeground = new ArrayList<Image>() ;
		this.largeur = largeur ;
		this.hauteur = hauteur ;
		this.type = type ;
		String cheminImage = "" ;
		switch(type){
			
			case "sol_normal" : cheminImage = "sol_normal.jpg" ; break ;
			case "spawn" : cheminImage = "sol_normal.jpg" ; break ;
			case "base" : cheminImage = "base.png" ; break ;
			case "sol_bonus_portee" : cheminImage = "sol_bonus_portee.jpg" ; break ;
			case "sol_bonus_as" : cheminImage = "sol_bonus_as.jpg" ; break ;
			
			case "monstre_basique" : cheminImage = "monstre_basique.png" ; break ;
			case "monstre_rapide" : cheminImage = "monstre_rapide.png" ; break ;
			case "monstre_puissant" : cheminImage = "monstre_puissant.png" ; break ;
			
			case "tourelle_basique" : cheminImage = "tourelle_basique.png" ; break ;
			case "tourelle_puissante" : cheminImage = "tourelle_puissante.png" ; break ;
			
		}
		
		try {
			Image image = ImageIO.read(new File(cheminImage)).getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT);
			if(type.startsWith("tourelle") || type.startsWith("monstre")){
				imagesForeground.add(image);
				typeImagesForegrounds = type ;
			}
			else{
				typeImagesForegrounds = "" ;
				this.imageTerrain = image;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouter(String typeImage){
		String cheminImage = "" ;
		switch(typeImage){
		
			case "sol_normal" : cheminImage = "sol_normal.jpg" ; break ;
			case "spawn" : cheminImage = "sol_normal.jpg" ; break ;
			case "base" : cheminImage = "base.png" ; break ;
			case "sol_bonus_portee" : cheminImage = "sol_bonus_portee.jpg" ; break ;
			case "sol_bonus_as" : cheminImage = "sol_bonus_as.jpg" ; break ;
			
			case "monstre_basique" : cheminImage = "monstre_basique.png" ; break ;
			case "monstre_rapide" : cheminImage = "monstre_rapide.png" ; break ;
			case "monstre_puissant" : cheminImage = "monstre_puissant.png" ; break ;
			
			case "tourelle_basique" : cheminImage = "tourelle_basique.png" ; break ;
			case "tourelle_puissante" : cheminImage = "tourelle_puissante.png" ; break ;
			
		}
		
		try {
			Image image = ImageIO.read(new File(cheminImage)).getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT);
			if(typeImage.startsWith("tourelle") || typeImage.startsWith("monstre")){
				imagesForeground.add(image);
				typeImagesForegrounds = typeImage ;
			}
			else{
				this.imageTerrain = image;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void redimensionner(int hauteur, int largeur){
		this.hauteur = hauteur ;
		this.largeur = largeur ;
		if(imageTerrain!=null){
			imageTerrain = imageTerrain.getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT);
		}
		for(Image i : imagesForeground){
			i = i.getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT);
		}

	}
	
	public void supprimerImageMonstre(){
		if(typeImagesForegrounds.startsWith("monstre")){
			imagesForeground = new ArrayList<Image>() ;
		}
	}
	
	public void nouveau(){
		imagesForeground = new ArrayList<Image>() ;
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.clearRect(0, 0, getWidth(), getHeight());
		if(imageTerrain !=null){
			g.drawImage(imageTerrain, 0, 0,  null);
		}
		for(Image i : imagesForeground){
			g.drawImage(i, 0, 0,  null);
		}
	}
	
	public String getType(){
		return type ;
	}
	
	public int getHauteur(){
		return hauteur ;
	}
	
	public int getLargeur(){
		return largeur ;
	}
	
}
