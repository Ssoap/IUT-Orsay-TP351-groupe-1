package test;

import static org.junit.Assert.*;

import org.junit.Test;

import pièces.*;

public class TestBattleFieldWater {

	@Test
	public void testIsCompatible() {
		
		BattleFieldWater water = new BattleFieldWater(1, 2);
		BattleFieldLandScape landScape = new BattleFieldLandScape(3, 4);
		BattleFieldRoad road = new BattleFieldRoad(5, 6);
		
		assertTrue(water.isCompatible(landScape));
		assertTrue(water.isCompatible(road));
		
	}
	
	@Test
	public void testIsDestroyable() {
		
		BattleFieldWater water = new BattleFieldWater(1, 2);
		assertFalse(water.isDestroyable());
		
	}

}
