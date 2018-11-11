package genericGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GraphAdjList<T> implements IGraph<T>{
	private int numVertices;
	private int numEdges;
	private final HashMap<Vertex<T>,Set<Edge<T>>> adjList;
	private boolean isDirected;
	private boolean isWeighted;
	
	public GraphAdjList(boolean isDirected, boolean isWeighted) {
		adjList = new HashMap<>();
		numVertices = 0;
		numEdges = 0;
	}
	
	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int numVertices){
		this.numVertices = numVertices;
	}

	public int getNumEdges() {
		return numEdges;
	}

	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}

	public HashMap<Vertex<T>, Set<Edge<T>>> getAdjList() {
		return adjList;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public boolean isWeighted() {
		return isWeighted;
	}

	public void setWeighted(boolean isWeighted) {
		this.isWeighted = isWeighted;
	}

	@Override
	public void addVertex(Vertex<T> v) throws IllegalArgumentException {
		if(!adjList.containsKey(v)) {
			this.adjList.put(v, new HashSet<Edge<T>>());
			numVertices++;
		}else {
			throw new IllegalArgumentException("Vertex alredy exists");
		}
	}
		
	@Override
	public void addEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException{
		if(adjList.containsKey(v1) && adjList.containsKey(v2)) {
			if(!isDirected) {
				adjList.get(v2).add(new Edge<T>(v2,v1, 1.0));
			}
			adjList.get(v1).add(new Edge<T>(v1,v2, 1.0));
			numEdges++;
		}else {
			throw new IllegalArgumentException();
		}
		
		
	}
	@Override
	public void addEdge(Vertex<T> v1, Vertex<T> v2, double w) throws IllegalArgumentException{
		if(!adjList.containsKey(v1) && !adjList.containsKey(v2)) {
			if(!isDirected) {
				adjList.get(v2).add(new Edge<T>(v2,v1, w));
			}
			adjList.get(v1).add(new Edge<T>(v1,v2, w));
			numEdges++;
		}else {
			throw new IllegalArgumentException();
		}
		
	}
	
	@Override
	public void removeVertex(Vertex<T> v) throws IllegalArgumentException{
		if(adjList.containsKey(v)) {
			for(Vertex<T> vertex: getVertices()) {
				for(Edge<T> edge: adjList.get(vertex)) {
					if(edge.endVertex().equals(vertex.getValue())) {
						adjList.get(vertex).remove(edge);
						return;
					}
				}
			}
		}else {
			throw new IllegalArgumentException("Vertex not found");
		}
	}
	@Override
	public void removeEdge(Vertex<T> v1, Vertex<T> v2) {
		if(adjList.containsKey(v1) && adjList.containsKey(v2)) {
			for(Edge<T> edge: adjList.get(v1)) {
				if(edge.endVertex().equals(v2)) {
					adjList.get(v1).remove(edge);
					return;
				}
			}
		}else{
			throw new IllegalArgumentException("Vertex not found");
		}
		
	}
	@Override
	public Vertex<T> getVertex(T valueVertex) throws IllegalArgumentException{
		for(Vertex<T> v: getVertices()) {
			if(v.getValue().equals(valueVertex)) {
				return v;
			}
		}
		throw new IllegalArgumentException("Vertex not found");
	}
	@Override
	public Iterable<Vertex<T>> getVertices() {
		return adjList.keySet();
	}
	@Override
	public double getWeightEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException {
		if(adjList.containsKey(v1)) {
			for(Edge<T> edge: adjList.get(v1)) {
				if(edge.endVertex().equals(v2)){
					return edge.getWeight();
				}
			}
		}
		throw new IllegalArgumentException();
	}
	@Override
	public void setWeightEdge(Vertex<T> v1, Vertex<T> v2, double w)throws IllegalArgumentException {
		if(adjList.containsKey(v1)) {
			for(Edge<T> edge: adjList.get(v1)) {
				if(edge.endVertex().equals(v2)){
					edge.setWeight(w);
					return;
				}
			}
		}
		throw new IllegalArgumentException();
	}
	
	public Edge<T> getEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException{
		for(Edge<T> edge: adjList.get(v1)) {
			if(edge.endVertex().equals(v2)) {
				return edge;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public Iterable<Edge<T>> getEdges(Vertex<T> v1) throws IllegalArgumentException{
		return adjList.get(v1);
	}
	@Override
	public int numEdges() {
		return this.numEdges;
	}
	@Override
	public int numVertices() {
		return this.numVertices;
	}
	@Override
	public void bfs(Vertex<T> startVertex) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dfs(Vertex<T> startVertex) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bellmanford(Vertex<T> starVertex) {
		// TODO Auto-generated method stub
		
	}
	
	
}
