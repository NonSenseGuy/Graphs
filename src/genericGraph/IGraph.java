package genericGraph;


public interface IGraph<T> {
	
	public void addVertex(Vertex<T> v);
	public void addEdge(Vertex<T> v1, Vertex<T> v2);
	public void addEdge(Vertex<T> v1, Vertex<T> v2, double w);
	public void removeEdge(Vertex<T> v1, Vertex<T> v2);
	public Vertex<T> getVertex(T valueVertex);
	public Iterable<Vertex<T>> getVertices();
	public double getWeightEdge(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException;
	public void setWeightEdge(Vertex<T> v1, Vertex<T> v2, double w) throws IllegalArgumentException;
	public int numEdges();
	public int numVertices();
	public void bfs(Vertex<T> startVertex);
	public void dfs(Vertex<T> startVertex);
	public void bellmanford(Vertex<T> starVertex);
	void removeVertex(Vertex<T> v);
	
	
}
