package test;

import static org.junit.Assert.*;
import matrices.BattleFieldMatrix;
import org.junit.Test;
import pièces.*;
import exceptions.ExceptionMatrice;

public class TestMatrice {

	@Test
	public void testHeight() {
		
		BattleFieldMatrix m = new BattleFieldMatrix(3, 2);
		
		assertTrue(m.height() == 3);
		
	}
	
	@Test
	public void testWidth() {
		
		BattleFieldMatrix m = new BattleFieldMatrix(3, 2);
		
		assertTrue(m.width() == 2);
		
	}
	
	@Test
	public void testSetGet(){
		
		BattleFieldMatrix m = new BattleFieldMatrix(3, 2);
		try{
			BattleFieldRoad r = new BattleFieldRoad(1, 2);
			m.set(1, 1, r);
			assertTrue(m.get(1, 1).equals(r));
		}
		catch(ExceptionMatrice e){
			fail("testSetGet() : Depassement des bornes");
		}
		
	}
	
	@Test
	public void testExists(){
		
		BattleFieldMatrix m = new BattleFieldMatrix(3, 2);
		try{
			m.set(1, 1, new BattleFieldLandScape(1, 2));
		}
		catch(ExceptionMatrice e){
			fail("testExists() : Depassement des bornes");
		}
		assertTrue(m.exists(1, 1));
		assertFalse(m.exists(1, 0));
		
	}

}
