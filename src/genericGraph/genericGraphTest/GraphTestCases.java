package genericGraph.genericGraphTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import genericGraph.Edge;
import genericGraph.GraphAdjList;
import genericGraph.Vertex;

class GraphTestCases {
	
	GraphAdjList<Integer> graph;
	
	void setup() {
		graph = new GraphAdjList<>(false, false);
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
	
//	@Test
//	void simpleAddEdgeTest2() {
//		setupMoreVertex();
//		Vertex<Integer> v1 = graph.getVertex(1);
//		Vertex<Integer> v2 = graph.getVertex(2);
//		Vertex<Integer> v3 = graph.getVertex(6);
//		Vertex<Integer> v4 = graph.getVertex(16);
//		Vertex<Integer> v5 = graph.getVertex(26);
//		Edge<Integer> e1 = new Edge<Integer>(v1,v2,1.0);
//		Edge<Integer> e2 = new Edge<Integer>(v1,v3,1.0);
//		Edge<Integer> e3 = new Edge<Integer>(v1,v4,1.0);
//		Edge<Integer> e4 = new Edge<Integer>(v2,v4,1.0);
//		Edge<Integer> e5 = new Edge<Integer>(v5,v1,1.0);
//		graph.addEdge(v1, v2);
//		graph.addEdge(v1, v3);
//		graph.addEdge(v1, v4);
//		graph.addEdge(v2, v4);
//		graph.addEdge(v5, v1);
//		HashSet<Edge<Integer>> list = new HashSet<>();
//		list.add(e1);
//		list.add(e2);
//		list.add(e3);
//		list.add(new Edge<Integer>(v1,v5,1.0));
//		assertEquals(list, graph.getAdjList().get(v1));
//	}
	
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
	
	
	

}
