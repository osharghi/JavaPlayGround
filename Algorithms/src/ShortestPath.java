import java.util.Arrays;

public class ShortestPath {
	
	ShortestPath()
	{
		int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
			            {4, 0, 8, 0, 0, 0, 0, 11, 0},
			            {0, 8, 0, 7, 0, 4, 0, 0, 2},
			            {0, 0, 7, 0, 9, 14, 0, 0, 0},
			            {0, 0, 0, 9, 0, 10, 0, 0, 0},
			            {0, 0, 4, 14, 10, 0, 2, 0, 0},
			            {0, 0, 0, 0, 0, 2, 0, 1, 6},
			            {8, 11, 0, 0, 0, 0, 1, 0, 7},
			            {0, 0, 2, 0, 0, 0, 6, 7, 0}
						};
         
		findPath(0, graph);
		   							
	}
	
	void findPath(int src, int[][] graph)
	{
		int V = graph.length;
		boolean[] visited = new boolean[V];
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[src] = 0;
		
		for(int count = 0; count<V-1; count++)
		{
			int u = getMin(visited, dist);
			
			visited[u] = true;
			
			for(int v = 0; v<graph.length; v++)
			{
				if(!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] <= dist[v] )
				{
					dist[v] = dist[u] + graph[u][v];
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
	
	int getMin(boolean[] visited, int[] dist)
	{
		int minIndex = -1;
		int minVal = Integer.MAX_VALUE;
		for(int i = 0; i<visited.length; i++)
		{
			if(!visited[i] && dist[i]<=minVal)
			{
				minIndex = i;
				minVal = dist[i];
			}
		}
		
		return minIndex;
	}

}
