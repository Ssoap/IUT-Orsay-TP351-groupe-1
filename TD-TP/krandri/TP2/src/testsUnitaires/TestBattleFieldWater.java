package testsUnitaires ;

import static org.junit.Assert.*;

import org.junit.Assert.*;
import org.junit.Test;

import pieceWises.BattleFieldLandScape;
import pieceWises.BattleFieldRoad;
import pieceWises.BattleFieldWater;

public class TestBattleFieldWater {

	@Test
	public void testIsCompatible() {
		
		BattleFieldWater water = new BattleFieldWater(1, 2) ;
		BattleFieldLandScape landScape = new BattleFieldLandScape(3, 4) ;
		BattleFieldRoad road = new BattleFieldRoad(5, 6) ;
		
		assertFalse(water.isCompatible(landScape)) ;
		assertFalse(water.isCompatible(road)) ;
		
	}
	
	@Test
	public void testIsDestroyable() {
		
		BattleFieldWater water = new BattleFieldWater(1, 2) ;
		assertFalse(water.isDestroyable()) ;
		
	}

}
