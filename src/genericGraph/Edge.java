package genericGraph;

public class Edge<T> {
	private Vertex<T> v1;
	private Vertex<T> v2;
	private double w;
	
	public Edge(Vertex<T> v1, Vertex<T> v2, double w) {
		this.v1 = v1; 
		this.v2 = v2;
		this.w = w;
	}
	
	public Vertex<T> initVertex(){
		return v1;
	}
	
	public Vertex<T> endVertex(){
		return v2;
	}
	
	public double getWeight() {
		return w;
	}
	
	public void setWeight(double w) {
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "(" + v1 + "," + v2 + ")";
	}
	
}

