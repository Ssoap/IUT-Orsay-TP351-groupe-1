package testsUnitaires;

import static org.junit.Assert.*;
import matrices.BattleFieldMatrixArrayList;

import org.junit.Test;

import pieceWises.*;
import exceptions.ExceptionMatrice;

public class TestBattleFieldMatrixArrayList {

	@Test
	public void testHeight() {
		
		BattleFieldMatrixArrayList m = new BattleFieldMatrixArrayList(3, 2) ;
		
		assertTrue(m.height() == 3) ;
		
	}
	
	@Test
	public void testWidth() {
		
		BattleFieldMatrixArrayList m = new BattleFieldMatrixArrayList(3, 2) ;
		
		assertTrue(m.width() == 2) ;
		
	}
	
	
	@Test
	public void testSetGet(){
		
		BattleFieldMatrixArrayList m = new BattleFieldMatrixArrayList(3, 2) ;
		try{
			BattleFieldRoad r = new BattleFieldRoad(1, 2) ;
			m.set(1, 1, r);
			assertTrue(m.get(1, 1).equals(r)) ;
			assertNull(m.get(2, 1)) ;
		}
		catch(ExceptionMatrice e){
			fail("testSetGet() : Depassement des bornes de la matrice") ;
		}
		
	}
	
	@Test
	public void testExists(){
		
		BattleFieldMatrixArrayList m = new BattleFieldMatrixArrayList(3, 2) ;
		try{
			m.set(1, 1, new BattleFieldLandScape(1, 2));
		}
		catch(ExceptionMatrice e){
			fail("testExists() : Depassement des bornes de la matrice") ;
		}
		assertTrue(m.exists(1, 1)) ;
		assertFalse(m.exists(1, 0)) ;
		
	}

}
