package controleur;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import modele.Modele;
import monstres.MonstreAllie;
import terrain.Case;
import terrain.Position;
import tourelles.Tourelle;
import vues.Dessin;
import vues.Vue;

public class Controleur {
	
	private Modele modele ;
	private Vue vue ;
	
	public Controleur(){
		modele = new Modele("Ssoap") ;
		vue = new Vue(Modele.HAUTEUR_TERRAIN, Modele.LARGEUR_TERRAIN, modele.getPseudoJoueur(), modele.getPvJoueur(), modele.getGoldJoueur(), modele.getPvAdversaire()) ;
		
		// Dessiner les cases
				for(int j = 0 ; j < Modele.HAUTEUR_TERRAIN ; j++){
					for(int i = 0 ; i < Modele.LARGEUR_TERRAIN ; i++){
						Dessin dessin = null ;
						String typeCase = modele.getTypeCase(new Position(i, j)) ;
						String typeDessin = "" ;
						switch(typeCase){
							case "bonus portee" : typeDessin = "range" ; break ;
							case "bonus attack speed" : typeDessin = "AS" ; break ;
							case "slow" : typeDessin = "slow" ; break ;
							case "spawn" : typeDessin = "spawn" ; break ;
							case "base" : typeDessin = "base" ; break ;
							default : typeDessin = typeCase ; break ;
						}
						dessin = new Dessin(typeDessin, Case.getHauteur(), Case.getLargeur()) ;
						
						dessin.addMouseListener(new MouseAdapter(){
							@Override
							public void mouseClicked(MouseEvent me){
								JLabel clicked = (JLabel)me.getSource() ;
								if(vue.getTourelleSelectionnee()!=null){
									int x = ((int)clicked.getX()) / Case.getLargeur() ;
									int y = ((int)clicked.getY()) / Case.getHauteur() ;
									Position posCase = new Position(x, y) ;
									System.out.println("une tourelle a été achetée");
									modele.acheterTourelle(vue.getTourelleSelectionnee(), posCase) ;
									vue.majGoldJoueur(modele.getGoldJoueur());
									((Dessin)clicked).modifImage(vue.getTourelleSelectionnee()) ;
									vue.deselectionnerTourelle() ;
								}
								vue.selectionnerCase(clicked) ;
						    }
						}) ;
						vue.dessinerCase(dessin, new Position(i, j)) ;
					}
			    }
		
		// Ajouter les tourelles dans le store
		vue.definirNbTourelles(Tourelle.NB_TYPES_TOURELLE) ;
		for(int i = 0 ; i < Tourelle.NB_TYPES_TOURELLE ; i++){
			final String typeTourelle = Tourelle.getTypeTourelle(i) ;
			JButton btnTourelle = vue.ajouterTypeTourelle(typeTourelle, Tourelle.getInfosTourelle(typeTourelle), new Dessin(typeTourelle, 50, 50)) ;
			// Ajouter un listener sur le bouton
			btnTourelle.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					vue.clickBtnAchatTour(typeTourelle) ;
				}
			});
		}
		
		// Ajouter les monstres dans le store
		vue.definirNbMonstres(MonstreAllie.NB_TYPES_MONSTRE) ;
		for(int i = 0 ; i < MonstreAllie.NB_TYPES_MONSTRE ; i++){
			String typeMonstre = MonstreAllie.getTypeMonstre(i) ;
			JButton btnMonstre = vue.ajouterTypeMonstre(typeMonstre, MonstreAllie.getInfosMonstre(typeMonstre), new Dessin(typeMonstre, 40, 40)) ;
			// Ajouter un listener sur le bouton
		}
		
		
		
		
		
		// Ajouter un listener sur la redimension de la fenetre
		vue.addComponentListener(new ComponentAdapter(){
			@Override
            public void componentResized(ComponentEvent e) {
            	Case.setLargeur(vue.getLargeurMap() / Modele.LARGEUR_TERRAIN) ;
            	Case.setHauteur(vue.getHauteurMap() / Modele.HAUTEUR_TERRAIN) ;
            	vue.redimensionner() ;
            }
        });
		
		vue.setPreferredSize(new Dimension(1000, 600)) ;
		vue.setVisible(true);
		vue.pack() ;
		vue.setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args){
		new Controleur() ;
	}
	
}
