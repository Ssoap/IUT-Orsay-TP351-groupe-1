package pièces;

public class BattleFieldLandScape extends BattleFieldPieceWise{
	
	public BattleFieldLandScape(int positionX, int positionY)
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
