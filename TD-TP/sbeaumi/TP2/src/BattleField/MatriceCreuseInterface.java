package BattleField;
import Exceptions.ExceptionMatrice;


public interface MatriceCreuseInterface<BattleFieldPieceWise> {
	
	public void set(int y, int x, BattleFieldPieceWise val) throws ExceptionMatrice;
	public BattleFieldPieceWise get(int y, int x)throws ExceptionMatrice;
	public boolean exists(int y, int x) throws ExceptionMatrice;
	public int heights();
	public int weights();
}
