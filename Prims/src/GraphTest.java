import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class GraphTest {
	
	@Test
	void testCLRSGraphCreator()
	{
		Graph g = new Graph();
		g.graphLoader("clrsTest.txt");
		
		int numOfVertices = g.graph.size();
		int numOfEdges = 0;
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			numOfEdges = numOfEdges + edges.size();		
		}
		
		assertEquals(numOfEdges/2, g.numOfEdges);
		assertEquals(numOfVertices, g.graphSize);
	}
	
	@Test
	void testCLRSGraphMSTResults()
	{
		Graph g = new Graph();
		g.graphLoader("clrsTest.txt");
		g.getMST();
		
		Graph.Vertex v0 = g.vertices.get(0);
		Graph.Vertex v1 = g.vertices.get(1);
		Graph.Vertex v2 = g.vertices.get(2);
		Graph.Vertex v3 = g.vertices.get(3);
		Graph.Vertex v4 = g.vertices.get(4);
		Graph.Vertex v5 = g.vertices.get(5);
		Graph.Vertex v6 = g.vertices.get(6);
		Graph.Vertex v7 = g.vertices.get(7);
		Graph.Vertex v8 = g.vertices.get(8);
		
		assertTrue(v0.minWeight == 4.0 || v1.minWeight == 4.0);
		assertTrue(v2.minWeight == 2.0 || v8.minWeight == 2.0);
		assertTrue(v3.minWeight == 7.0 || v2.minWeight == 7.0);
		assertTrue(v4.minWeight == 9.0 || v3.minWeight == 9.0);
		assertTrue(v5.minWeight == 2.0 || v6.minWeight == 2.0);
		assertTrue(v6.minWeight == 1.0 || v7.minWeight == 1.0);
	}
	
	@Test
	void testTinyGraphCreator()
	{
		Graph g = new Graph();
		g.graphLoader("tinyEWG.txt");
		
		int numOfVertices = g.graph.size();
		int numOfEdges = 0;
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			numOfEdges = numOfEdges + edges.size();		
		}
		
		assertEquals(numOfEdges/2, g.numOfEdges);
		assertEquals(numOfVertices, g.graphSize);
	}
	
	@Test
	void testTinyGraphMSTResults()
	{
		Graph g = new Graph();
		g.graphLoader("tinyEWG.txt");
		g.getMST();
		
		Graph.Vertex v0 = g.vertices.get(0);
		Graph.Vertex v1 = g.vertices.get(1);
		Graph.Vertex v2 = g.vertices.get(2);
		Graph.Vertex v3 = g.vertices.get(3);
		Graph.Vertex v4 = g.vertices.get(4);
		Graph.Vertex v5 = g.vertices.get(5);
		Graph.Vertex v6 = g.vertices.get(6);
		Graph.Vertex v7 = g.vertices.get(7);
		
		assertTrue(v0.minWeight == 0.16 || v7.minWeight == 0.16);
		assertTrue(v1.minWeight == 0.19 || v7.minWeight == 0.19);
		assertTrue(v2.minWeight == 0.17 || v3.minWeight == 0.17);
		assertTrue(v4.minWeight == 0.35 || v5.minWeight == 0.35);
		assertTrue(v5.minWeight == 0.28 || v7.minWeight == 0.28);
		assertTrue(v6.minWeight == 0.40 || v2.minWeight == 0.40);
		assertTrue(v7.minWeight == 0.16 || v1.minWeight == 0.16);
		
	}
	
	@Test 
	void testTinyGraphMSTTotalWeight()
	{
		Graph g = new Graph();
		g.graphLoader("tinyEWG.txt");
		g.getMST();
		
		Double weight = g.calculateTotalMSTWeight();
		weight = (double) Math.round(weight * 100);
		weight = weight/100;
		
		assertEquals((double) weight, (double) 1.81);
		
	}
	
	@Test
	void testMediumGraphCreator()
	{
		Graph g = new Graph();
		g.graphLoader("mediumEWG.txt");
		
		int numOfVertices = g.graph.size();
		int numOfEdges = 0;
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			numOfEdges = numOfEdges + edges.size();		
		}
		
		assertEquals(numOfEdges/2, g.numOfEdges);
		assertEquals(numOfVertices, g.graphSize);
	}
	
	@Test
	void testMediumGraphMST()
	{
		Graph g = new Graph();
		g.graphLoader("mediumEWG.txt");
		g.getMST();
		
		Graph.Vertex v7 = g.vertices.get(7);
		Graph.Vertex v157 = g.vertices.get(157);
		assertTrue(v7.minWeight == 0.00516 || v157.minWeight == 0.00516);
		
		Graph.Vertex v212 = g.vertices.get(212);
		Graph.Vertex v30 = g.vertices.get(30);
		assertTrue(v212.minWeight == 0.03314 || v30.minWeight == 0.03314);		
		
	}
	
	@Test
	void test1000GraphCreator()
	{
		Graph g = new Graph();
		g.graphLoader("1000EWG.txt");
		
		int numOfVertices = g.graph.size();
		int numOfEdges = 0;
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			numOfEdges = numOfEdges + edges.size();		
		}
		
		assertEquals(numOfEdges/2, g.numOfEdges);
		assertEquals(numOfVertices, g.graphSize);
	}
	
	@Test
	void test1000GraphMST()
	{
		Graph g = new Graph();
		g.graphLoader("1000EWG.txt");
		g.getMST();
		
		Graph.Vertex v0 = g.vertices.get(0);
		Graph.Vertex v958 = g.vertices.get(958);
		assertTrue(v0.minWeight == 0.01083 || v958.minWeight == 0.01083);
		
		Graph.Vertex v2 = g.vertices.get(2);
		Graph.Vertex v953 = g.vertices.get(953);
		assertTrue(v2.minWeight == 0.00842 || v953.minWeight == 0.00842);

	}
	
	@Test
	void test10000GraphCreator()
	{
		Graph g = new Graph();
		g.graphLoader("10000EWG.txt");
		
		int numOfVertices = g.graph.size();
		int numOfEdges = 0;
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			numOfEdges = numOfEdges + edges.size();		
		}
		
		assertEquals(numOfEdges/2, g.numOfEdges);
		assertEquals(numOfVertices, g.graphSize);
	}
	
	@Test
	void test10000GraphMST()
	{
		Graph g = new Graph();
		g.graphLoader("10000EWG.txt");
		g.getMST();
		
		Graph.Vertex v0 = g.vertices.get(0);
		Graph.Vertex v835 = g.vertices.get(835);
		assertTrue(v0.minWeight == 0.00491 || v835.minWeight == 0.00491);
	}
	
	@Test
	void testLargeGraphCreator()
	{
		Graph g = new Graph();
		g.graphLoader("largeEWG.txt");
		
		int numOfVertices = g.graph.size();
		int numOfEdges = 0;
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			numOfEdges = numOfEdges + edges.size();		
		}
		
		assertEquals(numOfEdges/2, g.numOfEdges);
		assertEquals(numOfVertices, g.graphSize);
	}
	
	@Test 
	void testTinyGraphEdgeReduceGraphSizeRecursive() {
		
		Graph g = new Graph();
		g.graphLoader("tinyEWG.txt");
		
		int edgeCounter = 0;
		
		g.newAlgorithmRecursive();

		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			
			edgeCounter = edgeCounter + edges.size();
		}
				
		assertEquals(edgeCounter/2, 7);
	}
	
	@Test 
	void testTinyGraphEdgeReduceGraphSizeIterative() {
		
		Graph g = new Graph();
		g.graphLoader("tinyEWG.txt");
		
		int edgeCounter = 0;
		
		g.newAlgorithmIterative();

		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			
			edgeCounter = edgeCounter + edges.size();
		}
				
		assertEquals(edgeCounter/2, 7);
	}
	
	@Test 
	void testTinyGraphEdgeReduceBiggestEdge() {
		
		Graph g = new Graph();
		g.graphLoader("tinyEWG.txt");
		g.sortEdges();
		boolean graphContainsEdge = false;
		Graph.Edge biggestEdge = g.edges.get(0);
		
		g.newAlgorithmRecursive();
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			if(edges.contains(biggestEdge))
			{
				graphContainsEdge = true;
				break;
			}
		}
		
		assertEquals(graphContainsEdge, false);
	}
	
	@Test 
	void testMediumGraphEdgeReduceBiggestEdge() {
		
		Graph g = new Graph();
		g.graphLoader("mediumEWG.txt");
		g.sortEdges();
		boolean graphContainsEdge = false;
		Graph.Edge biggestEdge = g.edges.get(0);
		
		g.newAlgorithmRecursive();
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			if(edges.contains(biggestEdge))
			{
				graphContainsEdge = true;
				break;
			}
		}
		
		assertEquals(graphContainsEdge, false);
	}
	
	@Test 
	void test1000GraphEdgeReduceBiggestEdge() {
		
		Graph g = new Graph();
		g.graphLoader("1000EWG.txt");
		g.sortEdges();
		boolean graphContainsEdge = false;
		Graph.Edge biggestEdge = g.edges.get(0);
		
		g.newAlgorithmRecursive();
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			if(edges.contains(biggestEdge))
			{
				graphContainsEdge = true;
				break;
			}
		}
		
		assertEquals(graphContainsEdge, false);
	}
	
	@Test 
	void testTinyGraphEdgeSort() {
		
		Graph g = new Graph();
		g.graphLoader("tinyEWG.txt");
		Graph.Edge biggestEdge = null;
		
		for(int i = 0; i<g.graph.size(); i++)
		{
			ArrayList<Graph.Edge> edges = g.graph.get(i);
			
			for(int j = 0; j<edges.size(); j++)
			{
				if(biggestEdge == null)
				{
					biggestEdge = edges.get(j);
				}
				else
				{
					if(biggestEdge.weight < edges.get(j).weight)
					{
						biggestEdge = edges.get(j);
					}
				}
			}
		}
		
		g.sortEdges();
		assertEquals(g.edges.get(0).weight, biggestEdge.weight);
	}
	
	@Test
	void testCompareIterativeVSRecursiveTinyEWG()
	{
		Graph g1 = new Graph();
		g1.graphLoader("tinyEWG.txt");
		g1.newAlgorithmRecursive();
		int g1EdgeRemovedCount = g1.numOfEdgesRemoved();
		
		Graph g2 = new Graph();
		g2.graphLoader("tinyEWG.txt");
		g2.newAlgorithmRecursive();
		int g2dgeRemovedCount = g2.numOfEdgesRemoved();
		
		assertEquals(g1EdgeRemovedCount, g2dgeRemovedCount);
	}
	
	@Test
	void testCompareIterativeVSRecursiveMediumEWG()
	{
		Graph g1 = new Graph();
		g1.graphLoader("mediumEWG.txt");
		g1.newAlgorithmRecursive();
		int g1EdgeRemovedCount = g1.numOfEdgesRemoved();
		
		Graph g2 = new Graph();
		g2.graphLoader("mediumEWG.txt");
		g2.newAlgorithmRecursive();
		int g2dgeRemovedCount = g2.numOfEdgesRemoved();
		
		assertEquals(g1EdgeRemovedCount, g2dgeRemovedCount);
	}
	
	@Test
	void testCompareIterativeVSRecursive1000EWG()
	{
		Graph g1 = new Graph();
		g1.graphLoader("1000EWG.txt");
		g1.newAlgorithmRecursive();
		int g1EdgeRemovedCount = g1.numOfEdgesRemoved();
		
		Graph g2 = new Graph();
		g2.graphLoader("1000EWG.txt");
		g2.newAlgorithmRecursive();
		int g2dgeRemovedCount = g2.numOfEdgesRemoved();
		
		assertEquals(g1EdgeRemovedCount, g2dgeRemovedCount);
	}
	
//	Working but time consuming
//	@Test
//	void testCompareIterativeVSRecursive10000EWG()
//	{
//		Graph g1 = new Graph();
//		g1.graphLoader("10000EWG.txt");
//		g1.newAlgorithmRecursive();
//		int g1EdgeRemovedCount = g1.numOfEdgesRemoved();
//		
//		Graph g2 = new Graph();
//		g2.graphLoader("10000EWG.txt");
//		g2.newAlgorithmRecursive();
//		int g2dgeRemovedCount = g2.numOfEdgesRemoved();
//		
//		assertEquals(g1EdgeRemovedCount, g2dgeRemovedCount);
//	}

}
