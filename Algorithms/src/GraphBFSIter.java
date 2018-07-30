import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSIter {

	GraphBFSIter()
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(4, 3);
		
		g.doBFS();
	}
	
	class Graph
	{
		int V;
		LinkedList<Integer>[] adj;
		
		Graph(int size)
		{
			V = size;
			adj = new LinkedList[V];
			
			for(int i = 0; i<V; i++)
			{
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int from, int to)
		{
			adj[from].add(to);
		}
		
		void doBFS()
		{
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("START: " + i);
				
				if(!visited[i])
				{
					queue.add(i);
					visited[i] = true;
					
					while(!queue.isEmpty())
					{
						int n = queue.poll();
						
						System.out.println("AT: " + n);

						LinkedList<Integer> neighbors = adj[n];
						
						for(int neighbor: neighbors)
						{
							if(!visited[neighbor])
							{
								System.out.println("AT: " + n + " ADD: " + neighbor);

								queue.add(neighbor);
								visited[neighbor] = true;
							}
							else
							{
								System.out.println("AT: " + n + " CANT: " + neighbor);

							}
						}
						
					}
				}
				else
				{
					System.out.println("NO START: " + i);

				}
			}
			
		}
		
		
	}
}
