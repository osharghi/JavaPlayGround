import java.util.ArrayList;

public class Graph {

	ArrayList<GraphNode> nodes;
	
	Graph()
	{
		nodes = new ArrayList<>();
	}
	
	void addNode(GraphNode node)
	{
		nodes.add(node);
	}
	
}
