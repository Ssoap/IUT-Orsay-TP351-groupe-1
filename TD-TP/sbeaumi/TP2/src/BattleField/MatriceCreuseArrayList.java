package BattleField;

import java.util.ArrayList;
import Exceptions.ExceptionMatrice;

/**
 * Cette classe permet de manipuler une matrice creuse repr�sent� sous forme d'ArrayLists
 * 
 * @param <BattleFieldPieceWise> Le type des donn�es contenus dans la matrice
 */
public class MatriceCreuseArrayList<BattleFieldPieceWise> implements MatriceCreuseInterface<BattleFieldPieceWise>{

	protected ArrayList<ArrayList < BattleFieldPieceWise >> matrice;
	int hauteur, largeur;
	
		/**
		 * Initialise une matrice creuse
		 * 
		 * @param x la hauteur equivalent au nombre de lignes de la matrice
		 * @param y la largeur equivalent au nombre de colonnes de la matrice
		 */
		public MatriceCreuseArrayList(int x, int y)
		{
			hauteur=x;
			largeur=y;
			matrice= new ArrayList<ArrayList<BattleFieldPieceWise>>();
			for(int i=0 ; i<x;i++ )
			{
				matrice.add(new ArrayList<BattleFieldPieceWise>());
				for(int j=0 ; j<y;j++ )
				{
					matrice.get(i).add(null);
				}
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
		public void set(int x, int y, BattleFieldPieceWise val) throws ExceptionMatrice{
			if(x<0 || x>hauteur || y<0 || y>largeur) 
				throw new ExceptionMatrice("D�passement des bornes de la matrice");
			matrice.get(x).set(y, val);
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
		public BattleFieldPieceWise get(int x, int y)throws ExceptionMatrice{
			if(x<0 || x>hauteur || y<0 || y>largeur) 
				throw new ExceptionMatrice("D�passement des bornes de la matrice");
			return matrice.get(x).get(y);
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
		public boolean exists(int x, int y) throws ExceptionMatrice{
			if(x<0 || x>hauteur || y<0 || y>largeur) 
				throw new ExceptionMatrice("D�passement des bornes de la matrice");
			return matrice.get(x).get(y)!=null;
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
