package testsUnitaires;

import static org.junit.Assert.*;

import org.junit.Test;

import pieceWises.BattleFieldLandScape;
import pieceWises.BattleFieldRoad;
import pieceWises.BattleFieldWater;

public class TestBattleFieldLandScape {
	
	@Test
	public void testIsCompatible() {
		
		BattleFieldLandScape landScape = new BattleFieldLandScape(1, 2) ;
		BattleFieldWater water = new BattleFieldWater(3, 4) ;
		BattleFieldRoad road = new BattleFieldRoad(5, 6) ;
		
		assertFalse(landScape.isCompatible(water)) ;
		assertTrue(landScape.isCompatible(road)) ;
		
	}
	
	@Test
	public void testIsDestroyable() {
		
		BattleFieldLandScape landScape = new BattleFieldLandScape(1, 2) ;
		assertTrue(landScape.isDestroyable()) ;
		
	}
	
}
