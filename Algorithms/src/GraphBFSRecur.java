import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSRecur {

	GraphBFSRecur()
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
			boolean[] visited = new boolean[V];
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("STARTING: " + i);
				
				if(!visited[i])
				{
					queue.add(i);
					doBFS(visited, queue);
				}
				else
				{
					System.out.println("NO START: " + i);

				}
			}
		}
		
		void doBFS(boolean[] visited, Queue<Integer> queue)
		{
			if(!queue.isEmpty())
			{
				
				int i = queue.poll();
				
				if(visited[i]) return;
				
				visited[i] = true;
				LinkedList<Integer> neighbors = adj[i];
				
				System.out.println("CURRENT: " + i);

				for(int neighbor: neighbors)
				{
					if(!visited[neighbor])
					{
						System.out.println("CURRENT: " + i + " ADD: " + neighbor);

						queue.add(neighbor);
					}
					else
					{
						System.out.println("CURRENT: " + i + " CANT: " + neighbor);

					}
				}
				
				doBFS(visited, queue);

			}	
		}
	}
	
}
