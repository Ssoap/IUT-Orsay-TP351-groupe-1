package TestsUnitaires;

import static org.junit.Assert.*;

import org.junit.Test;

import BattleField.*;

public class TestBattleFieldWater {

	@Test
	public void testIsCompatible() {	
		BattleFieldWater water = new BattleFieldWater(1, 1) ;
		BattleFieldLandScape landScape = new BattleFieldLandScape(1, 2) ;
		BattleFieldRoad road = new BattleFieldRoad(1, 3) ;	
		assertFalse(water.isCompatible(landScape)) ;
		assertFalse(water.isCompatible(road)) ;		
	}
	
	@Test
	public void testIsDestroyable() {
		BattleFieldWater water = new BattleFieldWater(1, 1) ;
		assertFalse(water.isDestroyable()) ;
	}
}
