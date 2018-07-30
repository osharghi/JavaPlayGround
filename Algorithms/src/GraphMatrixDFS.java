import java.util.Arrays;

public class GraphMatrixDFS {

	GraphMatrixDFS()
	{
		Graph g = new Graph(5);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(4, 3);
		
		g.printMatrix();
		
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
		
		void printMatrix()
		{
			System.out.println("PRINT");
			for(int[] row: matrix)
			{
				System.out.println(Arrays.toString(row));
			}
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{				
				if(!visited[i])
				{
					System.out.println("Current: " + i);

					doDFS(i, visited);
				}
				else
				{
					System.out.println("Current ALREADY VISITED: " + i + "");
				}
			}
		}
		
		void doDFS(int i, boolean[] visited)
		{
			visited[i] = true;
			
			System.out.println("Visiting: " + i);
			
			int[] neighbors = matrix[i];
			
			for(int j = 0; j<neighbors.length; j++)
			{
				if(!visited[j] && neighbors[j] == 1)
				{
					System.out.println("Current: " + i + " Child to Visit:" + j);
					doDFS(j, visited);
				}
				else
				{
					System.out.println("Current: " + i + " Child CANT Visit:" + j);
				}
			}
		}
	}
	
}
