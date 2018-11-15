package genericGraph;

import java.util.ArrayList;
import java.util.Set;

public interface IGraph<T> {
	
	public static final int INF = 150000000;
	public void addVertex(Vertex<T> v)throws IllegalArgumentException;
	public void addEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException;
	public void addEdge(Vertex<T> v1, Vertex<T> v2, double w)throws IllegalArgumentException;
	public void removeEdge(Vertex<T> v1, Vertex<T> v2)throws IllegalArgumentException;
	public Vertex<T> getVertex(T valueVertex) throws IllegalArgumentException;
	public Iterable<Vertex<T>> getVertices();
	public double getWeightEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException;
	public void setWeightEdge(Vertex<T> v1, Vertex<T> v2, double w) throws IllegalArgumentException;
	public void bfs(Vertex<T> startVertex);
	public boolean bellmanford(Vertex<T> starVertex);
	public void removeVertex(Vertex<T> v);
	public void dfs();
	public boolean areAdjacent(Vertex<T> v1, Vertex<T> v2);
	public Set<Vertex<T>> adjacentVertices(Vertex<T> v);
	public void dijkstra(Vertex<T> s);
	public void initializeSingleSource(Vertex<T> s);
	public void relax(Vertex<T> s, Vertex<T> e);
	public Iterable<Edge<T>> getEdges();
	public int getNumVertices();
	public int getNumEdges();
	public ArrayList<Vertex<T>> vertexPath(Vertex<T> startVertex, Vertex<T> endVertex) throws IllegalArgumentException;
	public void floydwarshall();
	public void prim();
	public void kruskal();
	
	
}
