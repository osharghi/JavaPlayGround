import java.util.Stack;

public class GraphDFSIterMatrix {

	GraphDFSIterMatrix()
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
			Stack<Integer> stack = new Stack<>();
			
			for(int i = 0; i<V; i++)
			{
				stack.push(i);
			
				System.out.println("Current: " + i);
				
				while(!stack.isEmpty())
				{
					int current = stack.pop();
					
					if(!visited[current])
					{
						visited[current] = true;
						
						System.out.println("Visiting: " + current);

						int[] neighbors = matrix[current];
						
						for(int j = 0; j<neighbors.length; j++)
						{
							if(!visited[j] && neighbors[j] == 1)
							{
								System.out.println("Visiting: " + current + " Neighbor: " + j);
								stack.push(j);
							}
							else
							{
								System.out.println("Visiting: " + current + " Cant Neighbor: " + j);

							}
						}
						
					}
				}
				
			}
			
			
			
		}
	}
}
