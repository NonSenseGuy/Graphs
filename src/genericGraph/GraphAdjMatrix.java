package genericGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class GraphAdjMatrix<T> implements IGraph<T> {
	
	private double[][] adjMatrix;
	private ArrayList<Vertex<T>> verticesList;
	private int numEdges;
	private int numVertices;
	private boolean isDirected;
	
	public GraphAdjMatrix(int numVertex, boolean isDirected) {
		adjMatrix = new double[numVertex][numVertex];
		for(double[] row: adjMatrix) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		numVertices = numVertex;
		verticesList = new ArrayList<>(numVertex);
		this.isDirected = isDirected;
		numEdges = 0;
	}

	@Override
	public void addVertex(Vertex<T> v)throws IllegalArgumentException {
		if(verticesList.size() < numVertices && !verticesList.contains(v)) {
			verticesList.add(v);
		}else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void addEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException{
		if(!verticesList.contains(v1) || !verticesList.contains(v2)) {
			throw new IllegalArgumentException();
		}
		int i = verticesList.indexOf(v1);
		int j = verticesList.indexOf(v2);
		adjMatrix[i][j] = 1;
		numEdges++;
		if(!isDirected) {
			adjMatrix[j][i] = 1;
		}
	}

	@Override
	public void addEdge(Vertex<T> v1, Vertex<T> v2, double w) {
		if(!verticesList.contains(v1) || !verticesList.contains(v2)) {
			throw new IllegalArgumentException();
		}
		int i = verticesList.indexOf(v1);
		int j = verticesList.indexOf(v2);
		
		adjMatrix[i][j] = w;
		numEdges++;
		if(!isDirected) {
			adjMatrix[j][i] = w;
		}
		
	}

	@Override
	public void removeEdge(Vertex<T> v1, Vertex<T> v2) {
		if(!verticesList.contains(v1) || !verticesList.contains(v2)) {
			throw new IllegalArgumentException();
		}
		int i = verticesList.indexOf(v1);
		int j = verticesList.indexOf(v2);
		
		adjMatrix[i][j] = Integer.MIN_VALUE;
		numEdges--;
		if(!isDirected) {
			adjMatrix[j][i] = Integer.MIN_VALUE;
		}
	}

	@Override
	public Vertex<T> getVertex(T valueVertex) throws IllegalArgumentException {
		for(Vertex<T> v: verticesList) {
			if(v.getValue().equals(valueVertex)) {
				return v;
			}
		}
		throw new IllegalArgumentException("Vertex not found");
	}

	@Override
	public Iterable<Vertex<T>> getVertices() {
		return verticesList;
	}

	@Override
	public double getWeightEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException {
		if(!verticesList.contains(v1) || !verticesList.contains(v2)) {
			throw new IllegalArgumentException();
		}
		int i = verticesList.indexOf(v1);
		int j = verticesList.indexOf(v2);
		return adjMatrix[i][j];
	}

	@Override
	public void setWeightEdge(Vertex<T> v1, Vertex<T> v2, double w) throws IllegalArgumentException {
		if(!verticesList.contains(v1) || !verticesList.contains(v2)) {
			throw new IllegalArgumentException();
		}
		int i = verticesList.indexOf(v1);
		int j = verticesList.indexOf(v2);
		adjMatrix[i][j] = w;
		
	}

	@Override
	public int numEdges() {
		return numEdges;
	}

	@Override
	public int numVertices() {
		return numVertices;
	}

	@Override
	public void bfs(Vertex<T> startVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bellmanford(Vertex<T> starVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVertex(Vertex<T> v) throws IllegalArgumentException{
		if(!verticesList.contains(v)) {
			throw new IllegalArgumentException("Vertex not found");
		}
		int i = verticesList.indexOf(v);
		verticesList.remove(i);
		Arrays.fill(adjMatrix[i], Integer.MIN_VALUE);
		
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

}
