package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import bp.Edge;
import bp.Graph;
import bp.Vertex;

public class Main {

	public static void main(String[] args) {
		Graph myGraph = new Graph();
		Vertex vertexA = new Vertex('A');
		Vertex vertexB = new Vertex('B');
		Vertex vertexC = new Vertex('C');
		Vertex vertexD = new Vertex('D');
		Vertex vertexE = new Vertex('E');
		Vertex vertexF = new Vertex('F');
		Vertex vertexG = new Vertex('G');
		Vertex vertexH = new Vertex('H');
		Vertex vertexI = new Vertex('I');

		myGraph.addEdge(new Edge(vertexA, vertexB, 5));
		myGraph.addEdge(new Edge(vertexA, vertexC, 8));
		myGraph.addEdge(new Edge(vertexC, vertexD, 2));
	

		System.out.println("Is this graph complete?: " + myGraph.isComplete());
		System.out.println("Does this graph have an euler cycle?: " + myGraph.hasStrongEulerCycle('A'));
		System.out.println(myGraph.DepthFirstSearch());
		System.out.println(myGraph.BreadthFirstSearch());
		System.out.println(myGraph.StrongEulerCycle('B'));
		System.out.println(myGraph.getShortestPath('A', 'C'));
		
		
	}

}