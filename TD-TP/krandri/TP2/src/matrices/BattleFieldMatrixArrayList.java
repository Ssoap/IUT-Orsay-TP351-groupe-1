package matrices;
import java.util.ArrayList;

import pieceWises.BattleFieldPieceWise;
import exceptions.ExceptionMatrice ;

/**
 * Cette classe permet de manipuler une matrice pouvant être creuse
 *
 * @param <T> Le type de données stockée dans chaque case
 */
public class BattleFieldMatrixArrayList<T> implements InterfaceMatriceCreuse<T>  {
	
	private ArrayList<ArrayList<BattleFieldPieceWise>> battleField ;
	private int nbL ;
	private int nbC ;
	
	
	/**
	 * Cree une matrice (representee par un ArrayList d'ArrayList's)
	 * 
	 * @param nbL
	 * @param nbC
	 */
	public BattleFieldMatrixArrayList(int nbL, int nbC){
		battleField = new ArrayList<ArrayList<BattleFieldPieceWise>>() ;
		for(int i = 0 ; i < nbL ; i++){
			battleField.add(new ArrayList<BattleFieldPieceWise>()) ;
			for(int j = 0 ; j < nbC ; j++){
				battleField.get(i).add(null) ;
			}
		}
		this.nbL = nbL ;
		this.nbC = nbC ;
	}
	
	
	/**
	 * Ajoute a la matrice une nouvelle donnee aux coordonnees specifiees
	 * 
	 * @param i La ligne a laquelle on veut ajouter la donnee
	 * @param j La colonne a laquelle on veut ajouter la donnee
	 * @param data La donnee
	 * 
	 * @exception ExceptionDepassementBornes si il y a depassement des bornes de la matrice
	 * 
	 */
	public void set(int i, int j, BattleFieldPieceWise data) throws ExceptionMatrice {
		
		if(i < 0 || i >= nbL || j < 0 || j >= nbC){
			throw new ExceptionMatrice("Erreur") ;
		}
		battleField.get(i).set(j, data) ;
	
	}

	
	/**
	 * Recupere une donnee aux coordonness specifiees
	 * 
	 * @param i La ligne a laquelle se trouve la donnee
	 * @param j La colonne a laquelle se trouve la donnee
	 * 
	 * @exception ExceptionDepassementBornes si il y a depassement des bornes de la matrice
	 * 
	 * @return La donnee
	 */
	public BattleFieldPieceWise get(int i, int j) throws ExceptionMatrice {
		
		if(i < 0 || i >= nbL || j < 0 || j >= nbC){
			throw new ExceptionMatrice("Erreur") ;
		}
		return battleField.get(i).get(j) ;
		
	}

	
	/**
	 * Verifie si une donnee existe aux coordonnees specifiees
	 * 
	 * @return Vrai si la donnee existe
	 */
	public boolean exists(int i, int j) {
		
		return battleField.get(i).get(j) != null ;
		
	}
	
	
	/**
	 * Recupere la hauteur (le nombre de lignes) de la matrice
	 * 
	 * @return la hauteur
	 */
	public int height(){
		return nbL ;
	}
	
	
	/**
	 * Recupere la largeur (le nombre de colonnes) de la matrice
	 * 
	 * @return la largeur
	 */
	public int width(){
		return nbC ;
	}
	
	
}
