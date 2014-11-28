package TestsUnitaires;

import static org.junit.Assert.*;
import BattleField.*;

import org.junit.Test;

public class TestBattleFieldRoad {

	@Test
	public void testIsCompatible() {	
		BattleFieldWater water = new BattleFieldWater(1, 1) ;
		BattleFieldLandScape landScape = new BattleFieldLandScape(1, 2) ;
		BattleFieldRoad road = new BattleFieldRoad(1, 3) ;	
		assertFalse(road.isCompatible(water)) ;
		assertTrue(road.isCompatible(landScape)) ;		
	}
	
	@Test
	public void testIsDestroyable() {
		BattleFieldRoad road = new BattleFieldRoad(1, 1) ;
		assertTrue(road.isDestroyable()) ;
	}

}
