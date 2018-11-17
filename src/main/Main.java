package main;

import genericGraph.Edge;
import genericGraph.GraphAdjList;
import genericGraph.GraphAdjMatrix;
import genericGraph.Vertex;

public class Main {
	
	static GraphAdjList<Integer> graph;
	static GraphAdjMatrix<Integer> graphMat;
	
	public static void main(String[] args) {
		graph = new GraphAdjList<>(false, false);
		graphMat = new GraphAdjMatrix<>(4, false);
	
		graph.addVertex(new Vertex<Integer>(1));
		graph.addVertex(new Vertex<Integer>(2));
//		graph.addVertex(v3);
//		graph.addVertex(v4);
//		graph.addEdge(v1, v2,10);
//		graph.addEdge(v2, v3,20);
//		graph.addEdge(v3, v4,30);
//		graph.addEdge(v4, v1,-60);
		Vertex<Integer> v1 = new Vertex<>(6);
		Vertex<Integer> v2 = new Vertex<>(16);
		Vertex<Integer> v3 = new Vertex<>(26);
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addEdge(v1, v3, 3.0);
		graph.addEdge(v2, v1, 10.0);
		graph.addEdge(v3, v2, 5.0);
		graph.addEdge(graph.getVertex(1), v3, 20);
		graph.addEdge(graph.getVertex(1), graph.getVertex(2), 2);
		graph.addEdge(graph.getVertex(1), graph.getVertex(6));
		
		graph.prim(graph.getVertex(2));
		for(Vertex<Integer> v : graph.getVertices()) {
			System.out.println("(" + v + "," + v.getPred() + ")" + " Distancia -> " + v.getD());
		}
		System.out.println("");
		
		
		System.out.println(graph);
//		
//		graphMat.addVertex(v1);
//		graphMat.addVertex(v2);
//		graphMat.addVertex(v3);
//		graphMat.addVertex(v4);
//		graphMat.addEdge(v1, v2);
//		graphMat.addEdge(v1, v3);
//		graphMat.addEdge(v4, v2);
//		System.out.println(graph);
//		graph.removeVertex(v2);
//		System.out.println(graph);
//		System.out.println(graphMat);
		
		
	}
}
