import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class GraphDFSIterNode {

	GraphDFSIterNode()
	{
		Graph g = new Graph();
		g.addEge(0, 1);
		g.addEge(0, 2);
		g.addEge(1, 2);
		g.addEge(2, 3);
		g.addEge(4, 3);
		g.doDFS();
	}
	
	class Graph
	{
		HashMap<Integer, GNode> map;
		
		Graph()
		{
			map = new HashMap<>();
		}
		
		void addEge(int u, int v)
		{
			GNode current = getNode(u);
			GNode neighbor = getNode(v);
			
			current.neighbors.add(neighbor);
		}
		
		GNode getNode(int i)
		{
			if(map.containsKey(i))
			{
				return map.get(i);
			}
			else
			{
				GNode newNode = new GNode(i);
				map.put(i, newNode);
				return newNode;
			}
		}
		
		void doDFS()
		{
			Stack<GNode> stack = new Stack<>();
			
			for(int i: map.keySet())
			{
				GNode current = map.get(i);
				System.out.println("Current: " + current.val);
				
				if(!current.visited)
				{
					stack.push(current);
					
					while(!stack.isEmpty())
					{
						GNode curr = stack.pop();
						curr.visited = true;
						System.out.println("Visiting: " + curr.val);

						ArrayList<GNode> neighbors = curr.neighbors;
						
						for(GNode neigh: neighbors)
						{
							if(!neigh.visited)
							{
								System.out.println("Visiting: " + curr.val + " Neighbor: " + neigh.val);

								stack.push(neigh);
							}
							else
							{
								System.out.println("Visiting: " + curr.val + " Cant Neighbor: " + neigh.val);

							}
						}
					}	
				}	
			}
		}
	}
	
	class GNode
	{
		int val;
		ArrayList<GNode> neighbors;
		boolean visited;
		
		GNode(int x)
		{
			val = x;
			neighbors = new ArrayList<>();
			visited = false;
		}
	}
	
}
