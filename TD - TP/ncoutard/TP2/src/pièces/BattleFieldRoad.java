package pièces;


public class BattleFieldRoad extends BattleFieldPieceWise{
	
	public BattleFieldRoad(int positionX, int positionY)
	{
		super(positionX, positionY);
	}
	
	public boolean isCompatible(BattleFieldPieceWise with)
	{
		Class<?> withClass = with.getClass();
		if(withClass.getName().equals("edu.iut.BattleFieldWater"))
		{
			return false;
		}
		return true;
	}

	public boolean isDestroyable()
	{
		return true;
	}

	
}
