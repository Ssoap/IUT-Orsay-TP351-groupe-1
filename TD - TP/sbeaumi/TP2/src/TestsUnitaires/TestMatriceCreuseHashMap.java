package TestsUnitaires;

import static org.junit.Assert.*;
import org.junit.Test;
import Exceptions.ExceptionMatrice;
import BattleField.*;

public class TestMatriceCreuseHashMap {

	@Test
	public void testsetGet(){
		MatriceCreuseHashMap<BattleFieldPieceWise> h = new MatriceCreuseHashMap<BattleFieldPieceWise>(4,2);
		try{
			BattleFieldRoad r = new BattleFieldRoad(1, 2) ;
			h.set(1, 1, r);
			assertTrue(h.get(1, 1).equals(r)) ;
			assertNull(h.get(2, 1)) ;
		}
		catch(ExceptionMatrice e){
			fail("Depassement des bornes de la matrice") ;
		}
	}
	
	@Test
	public void testWidth()
	{
		MatriceCreuseHashMap<BattleFieldPieceWise> h = new MatriceCreuseHashMap<BattleFieldPieceWise>(4,2);
		
		assertTrue(h.weights() == 2) ;
	}
	
	@Test
	public void testHeight() {
		
		MatriceCreuseHashMap<BattleFieldPieceWise> h = new MatriceCreuseHashMap<BattleFieldPieceWise>(4,2);
		
		assertTrue(h.heights() == 4) ;
	}
	
	@Test
	public void testExists(){
		
		MatriceCreuseHashMap<BattleFieldPieceWise> h = new MatriceCreuseHashMap<BattleFieldPieceWise>(4,2);
		try{
			BattleFieldRoad r = new BattleFieldRoad(1, 2) ;
			h.set(1, 1, r);
			assertTrue(h.exists(1, 1)) ;
			assertFalse(h.exists(1, 2)) ;
		}
		catch(ExceptionMatrice e){
			fail("Depassement des bornes de la matrice") ;
		}	
	}

}