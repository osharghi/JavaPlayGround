
public class RouteNodes {

	RouteNodes()
	{
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 5);
		g.addEdge(4, 3);

		g.hasPath(2, 4);
	}
	
	class Graph
	{
		int V;
		int[][] matrix;
		
		Graph(int size)
		{
			V = size;
			matrix =  new int[V][V];
		}
		
		void addEdge(int u, int v)
		{
			matrix[u][v] = 1;
		}
		
		void hasPath(int u, int x)
		{
			boolean[] visited = new boolean[V];
			
			boolean result = hasPath(visited, u, x);
			
			if(result)
			{
				System.out.println("Path exisits between " + u + " and " + x);
			}
			else
			{
				System.out.println("No path");
			}
		}
		
		private boolean hasPath(boolean[] visited, int u, int x)
		{
			if(u == x) return true;
			
			visited[u] = true;
			
			for(int v = 0; v<V; v++)
			{
				if(matrix[u][v] != 0 && !visited[v])
				{
					return hasPath(visited, v, x);
				}
			}
			
			return false;
			
		}
	}
	
}
