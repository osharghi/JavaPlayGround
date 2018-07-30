
public class GraphCycleRecurMatrix {
	
	GraphCycleRecurMatrix()
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(4, 3);
		g.doDFS();
	}
	
	class Graph
	{
		int[][] matrix;
		int V;
		
		Graph(int size)
		{
			V = size;
			matrix = new int[V][V];
		}
		
		void addEdge(int u, int v)
		{
			matrix[u][v] = 1;
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			boolean[] recurStack = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("Current: " + i);
				doDFS(i, visited, recurStack);
			}
		}
		
		void doDFS(int current, boolean[] visited, boolean[] recurStack)
		{
			if(recurStack[current])
			{
				System.out.println("CYCLE DETECTED at " + current);
				return;
			}
			
			if(visited[current])
			{
				System.out.println("AREADY VISITED: " + current);
				return;
			}
			
			recurStack[current] = true;
			visited[current] = true;
			
			System.out.println("VISITING: " + current);
			
			int[] neighbors = matrix[current];
			
			for(int i = 0; i<neighbors.length; i++)
			{
				if(neighbors[i] == 1)
				{
					System.out.println("VISITING: " + current + " Neighbor: " + i);

					doDFS(i, visited, recurStack);
				}
			}
			
			recurStack[current] = false;
		}
	}

}
