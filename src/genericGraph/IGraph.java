package genericGraph;

import java.util.Set;

public interface IGraph<T> {
	
	public void addVertex(Vertex<T> v)throws IllegalArgumentException;
	public void addEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException;
	public void addEdge(Vertex<T> v1, Vertex<T> v2, double w)throws IllegalArgumentException;
	public void removeEdge(Vertex<T> v1, Vertex<T> v2)throws IllegalArgumentException;
	public Vertex<T> getVertex(T valueVertex) throws IllegalArgumentException;
	public Iterable<Vertex<T>> getVertices();
	public double getWeightEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException;
	public void setWeightEdge(Vertex<T> v1, Vertex<T> v2, double w) throws IllegalArgumentException;
	public int numEdges();
	public int numVertices();
	public void bfs(Vertex<T> startVertex);
	public void bellmanford(Vertex<T> starVertex);
	public void removeVertex(Vertex<T> v);
	public void dfs();
	public boolean areAdjacent(Vertex<T> v1, Vertex<T> v2);
	public Set<Vertex<T>> adjacentVertices(Vertex<T> v);
	
	
}
