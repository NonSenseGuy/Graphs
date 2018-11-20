package main;

import java.util.Arrays;

import genericGraph.GraphMatrix;

public class GraphMatrixMain {
	
	private static GraphMatrix<Integer> gm;
	
	public static void main(String[] args) {
		gm = new GraphMatrix<>(6, false, true);
		for(int i = 1; i <= 6; i++) {
			gm.addVertex(i);
		}
		
		gm.addEdge(gm.getVertex(4), gm.getVertex(6), 3.0);
		gm.addEdge(gm.getVertex(5), gm.getVertex(4), 10.0);
		gm.addEdge(gm.getVertex(6), gm.getVertex(5), 5.0);
		gm.addEdge(gm.getVertex(1), gm.getVertex(6), 20);
		gm.addEdge(gm.getVertex(1), gm.getVertex(2), 2);
		gm.addEdge(gm.getVertex(1), gm.getVertex(4));
		
		System.out.println(gm);
		
		gm.floydWarshall();
		for(double[] row : gm.getDistMatrix()) {
			System.out.println(Arrays.toString(row));
		}
	}
}
