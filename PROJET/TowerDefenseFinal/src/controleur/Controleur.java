package controleur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;

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
	
	private Dessin caseSelectionnee ;
	private String tourelleSelectionnee ;
	private HashMap<String, JButton> hashTourelleBouton ;
	
	public Controleur(){
		modele = new Modele("Ssoap") ;
		vue = new Vue(Modele.HAUTEUR_TERRAIN, Modele.LARGEUR_TERRAIN, modele.getPseudoJoueur(), modele.getPvJoueur(), modele.getGoldJoueur(), modele.getPvAdversaire()) ;
		
		hashTourelleBouton = new HashMap<String, JButton>() ;
		
		// Dessiner les cases
		for(int j = 0 ; j < Modele.HAUTEUR_TERRAIN ; j++){
			for(int i = 0 ; i < Modele.LARGEUR_TERRAIN ; i++){
				Dessin dessin = null ;
				dessin = new Dessin(modele.getTypeCase(new Position(i, j)), Case.getHauteur(), Case.getLargeur()) ;
				
				dessin.addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent me){
						Dessin caseCliquee = (Dessin)me.getSource() ;
						int x = ((int)caseCliquee.getX()) / Case.getLargeur() ;
						int y = ((int)caseCliquee.getY()) / Case.getHauteur() ;
						Position posCase = new Position(x, y) ;
						if(tourelleSelectionnee != null){
							System.out.println("une tourelle a été achetée");
							modele.acheterTourelle(tourelleSelectionnee, posCase) ;
							vue.majGoldJoueur(modele.getGoldJoueur());
							caseCliquee.modifImage(tourelleSelectionnee) ;
							hashTourelleBouton.get(tourelleSelectionnee).setText("Acheter") ;
							tourelleSelectionnee = null ;
						}
						
						if(caseSelectionnee == caseCliquee){
							caseSelectionnee.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							caseSelectionnee = null ;
						}
						else{
							if(caseSelectionnee != null){
								caseSelectionnee.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							}
							caseSelectionnee= caseCliquee ;
							caseSelectionnee.setBorder(BorderFactory.createLineBorder(Color.RED));
						}
						
						if(!modele.caseVide(posCase)){
							vue.majInfosTourelle(infosTourelle(posCase));
							vue.getBtnAmeliorer().setEnabled(true) ;
						}
						else{
							vue.majInfosTourelle("aucune tourelle selectionnée");
							vue.getBtnAmeliorer().setEnabled(false) ;
						}
				    }
				}) ;
				vue.dessinerCase(dessin, new Position(i, j)) ;
			}
		}
		
		vue.getBtnAmeliorer().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int x = ((int)caseSelectionnee.getX()) / Case.getLargeur() ;
				int y = ((int)caseSelectionnee.getY()) / Case.getHauteur() ;
				Position posCase = new Position(x, y) ;
				modele.ameliorerTourelle(posCase) ;
			}
		});
		
		// Ajouter les tourelles dans le store
		vue.definirNbTourelles(Tourelle.NB_TYPES_TOURELLE) ;
		for(int i = 0 ; i < Tourelle.NB_TYPES_TOURELLE ; i++){
			final String typeTourelle = Tourelle.getTypeTourelle(i) ;
			JButton btnTourelle = vue.ajouterTypeTourelle(typeTourelle, infosTourelle(typeTourelle), new Dessin(typeTourelle, 50, 50)) ;
			hashTourelleBouton.put(typeTourelle, btnTourelle) ;
			// Ajouter un listener sur le bouton
			btnTourelle.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					if(tourelleSelectionnee == typeTourelle){
						tourelleSelectionnee = null ;
						hashTourelleBouton.get(typeTourelle).setText("Acheter") ;
					}
					else{
						if(tourelleSelectionnee != null){
							hashTourelleBouton.get(tourelleSelectionnee).setText("Acheter") ;
						}
						tourelleSelectionnee = typeTourelle ;
						hashTourelleBouton.get(typeTourelle).setText("Annuler achat") ;
					}
				}
			});
		}
		
		// Ajouter les monstres dans le store
		vue.definirNbMonstres(MonstreAllie.NB_TYPES_MONSTRE) ;
		for(int i = 0 ; i < MonstreAllie.NB_TYPES_MONSTRE ; i++){
			String typeMonstre = MonstreAllie.getTypeMonstre(i) ;
			JButton btnMonstre = vue.ajouterTypeMonstre(typeMonstre, infosMonstres(typeMonstre), new Dessin(typeMonstre, 40, 40)) ;
			// Ajouter un listener sur le bouton
			btnMonstre.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					/*modele.clickBtnAchatMonstre(typeMonstre) ;*/
				}
			});
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
	
	public String infosTourelle(Position p){
		
		Tourelle t = modele.getTourelle(p) ;

		return "<html>Type : " + t.getType() + "<br>Portee : " + t.getPortee() + "<br>Dommages : " + t.getDommages() + "<br>AS : " + t.getAS() + "</html>";
		
	}
	
	public String infosTourelle(String typeTourelle){
		String infosBrutes = Tourelle.getInfosTourelle(typeTourelle) ;

		String infosFormatees = "<html>Type : " + typeTourelle + "<br>";
	    int k = 0 ;
	    infosFormatees += "Cout : " ;
	    while(infosBrutes.charAt(k) != ':'){
	    	infosFormatees += infosBrutes.charAt(k);
	    	k++ ;
	    }
    	k++ ;
    	infosFormatees += "<br>" ;
    	infosFormatees += "Portee : " ;
	    while(infosBrutes.charAt(k) != ':'){
	    	infosFormatees += infosBrutes.charAt(k);
	    	k++ ;
	    }
    	k++ ;
    	infosFormatees += "<br>" ;
    	infosFormatees += "Dommages : " ;
	    while(infosBrutes.charAt(k) != ':'){
	    	infosFormatees += infosBrutes.charAt(k);
	    	k++ ;
	    }
    	k++ ;
    	infosFormatees += "<br>" ;
    	infosFormatees += "AS : " ;
	    while(infosBrutes.charAt(k) != ':'){
	    	infosFormatees += infosBrutes.charAt(k);
	    	k++ ;
	    }
	    infosFormatees += "</html>" ;
	    
	    return infosFormatees ;
	}

	public String infosMonstres(String typeMonstre){
		
		String infosBrutes = MonstreAllie.getInfosMonstre(typeMonstre) ;
		
		String infosFormatees = "<html>Type : " + typeMonstre + "<br>";
	    int k = 0 ;
	    infosFormatees += "Cout : " ;
	    while(infosBrutes.charAt(k) != ':'){
	    	infosFormatees += infosBrutes.charAt(k);
	    	k++ ;
	    }
    	k++ ;
    	infosFormatees += "<br>" ;
    	infosFormatees += "Income : " ;
	    while(infosBrutes.charAt(k) != ':'){
	    	infosFormatees += infosBrutes.charAt(k);
	    	k++ ;
	    }
    	k++ ;
    	infosFormatees += "<br>" ;
    	infosFormatees += "Pv : " ;
	    while(infosBrutes.charAt(k) != ':'){
	    	infosFormatees += infosBrutes.charAt(k);
	    	k++ ;
	    }
    	k++ ;
    	infosFormatees += "<br>" ;
    	infosFormatees += "MS : " ;
	    while(infosBrutes.charAt(k) != ':'){
	    	infosFormatees += infosBrutes.charAt(k);
	    	k++ ;
	    }
    	k++ ;
    	infosFormatees += "<br>" ;
    	infosFormatees += "DPS : " ;
	    while(infosBrutes.charAt(k) != ':'){
	    	infosFormatees += infosBrutes.charAt(k);
	    	k++ ;
	    }
	    infosFormatees += "</html>" ;
		
		return infosFormatees ;
		
	}
	
	public static void main(String[] args){
		new Controleur() ;
	}
	
}
