import java.util.Stack;

public class GraphDFSIterMatrixDirected {
	
	GraphDFSIterMatrixDirected()
	{
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 5);
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
				if(!visited[i])
				{
					System.out.println("Current: " + i);
					
					stack.push(i);
					
					while(!stack.isEmpty())
					{
						int u = stack.pop();
						visited[u] = true;

						
						System.out.println("Visiting: " + u);
						
						int[] neighbors = matrix[u];
						
						for(int v = 0; v<V; v++)
						{
							if(v!=u && neighbors[v] == 1 && !visited[v])
							{
								System.out.println("Visiting: " + u + " Neigh visiting: " + v);
								stack.push(v);
							}
							else if(neighbors[v] == 1 && visited[v])
							{
								System.out.println("Visiting " + u + " Neigh already visited: " + v);
							}
						}
					}		
				}
				else
				{
					System.out.println("Current already visited: " + i);
				}
			}
		}
	}

}
