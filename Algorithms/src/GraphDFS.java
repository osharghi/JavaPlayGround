import java.util.LinkedList;

public class GraphDFS {

	GraphDFS()
	{
		Graph g = new Graph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
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
		
		void addEdge(int from, int to)
		{
			adj[from].add(to);
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("START: " + i);
				
				if(!visited[i])
				{
					doDFS(i, visited);
				}
				else
				{
					System.out.println("NO START: " + i);

				}
			}
		}
		
		void doDFS(int node, boolean[] visited)
		{
			visited[node]  = true;
			
			LinkedList<Integer> neighbors = adj[node];
			
			System.out.println("VISITING: " + node);

			
			for(int neighbor: neighbors)
			{
				if(!visited[neighbor])
				{
					System.out.println("CURRENT: " + node + " Visit: " + neighbor);

					doDFS(neighbor, visited);
				}
				else
				{
					System.out.println("CURRENT: " + node + " Cant: " + neighbor);

				}
			}
		}
		
		
	}
	
	
}
