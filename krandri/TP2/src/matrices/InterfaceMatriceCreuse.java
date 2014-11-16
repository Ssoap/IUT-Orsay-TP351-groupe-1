package matrices;
import pieceWises.BattleFieldPieceWise;
import exceptions.ExceptionDepassementBornes;


public interface InterfaceMatriceCreuse<T> {
	
	public void set(int numL, int numC, BattleFieldPieceWise data) throws ExceptionDepassementBornes ;
	
	public BattleFieldPieceWise get(int numL, int numC) throws ExceptionDepassementBornes ;
	
	public boolean exists(int numL, int numC) ;
	
	public int height() ;
	
	public int width() ;
	
}