package TestsUnitaires;

import static org.junit.Assert.*;
import org.junit.Test;
import BattleField.*;
import Exceptions.ExceptionMatrice;

public class TestMatriceCreuseArrayList {

	@Test
	public void testsetGet(){
		MatriceCreuseArrayList<BattleFieldPieceWise> h = new MatriceCreuseArrayList<BattleFieldPieceWise>(4,2);
		try{
			BattleFieldRoad r = new BattleFieldRoad(1, 1) ;
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
		MatriceCreuseArrayList<BattleFieldPieceWise> h = new MatriceCreuseArrayList<BattleFieldPieceWise>(4,2);
		
		assertTrue(h.weights() == 2) ;
	}
	
	@Test
	public void testHeight() {
		
		MatriceCreuseArrayList<BattleFieldPieceWise> h = new MatriceCreuseArrayList<BattleFieldPieceWise>(4,2);
		
		assertTrue(h.heights() == 4) ;
	}
	
	@Test
	public void testExists(){
		
		MatriceCreuseArrayList<BattleFieldPieceWise> h = new MatriceCreuseArrayList<BattleFieldPieceWise>(4,2);
		try{
			BattleFieldRoad r = new BattleFieldRoad(1, 1) ;
			h.set(1, 1, r);
			assertTrue(h.exists(1, 1)) ;
			assertFalse(h.exists(2, 1)) ;
		}
		catch(ExceptionMatrice e){
			fail("Depassement des bornes de la matrice") ;
		}	
	}
}