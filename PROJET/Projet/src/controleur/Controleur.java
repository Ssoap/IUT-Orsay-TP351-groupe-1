package controleur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.Modele;
import monstres.Monstre;
import terrain.Case;
import terrain.Position;
import tourelles.Tourelle;
import vues.Dessin;
import vues.Vue;
import couple.Couple;

public class Controleur {
	
	private Modele modele ;
	private Vue vue ;
	private Timer timer ;
	private boolean timerRunning ;
	private boolean stopTimerNextTic ;
	private int cptVague ;
	
	private Dessin caseSelectionnee ;
	private String tourelleSelectionnee ;
	private HashMap<String, JButton> hashTourelleBouton ;
	private HashMap<Position, Dessin> hashPosCase ;
	
	public Controleur(){
		modele = new Modele("Ssoap") ;
		vue = new Vue(Modele.HAUTEUR_TERRAIN, Modele.LARGEUR_TERRAIN, modele.getPvJoueur(), modele.getGoldJoueur()) ;
		timerRunning = false ;
		stopTimerNextTic = false ;
		hashPosCase = new HashMap<Position, Dessin>() ;
		
		hashTourelleBouton = new HashMap<String, JButton>() ;
		
		// Dessiner les cases
		for(int j = 0 ; j < Modele.HAUTEUR_TERRAIN ; j++){
			for(int i = 0 ; i < Modele.LARGEUR_TERRAIN ; i++){
				Dessin dessin = null ;
				dessin = new Dessin(modele.getTypeCase(new Position(i, j)), Case.getHauteur(), Case.getLargeur()) ;
				hashPosCase.put(new Position(i, j), dessin) ;
				dessin.addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent me){
						Dessin caseCliquee = (Dessin)me.getSource() ;
						int x = ((int)caseCliquee.getX()) / Case.getLargeur() ;
						int y = ((int)caseCliquee.getY()) / Case.getHauteur() ;
						Position posCase = new Position(x, y) ;
						if(tourelleSelectionnee != null){
							if(modele.niSpawnNiBaseNiMorte(posCase)){
								if(modele.acheterTourelle(tourelleSelectionnee, posCase)){
									vue.majGoldJoueur(modele.getGoldJoueur());
									caseCliquee.ajouter(tourelleSelectionnee) ;
									hashTourelleBouton.get(tourelleSelectionnee).setText("Acheter") ;
									tourelleSelectionnee = null ;
									modele.definirCheminsMonstres() ;
								}
								else{
									vue.message("Achat impossible", "Vous n'avez pas assez de gold !", JOptionPane.WARNING_MESSAGE) ;
								}
							}
							else{
								vue.message("Achat impossible", "Vous ne pouvez pas placer de tourelle sur le spawn ou la base", JOptionPane.WARNING_MESSAGE);
							}

						}
						
						if(caseSelectionnee == caseCliquee){
							caseSelectionnee.setBorder(null);
							caseSelectionnee = null ;
						}
						else{
							if(caseSelectionnee != null){
								caseSelectionnee.setBorder(null);
							}
							caseSelectionnee= caseCliquee ;
							caseSelectionnee.setBorder(BorderFactory.createLineBorder(Color.RED));
						}
						
						if(!modele.caseVide(posCase)){
							if(modele.getCase(posCase).getSaTourelle().isAmelioree()){
								vue.majInfosTourelle(infosTourelle(posCase));
								vue.getBtnAmeliorer().setEnabled(false) ;
							}
							else{
								vue.majInfosTourelle(infosTourelle(posCase));
								vue.getBtnAmeliorer().setEnabled(true) ;
							}
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
				if(modele.ameliorerTourelle(posCase)){
					vue.majInfosTourelle(infosTourelle(posCase));
					vue.majGoldJoueur(modele.getGoldJoueur());
					((JButton)e.getSource()).setEnabled(false) ;
				}
				else{
					vue.message("Amelioration impossible", "Vous n'avez pas assez de gold", JOptionPane.WARNING_MESSAGE);
				}
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
		vue.definirNbMonstres(Monstre.NB_TYPES_MONSTRE).addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(!timerRunning){
					nouvelleVague() ;
				}
			}
		});
		
		for(int i = 0 ; i < Monstre.NB_TYPES_MONSTRE ; i++){
			String typeMonstre = Monstre.getTypeMonstre(i) ;
			vue.ajouterTypeMonstre(typeMonstre, infosMonstres(typeMonstre), new Dessin(typeMonstre, 40, 40)) ;
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
		
		vue.setPreferredSize(new Dimension(1000, 700)) ;
		vue.setVisible(true);
		vue.pack() ;
		vue.setLocationRelativeTo(null);
	}
	
	private void nouvelleVague(){
		stopTimerNextTic = false ;
		timerRunning = true ;
		cptVague = 0 ;
		timer = new Timer() ;
		timer.schedule(new TimerTask(){
			@Override
			public void run(){
				tic() ;
			}
		}, 1000, 100);
	}
	
	private void tic(){
		modele.majGold() ;
		vue.majGoldJoueur(modele.getGoldJoueur());
		Set<Position> cles = hashPosCase.keySet();
		Iterator<Position> it = cles.iterator() ;
		while(it.hasNext()){
			Dessin d = hashPosCase.get(it.next()) ;
			d.supprimerImageMonstre();
			d.repaint();
		}
		ArrayList<Couple<Position, String>> newPositionsTypesMonstre = modele.faireAvancerMonstres();
		for(Couple<Position, String> c : newPositionsTypesMonstre){
			hashPosCase.get(c.getT1()).ajouter(c.getT2()) ;
			hashPosCase.get(c.getT1()).repaint() ;
		}
		vue.majPvJoueur(modele.getPvJoueur());
		modele.faireAttaquerTourelles();
		
		if(cptVague < 10){
			Monstre m = null ;
			int n = (int)(Math.random() * 3) ;
			Position spawn = modele.randomSpawn() ;
			switch(n){
				case 0 :
					m = new Monstre("monstre_puissant", spawn) ;
					hashPosCase.get(spawn).ajouter("monstre_puissant");
					hashPosCase.get(spawn).repaint() ;
					break ;
				default :
					m = new Monstre("monstre_basique", spawn) ;
					hashPosCase.get(spawn).ajouter("monstre_basique");
					hashPosCase.get(spawn).repaint() ;
					break ;
			}
			modele.ajouterMonstre(m);
			modele.definirCheminsMonstres() ;
		}
		cptVague++ ;
		

		if(stopTimerNextTic){
			timer.cancel() ;
			timerRunning = false ;
		}
		if(modele.tousMonstresMorts()){
			stopTimerNextTic = true ;
		}
	}
	
	private String infosTourelle(Position p){
		
		Tourelle t = modele.getTourelle(p) ;
		String amelioree = "" ;
		if(t.isAmelioree()){
			amelioree = " (ameliorée)" ;
		}

		return "<html>Type : " + t.getType() + amelioree + "<br>Portee : " + t.getPortee() + "<br>Dommages : " + t.getDommages() + "<br>AS : " + t.getAS() + "</html>";
		
	}
	
	private String infosTourelle(String typeTourelle){
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

	private String infosMonstres(String typeMonstre){
		
		String infosBrutes = Monstre.getInfosMonstre(typeMonstre) ;
		
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
