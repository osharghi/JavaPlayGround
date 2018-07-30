
public class GraphCreator {

	Graph g;
	GraphNode start;
	GraphNode end;
	
	GraphCreator()
	{
		GraphNode g1 = new GraphNode(1);
		GraphNode g2 = new GraphNode(2);
		GraphNode g3 = new GraphNode(3);
		GraphNode g4 = new GraphNode(4);
		GraphNode g5 = new GraphNode(5);
		GraphNode g6 = new GraphNode(6);
		GraphNode g7 = new GraphNode(7);
		GraphNode g8 = new GraphNode(8);
		GraphNode g9 = new GraphNode(9);
		GraphNode g10 = new GraphNode(10);
		
		g1.addChild(g2);
		g1.addChild(g4);
		
		g2.addChild(g1);
		g2.addChild(g6);
		
		g3.addChild(g4);
		g3.addChild(g5);
		
		g4.addChild(g3);
		g4.addChild(g1);
		
		g5.addChild(g3);
		g5.addChild(g6);
		g5.addChild(g7);
		g5.addChild(g10);
		
		g6.addChild(g2);
		g6.addChild(g5);
		g6.addChild(g8);
		g6.addChild(g9);
		
		g7.addChild(g5);
		g8.addChild(g6);
		g9.addChild(g6);
		g10.addChild(g5);

		g = new Graph();
		g.addNode(g1);
		g.addNode(g2);
		g.addNode(g3);
		g.addNode(g4);
		g.addNode(g5);
		g.addNode(g6);
		g.addNode(g7);
		g.addNode(g8);
		g.addNode(g9);
		g.addNode(g10);
		
		start = g4;
		end = new GraphNode(11);
	}
	
	
	
}
