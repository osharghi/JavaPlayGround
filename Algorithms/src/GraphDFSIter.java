import java.util.LinkedList;
import java.util.Stack;

public class GraphDFSIter {

	GraphDFSIter()
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
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("START: " + i);
				if(!visited[i])
				{
					Stack<Integer> stack = new Stack<>();
					stack.push(i);
					
					while(!stack.isEmpty())
					{
						int n = stack.pop();
						visited[n] = true;
						System.out.println("Current: " + n);

						LinkedList<Integer> neighbors = adj[n];
						
						for(int neighbor: neighbors)
						{
							if(!visited[neighbor])
							{
								System.out.println("Current: " + n + " Add: " + neighbor);

								stack.push(neighbor);
							}
							else
							{
								System.out.println("Current: " + n + " Cant: " + neighbor);

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
