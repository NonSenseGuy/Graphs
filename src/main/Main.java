package main;

import genericGraph.GraphAdjList;
import genericGraph.GraphAdjMatrix;
import genericGraph.Vertex;

public class Main {
	
	static GraphAdjList<Integer> graph;
	static GraphAdjMatrix<Integer> graphMat;
	
	public static void main(String[] args) {
		graph = new GraphAdjList<>(false, false);
		graphMat = new GraphAdjMatrix<>(4, false);
		Vertex<Integer> v1 = new Vertex<>(1);
		Vertex<Integer> v2 = new Vertex<>(2);
		Vertex<Integer> v3 = new Vertex<>(3);
		Vertex<Integer> v4 = new Vertex<>(4);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(v4, v2);
		
		graphMat.addVertex(v1);
		graphMat.addVertex(v2);
		graphMat.addVertex(v3);
		graphMat.addVertex(v4);
		graphMat.addEdge(v1, v2);
		graphMat.addEdge(v1, v3);
		graphMat.addEdge(v4, v2);
		System.out.println(graph);
		graph.removeVertex(v2);
		System.out.println(graph);
		
		
	}
}
