import java.util.ArrayList;
import java.util.HashMap;

public class ShorestPathAdjList {

	ShorestPathAdjList()
	{
		Graph g = new Graph();
		g.addEdge(0, 1, 5);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 3, 2);
		g.addEdge(3, 4, 4);
		g.addEdge(0, 5, 6);
		g.addEdge(5, 6, 9);
		g.addEdge(5, 7, 10);
		g.getShortestPath(0);
	}
	
	
	class Graph
	{
		HashMap<Integer, GNode> map;
		
		Graph()
		{
			map = new HashMap<>();
		}
		
		void addEdge(int u, int v, int w)
		{
			GNode fromNode = getNode(u);
			GNode toNode = getNode(v);
			toNode.weight = w;
			fromNode.adj.add(toNode);
			toNode.adj.add(fromNode);
		}
		
		GNode getNode(int u)
		{
			if(map.containsKey(u))
			{
				return map.get(u);
			}
			else
			{
				GNode newNode = new GNode(u);
				map.put(u, newNode);
				return newNode;
			}
		}
		
		void getShortestPath(int start)
		{
			GNode current = map.get(start);
			current.dist = 0;
			
			for(int i = 0; i<map.size()-1; i++)
			{
				GNode u = getMin();
				u.visited = true;
				
				ArrayList<GNode> neighbors = u.adj;
				
				for(GNode neighbor: neighbors)
				{
					if(!neighbor.visited && (u.dist + neighbor.weight<=Integer.MAX_VALUE) && u.dist<=Integer.MAX_VALUE)
					{
						neighbor.dist = u.dist + neighbor.weight;
					}
				}
			}
			
			printDist();
			
		}
		
		void printDist()
		{
			System.out.println("Print");
			for(int i: map.keySet())
			{
				GNode node = map.get(i);
				System.out.println(i + " -> " + node.dist);
			}
		}
		
		GNode getMin()
		{
			int min = Integer.MAX_VALUE;
			GNode minNode = null;
			for(int i: map.keySet())
			{
				GNode possibleMinNode = map.get(i);
				if(!possibleMinNode.visited && possibleMinNode.dist <= min)
				{
					minNode = possibleMinNode;
					min = possibleMinNode.dist;
				}				
			}
			
			return minNode;
		}
	}
	
	class GNode
	{
		int label;
		int weight = 0;
		boolean visited;
		int dist;
		ArrayList<GNode> adj;
		
		GNode(int l)
		{
			label = l;
			visited =false;
			dist = Integer.MAX_VALUE;
			adj = new ArrayList<>();
		}
	}
	
}
