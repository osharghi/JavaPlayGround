import java.util.LinkedList;

public class GraphDFSCycle {

	GraphDFSCycle()
	{
		Graph g = new Graph(5);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
		
		System.out.println("Has Cycle: " + g.startDFS());
		
	}
	
	class Graph
	{
		int V;
		LinkedList<Integer>[] adj;
		
		Graph(int size)
		{
			V = size;
			adj = new LinkedList[size];
			for(int i = 0; i<size; i++)
			{
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int from, int to)
		{
			adj[from].add(to);
		}
		
		
		boolean hasCycle(int node, boolean[] visited, boolean[] recStack)
		{
			if(recStack[node])
			{
				System.out.println("Cycle at: " + node);
				return true;
			}
			
			if(visited[node])
			{
				return false;
			}
			
			System.out.println("Current: " + node);
			
			recStack[node] = true;
			visited[node] = true;
			
			LinkedList<Integer> neighbors = adj[node];
			for(int i: neighbors)
			{
			
				return hasCycle(i, visited, recStack);
				
			}
			
			recStack[node] = false;
			
			return false;
			
		}
		
		boolean startDFS()
		{
			boolean[] visited = new boolean[V];
			boolean[] recStack = new boolean[V];
			
			for(int i = 0; i<adj.length; i++)
			{
				if(!visited[i])
				{
					if(hasCycle(i, visited, recStack))
					{
						return true;
					}
				}
			}
			
			return false;
			
		}
		
	}
	
	
}
