package pieceWises;

public class BattleFieldRoad extends BattleFieldPieceWise {
	
	public BattleFieldRoad(int x, int y){
		super(x, y) ;
	}
	
	public boolean isCompatible(BattleFieldPieceWise with){
		return with.getClass() == BattleFieldLandScape.class || with.getClass() == BattleFieldRoad.class ;
	}
	
	public boolean isDestroyable(){
		return true ;
	}
	
}
