package monstres;

import java.util.ArrayList;

import terrain.Case;
import terrain.Position;
import terrain.Terrain;
import utilisateurs.Adversaire;

public class MonstreAdverse extends Monstre {

	private Adversaire maitre ;
	private Position pos ; // en pixels, sur le terrain
	private ArrayList<Position> chemin ;

	
	public MonstreAdverse(int pv, int dps, int gainDestruction, Position pos){
		super() ;
		this.pv = pv ;
		this.dps = dps ;
		this.gainDestruction = gainDestruction ;
		this.pos = pos ;
		this.chemin = new ArrayList<Position>() ;
	}

	
	public void blesser(int degats){
		pv -= degats ;
		if(pv<=0){
			maitre.tuerMonstre(this) ;
		}
	}

	
	public void asservir(Adversaire maitre){
		this.maitre = maitre ;
	}
	
	
	public int getPv(){
		return pv ;
	}

	
	public Position getPos(){
		return pos ;
	}

	
	/**
	 * Renvoie le monstre le plus faible (qui a le moins de pv)
	 * Si plusieurs monstres ont le même nombre de pv minimum, en renvoie un au hasard
	 * 
	 * @param monstres
	 * @return un MonstreAdverse
	 */
	public static MonstreAdverse lePlusFaible(ArrayList<MonstreAdverse> monstres){
		
		ArrayList<MonstreAdverse> lesPlusFaibles = new ArrayList<MonstreAdverse>() ;
		
		lesPlusFaibles.add(monstres.get(0)) ;
		
		for(int i = 1 ; i < monstres.size(); i++){
			if(monstres.get(i).getPv() <= lesPlusFaibles.get(0).getPv()){
				if(monstres.get(i).getPv() < lesPlusFaibles.get(0).getPv()){
					lesPlusFaibles.clear() ;
				}
				lesPlusFaibles.add(monstres.get(i)) ;
			}
		}
		
		return lesPlusFaibles.get((int)(Math.random() * lesPlusFaibles.size())) ;
	}
	
	public void definirChemin(ArrayList<Position> chemin){
		this.chemin = chemin ;
	}
	
	public void avancer(){
		this.pos = chemin.get(0) ;
		chemin.remove(0) ;
		//System.out.println(this.pos);
	}
	
	/*
	
	public void calculerChemin(Terrain terrain){
		
	}
	
	public void avancerX(Terrain t)
	{
		int caseX;
		Case c = new Case("sol_normal");
		//attendre la moitié de la case avant de checker la tour de la case d'après
		caseX = pos.getX()-(pos.getX()%Case.getLargeur());
		caseX = caseX+Case.getLargeur();
	  
		Position p= new Position(caseX, pos.getY());
		c=t.get(p);
		Position posBase = t.getPosBase();
		
		if(pos.getX() > 0 && pos.getX() < Case.getLargeur()*t.getNbcaselargeur())
		{
			if(pos.getX() < posBase.getX())
			{
		   
				if(c.vide())
				{
					pos.setX(pos.getX()+1);
				}else
				{
					this.avancerY(t);
				}
		   
			}
			else if(pos.getX() > posBase.getX())
			{
				if(c.vide())
				{
					pos.setX(pos.getX()-1);
				}else
				{
					this.avancerY(t);
				}
			}
		  
		}
	}
	 
	public void avancerY(Terrain t)
	{
		int caseY;
		Case c = new Case("sol_normal");
		caseY=pos.getX()-(pos.getX()%c.getHauteur());
		caseY=caseY+c.getHauteur();
	  
		Position p= new Position(pos.getX(),caseY);
		c=t.get(p);
		Position posBase = t.getPosBase();

		if(pos.getY() > 0 && pos.getY() < c.getHauteur()*t.getNbcasehauteur())
		{	  
			if(pos.getY() < posBase.getY())
			{
				if(c.vide())
				{
					pos.setY(pos.getY()+1);
				}
				else
				{
					this.avancerX(t);
				}
			}
			else if(pos.getY() > posBase.getY())
			{
				if(c.vide())
				{
					pos.setY(pos.getY()-1);
				}
				else
				{
					this.avancerX(t);
				}
			}
		  
		}
	}
*/
}
