import java.util.LinkedList;

public class GraphDFSRecurAdj {

	GraphDFSRecurAdj()
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
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
			adj  = new LinkedList[V];	
			for(int i = 0; i<V; i++)
			{
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int u, int v)
		{
			adj[u].add(v);
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("Current " + i);
				
				if(!visited[i])
				{
					doDFS(visited, i);
				}
			}
		}
		
		void doDFS(boolean[] visited, int u)
		{
			visited[u] = true;
			
			System.out.println("Visiting: " + u);
			
			LinkedList<Integer> neighbors = adj[u];
			
			for(int i: neighbors)
			{
				if(!visited[i])
				{
					System.out.println("Visited: " + u + " Neighbor: " + i);
					doDFS(visited, i);
				}
				else
				{
					System.out.println("Visited: " + u + " Can't neighbor: " + i);
				}
			}
			
		}
		
		
	}
}
