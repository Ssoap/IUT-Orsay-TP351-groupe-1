package dijkstra;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import terrain.Position;

public class TestDijkstraAlgorithm {

	private List<Position> sommets;
	private List<Arc> arcs;
	
	@Test
	public void testExcute() {
		sommets = new ArrayList<Position>();
		arcs = new ArrayList<Arc>();
		
		for (int i = 0; i < 11; i++) {
			sommets.add(new Position(i, i));
		}
		
		addLane("Arc_0", 0, 1, 85);
		addLane("Arc_1", 0, 2, 217);
		addLane("Arc_2", 0, 4, 173);
		addLane("Arc_3", 2, 6, 186);
		addLane("Arc_4", 2, 7, 103);
		addLane("Arc_5", 3, 7, 183);
		addLane("Arc_6", 5, 8, 250);
		addLane("Arc_7", 8, 9, 84);
		addLane("Arc_8", 7, 9, 167);
		addLane("Arc_9", 4, 9, 502);
		addLane("Arc_10", 9, 10, 40);
		addLane("Arc_11", 1, 10, 600);
		
		// Lets check from location Loc_1 to Loc_10
		Graphe graph = new Graphe(sommets, arcs);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(sommets.get(0));
		ArrayList<Position> chemin = dijkstra.getPath(sommets.get(10));
		    
		assertNotNull(chemin);
		assertTrue(chemin.size() > 0);
		    
		for (Position sommet : chemin) {
			System.out.println(sommet);
		}
	
	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo, int poids) {
		Arc lane = new Arc(laneId, sommets.get(sourceLocNo), sommets.get(destLocNo), poids);
		arcs.add(lane);
	}
}