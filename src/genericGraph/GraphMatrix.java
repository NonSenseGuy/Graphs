package genericGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphMatrix<T> implements IGraph<T>{
	
	private Map<Vertex<T>, Integer> vertices;
	private List<Vertex<T>> verticesLookUp;
	private double[][] adjMatrix;
	private int index;
	private final boolean isDirected;
	private final boolean isWeighted;
	
	public GraphMatrix(int numVertices, boolean isDirected, boolean isWeighted) {
		adjMatrix = new double[numVertices][numVertices];
		Arrays.fill(adjMatrix, INF);
		index = 0;
		vertices = new HashMap<Vertex<T>, Integer>();
		verticesLookUp = new ArrayList<Vertex<T>>();
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
	}

	
	
	public List<Vertex<T>> getVerticesLookUp() {
		return verticesLookUp;
	}



	public void setVerticesLookUp(List<Vertex<T>> verticesLookUp) {
		this.verticesLookUp = verticesLookUp;
	}



	public double[][] getAdjMatrix() {
		return adjMatrix;
	}



	public void setAdjMatrix(double[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}



	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}



	public void setVertices(Map<Vertex<T>, Integer> vertices) {
		this.vertices = vertices;
	}



	@Override
	public void addVertex(Vertex<T> v) throws IllegalArgumentException {
		if(vertices.containsKey(v)) {
			throw new IllegalArgumentException("Vertex already exists in the graph");
		}
		vertices.put(v, index);
		verticesLookUp.add(v);
		index++;
	}

	@Override
	public void addEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException {
		if(!vertices.containsKey(v1) || vertices.containsKey(v2)) {
			throw new IllegalArgumentException("Vertex not found");
		}
		int indexV1 = vertices.get(v1);
		int indexV2 = vertices.get(v2);
		adjMatrix[indexV1][indexV2] = 1;
		if(!isDirected) {
			adjMatrix[indexV2][indexV1] = 1;
		}
	}

	@Override
	public void addEdge(Vertex<T> v1, Vertex<T> v2, double w) throws IllegalArgumentException {
		if(!vertices.containsKey(v1) || !vertices.containsKey(v2)) {
			throw new IllegalArgumentException("Vertex not found");
		}
		int indexV1 = vertices.get(v1);
		int indexV2 = vertices.get(v2);
		adjMatrix[indexV1][indexV2] = w;
		if(!isDirected) {
			adjMatrix[indexV2][indexV1] = w;
		}
	}

	@Override
	public void removeEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException {
		if(!vertices.containsKey(v1) || !vertices.containsKey(v2)) {
			throw new IllegalArgumentException("Vertex not found");
		}
		
		
	}

	@Override
	public Vertex<T> getVertex(T valueVertex) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Vertex<T>> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getWeightEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWeightEdge(Vertex<T> v1, Vertex<T> v2, double w) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bfs(Vertex<T> startVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean bellmanford(Vertex<T> starVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeVertex(Vertex<T> v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dfs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean areAdjacent(Vertex<T> v1, Vertex<T> v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Vertex<T>> adjacentVertices(Vertex<T> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstra(Vertex<T> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeSingleSource(Vertex<T> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void relax(Vertex<T> s, Vertex<T> e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Edge<T>> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Vertex<T>> vertexPath(Vertex<T> startVertex, Vertex<T> endVertex) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void floydwarshall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kruskal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prim(Vertex<T> v) {
		// TODO Auto-generated method stub
		
	}

}
