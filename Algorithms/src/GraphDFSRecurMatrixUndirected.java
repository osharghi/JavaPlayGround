
public class GraphDFSRecurMatrixUndirected {

	
	GraphDFSRecurMatrixUndirected()
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
		int[][] matrix;
		
		Graph(int size)
		{
			V = size;
			matrix = new int[V][V];
		}
		
		void addEdge(int u, int v)
		{
			matrix[u][v] = 1;
			matrix[v][u]  = 1;
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			
			for(int u = 0; u<V; u++)
			{
				if(!visited[u])
				{
					System.out.println("Current: " + u);
					doDFS(u, visited);
				}
				else
				{
					System.out.println("Current already visited: " + u);

				}
			}
		}
		
		void doDFS(int u, boolean[] visited)
		{
			visited[u] = true;
			
			System.out.println("Visiting: " + u);
			
			int[] neighbors = matrix[u];
			
			for(int v = 0; v<V; v++)
			{
				if(v != u && neighbors[v] == 1 && !visited[v])
				{
					System.out.println("Visiting: " + u + " Neigh: " + v);
					doDFS(v, visited);
				}
				else if(neighbors[v] == 1 && visited[v])
				{
					System.out.println("Visiting: " + u + " Neigh already visited: " + v);
				}
			}
		}
	}
	
}
