package matrices;
import java.util.HashMap ;

import pieceWises.BattleFieldPieceWise;
import exceptions.ExceptionDepassementBornes ;

/**
 * Cette classe permet de manipuler une matrice pouvant être creuse
 *
 * @param <T> Le type de données stockée dans chaque case
 */
public class BattleFieldMatrixHashMap<T> implements InterfaceMatriceCreuse<T> {
	
	private HashMap<Integer, HashMap<Integer, BattleFieldPieceWise>> battleField ;
	private int nbL ;
	private int nbC ;
	
	
	/**
	 * Cree une matrice (representee par un HashMap)
	 * 
	 * @param nbL La hauteur (nombre de ligne) de la matrice
	 * @param nbC La largeur (nombre de colonnes) de la matrice
	 */
	public BattleFieldMatrixHashMap(int nbL, int nbC){
		battleField = new HashMap<Integer, HashMap<Integer, BattleFieldPieceWise>>() ;
		this.nbC = nbC ;
		this.nbL = nbL ;
	}
	
	
	@Override
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
	public void set(int i, int j, BattleFieldPieceWise data) throws ExceptionDepassementBornes{
		
		if(i < 0 || i > nbL || j < 0 || j > nbC){
			throw new ExceptionDepassementBornes("set(i, j, data) : Depassement des bornes de la matrice") ;
		}
		
		if(battleField.containsKey(i)){
			battleField.get(i).put(j, data) ;
		}
		else{
			HashMap l = new HashMap<Integer, BattleFieldPieceWise>() ;
			l.put(j,  data) ;
			battleField.put(i, l) ;
		}
		
	}
	
	
	
	/**
	 * Recupere une donnee aux coordonness specifiees
	 * 
	 * @param i La ligne a laquelle se trouve la donnee
	 * @param j La colonne a laquelle se trouve la donnee
	 * 
	 * @return La donnee
	 */
	@Override
	public BattleFieldPieceWise get(int i, int j){
		
		if(battleField.containsKey(i)){
			return battleField.get(i).get(j) ;
		}
		else{
			return null ;
		}
		
	}
	
	
	/**
	 * Verifie si une donnee existe aux coordonnees specifiees
	 * 
	 * @return Vrai si la donnee existe
	 */
	@Override
	public boolean exists(int i, int j) {
		
		if (battleField.containsKey(i)){
			return battleField.get(i).containsKey(j) ;
		}
		else{
			return false ;
		}
	}
	
	/**
	 * Recupere la hauteur (le nombre de lignes) de la matrice
	 * 
	 * @return la hauteur
	 */
	@Override
	public int height(){
		return nbL ;
	}
	
	
	/**
	 * Recupere la largeur (le nombre de colonnes) de la matrice
	 * 
	 * @return la largeur
	 */
	@Override
	public int width(){
		return nbC ;
	}
	
}
