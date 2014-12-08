package BattleField;

/**
 * Cette classe permet de manipuler un morceau d'eau
 *
 */
public class BattleFieldWater extends BattleFieldPieceWise {

	/**
	 * Initialise un moreceau d'eau
	 * 
	 * @param x la position du morceau
	 * @param y la position du morceau
	 */
	public BattleFieldWater(int x, int y) {
		super(x, y);
	}

	/**
	 * Verifie qu'un morecau d'eau est compatible avec le morceau en paramètres
	 * 
	 * @param with le morceau de terrain dont on verifie la compatibilité
	 * 
	 * @return faux si le morceau est une route ou une plaine 
	 */
	public boolean isCompatible(BattleFieldPieceWise with) {
		return with.getClass()!=BattleFieldLandScape.class && with.getClass()!=BattleFieldRoad.class;
	}

	/**
	 * Verifie qu'un morceau d'eau est destructible
	 * 
	 * @return faux
	 */
	public boolean isDestroyable() {
		return false;
	}

}
