package bp;

import java.util.List;

public class Vertex implements IVertex {
//Instantiating values
	private char id;
	List<Edge> edges;
	boolean wasVisited;
	boolean wasSeen;
	private int numberAway;
	
	//Constructing new vertex with ID
	public Vertex(char pID) {
		id = pID;
		wasVisited = false;
		wasSeen = false;
		numberAway = 0;
		//Adding this onto the all vertices list
		bp.Graph.allVertices.add(pID);
		//Increasing the counter
		bp.Graph.numberOfVertices++;
	}

	
	public char getID() {
		return id;
	}

	
	public void setID(char pID) {
		id = pID;
	}

	
	public List<Edge> getEdges() {
		return edges;
	}


	public void setEdges(List<Edge> pEdges) {
		edges = pEdges;
	}

	//Singular addition to an edge
	public void addEdge(Edge pEdge) {
		edges.add(pEdge);
	}

	//Singular subtraction from the edge for a specific index
	public void removeEdge(int pIndex) {
		edges.remove(pIndex);
		
	}

}
