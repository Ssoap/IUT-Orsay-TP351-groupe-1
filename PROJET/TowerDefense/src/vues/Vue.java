package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import terrain.Case;
import terrain.Position;


public class Vue extends JFrame{
	
	private int nbCasesHauteur ;
	private int nbCasesLargeur ;
	
	private JPanel pnlGestion;
	
	private JTabbedPane pnlOnglets;
	
	private JPanel pnlInfos;
	
	private JPanel pnlInfosTourelle ;
	private JLabel lblInfosTourelle ;
	
	private JPanel pnlInfosJoueur ;
	private JLabel lblPseudo ;
	private JLabel lblPv ;
	private JLabel lblGold ;
	private JLabel lblPvAdversaire ;
	
	private JPanel pnlMap;

	private JLabel caseSelectionnee ;
	private String tourelleSelectionnee ;
	private HashMap<String, JButton> hashTourelleBouton ;
	
 	public Vue(int nbCasesHauteur, int nbCasesLargeur, String pseudo, int pv, int gold, int pvAdversaire){
		
		super("Tower defense") ;
		
		this.nbCasesHauteur = nbCasesHauteur ;
		this.nbCasesLargeur = nbCasesLargeur ;
	    
	    pnlMap = new JPanel() ;
	    pnlMap.setLayout(new GridLayout(nbCasesHauteur, nbCasesLargeur));
	    pnlMap.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		
		pnlInfos = new JPanel();
		pnlInfos.setBackground(new Color(0, 0, 0, 0));
		pnlInfos.setLayout(new GridLayout(2, 1));
		
		pnlInfosTourelle = new JPanel() ;
		pnlInfosTourelle.setBackground(new Color(0, 50, 100));
		lblInfosTourelle = new JLabel() ;
		lblInfosTourelle.setForeground(Color.WHITE);
		pnlInfosTourelle.add(lblInfosTourelle) ;
		
		pnlInfosJoueur = new JPanel() ;
		pnlInfosJoueur.setBackground(new Color(0, 0, 0, 0));
		lblPseudo = new JLabel() ;
		lblPseudo.setForeground(Color.WHITE);
		lblPseudo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER) ;
		lblPseudo.setText("Pseudo : " + pseudo) ;
		lblPv = new JLabel() ;
		lblPv.setForeground(Color.WHITE);
		lblPv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER) ;
		majPvJoueur(pv) ;
		lblGold = new JLabel() ;
		lblGold.setForeground(Color.WHITE);
		lblGold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER) ;
		majGoldJoueur(gold) ;
		lblPvAdversaire = new JLabel() ;
		lblPvAdversaire.setForeground(Color.WHITE);
		lblPvAdversaire.setHorizontalAlignment(javax.swing.SwingConstants.CENTER) ;
		majPvAdversaire(pvAdversaire) ;
		pnlInfosJoueur.setLayout(new GridLayout(4,1)) ;
		pnlInfosJoueur.add(lblPseudo) ;
		pnlInfosJoueur.add(lblPv) ;
		pnlInfosJoueur.add(lblGold) ;
		pnlInfosJoueur.add(lblPvAdversaire) ;
		
		pnlInfos.add(pnlInfosTourelle) ;
		pnlInfos.add(pnlInfosJoueur) ;
		
		
		pnlGestion = new JPanel();
		pnlGestion.setLayout(new BorderLayout());
		pnlGestion.setPreferredSize(new Dimension(200, this.getHeight()));
		pnlGestion.setBackground(new Color(0,30,90));

		pnlOnglets = new JTabbedPane();
	    JPanel ongletMonstres = new JPanel();
	    pnlOnglets.add("Monstres", ongletMonstres);
	    JPanel ongletTours = new JPanel() ;
	    pnlOnglets.add("Tourelles", ongletTours);
	    
		pnlGestion.add(pnlOnglets, BorderLayout.CENTER);
		pnlGestion.add(pnlInfos, BorderLayout.SOUTH);

		this.getContentPane().setLayout(new BorderLayout());
		this.add(pnlMap, BorderLayout.CENTER);
		this.add(pnlGestion, BorderLayout.EAST);
		
		hashTourelleBouton = new HashMap<String, JButton>() ;
	
	}
	
	public void majPvJoueur(int pv){
		lblPv.setText("pv : " + pv) ;
	}
	
	public void majGoldJoueur(int gold){
		lblGold.setText("Gold : " + gold) ;
	}
	
	public void majPvAdversaire(int pvAdverseaire){
		lblPvAdversaire.setText("pv adverses : " + pvAdverseaire) ;
	}

	public void deselectionnerTourelle(){
		hashTourelleBouton.get(this.tourelleSelectionnee).setText("Acheter") ;
		this.tourelleSelectionnee = null ;
	}
	
	public String getTourelleSelectionnee(){
		return tourelleSelectionnee ;
	}

	public void clickBtnAchatTour(String typeTourelle){

		if(this.tourelleSelectionnee == typeTourelle){
			this.tourelleSelectionnee = null ;
			this.hashTourelleBouton.get(typeTourelle).setText("Acheter") ;
		}
		else{
			if(this.tourelleSelectionnee != null){
				this.hashTourelleBouton.get(this.tourelleSelectionnee).setText("Acheter") ;
			}
			this.tourelleSelectionnee = typeTourelle ;
			this.hashTourelleBouton.get(typeTourelle).setText("Annuler achat") ;
		}
	}
	
	public void selectionnerCase(JLabel caseSelectionnee){

		if(this.caseSelectionnee == caseSelectionnee){
			this.caseSelectionnee.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.caseSelectionnee = null ;
			lblInfosTourelle.setText("ok");
		}
		else{
			if(this.caseSelectionnee != null){
				this.caseSelectionnee.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			this.caseSelectionnee= caseSelectionnee ;
			this.caseSelectionnee.setBorder(BorderFactory.createLineBorder(Color.RED));
			lblInfosTourelle.setText("case selectionnée") ;
		}
	}
	
	public void definirNbMonstres(int nbMonstres){
		((JPanel)pnlOnglets.getComponentAt(0)).setLayout(new GridLayout(nbMonstres, 1)) ;
	}
	
	public void definirNbTourelles(int nbTourelles){
		((JPanel)pnlOnglets.getComponentAt(1)).setLayout(new GridLayout(nbTourelles, 1)) ;
	}
	
	public JButton ajouterTypeMonstre(String type, String informations, Dessin dessin){
		JPanel pnlMonstre = new JPanel();
		pnlMonstre.setBackground(new Color(0,45,90));
		pnlMonstre.setLayout(new BorderLayout()) ;
		pnlMonstre.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
	    JLabel InfosMonstre = new JLabel();
	    InfosMonstre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    String infos = "<html>Type : " + type + "<br>";
	    int k = 0 ;
	    infos += "Cout : " ;
	    while(informations.charAt(k) != ':'){
	    	infos += informations.charAt(k);
	    	k++ ;
	    }
    	k++ ;
	    infos += "<br>" ;
	    infos += "Income : " ;
	    while(informations.charAt(k) != ':'){
	    	infos += informations.charAt(k);
	    	k++ ;
	    }
    	k++ ;
	    infos += "<br>" ;
	    infos += "Pv : " ;
	    while(informations.charAt(k) != ':'){
	    	infos += informations.charAt(k);
	    	k++ ;
	    }
    	k++ ;
	    infos += "<br>" ;
	    infos += "MS : " ;
	    while(informations.charAt(k) != ':'){
	    	infos += informations.charAt(k);
	    	k++ ;
	    }
    	k++ ;
	    infos += "<br>" ;
	    infos += "DPS : " ;
	    while(informations.charAt(k) != ':'){
	    	infos += informations.charAt(k);
	    	k++ ;
	    }
	    infos += "</html>" ;
	    
	    InfosMonstre.setText(infos);
	    InfosMonstre.setForeground(Color.white);
	    
	    dessin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    JButton btnAchatMonstre = new JButton("acheter et envoyer") ;
	    btnAchatMonstre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    pnlMonstre.add(dessin, BorderLayout.NORTH) ;
	    pnlMonstre.add(InfosMonstre, BorderLayout.CENTER);
		pnlMonstre.add(btnAchatMonstre, BorderLayout.SOUTH);
		
		((JPanel)pnlOnglets.getComponentAt(0)).add(pnlMonstre);
		
		return btnAchatMonstre ;
	}
	
	public JButton ajouterTypeTourelle(String type, String informations, Dessin dessin){
		
		JPanel pnlTourelle = new JPanel();
		pnlTourelle.setBackground(new Color(0,45,90));
		pnlTourelle.setLayout(new BorderLayout()) ;
		pnlTourelle.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
	    JLabel InfosTourelle = new JLabel();
	    InfosTourelle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    String infos = "<html>Type : " + type + "<br>";
	    int k = 0 ;
	    infos += "Cout : " ;
	    while(informations.charAt(k) != ':'){
	    	infos += informations.charAt(k);
	    	k++ ;
	    }
    	k++ ;
	    infos += "<br>" ;
	    infos += "Portee : " ;
	    while(informations.charAt(k) != ':'){
	    	infos += informations.charAt(k);
	    	k++ ;
	    }
    	k++ ;
	    infos += "<br>" ;
	    infos += "Dommages : " ;
	    while(informations.charAt(k) != ':'){
	    	infos += informations.charAt(k);
	    	k++ ;
	    }
    	k++ ;
	    infos += "<br>" ;
	    infos += "AS : " ;
	    while(informations.charAt(k) != ':'){
	    	infos += informations.charAt(k);
	    	k++ ;
	    }
	    infos += "</html>" ;
	    
	    
	    InfosTourelle.setText(infos);
	    InfosTourelle.setForeground(Color.white);
	    
	    dessin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    JButton btnAchatTourelle = new JButton("Acheter") ;
	    btnAchatTourelle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    pnlTourelle.add(dessin, BorderLayout.NORTH) ;
	    pnlTourelle.add(InfosTourelle, BorderLayout.CENTER);
	    pnlTourelle.add(btnAchatTourelle, BorderLayout.SOUTH);
		
		((JPanel)pnlOnglets.getComponentAt(1)).add(pnlTourelle);
		
		hashTourelleBouton.put(type, btnAchatTourelle) ;
		
		return btnAchatTourelle ;
	}
	
	public void dessinerCase(Dessin dessin, Position p){
        dessin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnlMap.add(dessin);
	}
	
	public void redimensionner(){
		for(Component c : pnlMap.getComponents()){
			if(c instanceof Dessin){
				((Dessin)c).redimensionner(pnlMap.getHeight()/nbCasesHauteur, pnlMap.getWidth()/nbCasesLargeur);
			}
			
		}
	}
	
	public int getHauteurMap(){
		return pnlMap.getHeight() ;
	}
	
	public int getLargeurMap(){
		return pnlMap.getWidth() ;
	}

}