package main;

import java.util.Arrays;

import genericGraph.GraphMatrix;
import genericGraph.Vertex;

public class GraphMatrixMain {
	
	private static GraphMatrix<Integer> gm;
	
	public static void main(String[] args) {
		gm = new GraphMatrix<>(7, false, true);
		for(int i = 1; i <= 7; i++) {
			gm.addVertex(i);
		}
		
		gm.addEdge(gm.getVertex(4), gm.getVertex(6), 3);
		gm.addEdge(gm.getVertex(5), gm.getVertex(4), 10);
		gm.addEdge(gm.getVertex(6), gm.getVertex(5), 5);
		gm.addEdge(gm.getVertex(1), gm.getVertex(6), 20);
		gm.addEdge(gm.getVertex(1), gm.getVertex(2), 2);
		gm.addEdge(gm.getVertex(1), gm.getVertex(4));
		gm.addEdge(gm.getVertex(3), gm.getVertex(7));
		
		gm.prim(gm.getVertex(1));
		for(Vertex<Integer> v: gm.getVerticesLookUp()) {
			System.out.println(v + "<-> " + v.getPred());
		}
		
		gm.floydWarshall();
		for(int[] row : gm.getDistMatrix()) {
			System.out.println(Arrays.toString(row));
		}
	}
}
