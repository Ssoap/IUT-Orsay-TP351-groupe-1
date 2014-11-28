package TestsUnitaires;

import static org.junit.Assert.*;

import org.junit.Test;

import BattleField.*;

public class TestBattleFieldLandScape {

	@Test
	public void testIsCompatible() {	
		BattleFieldWater water = new BattleFieldWater(1, 1) ;
		BattleFieldLandScape landScape = new BattleFieldLandScape(1, 2) ;
		BattleFieldRoad road = new BattleFieldRoad(1, 3) ;	
		assertFalse(landScape.isCompatible(water)) ;
		assertTrue(landScape.isCompatible(road)) ;		
	}
	
	@Test
	public void testIsDestroyable() {
		BattleFieldLandScape landScape = new BattleFieldLandScape(1, 1) ;
		assertTrue(landScape.isDestroyable()) ;
	}

}
