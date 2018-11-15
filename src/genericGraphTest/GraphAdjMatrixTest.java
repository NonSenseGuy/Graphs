package genericGraphTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import genericGraph.GraphAdjMatrix;
import genericGraph.Vertex;

class GraphAdjMatrixTest {
	
	GraphAdjMatrix<Integer> graph;
	
	void setup() {
		graph = new GraphAdjMatrix<>(10, false);		
	}
	
	@Test
	void addTest() {
		setup();
		graph.addVertex(new Vertex<Integer>(1));
		assertTrue(graph.getVertex(1) != null);
	}

}
