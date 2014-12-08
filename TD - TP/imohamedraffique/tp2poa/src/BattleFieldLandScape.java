public class BattleFieldLandScape extends BattleFieldPieceWise {
	
	public BattleFieldLandScape(int x, int y){
		super(x, y) ;
	}
	
	public boolean isCompatible(BattleFieldPieceWise compatible){
		if(compatible.getClass() == BattleFieldRoad.class)
		{
			return true;
		}
		/*else if (compatible.getClass()==BattleFieldWater.class)
		{
			return false;
		}*/
		
		return false;
		
	}
	
	public boolean isDestroyable(){
		return true ;
	}
	
}