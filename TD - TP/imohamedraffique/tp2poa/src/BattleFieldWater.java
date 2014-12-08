public class BattleFieldWater extends BattleFieldPieceWise {
	
	public BattleFieldWater(int x, int y){
		super(x, y) ;
	}
	
	public boolean isCompatible(BattleFieldPieceWise compatible){
		if(compatible.getClass() == BattleFieldLandScape.class || compatible.getClass() == BattleFieldRoad.class)
		{
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean isDestroyable(){
		return false ;
	}
	
}