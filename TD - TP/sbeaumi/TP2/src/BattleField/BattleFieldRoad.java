package BattleField;

/**
 * Cette classe permet de manipuler un morceau de route
 *
 */
public class BattleFieldRoad extends BattleFieldPieceWise {
	
	/**
	 * Initialise un morceau de route
	 * 
	 * @param x la position du morceau
	 * @param y la position du morceau
	 */
	public BattleFieldRoad(int x, int y) {
		super(x, y);
	}

	/**
	 * Verifie qu'un morecau de route est compatible avec le morceau en paramètres
	 * 
	 * @param with le morceau de terrain dont on verifie la compatibilité
	 * 
	 * @return vrai si le morceau n'est pas de l'eau faux sinon
	 */
	public boolean isCompatible(BattleFieldPieceWise with) {
		return with.getClass()!=BattleFieldWater.class;
	}

	/**
	 * Verifie qu'un morceau de route est destructible
	 * 
	 * @return vrai
	 */
	public boolean isDestroyable() {
		return true;
	}
	
}
