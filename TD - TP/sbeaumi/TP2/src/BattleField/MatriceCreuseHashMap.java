package BattleField;

import java.util.HashMap;

import Exceptions.ExceptionMatrice;


/**
 * Cette classe permet de manipuler une matrice creuse repr�sent� sous forme de HashMaps
 * 
 * @param <BattleFieldPieceWise> Le type des donn�es contenus dans la matrice
 */
public class MatriceCreuseHashMap<BattleFieldPieceWise>  implements MatriceCreuseInterface<BattleFieldPieceWise>{

	protected HashMap<Integer, HashMap<Integer, BattleFieldPieceWise>> battlefield;
	int hauteur, largeur;
	
	/**
	 * Initialise une matrice creuse
	 * 
	 * @param x la hauteur equivalent au nombre de lignes de la matrice
	 * @param y la largeur equivalent au nombre de colonnes de la matrice
	 */
	public MatriceCreuseHashMap(int x, int y)
	{
		battlefield= new HashMap<Integer,HashMap<Integer, BattleFieldPieceWise>>();
		hauteur=x;
		largeur=y;
		
		
	}

	/**
	 * R�cup�re une donn�e aux cordonn�es sp�cifi�es
	 * 
	 * @param x le num�ro de ligne de la matrice
	 * @param y le num�ro de colonne de la matrice
	 * 
	 * @throws ExceptionMatrice une exception si x ou y d�passe les bornes de la matrice
	 * 
	 * @return La donn�e ou null si la case est vide
	 */
	public BattleFieldPieceWise get(int x, int y) throws ExceptionMatrice
	{
		if(x<0 || x>hauteur || y<0 || y>largeur)
			throw new ExceptionMatrice("D�passement des bornes de la matrice");
		if(exists(x,y)){
			return battlefield.get(x).get(y);
		} else {			
			return null;
		}
	}
	
	/**
	 * Modifie une donn�e aux coordonn�es sp�cifi�es
	 *
	 * @param x le num�ro de ligne de la matrice
	 * @param y le num�ro de colonne de la matrice
	 * @param val la donn�e a stocker dans la matrice
	 * 
	 * @throws ExceptionMatrice une exception si x ou y d�passe les bornes de la matrice
	 */
	public void set(int x, int y, BattleFieldPieceWise val) throws ExceptionMatrice
	{
		if(x<0 || x>hauteur || y<0 || y>largeur) 
			throw new ExceptionMatrice("D�passement des bornes de la matrice");
		if(!exists(x,y))
		{
			HashMap<Integer, BattleFieldPieceWise> b = new HashMap<Integer, BattleFieldPieceWise>();
			battlefield.put(x, b);
		}
		battlefield.get(x).put(y, val);
	}
	
	/**
	 * V�rifie si il existe une donn�e aux coordonn�es sp�cifi�es
	 * 
	 * @param x le num�ro de ligne de la matrice
	 * @param y le num�ro de colonne de la matrice
	 * 
	 * @throws ExceptionMatrice une exception si x ou y d�passe les bornes de la matrice
	 * 
	 * @return vrai si une donn�e existe faux sinon
	 */
	public boolean exists(int x, int y) throws ExceptionMatrice
	{
		if(x<0 || x>hauteur || y<0 || y>largeur) 
			throw new ExceptionMatrice("D�passement des bornes de la matrice");
		if (battlefield.containsKey(x)){
			return battlefield.get(x).containsKey(y) ;
		}
		else{
			return false ;
		}
	}
	
	/**
	 * Retourne la hauteur de la matrice
	 * 
	 * @return la hauteur
	 */
	public int heights()
	{
		return hauteur;
	}
	
	/**
	 * Retourne la largeur de la matrice
	 * 
	 * @return la largeur
	 */
	public int weights()
	{
		return largeur;
	}
	

}
