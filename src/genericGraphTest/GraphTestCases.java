package genericGraphTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import genericGraph.Edge;
import genericGraph.GraphAdjList;
import genericGraph.Vertex;

class GraphTestCases {
	
	GraphAdjList<Integer> graph;
	
	void setup() {
		graph = new GraphAdjList<>(false, false);
	}
	
	void setupBellmanford() {
		setupDirectedGraph();
		Vertex<Integer> v1 = new Vertex<Integer>(1);
		Vertex<Integer> v2 = new Vertex<Integer>(2);
		Vertex<Integer> v3 = new Vertex<Integer>(3);
		Vertex<Integer> v4 = new Vertex<Integer>(4);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		
		graph.addEdge(v1, v2, 10);
		graph.addEdge(v2, v3, -13);
		graph.addEdge(v2, v4, 4);
		graph.addEdge(v3, v1, 2);


	}
	
	void setupDirectedGraph() {
		graph = new GraphAdjList<>(true, false);
	}
	
	void setupDirectedWeightedGraph() {
		graph = new GraphAdjList<>(true,true);
	}
	
	void setupDirectedWeightedGraph2() {
		setupDirectedWeightedGraph();
		Vertex<Integer> v1 = new Vertex<>(1);
		Vertex<Integer> v2 = new Vertex<>(2);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addEdge(v1, v2, 5);
	}
	void setupDirectedGraph2() {
		setupDirectedGraph();
		Vertex<Integer> v1 = new Vertex<>(1);
		Vertex<Integer> v2 = new Vertex<>(2);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addEdge(v1, v2);
		
	}
	
	void setup2() {
		setup();
		graph.addVertex(new Vertex<Integer>(1));
		graph.addVertex(new Vertex<Integer>(2));
	}
	
	void setupMoreVertex() {
		setup2();
		Vertex<Integer> v1 = new Vertex<>(6);
		Vertex<Integer> v2 = new Vertex<>(16);
		Vertex<Integer> v3 = new Vertex<>(26);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addEdge(v1, v3);
		graph.addEdge(v2, v1);
		graph.addEdge(v3, v2);
		graph.addEdge(graph.getVertex(1), v3);
	}
	
	void setup3() {
		setup2();
		Vertex<Integer> v1 = graph.getVertex(1);
		Vertex<Integer> v2 = graph.getVertex(2);
		graph.addEdge(v1,v2);
	}
	
	@Test
	void simpleAddVertexTest() {
		setup();
		Vertex<Integer> v = new Vertex<Integer>(1);
		graph.addVertex(v);
		assertTrue(graph.getAdjList().keySet().contains(v));
	}
	
	@Test
	void simpleAddVertexTest2() {
		setupMoreVertex();
		assertTrue(graph.getAdjList().size() == 5);
	}
	
	@Test
	void simpleRemoveVertexTest() {
		setup3();
		Vertex<Integer> v1 = graph.getVertex(1);
		Vertex<Integer> v2 = graph.getVertex(2);
		Edge<Integer> e1 = graph.getEdge(v1, v2);
		Edge<Integer> e2 = graph.getEdge(v2, v1);
		Set<Edge<Integer>> edgesV1 = graph.getAdjList().get(v1);
		Set<Edge<Integer>> edgesV2 = graph.getAdjList().get(v2);
		graph.removeVertex(v1);
		boolean cond = edgesV1.contains(e1) || edgesV2.contains(e2);
		assertFalse(graph.getAdjList().containsKey(v1) || cond);
		
	}
	
	@Test
	void simpleAddEdgeTest() {
		setup2();
		Vertex<Integer> v1 = graph.getVertex(1);
		Vertex<Integer> v2 = graph.getVertex(2);
		graph.addEdge(v1, v2);
		Edge<Integer> e = null;
		for(Edge<Integer> edge: graph.getAdjList().get(v1)) {
			if(edge.endVertex().equals(v2)){
				e = edge;
			}
		}
		assertTrue(e.endVertex().getValue() == 2);
	}
	
	@Test
	void simpleGetEdgeTest() {
		setup3();
		Vertex<Integer> v1 = graph.getVertex(1);
		Vertex<Integer> v2 = graph.getVertex(2);
		Edge<Integer> edge = graph.getEdge(v1, v2);
		assertTrue(edge.endVertex().equals(v2) && edge.initVertex().equals(v1) && edge.getWeight() == 1.0);
	}
	
	@Test
	void simpleRemoveEdgeTest() {
		setup3();
		Vertex<Integer> v1 = graph.getVertex(1);
		Vertex<Integer> v2 = graph.getVertex(2);
		Edge<Integer> edge = graph.getEdge(v1, v2);
		graph.removeEdge(v1, v2);
	
		assertFalse(graph.getAdjList().get(v1).contains(edge));
	}
	
	@Test
	void directedAddEdgeTest() {
		setupDirectedGraph2();
		Vertex<Integer> v1 = graph.getVertex(1);
		Vertex<Integer> v2 = graph.getVertex(2);
		Edge<Integer> e = graph.getEdge(v1, v2);
		assertTrue(graph.getAdjList().get(v2).isEmpty() && e.endVertex().getValue() == 2 && e.initVertex().getValue() == 1);
	}
	
	@Test
	void directedWeightedAddEdgeTest() {
		setupDirectedWeightedGraph2();
		Vertex<Integer> v1 = graph.getVertex(1);
		Vertex<Integer> v2 = graph.getVertex(2);
		Edge<Integer> e = graph.getEdge(v1, v2);
		assertTrue(graph.getAdjList().get(v2).isEmpty() && e.endVertex().getValue() == 2 && e.initVertex().getValue() == 1 && e.getWeight() == 5);
	}
	
	@Test
	void bellmanfordTest() {
		setupBellmanford();
		assertFalse(graph.bellmanford(graph.getVertex(1)));
	}
	
	@Test
	void bellmanfordTest2() {
		setupBellmanford();
		Vertex<Integer> v = graph.getVertex(2);
		graph.removeVertex(v);
		assertTrue(graph.bellmanford(graph.getVertex(4)));
	}
	
	@Test 
	void dijkstraTest(){
		setupMoreVertex();
	}
	

}
