import java.util.ArrayList;
import java.util.HashMap;

public class GraphDFSRecurNode {

	GraphDFSRecurNode()
	{
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
		
		g.doDFS();
	}
	
	class Graph
	{
		HashMap<Integer, GNode> adjMap;
		
		Graph()
		{
			adjMap = new HashMap<>();
		}
		
		void addEdge(int u, int v)
		{
			if(adjMap.containsKey(u))
			{
				GNode current = adjMap.get(u);
				
				if(adjMap.containsKey(v))
				{
					current.adj.add(adjMap.get(v));
				}
				else
				{
					GNode visit = new GNode(v);
					adjMap.put(v, visit);
					current.adj.add(adjMap.get(v));
				}
			}
			else
			{
				GNode current = new GNode(u);
				adjMap.put(u, current);
				
				if(adjMap.containsKey(v))
				{
					current.adj.add(adjMap.get(v));
				}
				else
				{
					GNode visit = new GNode(v);
					adjMap.put(v, visit);
					current.adj.add(adjMap.get(v));
				}
			}
		}
		
		void doDFS()
		{
			
			for(int i: adjMap.keySet())
			{
				GNode current = adjMap.get(i);
				
				System.out.println("Current " + current.val);
				
				if(!current.visited)
				{
					doDFS(current);
				}
			}
			
		}
		
		void doDFS(GNode current)
		{
			current.visited = true;
			System.out.println("Visiting " + current.val);
			
			ArrayList<GNode> neighbors = current.adj;
			
			for(GNode neigh: neighbors)
			{
				if(!neigh.visited)
				{
					System.out.println("Visiting " + current.val + " Neighbor: " + neigh.val);
					doDFS(neigh);
				}
				else
				{
					System.out.println("Visiting " + current.val + " Cant Neighbor: " + neigh.val);
				}
			}
			
		}
	}
	
	
	class GNode
	{
		ArrayList<GNode> adj;
		int val;
		boolean visited;
		
		GNode(int x)
		{
			val = x;
			adj = new ArrayList<>();
			visited = false;
		}
	}
	
}
