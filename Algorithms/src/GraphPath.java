import java.util.ArrayList;
import java.util.LinkedList;

public class GraphPath {
	
	GraphPath()
	{
		
		Graph g = new Graph();
		GNode n0 = new GNode(0);
		GNode n1 = new GNode(1);
		GNode n2 = new GNode(2);
		GNode n3 = new GNode(3);
		GNode n4 = new GNode(4);
		GNode n5 = new GNode(5);
		
		g.addEdge(n0, n1);
		g.addEdge(n0, n2);
		g.addEdge(n1, n2);
		g.addEdge(n2, n3);
		g.addEdge(n3, n3);
		g.addEdge(n3, n5);
		g.addEdge(n4, n3);
		
		ArrayList<GNode> visited = new ArrayList<>();
		System.out.println(g.findEdge(n0, n3, visited));


	}
	
	class Graph
	{
		ArrayList<GNode> nodes;
		
		Graph()
		{
			nodes = new ArrayList<>();
		} 
		
		GNode createNode(int i) {
			
			GNode node = new GNode(i);
			nodes.add(node);
			return node;
		}
		
		void addEdge(GNode u, GNode v)
		{
			u.adj.add(v);
		}
		
		boolean findEdge(GNode current, GNode target, ArrayList<GNode> visited)
		{
			if(current == null) return false;
			
			visited.add(current);
			
			if(current == target)
			{
				return true;
			}
			
			for(GNode neighbor: current.adj)
			{
				if(!visited.contains(neighbor))
				{
					boolean result = findEdge(neighbor, target, visited);
					if(result) return result;
				}
			}
			
			return false;
		}

	}
	
	class GNode
	{
		int val;
		LinkedList<GNode> adj;
		
		GNode(int i)
		{
			val = i;
			adj = new LinkedList<>();
		}
				
	}

}
