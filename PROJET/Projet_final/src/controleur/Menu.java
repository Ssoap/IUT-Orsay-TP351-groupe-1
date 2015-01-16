package controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Menu extends JFrame{
	public JPanel map = new JPanel();
	public JLabel fondMenu;
	public JPanel panelBoutons;
	
	JButton btnJouer;
    JButton btnQuitter;
	Font fontf = new Font("Arial", Font.PLAIN, 35);

	
	
	
	public Menu(){
		this.setTitle("TOWER DEFENSE");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fondMenu = new JLabel(new ImageIcon("menu.jpg"));
	    this.add(fondMenu, BorderLayout.CENTER);
	    panelBoutons = new JPanel();
	    this.setLayout(new GridLayout(1,1));
		this.setSize(670, 520);
		this.setVisible(true);	
		this.setLocationRelativeTo(null);
		btnJouer = new JButton("Jouer");
		btnQuitter = new JButton("Quitter");
		JPanel pb = new JPanel();
		GridLayout gr = new GridLayout(2,1);
		pb.setLayout(gr);
		gr.setVgap(20);
		
		pb.add(btnJouer);
		pb.add(btnQuitter);
		pb.setOpaque(false);
		fondMenu.setLayout(new GridLayout(1,1));
		fondMenu.add(new JLabel());
		JPanel pp = new JPanel();
		pp.setLayout(new GridLayout(3,1));
		fondMenu.add(pp);
		pp.add(new JLabel());
		pp.add(pb);
		pp.add(new JLabel());
		fondMenu.add(new JLabel());
		pp.setOpaque(false);
		btnJouer.setFont(fontf);
		btnJouer.setForeground(Color.GREEN);
		btnJouer.setBackground(new Color(94,47,0));
		
		btnQuitter.setFont(fontf);
		btnQuitter.setForeground(Color.GREEN);
		btnQuitter.setBackground(new Color(94,47,0));
		
		btnJouer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controleur m = new Controleur(Menu.this);
			}});
		
		btnQuitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.this.dispose();
			}});
	 }
	
	public static void main (String[] args){
		Menu m = new Menu();
	}
	
	
 
}
