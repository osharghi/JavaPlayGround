import java.util.ArrayList;
import java.util.LinkedList;

public class GraphDFSCycleRecurUndirectedAdj {

	GraphDFSCycleRecurUndirectedAdj()
	{
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 2);
		g.doDFS();
	}
	
	class Graph
	{
		int V;
		ArrayList<LinkedList<Integer>> adj;
		
		Graph(int size)
		{
			V = size;
			adj = new ArrayList<>();
			for(int i = 0; i<V; i++)
			{
				adj.add(new LinkedList<>());
			}
		}
		
		void addEdge(int u, int v)
		{
			LinkedList<Integer> uList = adj.get(u);
			LinkedList<Integer> vList = adj.get(v);
			uList.add(v);
			vList.add(u);
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			
			for(int i= 0; i<V; i++)
			{
				if(!visited[i])
				{
					if(isCyc(i, visited, -1))
					{
						System.out.println("Cycle Detected");
					}
					else
					{
						System.out.println("NO cycle");
					}
				}
			}
		}
		
		boolean isCyc(int u, boolean[] visited, int parent)
		{
			System.out.println("VIsiting " + u + " Parent " + parent);
			
			if(visited[u])
			{
				System.out.println("Cycle detected at: " + u + " Parent: " + parent);
				return true;
			}
			
			visited[u] = true;
			
			LinkedList<Integer> neighbors = adj.get(u);
			
			for(Integer v: neighbors)
			{
				if(v!= parent)
				{
					if(isCyc(v, visited, u))
					{
						return true;
					}
				}
			}
			
			return false;
		}
	}
	
}
