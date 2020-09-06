import java.util.Arrays;

public class ShortestPath2 {

	
	ShortestPath2()
	{
		Graph g = new Graph(9);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(1, 2, 8);
		g.addEdge(2, 8, 2);
		g.addEdge(8, 6, 6);
		g.addEdge(7, 6, 1);
		g.addEdge(7, 8, 7);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 5, 14);
		g.addEdge(6, 5, 2);
		g.addEdge(3, 4, 9);
		g.addEdge(5, 4, 10);
		
//		g.printMatrix();
		g.shortestPath(0);
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
		
		void printMatrix()
		{
			for(int i = 0; i<V; i++)
			{
				int[] arr = matrix[i];
				System.out.println(Arrays.toString(arr));
			}
		}
		
		void addEdge(int u, int v, int weight)
		{
			matrix[u][v] = weight;
			matrix[v][u] = weight;
		}
		
		void shortestPath(int start)
		{
			boolean[] visited = new boolean[V];
			int[] dist = new int[V];
			
			for(int i = 0; i<V; i++)
			{
				dist[i] = Integer.MAX_VALUE;
			}
			
			dist[start] = 0;
			
			for(int i = 0; i<V-1; i++)
			{
				int u = getMin(visited, dist);
				
				visited[u] = true;
				
				int[] neighbors = matrix[u];
				
				for(int v = 0; v<neighbors.length; v++)
				{
					// !visited[v] Because cycle
					// dist[u] != Integer.MAX_VALUE that means there was no path to node U meaning there is no shortest path.
					if(!visited[v] && (dist[u] + matrix[u][v] <= dist[v]) && matrix[u][v]!= 0 && dist[u] != Integer.MAX_VALUE)
					{
						dist[v] = dist[u] + matrix[u][v];
					}
				}
			}
			
			print(dist);
		}
		
		void print(int[] dist)
		{
			System.out.println("PRINT");
			for(int i = 0; i<V; i++)
			{
				System.out.println(i + " -> " + dist[i]);
			}
		}
		
		int getMin(boolean[] visited, int[] dist)
		{
			int minValue = Integer.MAX_VALUE;
			int minIndex = -1;
			for(int i = 0; i<V; i++)
			{
				if(!visited[i] && dist[i]<=minValue)
				{
					minIndex = i;
					minValue = dist[i];
				}				
			}
			
			return minIndex;

		}
		
	}
}
