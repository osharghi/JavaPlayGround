import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;


public class GraphDFSObjIter2 {

	GraphDFSObjIter2()
	{
		Graph g = new Graph();
		g.addNode(0);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		
		g.addEdge(0, 1);
		g.addEdge(0,	2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
		
		g.DFS();
	}
	
	class Graph
	{
		HashMap<Integer, GNode> map;
		int V = 0;
		
		Graph()
		{
			map = new HashMap<>();
		}
		
		void addNode(int i)
		{
			GNode node = new GNode(i);
			map.put(i, node);
			V++;
		}
		
		void addEdge(int from, int to)
		{
			GNode u = map.get(from);
			GNode v = map.get(to);
			u.neighbors.add(v);
		}
		
		void DFS()
		{
			Stack<GNode> stack = new Stack<>();
			boolean[] visited = new boolean[V];
			
			for(int key: map.keySet())
			{
				stack.push(map.get(key));
				
				while(!stack.isEmpty())
				{
					GNode current = stack.pop();
					
					if(!visited[current.val])
					{
						visited[current.val] = true;
						System.out.println("VISITING: " + current.val);
						
						LinkedList<GNode> neighbors = current.neighbors;
						
						for(GNode neighbor: neighbors)
						{
							if(!visited[neighbor.val])
							{
								System.out.println("Visiting: " + current.val + " child: " + neighbor.val);
								stack.push(neighbor);
							}
							else
							{
								System.out.println("Visiting: " + current.val + " cant: " + neighbor.val);

							}
						}

					}
					else
					{
						System.out.println("ALREADY VISITED: " + current.val);
					}
				}
			}
			
			
		}
		
		class GNode
		{
			int val;
			LinkedList<GNode> neighbors;
			
			GNode(int i)
			{
				val = i;
				neighbors = new LinkedList<>();
				
			}
		}
		
	}
}
