import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphObjDFS {

	GraphObjDFS()
	{
		Graph g = new Graph();
		g.addNode(0);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(4, 3);
		
		g.doDFS();
				
	}
	
	
	class Graph
	{
		HashMap<Integer, GNode> nodes;
		
		Graph()
		{
			nodes = new HashMap<>();
		}
		
		void addNode(int i)
		{
			GNode node = new GNode(i);
			nodes.put(i, node);
		}
		
		void addEdge(int u, int v)
		{
			GNode fromNode = nodes.get(u);
			GNode toNode = nodes.get(v);
			fromNode.neighbors.add(toNode);
		}
		
		void doDFS()
		{
			boolean[] visited = new boolean[nodes.size()];
			
			for(int key: nodes.keySet())
			{
				GNode node = nodes.get(key);
				
				if(!visited[key])
				{
					System.out.println("CURRENT: " + key);
					doDFS(visited, node);
				}
				else
				{
					System.out.println("CANT CURRENT: " + key);
				}
			}
		}
		
		void doDFS(boolean[] visited, GNode current)
		{
			visited[current.val] = true;
			
			System.out.println("visiting: " + current.val);
			
			LinkedList<GNode> neighbors = current.neighbors;
			
			for(GNode neighbor: neighbors)
			{
				if(!visited[neighbor.val])
				{
					System.out.println("visiting: " + current.val + " child: " + neighbor.val);
					doDFS(visited, neighbor);
				}
				else
				{
					System.out.println("visiting: " + current.val + " cant child: " + neighbor.val);

				}
			}
		}
		
		class GNode
		{
			int val;
			LinkedList<GNode> neighbors;
			
			GNode(int i)
			{
				val = i;
				neighbors = new LinkedList<>();
			}
			
			void addNeighbor(GNode neighbor)
			{
				neighbors.add(neighbor);
			}
		}
		
	}
	
	
	
	
	
}
