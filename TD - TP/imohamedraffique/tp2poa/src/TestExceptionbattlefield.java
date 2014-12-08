import static org.junit.Assert.*;

import org.junit.Test;


public class TestExceptionbattlefield {
	@Test
	/**
	 * Test unitaire pour les matrice d'arrayList et les matrices d'HashMaps
	 */
	public void test() {
		
		
		ClassArrayList<Integer> a = new ClassArrayList<Integer>(10, 10);
		try {
			a.set(2,2,25 );
		} catch (ExceptionMatrice e) {

			fail("J'ai recu une exception "+e);
		}
		try {
			assertTrue("erreur",a.get(2,2)==25);
		} catch (ExceptionMatrice e) {

			fail("J'ai recu une exception "+e);
		}
		
		ClassHashMap<Integer> m = new ClassHashMap<Integer>(5, 5);
		try {
			m.set(2,2,5);
		} catch (ExceptionMatrice e) {

			fail("J'ai recu une exception "+e);
		}
		try {
			assertTrue("erreur",m.get(2,2)==5);
		} catch (ExceptionMatrice e) {

			fail("J'ai recu une exception "+e);
		}
			
		
	}
	@Test
	/**
	 * Test unitaire pour la compatibilité des surfaces
	 */
public void TestUnitaireCompatible() {
		BattleFieldWater w = new BattleFieldWater(5,5);
		BattleFieldRoad r = new BattleFieldRoad(2,2);
		BattleFieldLandScape l = new BattleFieldLandScape(10,10);
		assertTrue("erreur", w.isCompatible(r)==false);
		assertTrue("erreur", l.isCompatible(r)==true);
		assertTrue("erreur", l.isCompatible(w)==false);
	}
	
	
	@Test
	/**
	 * Test unitaire pour vérifier si une surface est destructible
	 */
	public void TestUnitaireDestroyable(){
		
		BattleFieldRoad r = new BattleFieldRoad(2, 2) ;
		BattleFieldWater w = new BattleFieldWater(5,5);
		BattleFieldLandScape l = new BattleFieldLandScape(10,10);
		assertFalse("erreur",r.isDestroyable()==false); //Ceci va pas fonctionner
		assertTrue("erreur",r.isDestroyable()==true);  //Cecic va fontionner
		//assertFalse("erreur",road.isDestroyable()==true); Ceci ne va fonctionner
		assertTrue("erreur",w.isDestroyable()==false);
		assertTrue("erreur",l.isDestroyable()==true);
}
	
}

