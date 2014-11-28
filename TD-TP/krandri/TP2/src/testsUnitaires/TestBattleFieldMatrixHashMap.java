package testsUnitaires;

import static org.junit.Assert.*;

import org.junit.Test;

import pieceWises.*;
import exceptions.ExceptionMatrice;
import matrices.BattleFieldMatrixHashMap;

public class TestBattleFieldMatrixHashMap {

	@Test
	public void testHeight() {
		
		BattleFieldMatrixHashMap m = new BattleFieldMatrixHashMap(3, 2) ;
		
		assertTrue(m.height() == 3) ;
		
	}
	
	@Test
	public void testWidth() {
		
		BattleFieldMatrixHashMap m = new BattleFieldMatrixHashMap(3, 2) ;
		
		assertTrue(m.width() == 2) ;
		
	}
	
	
	@Test
	public void testSetGet(){
		
		BattleFieldMatrixHashMap m = new BattleFieldMatrixHashMap(3, 2) ;
		BattleFieldWater r = new BattleFieldWater(1, 2) ;
		try{
			m.set(1, 1, r);
		}
		catch(ExceptionMatrice e){
			fail("testSetGet() : Depassement des bornes de la matrice") ;
		}
		
		assertTrue(m.get(1, 1).equals(r)) ;
		assertNull(m.get(2, 1)) ;
		
	}
	
	@Test
	public void testExists(){
		
		BattleFieldMatrixHashMap m = new BattleFieldMatrixHashMap(3, 2) ;
		try{
			m.set(1, 1, new BattleFieldWater(1, 2));
		}
		catch(ExceptionMatrice e){
			fail("testExists() : Depassement des bornes de la matrice") ;
		}
		assertTrue(m.exists(1, 1)) ;
		assertFalse(m.exists(1, 2)) ;
		
	}

}
