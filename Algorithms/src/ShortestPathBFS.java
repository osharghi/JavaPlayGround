import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBFS {

	ShortestPathBFS()
	{
		Graph g = new Graph(5);
		
		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		int[] shortestPath = g.shortestPath(0);
		System.out.println(Arrays.toString(shortestPath));
	}
	
	class Graph
	{
		
		int[][] matrix;
		int V;
		
		Graph(int size)
		{
			V = size;
			matrix = new int[size][size];
			for(int i = 0; i<size; i++)
			{
				matrix[i] = new int[size];
			}
		}
		
		void addEdge(int from, int to)
		{
			int[] arr = matrix[from];
			arr[to] = 1;
		}
		
		int[] shortestPath(int node)
		{
			int path = 0;
			boolean[] visited = new boolean[V];
			int[] shortestPath = new int[V];
			Queue<Integer> queue= new LinkedList<>();
		
			visited[node] = true;
			queue.add(node);
			
			while(!queue.isEmpty())
			{
				int n = queue.poll();
				int[] neighbors = matrix[n];
				for(int i = 0; i<neighbors.length; i++)
				{
					if(neighbors[i] == 1 && !visited[i])
					{
						shortestPath[i] = shortestPath[n] + neighbors[i];
						visited[i] = true;
						queue.add(i);
					}
				}
			}
			
			return shortestPath;
		}
		
	}
	
	
}
