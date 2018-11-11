package genericGraph.genericGraphTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import genericGraph.Edge;
import genericGraph.GraphAdjList;
import genericGraph.Vertex;

class GraphTestCases {
	
	GraphAdjList<Integer> graph;
	
	void setup() {
		graph = new GraphAdjList<>(false, false);
	}
	
	void setup2() {
		setup();
		graph.addVertex(new Vertex<Integer>(1));
		graph.addVertex(new Vertex<Integer>(2));
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
	
	
	

}
