public class BattleFieldRoad extends BattleFieldPieceWise {
	
	public BattleFieldRoad(int x, int y){
		super(x, y) ;
	}
	
	public boolean isCompatible(BattleFieldPieceWise compatible){
		if(compatible.getClass() == BattleFieldLandScape.class)
		{
			return true;
		}
		else return false;
	}
	
	public boolean isDestroyable(){
		return true ;
	}
	
}