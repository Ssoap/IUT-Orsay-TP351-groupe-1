package test;

import static org.junit.Assert.*;

import org.junit.Test;

import pièces.*;

public class TestBattleFieldLandScape {
	
	@Test
	public void testIsCompatible() {
		
		BattleFieldLandScape landScape = new BattleFieldLandScape(1, 2);
		BattleFieldWater water = new BattleFieldWater(3, 4);
		BattleFieldRoad road = new BattleFieldRoad(5, 6);
		
		assertTrue(landScape.isCompatible(water));
		assertTrue(landScape.isCompatible(road));
		
	}
	
	@Test
	public void testIsDestroyable() {
		
		BattleFieldLandScape landScape = new BattleFieldLandScape(1, 2);
		assertTrue(landScape.isDestroyable());
		
	}
	
}
