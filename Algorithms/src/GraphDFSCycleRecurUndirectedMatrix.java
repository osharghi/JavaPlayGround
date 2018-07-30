
public class GraphDFSCycleRecurUndirectedMatrix {
	
	GraphDFSCycleRecurUndirectedMatrix()
	{
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 2);


		
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
			matrix[v][u] = 1;
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{
				if(!visited[i])
				{
					System.out.println("Current: " + i);
					if(!doDFS(i, visited, -1)) {
						System.out.println("There is a cycle");
						break;
					}
				}
			}
		}
		
		boolean doDFS(int u, boolean[] visited,  int parent)
		{
			
			System.out.println("Visiting: " + u);

			if(visited[u])
			{
				System.out.println("Cycle Detected at " + u + " Parent: "+ parent );
				return false;
			}
			
			visited[u] = true;
						
			for(int v = 0; v<V; v++)
			{
				if(matrix[u][v] != 0 && v!=parent)
				{
					System.out.println("Visitng " + u + " Neighbor " + v);
					return doDFS(v, visited, u);
				}
			}
			
			return true;
		}
	}

}
