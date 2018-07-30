import java.util.Stack;


public class BetweenNodes {

	Graph g;
	
	BetweenNodes()
	{
		GraphCreator graphCreator = new GraphCreator();
		g = graphCreator.g;
		GraphNode start = graphCreator.start;
		GraphNode end = graphCreator.end;
		System.out.println(search(start, end));

		
	}
	
	boolean search(GraphNode start, GraphNode end)
	{
		Stack<GraphNode> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty())
		{
			GraphNode current = stack.pop();
			
			for(GraphNode child: current.children)
			{
				if(child.state == GraphNode.State.UnVisited)
				{
					if(child == end)
					{
						return true;
					}
					
					child.state = GraphNode.State.Visiting;
					stack.push(child);
				}
			}
			
			current.state = GraphNode.State.Visited;
		}
		
		return false;
	}
	
}
