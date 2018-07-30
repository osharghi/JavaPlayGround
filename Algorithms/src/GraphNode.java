import java.util.ArrayList;

public class GraphNode {

	int data;
	ArrayList<GraphNode>children;
	State state;
	

	
	GraphNode(int d)
	{
		data = d;
		children = new ArrayList<>();
		state = State.UnVisited;
	}
	
	void addChild(GraphNode child)
	{
		children.add(child);
	}
	
	enum State
	{
		UnVisited,
		Visiting,
		Visited
	}

}
