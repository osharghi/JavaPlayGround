import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar {
	
	
	PriorityQueue<AStarNode> open;
	ArrayList <AStarNode> closed;
	
	AStar()
	{
		AStarNode A = new AStarNode("A", 20);
		AStarNode B = new AStarNode("B", 9);
		AStarNode C = new AStarNode("C", 10);
		AStarNode E = new AStarNode("E", 7);
		AStarNode F = new AStarNode("F", 12);

		A.edges = new Edge[] {new Edge(B, 2), new Edge(C, 2)};
		B.edges = new Edge[] {new Edge(E, 1)};
		C.edges = new Edge[] {new Edge(E, 3)};
		E.edges = new Edge[] {new Edge(F, 5)};
		
		open = new PriorityQueue<>(5, new NodeComparator());
		closed = new ArrayList<>(5);
		
		AStarNode node = begin(A, F);
		System.out.println("COST: " + node.fCost);
		System.out.print("Order: ");
		print(node);
		
	}
	
	void print(AStarNode current)
	{
		if(current.parent == null)
		{
			System.out.print(current.name);
			return;
		}
		
		print(current.parent);
		System.out.print( " -> " + current.name);
	}
	
	
	AStarNode begin(AStarNode start, AStarNode end)
	{
		if(start == end) return end;
		
		open.add(start);
		
		while(!open.isEmpty())
		{
			
			AStarNode current = open.poll();
			closed.add(current);
			
			if(current == end) return current;
			
			System.out.println("Current:" + current.name + " gCost:" + current.gCost);
			
			for(Edge edge: current.edges)
			{
				if(closed.contains(edge.node)) continue;
				
				int tempG = current.gCost + edge.cost;
				int tempF = tempG + edge.node.hCost;
				
				if(!open.contains(edge.node))
				{
					edge.node.gCost = tempG;
					edge.node.fCost = tempF;
					edge.node.parent = current;
					open.add(edge.node);

					
					System.out.println("Child:" + edge.node.name + " gCost:" + edge.node.gCost + " fCost:" + edge.node.fCost);
					AStarNode peek = open.peek();
					System.out.println("PEEK " + peek.name + ":" + peek.fCost);
				}
				else
				{
					if(tempF < edge.node.fCost)
					{
						edge.node.fCost = tempF;
						edge.node.gCost = tempG;
						edge.node.parent = current;
					}
				}
			}
			
		}
		
		return null;
	}
	
	class NodeComparator implements Comparator<AStarNode>{
		public int compare(AStarNode n1, AStarNode n2){
			
			if(n1.fCost<n2.fCost)
			{
				return -1;
			}
			else if(n1.fCost == n2.fCost)
			{
				return 0;
			}
			else
			{
				return 1;
			}
			
		}
	}

}

class AStarNode
{
	String name;
	AStarNode parent;
	Edge[] edges;
	int gCost;
	int hCost;
	int fCost = 0;
	
	AStarNode(String n, int costToEnd)
	{
		name = n;
		hCost = costToEnd;
		gCost = 0;
	}
	
}

class Edge
{
	AStarNode node;
	int cost;
	
	Edge(AStarNode n, int c)
	{
		node = n;
		cost = c;
	}
}
