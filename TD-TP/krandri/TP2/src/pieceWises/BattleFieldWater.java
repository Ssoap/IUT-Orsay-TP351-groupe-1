package pieceWises;

public class BattleFieldWater extends BattleFieldPieceWise {
	
	public BattleFieldWater(int x, int y){
		super(x, y) ;
	}
	
	public boolean isCompatible(BattleFieldPieceWise with){
		return !(with.getClass() == BattleFieldLandScape.class || with.getClass() == BattleFieldRoad.class) ;
	}
	
	public boolean isDestroyable(){
		return false ;
	}
	
}
