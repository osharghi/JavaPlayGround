import java.util.ArrayList;
import java.util.HashMap;

public class GraphCycleRecurNode {

	GraphCycleRecurNode()
	{
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(4, 3);
		
		g.doDFS();
	}
	
	class Graph
	{
		HashMap<Integer, GNode> map;
		ArrayList<GNode> nodes;
		
		Graph()
		{
			map = new HashMap<>();
			nodes = new ArrayList<>();
		}
		
		void addEdge(int u, int v)
		{
			GNode current = getNode(u);
			GNode neigh = getNode(v);
			current.adj.add(neigh);
		}
		
		GNode getNode(int i)
		{
			if(map.containsKey(i))
			{
				return map.get(i);
			}
			else
			{
				GNode node = new GNode(i);
				map.put(i, node);
				nodes.add(node);
				return node;
			}
		}
		
		void doDFS()
		{
			for(GNode current: nodes)
			{
				System.out.println("Current: " + current.val);
				doDFS(current);
			}
		}
		
		void doDFS(GNode c)
		{
			if(c.inRecStack)
			{
				System.out.println("Cycle Detected at: " + c.val);
				return;
			}
			
			if(c.visited)
			{
				System.out.println("Visited: " + c.val);
				return;
			}
			
			c.visited = true;
			c.inRecStack = true;
			
			ArrayList<GNode> neighbors = c.adj;
			
			System.out.println("Visiting: " + c.val);
			
			for(GNode neigh: neighbors)
			{
				System.out.println("Visiting: " + c.val + " Neighbor: " + neigh.val);
				doDFS(neigh);
			}
			
			c.inRecStack = false;
			
		}
	}
	
	class GNode
	{
		int val;
		ArrayList<GNode> adj;
		boolean visited;
		boolean inRecStack;
		
		GNode(int x)
		{
			val = x;
			adj = new ArrayList<>();
			visited = false;
			inRecStack = false;
		}
	}
}
