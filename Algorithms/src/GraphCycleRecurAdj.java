import java.util.ArrayList;
import java.util.LinkedList;

public class GraphCycleRecurAdj {

	GraphCycleRecurAdj()
	{
		Graph g = new Graph(5);
		g.addEge(0, 1);
		g.addEge(0, 2);
		g.addEge(1, 2);
		g.addEge(2, 0);
		g.addEge(2, 3);
		g.addEge(3, 3);
		g.addEge(4, 3);
		
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
		
		void addEge(int u, int v)
		{
			LinkedList<Integer> neighbors = adj.get(u);
			neighbors.add(v);
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			boolean[] recurStack = new boolean[V];
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("Currenet: " + i);
				doDFS(i, visited, recurStack);
			}
		}
		
		void doDFS(int current, boolean[] visited, boolean[] recurStack)
		{
			if(recurStack[current])
			{
				System.out.println("CYCLE Detected at: " + current);
				return;
			}
			
			if(visited[current])
			{
				System.out.println("Aready visited: " + current);
				return;
			}
			
			System.out.println("VISITING: " + current);
			
			recurStack[current] = true;
			visited[current] = true;
			
			LinkedList<Integer> neighbors = adj.get(current);
			for(Integer neigh: neighbors)
			{
				System.out.println("VISITING: " + current + " Neighbor: " + neigh);
				doDFS(neigh, visited, recurStack);
			}
			
			recurStack[current] = false;
					
		}
	}
	
}
