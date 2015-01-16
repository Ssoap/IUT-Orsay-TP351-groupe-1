package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;

import terrain.Position;


public class Vue extends JFrame{
	
	private int nbCasesHauteur ;
	private int nbCasesLargeur ;
	
	private JPanel pnlGestion;
	
	private JTabbedPane pnlOnglets;
	
	private JPanel pnlInfos;
	
	private JPanel pnlInfosTourelle ;
	private JLabel lblInfosTourelle ;
	private JButton btnAmeliorer ;
	
	private JPanel pnlInfosJoueur ;
	private JLabel lblPv ;
	private JLabel lblGold ;
	
	private JPanel pnlMap;
	private HashMap<Position, Dessin> cases ;

	
 	public Vue(int nbCasesHauteur, int nbCasesLargeur, int pv, int gold){
		
		super("Tower defense") ;
		
		this.nbCasesHauteur = nbCasesHauteur ;
		this.nbCasesLargeur = nbCasesLargeur ;
	    
	    pnlMap = new JPanel() ;
	    pnlMap.setLayout(new GridLayout(nbCasesHauteur, nbCasesLargeur));
	    pnlMap.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		
	    cases = new HashMap<Position, Dessin>() ;
	    
		pnlInfos = new JPanel();
		pnlInfos.setBackground(new Color(0, 0, 0, 0));
		pnlInfos.setLayout(new BorderLayout());
		
		pnlInfosTourelle = new JPanel() ;
		pnlInfosTourelle.setLayout(new BorderLayout());
		pnlInfosTourelle.setBackground(new Color(0, 50, 100));
		lblInfosTourelle = new JLabel() ;
		lblInfosTourelle.setForeground(Color.WHITE);
		lblInfosTourelle.setText("Aucune tourelle selectionnée");
		
		btnAmeliorer = new JButton("Améliorer") ;
		btnAmeliorer.setEnabled(false);
		
		pnlInfosTourelle.add(lblInfosTourelle, BorderLayout.CENTER) ;
		pnlInfosTourelle.add(btnAmeliorer, BorderLayout.SOUTH) ;
		
		pnlInfosJoueur = new JPanel() ;
		pnlInfosJoueur.setBackground(new Color(0, 50, 100));
		lblPv = new JLabel() ;
		lblPv.setForeground(Color.WHITE);
		lblPv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER) ;
		majPvJoueur(pv) ;
		lblGold = new JLabel() ;
		lblGold.setForeground(Color.WHITE);
		lblGold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER) ;
		majGoldJoueur(gold) ;
		pnlInfosJoueur.setLayout(new GridLayout(2,1)) ;
		pnlInfosJoueur.add(lblPv) ;
		pnlInfosJoueur.add(lblGold) ;
		
		pnlInfos.add(pnlInfosTourelle, BorderLayout.CENTER) ;
		pnlInfos.add(pnlInfosJoueur, BorderLayout.SOUTH) ;
		
		
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
	
	}
	
	public void majPvJoueur(int pv){
		lblPv.setText("pv : " + pv) ;
	}
	
	public void majGoldJoueur(int gold){
		lblGold.setText("Gold : " + gold) ;
	}
	
	public JButton definirNbMonstres(int nbMonstres){
		
		JLabel lbl = new JLabel("Infos monstres") ;
		lbl.setFont(new Font("Arial", Font.BOLD, 15));
		lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		JButton btnNewVague = new JButton("Prochaine vague") ;
		
		JPanel pnlMonstres = new JPanel();
		pnlMonstres.setLayout(new GridLayout(nbMonstres, 1));
		
		((JPanel)pnlOnglets.getComponentAt(0)).setLayout(new BorderLayout()) ;
		((JPanel)pnlOnglets.getComponentAt(0)).add(lbl, BorderLayout.NORTH) ;
		((JPanel)pnlOnglets.getComponentAt(0)).add(pnlMonstres, BorderLayout.CENTER) ;
		((JPanel)pnlOnglets.getComponentAt(0)).add(btnNewVague, BorderLayout.SOUTH) ;
		
		return btnNewVague ;
	}
	
	public void definirNbTourelles(int nbTourelles){
		((JPanel)pnlOnglets.getComponentAt(1)).setLayout(new GridLayout(nbTourelles, 1)) ;
	}
	
	public void ajouterTypeMonstre(String type, String informations, Dessin dessin){
		JPanel pnlMonstre = new JPanel();
		pnlMonstre.setBackground(new Color(0,45,90));
		pnlMonstre.setLayout(new BorderLayout()) ;
		pnlMonstre.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
	    JLabel InfosMonstre = new JLabel();
	    InfosMonstre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    InfosMonstre.setText(informations);
	    InfosMonstre.setForeground(Color.white);
	    
	    dessin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    dessin.setMinimumSize(new Dimension(100,50));
	    dessin.setPreferredSize(new Dimension(100,50));
	    
	    pnlMonstre.add(dessin, BorderLayout.NORTH) ;
	    pnlMonstre.add(InfosMonstre, BorderLayout.CENTER);
		
		((JPanel)((JPanel)pnlOnglets.getComponentAt(0)).getComponent(1)).add(pnlMonstre);
	}
	
	public JButton ajouterTypeTourelle(String type, String informations, Dessin dessin){
		
		JPanel pnlTourelle = new JPanel();
		pnlTourelle.setBackground(new Color(0,45,90));
		pnlTourelle.setLayout(new BorderLayout()) ;
		pnlTourelle.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
	    JLabel InfosTourelle = new JLabel();
	    InfosTourelle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    InfosTourelle.setText(informations);
	    InfosTourelle.setForeground(Color.white);
	    
	    dessin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    dessin.setMinimumSize(new Dimension(100,50));
	    dessin.setPreferredSize(new Dimension(100,50));
	    dessin.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    JButton btnAchatTourelle = new JButton("Acheter") ;
	    btnAchatTourelle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    pnlTourelle.add(dessin, BorderLayout.NORTH) ;
	    pnlTourelle.add(InfosTourelle, BorderLayout.CENTER);
	    pnlTourelle.add(btnAchatTourelle, BorderLayout.SOUTH);
		
		((JPanel)pnlOnglets.getComponentAt(1)).add(pnlTourelle);
		
		return btnAchatTourelle ;
	}
	
	public void dessinerCase(Dessin dessin, Position p){
		cases.put(p, dessin) ;
        dessin.setBorder(null);
        pnlMap.add(dessin);
	}
	
	public void redimensionner(){
		for(Component c : pnlMap.getComponents()){
			if(c instanceof Dessin){
				((Dessin)c).redimensionner(pnlMap.getHeight()/nbCasesHauteur, pnlMap.getWidth()/nbCasesLargeur);
			}
			
		}
	}
	
	public JButton getBtnAmeliorer(){
		return btnAmeliorer ;
	}
	
	public int getHauteurMap(){
		return pnlMap.getHeight() ;
	}
	
	public int getLargeurMap(){
		return pnlMap.getWidth() ;
	}
	
	public void message(String titre, String msg, int type){
		JOptionPane.showMessageDialog(null, msg, titre, type);
	}

	public void majInfosTourelle(String infos){
		lblInfosTourelle.setText(infos);
	}
	
}