import java.util.HashMap;
import java.util.LinkedList;

public class RouteNodes2 {
	
	RouteNodes2()
	{
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 5);
		g.addEdge(4, 3);
		
		Node u = g.getNode(0);
		Node x = g.getNode(5);
		
		g.hasPath(u, x);
	}

	class Graph
	{
		HashMap<Integer, Node> map;
		
		Graph()
		{
			map = new HashMap<>();
		}
	
		void addEdge(int u, int v)
		{
			Node uNode = getNode(u);
			Node vNode = getNode(v);
			uNode.adj.add(vNode);
		}
		
		Node getNode(int u)
		{
			if(map.containsKey(u))
			{
				return map.get(u);
			}
			else
			{
				Node n = new Node(u);
				map.put(u, n);
				return n;
			}
		}
		
		void hasPath(Node u, Node x)
		{
			
			boolean result = doDFS(u, x);
			
			if(result)
			{
				System.out.println("Path exists between " + u.val + " and " + x.val);
			}
			else
			{
				System.out.println("no path");
			}
			
		}
		
		boolean doDFS(Node u, Node x)
		{
			System.out.println(u.val + " and " + x.val);

			
			if(u == x) return true;
			
			u.visited = true;
			
			for(Node v: u.adj)
			{
				if(!v.visited)
				{
					if(doDFS(v, x))
					{
						return true;
					}
				}
			}
			
			return false;
		}
	}
	
	class Node
	{
		int val;
		boolean visited;
		LinkedList<Node> adj;
		
		Node(int x)
		{
			val = x;
			visited =false;
			adj = new LinkedList<>();
		}
	}
	
	
}
