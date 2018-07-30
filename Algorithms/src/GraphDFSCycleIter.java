import java.util.LinkedList;
import java.util.Stack;

public class GraphDFSCycleIter {

	GraphDFSCycleIter()
	{
		Graph g = new Graph(5);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
//		g.addEdge(2, 0);
		g.addEdge(2, 3);
//		g.addEdge(3, 3);
		g.addEdge(4, 3);
		
		System.out.println(g.hasCycle());
		
	}
	
	class Graph
	{
		int V;
		LinkedList<Integer>[] adj;
		
		Graph(int size)
		{
			V = size;
			adj = new LinkedList[size];
			for(int i = 0; i<size; i++)
			{
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int from, int to)
		{
			adj[from].add(to);
		}
		
	
		boolean hasCycle()
		{
			boolean[] visited = new boolean[V];
			for(int i = 0 ; i<V; i++)
			{
				if(!visited[i])
				{
					System.out.println("START: " + i);
					if(hasCycle(i,visited))
					{
						return true;
					}
				}
				else
				{
					System.out.println("ALREADY: " + i);
				}
			}
			
			return false;
		}
		
		boolean hasCycle(int node, boolean[] visited)
		{
			Stack<Integer> stack = new Stack<>();
			stack.push(node);
			
			boolean[] partial = new boolean[V];
						
			while(!stack.isEmpty())
			{
				int n = stack.peek();
				System.out.println("CURRENT: " + n);

				if(partial[n])
				{
					partial[n] = false;
					stack.pop();
					System.out.println("REMOVING: " + n);

				}
				else
				{
					LinkedList<Integer> neighbors = adj[n];
					System.out.println("VISTING: " + n);

					partial[n] = true;
					visited[n] = true;
					
					for(int i: neighbors)
					{
						if(partial[i])
						{
							System.out.println("CURRENT: " + n + " CYCLE AT: " + i);

							return true;
						}
						
						if(!visited[i])
						{
							System.out.println("CURRENT: " + n + " ADD: " + i);

							stack.push(i);
						}
					}
				}
			}
			
			return false;
		}
		
	}
}
