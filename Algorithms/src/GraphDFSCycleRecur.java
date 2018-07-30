import java.util.LinkedList;

public class GraphDFSCycleRecur {
	
	GraphDFSCycleRecur()
	{
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
//		g.addEdge(2, 0);
		g.addEdge(2, 3);
//		g.addEdge(3, 3);
		
		System.out.println(g.doDFS());
		
		
	}

	class Graph
	{
		int V;
		LinkedList<Integer>[] adj;
		
		Graph(int size)
		{
			V = size;
			adj = new LinkedList[V];
			for(int i = 0; i<size; i++)
			{
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int from, int to)
		{
			adj[from].add(to);
		}
		
		boolean doDFS()
		{
			boolean[] visited = new boolean[V];
			boolean[] recStack = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{
				if(hasCycle(i, visited, recStack))
				{
					return true;
				}
			}
			
			return false;
		}
		
		boolean hasCycle(int i, boolean[] visited, boolean[] recStack)
		{
			if(recStack[i]) {
				return true;
			}
			
			if(visited[i]) {
				return false;
			}
			
			visited[i] = true;
			recStack[i] = true;
			
			LinkedList<Integer> neighbors = adj[i];
			
			for(int j: neighbors)
			{

				if(hasCycle(j, visited, recStack))
				{
					return true;
				}
			}
			
			recStack[i] = false;
			
			return false;
			
		}
		
		
	}
}
