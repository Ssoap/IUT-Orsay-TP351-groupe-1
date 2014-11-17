package pieceWises;

public class BattleFieldLandScape extends BattleFieldPieceWise {
	
	public BattleFieldLandScape(int x, int y){
		super(x, y) ;
	}
	
	public boolean isCompatible(BattleFieldPieceWise with){
		return with.getClass() == BattleFieldRoad.class ;
	}
	
	public boolean isDestroyable(){
		return true ;
	}
	
}
