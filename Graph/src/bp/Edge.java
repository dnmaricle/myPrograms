package bp;

import bp.Vertex;

public class Edge implements IEdge {
	// Instantiating vertex1 and vertex 2
	private Vertex vertex1;
	private Vertex vertex2;
	private int weight;

	public Edge(Vertex v1, Vertex v2, int pWeight) {
		vertex1 = v1;
		vertex2 = v2;
		weight = pWeight;
	}

	// Getting the value of vertex1
	public Vertex getVertex1() {
		return vertex1;
	}

	// Setting the value of vertex1
	public void setVertex1(Vertex pVertex1) {
		vertex1 = pVertex1;
	}

	// Getting the value of vertex2
	public Vertex getVertex2() {
		return vertex2;
	}

	// Setting the value of vertex2
	public void setVertex2(Vertex pVertex2) {
		vertex2 = pVertex2;
	}

	public String toString() {
		return vertex1.getID() + "-" + vertex2.getID();
	}
}