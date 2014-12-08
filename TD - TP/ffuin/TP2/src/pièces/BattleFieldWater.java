package pièces;

public class BattleFieldWater extends BattleFieldPieceWise{
	
	public BattleFieldWater(int positionX, int positionY)
	{
		super(positionX, positionY);
	}
	
	public boolean isCompatible(BattleFieldPieceWise with)
	{
		Class<?> withClass = with.getClass();
		if(withClass.getName().equals("edu.iut.BattleFieldRoad"))
		{
			return false;
		}
		if(withClass.getName().equals("edu.iut.BattleFieldLandScape"))
		{
			return false;
		}
		return true;
	}

	public boolean isDestroyable()
	{
		return false;
	}

	
}
