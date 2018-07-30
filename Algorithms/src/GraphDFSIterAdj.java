import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphDFSIterAdj {

	GraphDFSIterAdj()
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
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
			LinkedList<Integer> list = adj.get(u);
			list.add(v);
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[V];
			Stack<Integer> stack = new Stack<>();
			
			for(int i = 0; i<V; i++)
			{
				System.out.println("Current: " + i);
				
				if(!visited[i])
				{
					stack.push(i);
					
					while(!stack.isEmpty())
					{
						int current = stack.pop();
						visited[current] = true;
						
						System.out.println("Visiting: " + current);
	
						LinkedList<Integer> neighbors = adj.get(current);
						
						for(Integer n: neighbors)
						{
							if(!visited[n])
							{
								System.out.println("Visiting: " + current + " Neighbor: " + n);
								stack.push(n);
							}
							else
							{
								System.out.println("Visiting: " + current + " Cant Neighbor: " + n);
							}
						}
					}
				}
			}
		}
	}
	
}
