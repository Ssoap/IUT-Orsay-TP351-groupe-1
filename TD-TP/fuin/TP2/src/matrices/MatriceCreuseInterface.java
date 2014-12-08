package matrices;
import exceptions.ExceptionMatrice;
import pi�ces.BattleFieldPieceWise;

public interface MatriceCreuseInterface<T>{

	public T get(int numLigne, int numCol) throws ExceptionMatrice;
	
	public void set(int numLigne, int numCol, BattleFieldPieceWise data) throws ExceptionMatrice;
	
	public boolean exists(int numLigne, int numCol);
	
	public int width();
	
	public int height();
}
