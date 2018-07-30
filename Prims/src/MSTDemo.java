//	Name: Omid Sharghi and Anni Ankola
//	Date: 12/11/2017
//	Course: CS 146 Section 1
//	Description: Program runs the Prim's Algorithm and a custom new algorithm to determine the Minimum Spanning Tree of graphs.
// 	Usage: Program reads through text files and creates Vertex and Edge objects and an adjacency list.


public class MSTDemo {
	
	public static void main(String[] args) {
		
		System.out.println("\nPrims Results For tinyEWG:" );
		System.out.println("---------------------------");
		Graph g1 = new Graph();
		g1.setStartTime();
		g1.graphLoader("tinyEWG.txt");
	    System.out.print("\nInitial Adjacency List:");
	    g1.printEdges(); //print original adjacency list
	    System.out.print("\nInitial Vertices: ");
	    g1.printVertices();   //prints the parent vertex and weight of each vertex before applying Prim's
		g1.getMST();
	    System.out.print("\nFinal ");
	    g1.printVertices();  //prints the parent vertex and weight of each vertex after applying Prim's
	    g1.calculateTotalMSTWeight();
	    g1.duration();
		
		System.out.println("\nNew Algorithm Recursive Results for tinyEWG:" );
		System.out.println("-----------------------------------------------");
		Graph g2 = new Graph();
		g2.setStartTime();
		g2.graphLoader("tinyEWG.txt");
	    System.out.print("\nInitial Adjacency List:");
	    g2.printEdges(); //print original adjacency list
		g2.newAlgorithmRecursive();
		System.out.print("\nFinal Adjacency List:");
		g2.printEdges(); //print final adjacency list
		g2.numOfEdgesRemoved();
		g2.duration();
		
		System.out.println("\nNew Algorithm Iterative Results for tinyEWG:" );
		System.out.println("----------------------------------------------");
		Graph g3 = new Graph();
		g3.setStartTime();
		g3.graphLoader("tinyEWG.txt");
	    System.out.print("\nInitial Adjacency List:");
	    g3.printEdges(); //print original adjacency list
	    g3.newAlgorithmIterative();
		System.out.print("\nFinal Adjacency List:");
		g3.printEdges(); //print final adjacency list
		g3.numOfEdgesRemoved();
		g3.duration();
		
		System.out.println("\nPrims Results For mediumEWG:" );
		System.out.println("----------------------------");
		Graph g4 = new Graph();
		g4.setStartTime();
		g4.graphLoader("mediumEWG.txt");
		g4.getMST();
		g4.calculateTotalMSTWeight();
		g4.duration();
		
		System.out.println("\nNew Algorithm Recursive Results for mediumEWG: " );
		System.out.println("------------------------------------------------");
		Graph g5 = new Graph();
		g5.setStartTime();
		g5.graphLoader("mediumEWG.txt");
		g5.newAlgorithmRecursive();
		g5.numOfEdgesRemoved();
		g5.duration();
		
		System.out.println("\nNew Algorithm Iterative Results for mediumEWG: " );
		System.out.println("-----------------------------------------------");
		Graph g6 = new Graph();
		g6.setStartTime();
		g6.graphLoader("mediumEWG.txt");
		g6.newAlgorithmIterative();
		g6.numOfEdgesRemoved();
		g6.duration();
		
		System.out.println("\nPrims Results For 1000EWG:" );
		System.out.println("----------------------------");
		Graph g7 = new Graph();
		g7.setStartTime();
		g7.graphLoader("1000EWG.txt");
		g7.getMST();
		g7.calculateTotalMSTWeight();
		g7.duration();
		
		System.out.println("\nNew Algorithm Recursive Results for 1000EWG:" );
		System.out.println("----------------------------------------------");
		Graph g8 = new Graph();
		g8.setStartTime();
		g8.graphLoader("1000EWG.txt");
		g8.newAlgorithmRecursive();
		g8.numOfEdgesRemoved();
		g8.duration();

		System.out.println("\nNew Algorithm Iterative Results for 1000EWG:" );
		System.out.println("----------------------------------------------");
		Graph g9 = new Graph();
		g9.setStartTime();
		g9.graphLoader("1000EWG.txt");
		g9.newAlgorithmIterative();
		g9.numOfEdgesRemoved();
		g9.duration();
		
		System.out.println("\nPrims Results For 10000EWG:" );
		System.out.println("----------------------------");
		Graph g10 = new Graph();
		g10.setStartTime();
		g10.graphLoader("10000EWG.txt");
		g10.getMST();
		g10.calculateTotalMSTWeight();
		g10.duration();
		
		System.out.println("\nNew Algorithm Recursive Results for 10000EWG:" );
		System.out.println("------------------------------------------------");
		Graph g11 = new Graph();
		g11.setStartTime();
		g11.graphLoader("10000EWG.txt");
		g11.newAlgorithmRecursive();
		g11.numOfEdgesRemoved();
		g11.duration();
		
		System.out.println("\nNew Algorithm Iterative Results for 10000EWG:" );
		System.out.println("------------------------------------------------");
		Graph g12 = new Graph();
		g12.setStartTime();
		g12.graphLoader("10000EWG.txt");
		g12.newAlgorithmIterative();
		g12.numOfEdgesRemoved();
		g12.duration();
		
		System.out.println("\nPrims Results For largeEWG:" );
		System.out.println("----------------------------");
		Graph g13 = new Graph();
		g13.setStartTime();
		g13.graphLoader("largeEWG.txt");
		g13.getMST();
		g13.calculateTotalMSTWeight();
		g13.duration();
		
//		Very time consuming
//		System.out.println("\nNew Algorithm Recursive Results for largeEWG:" );
//		System.out.println("------------------------------------------------");
//		Graph g14 = new Graph();
//		g14.setStartTime();
//		g14.graphLoader("largeEWG.txt");
//		g14.newAlgorithmRecursive();
//		g14.numOfEdgesRemoved();
//		g14.duration();
//		
//		System.out.println("\nNew Algorithm Iterative Results for largeEWG:" );
//		System.out.println("------------------------------------------------");
//		Graph g15 = new Graph();
//		g15.setStartTime();
//		g15.graphLoader("largeEWG.txt");
//		g15.newAlgorithmIterative();
//		g15.numOfEdgesRemoved();
//		g15.duration();
	}

}
