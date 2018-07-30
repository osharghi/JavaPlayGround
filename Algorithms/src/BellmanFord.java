
public class BellmanFord {

	BellmanFord()
	{
		int[][] graph = {{0,-1, 4, 0, 0},
						 {0, 0, 3, 2, 2},
						 {0, 0, 0, 5, 0},
						 {0, 1, 5, 0, 0},
						 {0, 0, 0, -3, 0}
						 };
		
		findShortestPath(graph, 0);
	}
	
	void findShortestPath(int[][] graph, int src)
	{
		int size = graph.length;
		int[] dist= new int[size];
		for(int i = 0; i<size; i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[src] = 0;	
		
		for(int u = 0; u<size; u++)
		{
			int[] neighbors = graph[u];
			for(int v = 0; v<neighbors.length; v++)
			{
				if(dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v] && graph[u][v] != 0)
				{
					dist[v] = dist[u] + graph[u][v];
				}
			}
			
		}
		
		for(int u = 0; u<size; u++)
		{
			int[] neighbors = graph[u];
			for(int v = 0; v<neighbors.length; v++)
			{
				if(dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v] && graph[u][v] != 0)
				{
					System.out.println("negative cycle exists");
				}
			}
			
		}
		
		print(dist);
	}
	
	void print(int[] dist)
	{
		for(int i = 0; i<dist.length; i++)
		{
			System.out.println(i + ": " + dist[i]);
		}
	}
	
}
