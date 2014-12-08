
public interface BattleField<T> {
	
	public T get(int numeroLigne,int numeroColonne) throws ExceptionMatrice;
	/**
	 * 
	 * @param numeroLigne
	 * @param numeroColonne
	 * @param data
	 */
	
	public void set(int numeroLigne,int numeroColonne,T data)throws ExceptionMatrice;
	/**
	 * 
	 * @param numeroLigne
	 * @param numeroColonne
	 * @return
	 * cette fontion permet de placer la valeur data dans la colonne de valeur numeroColonne
	 * et dans la ligne de valeur numeroLigne
	 */
	
	public boolean exists(int numeroLigne,int numeroColonne);
	/**
	 * 
	 * @return false si la valeur de la case est nulle 
	 */
	
	public int height();
	/**
	 * 
	 * @return la hauteur de la matrice
	 */
	
	public int width();
	/**
	 * retourne la largeur de la matrice
	 */
	
	
}
