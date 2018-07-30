import java.util.LinkedList;

public class GraphDFSTop {
	
	GraphDFSTop()
	{
		Graph g = new Graph(5);
		
		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
		
		LinkedList<Integer> topList = g.doDFS();
		
		if(topList == null)
		{
			System.out.println("NULL");
		}
		else
		{
			for(int i: topList)
			{
				System.out.print(i + " -> ");
			}
		}
		
		
	}
	
	class Graph
	{
		LinkedList<Integer>[] adj;
		LinkedList<Integer> topList;
		int V;
		
		Graph(int size)
		{
			V = size;
			adj = new LinkedList[size];
			for(int i = 0; i<size; i++)
			{
				adj[i] = new LinkedList<>();
			}
			
			topList = new LinkedList<>();
		}
		
		void addEdge(int from, int to)
		{
			adj[from].add(to);
		}
		
		LinkedList<Integer> doDFS()
		{
			boolean[] recStack = new boolean[V];
			boolean[] visited = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{
				if(hasCycle(i, recStack, visited))
				{
					return null;
				}
				
			}
			
			return topList;
		}
		
		boolean hasCycle(int i, boolean[] recStack, boolean[] visited)
		{
			if(recStack[i]) return true;
			
			if(visited[i]) return false;
			
			visited[i] = true;
			recStack[i] = true;
			
			LinkedList<Integer> neighbors = adj[i];
			
			for(int n: neighbors)
			{
				if(hasCycle(n, recStack, visited)) return true;
			}
			
			recStack[i] = false;
			
			topList.addFirst(i);
			
			return false;
			
		}
		
	}

}
