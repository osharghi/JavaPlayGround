import java.util.LinkedList;
import java.util.Stack;

public class GraphDFSIterAdjListDirected {

	GraphDFSIterAdjListDirected()
	{
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 5);
		g.addEdge(4, 3);
		g.doDFS();
	}
	
	class Graph
	{
		int V;
		LinkedList<Integer>[] adj;
		
		Graph(int size)
		{
			V = size;
			adj = new LinkedList[V];
			
			for(int i = 0; i<V; i++)
			{
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int u, int v)
		{
			LinkedList<Integer> ll = adj[u];
			ll.add(v);
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			Stack<Integer> stack = new Stack<>();
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("Current: " + i);

				if(!visited[i])
				{
					stack.push(i);
					
					while(!stack.isEmpty())
					{
						int u = stack.pop();
						System.out.println("Visiting: " + u);
						visited[u] = true;
						
						LinkedList<Integer> neighbors = adj[u];
						
						for(Integer v: neighbors)
						{
							if(!visited[v])
							{
								System.out.println("Visiting: " + u + " Visit neigh: " + v);
								stack.push(v);
							}
							else
							{
								System.out.println("Visiting: " + u + " Visit already visited: " + v);
							}
						}
					}
				}
				else
				{
					System.out.println("Current already visited: " + i);
				}
			}
		}
	}
	
}
