package bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

import bp.Vertex;

public class Graph implements IGraph, IGraph2 {
	List<Edge> edges = new ArrayList<>();
	List<Vertex> vertices = new ArrayList<>();
	public static int numberOfVertices = 0;
	private final int MAX_VERTICES = 26;
	int[][] adjacencyMatrix = new int[MAX_VERTICES + 1][MAX_VERTICES + 1];
	private char[] adjacentVertices = new char[MAX_VERTICES];
	private char[] visitedVertices = new char[MAX_VERTICES];
	public static ArrayList allVertices = new ArrayList();
	private int visitedVerticesLength = 0;
	public char[] visitedVerticesCompare = new char[MAX_VERTICES];
	private int visitedVerticesCompareLength = 0;
	public char[] shortPath = new char[MAX_VERTICES];
	private int bestWeight = 0;

	public Graph() {
		for (int i = 1; i <= MAX_VERTICES; i++) {
			adjacencyMatrix[i][i] = 0;
		}
	}

	public Vertex getVertexByID(char pID) {
		for (Vertex v : vertices) {
			if (v.getID() == pID) {
				return v;
			}
		}
		return null;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> pEdges) {
		edges = pEdges;
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertex> pVertices) {
		vertices = pVertices;
	}

	public void addEdge(Edge pEdge) {
		// Insert the edge into the graph
		edges.add(pEdge);
		// Connect new edge to vertex1
		vertices.add(pEdge.getVertex1());
		// Connect new edge to vertex2
		vertices.add(pEdge.getVertex2());

		// Add new vertices that are adjacent in the
		// adjacency matrix
		//Should there already be an edge there, increase the number of the edge
		if (adjacencyMatrix[convertCharToNum(pEdge.getVertex1().getID())][convertCharToNum(pEdge.getVertex2().getID())] >= 1) {
			int numberOfEdges = adjacencyMatrix[convertCharToNum(pEdge.getVertex1().getID())][convertCharToNum(pEdge.getVertex2().getID())];
			numberOfEdges++;
			adjacencyMatrix[convertCharToNum(pEdge.getVertex1().getID())][convertCharToNum(pEdge.getVertex2().getID())] = numberOfEdges;
			
			//No current edge exists between the two vertices? Add the first one
		} else {
			adjacencyMatrix[convertCharToNum(pEdge.getVertex1().getID())][convertCharToNum(pEdge
					.getVertex2().getID())] = 1;
			adjacencyMatrix[convertCharToNum(pEdge.getVertex2().getID())][convertCharToNum(pEdge
					.getVertex1().getID())] = 1;
		}
	}

	public void removeEdge(int pIndex) {
		if (adjacencyMatrix[convertCharToNum(edges.get(pIndex).getVertex1().getID())][convertCharToNum(edges
				.get(pIndex).getVertex2().getID())] >= 1) {
			int numberOfEdges = adjacencyMatrix[convertCharToNum(edges.get(pIndex).getVertex1().getID())][convertCharToNum(edges.get(pIndex).getVertex2().getID())];
			numberOfEdges--;
			 adjacencyMatrix[convertCharToNum(edges.get(pIndex).getVertex1().getID())][convertCharToNum(edges.get(pIndex).getVertex2().getID())] = numberOfEdges;
		} else {
			adjacencyMatrix[convertCharToNum(edges.get(pIndex).getVertex1().getID())][convertCharToNum(edges
					.get(pIndex).getVertex2().getID())] = 0;
			adjacencyMatrix[convertCharToNum(edges.get(pIndex).getVertex2().getID())][convertCharToNum(edges
					.get(pIndex).getVertex1().getID())] = 0;
			// Take away the edge that user wants to remove
			edges.remove(pIndex);
		}
	}

	public void setVisited(char pVertex) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getID() == pVertex) {
				vertices.get(i).wasVisited = true;
			}
		}
	}

	public void setUnvisited(char pVertex) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getID() == pVertex) {
				vertices.get(i).wasVisited = false;
			}
		}
	}
	
	public void setSeen(char pVertex) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getID() == pVertex) {
				vertices.get(i).wasSeen = true;
			}
		}
	}
	
	public void setUnseen(char pVertex) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getID() == pVertex) {
				vertices.get(i).wasSeen = false;
			}
		}
	}

	public boolean hasVisited(char pVertex) {

		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getID() == pVertex
					&& vertices.get(i).wasVisited == true) {
				return true;
			}
		}
		return false;
	}
	public boolean hasSeen(char pVertex) {

		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getID() == pVertex
					&& vertices.get(i).wasSeen == true) {
				return true;
			}
		}
		return false;
	}

	// Thanks to:
	// http://stackoverflow.com/questions/10813154/converting-number-to-letter
	// for teaching me how to do this!
	// This converts numbers to their corresponding "alphabet number"
	public String convertNumToChar(int i) {
		return i > 0 && i < 27 ? String.valueOf((char) (i + 'A' - 1)) : null;
	}

	// Thanks to:
	// http://stackoverflow.com/questions/15027231/java-how-to-convert-letters-in-a-string-to-an-number
	// for teaching me how to do this!
	public int convertCharToNum(char c) {
		c = Character.toLowerCase(c);
		return c - 'a' + 1;
	}

	public void addVertex(Vertex pVertex) {
		// Adding the vertex to the graph
		vertices.add(pVertex);
		// Counting the number of vertices we have
		numberOfVertices++;
		allVertices.add(pVertex.getID());

	}

	public void removeVertex(int pIndex) {
		int vertexToRemove = 0;
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(pIndex).getID() == convertNumToChar(
					adjacencyMatrix[i][0]).charAt(0)) {
				vertexToRemove = i;
			}
		}
		// Resetting adjacency matrix
		if (vertexToRemove != 0) {
			for (int i = 1; i <= MAX_VERTICES; i++) {
				adjacencyMatrix[vertexToRemove][i] = 0;
				adjacencyMatrix[i][vertexToRemove] = 0;
			}
			allVertices.remove(convertNumToChar(vertexToRemove));
		} else {
			for (int i = 1; i <= MAX_VERTICES; i++) {
				adjacencyMatrix[convertCharToNum(vertices.get(i).getID())][i] = 0;
				adjacencyMatrix[i][convertCharToNum(vertices.get(i).getID())] = 0;
			}
			allVertices.remove(pIndex);
		}
		vertices.remove(pIndex);
	}

	/*
	 * A graph is connected if there is at least one path from every vertex to
	 * every other vertex.
	 * 
	 * @see bp.IGraph#isConnected()
	 */
	public boolean isConnected() {
		int visitedVerticesCompareLength = 0;
		int visitedCompareMyLength = visitedVerticesCompare.length;
		visitedVerticesCompare = new char[visitedCompareMyLength];
		int myLengthForMyAdjacentVertices = adjacentVertices.length;
		adjacentVertices = new char[myLengthForMyAdjacentVertices];
		// Check to see if the graph is empty
		if (vertices.isEmpty()) {
			return true;
		} else {
			// Starting at the first vertex
			visitedVertices[visitedVerticesLength] = vertices.get(0).getID();
			visitedVerticesLength++;
			vertices.get(0).wasVisited = true;

			// Loop as long as we still have a path to follow
			while (visitedVerticesLength != 0) {
				for (int i = 0; i < MAX_VERTICES; i++) {
					// Getting all vertices adjacent to current point
					if (visitedVertices[i] != 0) {
						adjacentVertices = getAdjacentVertices(visitedVertices[visitedVerticesLength - 1]);
					}
					// Check to see if we're at an empty spot
					if (visitedVertices[i] == 0) {
						// Put into comparison array
						visitedVerticesCompare[visitedVerticesCompareLength] = visitedVertices[visitedVerticesLength - 1];
						visitedVerticesCompareLength++;
						// Push off the stack
						visitedVertices[visitedVerticesLength - 1] = 0;
						visitedVerticesLength--;
						break;
					} else
						// Iterate through each potential adjacent vertices
						for (int j = 0; j < adjacentVertices.length; j++) {
							if (!hasVisited(adjacentVertices[j])
									&& adjacentVertices[j] != 0) {
								// Put this onto the stack!
								visitedVertices[visitedVerticesLength] = adjacentVertices[j];
								visitedVerticesLength++;
								setVisited(adjacentVertices[j]);
								break;

							}
						}
				}
			}

			// Reset all vertices to not yet visited!
			for (int k = 1; k < MAX_VERTICES; k++) {
				setUnvisited(convertNumToChar(k).charAt(0));
			}
			// Thanks to:
			// http://stackoverflow.com/questions/15590675/converting-char-array-to-list-in-java
			List<char[]> visitedVerticesCompareList = Arrays
					.asList(visitedVerticesCompare);

			ArrayList<Character> listC = new ArrayList<Character>();
			for (char c : visitedVerticesCompare) {
				if (c != 0) {
					listC.add(c);
				}
			}

			// Removing all duplicate entries in listC
			HashSet comparingVertex = new HashSet();
			comparingVertex.addAll(listC);
			listC.clear();
			listC.addAll(comparingVertex);

			Collections.sort(listC);
			Collections.sort(allVertices);
			return allVertices.equals(listC);
		}
	}

	public boolean isAdjacent(char pVertex1ID, char pVertex2ID) {
		// Should there be no vertices, automatically return false
		if (vertices.isEmpty() || edges.isEmpty()) {
			return false;
		} else {
			// Referencing adjacency matrix to see if corresponding vertex is
			// adjacent
			if (adjacencyMatrix[convertCharToNum(pVertex1ID)][convertCharToNum(pVertex2ID)] >= 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	// Returns a vertex adjacent to pVertexID
	public char[] getAdjacentVertices(char pVertexID) {

		// Clearing out previous lists of adjacent vertices
		int charSize = adjacentVertices.length;
		adjacentVertices = new char[charSize];

		int positionInCharArray = 0;
		for (int i = 1; i <= MAX_VERTICES; i++) {
			if (adjacencyMatrix[convertCharToNum(pVertexID)][i] >= 1) {
				adjacentVertices[positionInCharArray] = convertNumToChar(i)
						.charAt(0);
				positionInCharArray++;
			}
		}

		return adjacentVertices;
	}

	
	public char[] DepthFirstSearch() {
		visitedVerticesLength = 0;
		int visitedVerticesCompareLength = 0;
		int visitedCompareMyLength = visitedVerticesCompare.length;
		visitedVerticesCompare = new char[visitedCompareMyLength];
		int myLengthForMyAdjacentVertices = adjacentVertices.length;
		adjacentVertices = new char[myLengthForMyAdjacentVertices];
		// Check to see if the graph is empty
		if (vertices.isEmpty()) {
			for (int k = 0; k < MAX_VERTICES ; k++) {
				visitedVertices[k] = 0;
			}
			return visitedVertices;
		} else {
			// Starting at the first vertex
			visitedVertices[visitedVerticesLength++] = vertices.get(0).getID();
			visitedVerticesCompare[visitedVerticesCompareLength++] = visitedVertices[visitedVerticesLength - 1];
			vertices.get(0).wasVisited = true;

			// Loop as long as we still have a path to follow
			while (visitedVerticesLength != 0) {
				for (int i = 0; i < MAX_VERTICES; i++) {
					// Getting all vertices adjacent to current point
					if (visitedVertices[i] != 0) {
						adjacentVertices = getAdjacentVertices(visitedVertices[visitedVerticesLength - 1]);
					}
					// Check to see if we're at an empty spot
					if (visitedVertices[i] == 0) {
						visitedVertices[visitedVerticesLength - 1] = 0;
						visitedVerticesLength--;
						break;
					} else {
						// Iterate through each potential adjacent vertices
						for (int j = 0; j < adjacentVertices.length; j++) {
							if (!hasVisited(adjacentVertices[j])
									&& adjacentVertices[j] != 0) {
								// Put this onto the stack!
								visitedVertices[visitedVerticesLength++] = adjacentVertices[j];
								setVisited(adjacentVertices[j]);

								// We found a new one? Put it onto the "stack"
								visitedVerticesCompare[visitedVerticesCompareLength++] = adjacentVertices[j];
								break;

							}
						}
					}
				}
			}
			// Reset all vertices to not yet visited!
			for (int k = 1; k < MAX_VERTICES; k++) {
				setUnvisited(convertNumToChar(k).charAt(0));
			}
			return visitedVerticesCompare;
		}
	}

	
	public char[] BreadthFirstSearch() {
		visitedVerticesLength = 0;
		int visitedVerticesCompareLength = 0;
		int visitedCompareMyLength = visitedVerticesCompare.length;
		visitedVerticesCompare = new char[visitedCompareMyLength];
		int myLengthForMyAdjacentVertices = adjacentVertices.length;
		adjacentVertices = new char[myLengthForMyAdjacentVertices];
		// Should this graph not contain anything, no need to search it!
		if (vertices.isEmpty()) {
			return null;
		} else {
			// Starting at the first vertex
			visitedVertices[visitedVerticesLength++] = vertices.get(0).getID();
			// Adding this vertex onto my answer array
			visitedVerticesCompare[visitedVerticesCompareLength++] = visitedVertices[visitedVerticesLength - 1];
			// Mark first vertex as visited
			vertices.get(0).wasVisited = true;
			// Mark first vertex as seen
			vertices.get(0).wasSeen = true;
			// Let's loop through this...until there's nothing else adjacent
			// to the next vertex
			while (visitedVerticesLength != 0) {
				// Iterating through each potential vertex that's adjacent
				for (int i = 0; i < MAX_VERTICES; i++) {
					// Getting all vertices adjacent to current point
					if (visitedVertices[i] != 0) {
						adjacentVertices = getAdjacentVertices(visitedVertices[visitedVerticesLength - 1]);
						// Throw these into our answer array as well!
						
						
						
						for (int j = 0; j < adjacentVertices.length; j++) {
							if (hasSeen(adjacentVertices[j]) == false
									&& adjacentVertices[j] != 0) {
								visitedVerticesCompare[visitedVerticesCompareLength++] = adjacentVertices[j];
								// Set the current vertex to seen
								setSeen(adjacentVertices[j]);
							}
						}
					}
					// Check to see if we're at an empty spot
					if (visitedVertices[i] == 0) {
						// Push off the stack
						visitedVertices[visitedVerticesLength - 1] = 0;
						visitedVerticesLength--;
						break;
					} else {
						// Iterate through each potential adjacent vertices
						for (int j = 0; j < adjacentVertices.length; j++) {
							if (!hasVisited(adjacentVertices[j])
									&& adjacentVertices[j] != 0) {
								// Put this onto the stack!
								visitedVertices[visitedVerticesLength++] = adjacentVertices[j];
								setVisited(adjacentVertices[j]);
								break;
							}

						}
					}
				}
			}
			// Reset all vertices to not yet visited!
			for (int k = 1; k < MAX_VERTICES; k++) {
				setUnvisited(convertNumToChar(k).charAt(0));
			}
			// Reset all vertices to not yet seen!
			for (int k = 1; k < MAX_VERTICES; k++) {
				setUnseen(convertNumToChar(k).charAt(0));
			}
			return visitedVerticesCompare;
		}
	}

	//Optional
	public char[] HamiltonianCycle(char pVertexID) {
		// TODO Auto-generated method stub
		return null;
	}

	//Optional
	public char[] HamiltonianPath(char pVertex1ID, char pVertex2ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] StrongEulerCycle(char pVertexID) {
		int degreeOfVertices = 0;
		char[] potentialVertices = new char[MAX_VERTICES];
		int numberOfPotentialVertices = 0;
		//Check to see if it's connected...if it's not, don't
		//worry about finding an euler cycle!
		if (isConnected()) {
			if (hasStrongEulerCycle('A')) {
				visitedVerticesLength = 0;
				int visitedVerticesCompareLength = 0;
				int visitedCompareMyLength = visitedVerticesCompare.length;
				visitedVerticesCompare = new char[visitedCompareMyLength];
				int myLengthForMyAdjacentVertices = adjacentVertices.length;
				adjacentVertices = new char[myLengthForMyAdjacentVertices];
				// Check to see if the graph is empty
				if (vertices.isEmpty()) {
					return null;
				} else {
					// Starting at the first vertex (the one the user passed in)
					visitedVertices[visitedVerticesLength++] = pVertexID;
					visitedVerticesCompare[visitedVerticesCompareLength++] = visitedVertices[visitedVerticesLength - 1];
					setVisited(pVertexID);

					// Loop as long as we still have a path to follow
					while (visitedVerticesLength != 0) {
						for (int i = 0; i < MAX_VERTICES; i++) {
							// Getting all vertices adjacent to current point
							if (visitedVertices[i] != 0) {
								adjacentVertices = getAdjacentVertices(visitedVertices[visitedVerticesLength - 1]);
							}
							// Check to see if we're at an empty spot
							if (visitedVertices[i] == 0) {
								visitedVertices[visitedVerticesLength - 1] = 0;
								visitedVerticesLength--;
								break;
							} else {
								// Iterate through each potential adjacent vertices
								for (int j = 0; j < adjacentVertices.length; j++) {
									if (!hasVisited(adjacentVertices[j])
											&& adjacentVertices[j] != 0) {
										// Put this onto the stack!
										visitedVertices[visitedVerticesLength++] = adjacentVertices[j];
										setVisited(adjacentVertices[j]);

										// We found a new one? Put it onto the "stack"
										visitedVerticesCompare[visitedVerticesCompareLength++] = adjacentVertices[j];
										break;

									}
								}
							}
						}
					}
					// Reset all vertices to not yet visited!
					for (int k = 1; k < MAX_VERTICES; k++) {
						setUnvisited(convertNumToChar(k).charAt(0));
					}
					visitedVerticesCompare[visitedVerticesCompareLength++] = pVertexID;
					return visitedVerticesCompare;
				}
			} else {
				System.out.println("No strong Euler Cycle exists.");
				for (int j = 0; j < numberOfVertices; j++) {
					visitedVerticesCompare[j] = 0;
				}
				return visitedVerticesCompare;
			}
		} else {
			System.out.println("Graph is not connected. Thus, no Euler Eycle exists.");
			for (int k = 0; k < numberOfVertices; k++) {
				visitedVerticesCompare[k] = 0;
			}
			return visitedVerticesCompare;
		}
	}

	@Override
	public boolean hasStrongEulerCycle(char pVertexID) {
		int degreeOfVertices = 0;
		boolean isConnected = false;
		// Check to see if isConnected()
		if (isConnected()) {
			isConnected = true;
			for (int j = 0; j < allVertices.size(); j++) {
				// Getting the next vertex in the graph
				char vertexID = allVertices.get(j).toString().charAt(0);
				// Now iterate through each edge that is connected to this
				// vertex
				for (int k = 1; k <= allVertices.size(); k++) {
					// Check to see if current vertex is connected to vertexID
					// If so, increase the degree of the edge
					if (adjacencyMatrix[convertCharToNum(vertexID)][k] == 1) {
						degreeOfVertices++;
					}
				}
				if (degreeOfVertices % 2 == 0) {
					degreeOfVertices = 0;
				} else {
					return false;
				}
			}
		}
		// If survived above and is connected...return true
		if (isConnected) {
			// Meets both conditions? Return true
			return true;
		} else {
			// Not connected? Return false
			return false;
		}
	}
	private char[] getShortPathHelper(char[] pPath, int pWeight,  char current, char goal) {
		ArrayList myCurrentPath = new ArrayList();
		int pathLength = pPath.length;
		int currentWeight = pWeight;
		char[] path = new char [pPath.length];
		
		for (int l = 0; l < path.length; l++) {
			path[l] = pPath[l];
		}
		//Clearing adjacentVertices
		for (int i = 0; i < MAX_VERTICES; i++) {
			adjacentVertices[i] = 0;
		}
		//Scanning all adjacent vertices
		for (int j = 0; j < MAX_VERTICES; j++) {
			if (getAdjacentVertices(current).toString().charAt(j) == 0) {
				break;
			} else {
				adjacentVertices[j] = getAdjacentVertices(current).toString().charAt(j);
			}
		}
		for (int h = 0; h < path.length; h++) {
			myCurrentPath.add(path[h]);
		}
		for (int k = 0; k < adjacentVertices.length; k++) {
			if (path[path.length - 1] == adjacentVertices[k]) {
				//Continue...do nothing...yes, I just did this
				continue;
			} else if (myCurrentPath.contains(adjacentVertices[k])) {
				path[pathLength++] = current;
				path[pathLength++] = adjacentVertices[k];
						//Should the global variable be null?
						if (bestWeight == 0 || bestWeight > currentWeight) {
							bestWeight = currentWeight;
							shortPath = path;
						} else {
							//add current vertex to the running path
							path[pathLength++] = adjacentVertices[k];
							
							//add the weight of the edge between current and the adjacency we're considering
							getShortPathHelper(path, currentWeight, adjacentVertices[k], goal);
						}
			}
		}

		
		
		return path;
	}
	
	public char[] getShortestPath(char start, char goal) {
		char[] myAdjacentEdges = new char[MAX_VERTICES];
		int numberOfAdjacentEdges = 0;
		//Clearing things out
		bestWeight = 0;
		int shortPathLength = 0;
		//int shortPathLength = shortPath.length;
		char[] myShortPath = new char[shortPathLength];
		shortPath = myShortPath;
		
		char[] creatingPath = new char[MAX_VERTICES];
		int creatingPathLength = 0;
		creatingPath[creatingPathLength++] = start;
		//Create a path 
		//Add start to path
		for  (int o = 0; o < MAX_VERTICES; o++) {
			myAdjacentEdges[o] = getAdjacentVertices(start).toString().charAt(o);
			numberOfAdjacentEdges++;
		}
		//Loop through the adjacencies of start
		for (int l = 0; l < numberOfAdjacentEdges; l++) {
			if (myAdjacentEdges[l] == goal) {
				creatingPath[shortPathLength++] = myAdjacentEdges[l];
				
			}
		}
			//If it's at the goal, do the same as in above method (except the first part)
		getShortPathHelper(creatingPath, 0, start, goal);//Short path recursion (path , 0 , )
		return shortPath;
	}
	
	

	@Override
	public boolean isComplete() {
		int counterNumberOfVertices = 0;
		for (int k = 0; k < allVertices.size(); k++) {
			// Getting the next vertex in the graph...will iterate through all
			// of them
			char vertexID = allVertices.get(k).toString().charAt(0);
			for (int j = 1; j <= allVertices.size(); j++) {
				// If it's adjacent to another vertex, increase the counter
				// which is counting how many vertices the vertexID (current
				// vertex)
				// is adjacent to
				if (adjacencyMatrix[convertCharToNum(vertexID)][j] == 1) {
					counterNumberOfVertices++;
				}
			}
			// Checking if that vertex is adjacent to everything but itself
			if (counterNumberOfVertices == (allVertices.size() - 1)) {
				counterNumberOfVertices = 0;
			} else {
				// Should we find a vertex where it doesn't
				// touch every one (but itself), return false
				return false;
			}
		}
		// If we're able to survive everything above...then its complete!
		return true;
	}

}