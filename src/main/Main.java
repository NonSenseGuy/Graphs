package main;



import genericGraph.GraphAdjList;
import genericGraph.Vertex;

public class Main {
	
	static GraphAdjList<Integer> graph;
	
	public static void main(String[] args) {
		graph = new GraphAdjList<>(false, true);
	
//		graph.addVertex(new Vertex<Integer>(1));
//		graph.addVertex(new Vertex<Integer>(2));
//		graph.addVertex(v3);
//		graph.addVertex(v4);
//		graph.addEdge(v1, v2,10);
//		graph.addEdge(v2, v3,20);
//		graph.addEdge(v3, v4,30);
//		graph.addEdge(v4, v1,-60);
		Vertex<Integer> v1 = new Vertex<>(0);
		Vertex<Integer> v2 = new Vertex<>(1);
		Vertex<Integer> v3 = new Vertex<>(2);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addEdge(v1, v2, 10);
		graph.addEdge(v2, v3, 20);
		graph.addEdge(v3, v2, 30);
		
		graph.prim(v1);
		for(Vertex<Integer> v: graph.getVertices()){
			System.out.println(v.getPred());
		}
		
//		graph.addVertex(v1);
//		graph.addVertex(v2);
//		graph.addVertex(v3);
//		graph.addEdge(v1, v3, 3.0);
//		graph.addEdge(v2, v1, 10.0);
//		graph.addEdge(v3, v2, 5.0);
//		graph.addEdge(graph.getVertex(1), v3, 20);
//		graph.addEdge(graph.getVertex(1), graph.getVertex(2), 2);
//		graph.addEdge(graph.getVertex(1), graph.getVertex(6));
	
		
		
		
//		ArrayList<Edge<Integer>> arr = graph.kruskal();
//		for(Edge<Integer> e : arr) {
//			System.out.println("(" + e + "," + e.getWeight() + ")");
//		}
//		System.out.println("");
//		
//		double[][] matrix = graph.getWeightsMatrix();
//		for(int i = 0; i < graph.vertices().size(); i++) {
//			System.out.println(graph.vertices().get(i));
//		}
//		
//		matrix = graph.floydWarshall();
//		for(double[] row: matrix) {
//			System.out.println(Arrays.toString(row));
//		}
//		

		
		
	}
}
