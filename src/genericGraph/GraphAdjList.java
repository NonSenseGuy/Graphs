package genericGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GraphAdjList<T> implements IGraph<T>{
	private int numVertices;
	private int numEdges;
	private final HashMap<Vertex<T>,Set<Edge<T>>> adjList;
	private boolean isDirected;
	private boolean isWeighted;
	private Vertex<T> refVertex;
	private int time;
	
	public GraphAdjList(boolean isDirected, boolean isWeighted) {
		adjList = new HashMap<>();
		numVertices = 0;
		numEdges = 0;
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
	}
	
	public Vertex<T> getRefVertex(){
		return refVertex;
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
	
	public void addVertex(T element) {
		addVertex(new Vertex<T>(element));
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
		if(adjList.containsKey(v1) && adjList.containsKey(v2)) {
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
			for(Edge<T> e: getEdges()) {
				if(e.initVertex().getValue().equals(v.getValue()) || e.endVertex().getValue().equals(v.getValue())) {
					removeEdge(e.initVertex(), e.endVertex());
				}
			}
			adjList.remove(v);
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
		refVertex = startVertex;
		for(Vertex<T> u: getVertices()) {
			u.setColor(Vertex.WHITE);
			u.setD(Integer.MAX_VALUE);
			u.setPred(null);
		}
		startVertex.setColor(Vertex.GRAY);
		startVertex.setD(0);
		startVertex.setPred(null);
		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		while(!queue.isEmpty()) {
			Vertex<T> u = queue.poll();
			for(Edge<T> e: adjList.get(u)) {
				Vertex<T> v = e.endVertex();
				if(v.getColor() == Vertex.WHITE) {
					v.setColor(Vertex.GRAY);
					v.setD(u.getD()+1);
					v.setPred(u);
					queue.offer(v);
				}
			}
			u.setColor(Vertex.BLACK);
		}
		
	}
	@Override
	public void dfs() {
		for(Vertex<T> u: getVertices()) {
			u.setColor(Vertex.WHITE);
			u.setPred(null);
		}
		time = 0;
		for(Vertex<T> u: getVertices()) {
			if(u.getColor() == Vertex.WHITE) {
				dfsVisit(u);
			}
		}
	}
	
	public void dfsVisit(Vertex<T>u){
		time++;
		u.setD(time);
		u.setColor(Vertex.GRAY);
		for(Edge<T> e: adjList.get(u)) {
			Vertex<T> v = e.endVertex();
			if(v.getColor() == Vertex.WHITE) {
				v.setPred(u);
				dfsVisit(v);
			}
		}
		u.setColor(Vertex.BLACK);
		time++;
		u.setF(time);
	}
	
	@Override
	public boolean bellmanford(Vertex<T> startVertex) {
		refVertex = startVertex;
		initializeSingleSource(startVertex);
		for(Vertex<T> v: getVertices()) {
			for(Edge<T> edge: adjList.get(v)) {
				relax(edge.initVertex(),edge.endVertex());
			}
		}
		for(Edge<T> e: getEdges()) {
			if(e.endVertex().getD() > e.initVertex().getD() + e.getWeight()) {
				return false;
			}
		}
//		for(Vertex<T> v: getVertices()) {
//			for(Edge<T> e: adjList.get(v)) {
//				if(e.endVertex().getD() > e.initVertex().getD() + e.getWeight()) {
//					return false;
//				}
//			}
//		}
		return true;
	}
	
	public void initializeSingleSource(Vertex<T> s) {
		for(Vertex<T> v: getVertices()) {
			v.setD(Integer.MAX_VALUE);
			v.setPred(null);
		}
		s.setD(0);
	}
	
	public void relax(Vertex<T> u,Vertex<T> v) {
		double tempDistance = u.getD() + getEdge(u,v).getWeight();
		if(v.getD() > tempDistance) {
			v.setD(tempDistance);
			v.setPred(u);
		}
	}

	@Override
	public boolean areAdjacent(Vertex<T> v1, Vertex<T> v2) throws IllegalArgumentException {
		if(!adjList.containsKey(v1) || !adjList.containsKey(v2)) {
			throw new IllegalArgumentException("Vertex not found");
		}
		for(Edge<T> e: adjList.get(v1)) {
			if(e.endVertex().equals(v2)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Vertex<T>> adjacentVertices(Vertex<T> v) throws IllegalArgumentException{
		if(!adjList.containsKey(v)) {
			throw new IllegalArgumentException("Vertex not found");
		}
		Set<Vertex<T>> adjVertices = new HashSet<Vertex<T>>();
		for(Edge<T> e: adjList.get(v)) {
			adjVertices.add(e.endVertex());
		}
		return adjVertices;
	}
	
	public void djikstra(Vertex<T> s) {
		initializeSingleSource(s);
		Queue<Vertex<T>> priorityQ = new PriorityQueue<>();
		priorityQ.addAll(adjList.keySet());
		while(!priorityQ.isEmpty()) {
			Vertex<T> u = priorityQ.poll();
			for(Edge<T> e: adjList.get(u)) {
				relax(u,e.endVertex());
			}
		}
	}
	
	public Iterable<Edge<T>> getEdges(){
		ArrayList<Edge<T>> edgesList = new ArrayList<Edge<T>>();
		for(Vertex<T> v:getVertices()) {
			for(Edge<T> e: adjList.get(v)) {
				edgesList.add(e);
			}
		}
		return edgesList;
	}	
	
	@Override
	public String toString() {
		String s = "";
		for(Vertex<T> v:getVertices()) {
			s+= "Vertice " + v + "={";
			for(Edge<T> e: adjList.get(v)) {
				s+= e;
			}
			s += "}\n";
		}
		return s;
	}
	
}
