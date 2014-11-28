package test;

import static org.junit.Assert.*;

import org.junit.Test;

import pièces.*;

public class TestBattleFieldRoad {

	@Test
	public void testIsCompatible() {
		
		BattleFieldRoad road = new BattleFieldRoad(1, 2);
		BattleFieldLandScape landScape = new BattleFieldLandScape(3, 4);
		BattleFieldWater water = new BattleFieldWater(5, 6);
		
		assertTrue(road.isCompatible(water));
		assertTrue(road.isCompatible(landScape));
		
	}
	
	@Test
	public void testIsDestroyable(){
		
		BattleFieldRoad road = new BattleFieldRoad(1, 2);
		assertTrue(road.isDestroyable());
		
	}

}
