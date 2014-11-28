package matrices;
import pieceWises.BattleFieldPieceWise;
import exceptions.ExceptionMatrice;


public interface InterfaceMatriceCreuse<T> {
	
	public void set(int i, int j, BattleFieldPieceWise data) throws ExceptionMatrice ;
	
	public BattleFieldPieceWise get(int i, int j) throws ExceptionMatrice ;
	
	public boolean exists(int i, int j) ;
	
	public int height() ;
	
	public int width() ;
	
}