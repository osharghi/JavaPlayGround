
public class GraphDFSRecurMatrix {

	GraphDFSRecurMatrix()
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
		int[][] matrix;
		
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
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("CURRENT: " + i);
				if(visited[i] == false)
				{
					doDFS(visited, i);
				}
				else
				{
					System.out.println("CANT CURRENT: " + i);
				}
			}
		}
		
		void doDFS(boolean[] visited, int u)
		{
			visited[u] = true;
			
			System.out.println("VISITING: " + u);
			
			int[] neighbors = matrix[u];
			
			for(int i = 0; i<neighbors.length; i++)
			{
				if(neighbors[i] == 1 && visited[i] == false)
				{
					System.out.println("VISITING: " + u + " Neighbor: " + i);

					doDFS(visited, i);
				}
				else
				{
					System.out.println("VISITING: " + u + " Cant Neighbor: " + i);
				}
			}
		}
	}
	
}
