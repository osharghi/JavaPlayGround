import java.util.LinkedList;

public class GraphDFSRecurAdjListUndirected {
	
	GraphDFSRecurAdjListUndirected()
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
		LinkedList<Integer>[] adj;
		
		Graph(int size)
		{
			V = size;
			adj = new LinkedList[V];
			
			for(int i = 0; i< V; i++)
			{
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int u, int v)
		{
			LinkedList<Integer> llu = adj[u];
			llu.add(v);
			
			LinkedList<Integer> llv = adj[v];
			llv.add(u);
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
					System.out.println("Current: " + i + " Already Visited");
				}
			}
		}
		
		void doDFS(int u, boolean[] visited)
		{
			visited[u] = true;
			
			System.out.println("Visiting: " + u);
			
			LinkedList<Integer> neighbors = adj[u];
			
			for(Integer v: neighbors)
			{
				if(!visited[v])
				{
					System.out.println("Visiting: " + u + " Neigh: " + v);
					doDFS(v, visited);
				}
				else
				{
					System.out.println("Visiting: " + u + " Neigh already visited: " + v);
				}
			}
		}
		
	}

}
