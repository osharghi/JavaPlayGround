import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;



public class Graph {
	
	ArrayList<ArrayList<Edge>> graph;	//ArrayList used to represent an adjacency list. graph stores an ArrayList of edges for each vertex.
	ArrayList<Edge> edges;				//ArrayList of Edge objects. Represents the number of edges in a graph. 				
	ArrayList<Vertex> vertices;			//ArrayList of Vertex objects. Represents the vertices in the graph.
	PriorityQueue<Vertex> queue;			//Priority queue used for Prim's Algorithm. Sorted in descending order.
	
	//DFS
	final int WHITE = 0;					//integer value used to represent an unvisited vertex.
	final int GRAY = 1;					//integer value used to represent an visited vertex.
	final int BLACK = 2;					//integer value used to represent a fully explored vertex.
	private int time;
	boolean cycleExists;					//boolean used to recognize when an edge exists inside a cycle
	Vertex fromVertex;					//Reference to the beginning vertex of an edge. Used for DFS.
	Vertex toVertex;						//Reference to the end vertex of an edge. Used for DFS.
	Stack<Vertex> verticesInCycle;		//Stack to keep track of which vertices are in the traversal of a DFS when attempting to detect an edge in a cycle.

	public int graphSize;				//number of vertices in a graph.
	public int numOfEdges;				//number of edges in a graph.
	private int edgesRemovedCount;		//number of edges removed when running the "new" algorithm.
	
	public long startTime;				//Used to store start time of when an algorithm begins running.
	
	//Initiates Prim's algorithm
	public void getMST()
	{
	    setRoot();
	    addVerticesToMinQueue();
	    findMinWeights();
	}
	
	//Set the root of MST
	private void setRoot()
	{
		Vertex v = vertices.get(0);
		v.minWeight = 0.00;
	}
	
	//Sets the minimum weight of each vertex based on what Vertex is popped from the Minimum Priority Queue.
	private void findMinWeights()
	{		
		while(!queue.isEmpty())
		{
			Vertex fromVertex = queue.poll();
			
			if(fromVertex != null)
			{
				ArrayList<Edge> edges = graph.get(fromVertex.label);
				
				for(int i = 0; i<edges.size(); i++)
				{
					Edge e = edges.get(i);
					updateVertexWeightAndParent(e.toVertex, e.weight, fromVertex);
				}
			}			
		}	
	}
	
	//Updates the weight and parent of a vertex
	private void updateVertexWeightAndParent(Vertex toVertex, double weight, Vertex parentVertex)
	{
		if(weight<toVertex.minWeight  && queue.contains(toVertex))
		{
			toVertex.minWeight = weight;
			toVertex.parent = parentVertex;
			queue.remove(toVertex);
			queue.add(toVertex);
		}
	}
	
	//Adds vertices to the Minimum Priority Queue
	private void addVerticesToMinQueue()
	{
		for(int i = 0; i<vertices.size(); i++)
		{
			Vertex v = vertices.get(i);
			queue.add(v);
		}
	}
	
	//Returns the number of edges in a graph
	public int edgeCount()
	{
		return edges.size();
	}
	
	//Returns the number of edges removed when running the "new" algorithm
	public int numOfEdgesRemoved()
	{
		System.out.println("Edges Removed: " + edgesRemovedCount + " Number Of Edges In MST: " + (edges.size() - edgesRemovedCount));
		return edgesRemovedCount;
	}
	
	//Calculates the total weight of a MST
	public Double calculateTotalMSTWeight()
	{
		Double totalWeight = 0.0;
		for(Vertex v:vertices)
		{
			totalWeight = totalWeight + v.minWeight;
		}
		
		System.out.println("Total Minimum Weight: " + totalWeight);
		
		return totalWeight;
	}
	
	//Sorts ArrayList of edges in descending order
	public void sortEdges()
	{
		Collections.sort(edges);	
	}
	
	//Runs a recursive version of the new algorithm for finding and removing edges in a cycle
	public void newAlgorithmRecursive()
	{
		sortEdges();
		DFS();
	}
	
	//Runs a iterative version of the new algorithm for finding and removing edges in a cycle
	public void newAlgorithmIterative()
	{
		sortEdges();
		iterativeDFS();
	}
	
	//Runs recursive Depth First Search for finding edges in a cycle
	private void DFS()
	{
		initializeVertices();
		cycleExists = false;
		verticesInCycle = new Stack<Vertex>();
		time = 0;
		edgesRemovedCount = 0;
		
		for(Edge e: edges)
		{
			Vertex u = vertices.get(e.fromVertex.label);
			fromVertex = u;
			Vertex v = vertices.get(e.toVertex.label);
			toVertex = v;			
			
			if(u.color == WHITE)
			{
				DFS_VISIT(u);
			}
			
			if(cycleExists)
			{
				if(verticesInCycle.contains(toVertex))
				{
					removeEdgeFromAdjacencyList(e.fromVertex, e.toVertex);
					edgesRemovedCount++;
				}
			}
			
			u.resetVertices();
			verticesInCycle.clear();
			cycleExists = false;
		}
	}
	
	//Recursive portion of Depth First Search that marks vertices as visited.
	private void DFS_VISIT(Vertex u)
	{
		time++;
		u.discoverTime = time;
		u.color = GRAY;
		
		ArrayList<Edge> edges = graph.get(u.label);
		
		if(edges.size() != 0)
		{	
			for(Edge e: edges)
			{
				Vertex v = e.toVertex;	
								
				if(v.color == WHITE)
				{
					v.parent = u;
					verticesInCycle.push(v);
					DFS_VISIT(v);
				}
				else if(v.color != WHITE && v.label.equals(fromVertex.label) && !u.parent.label.equals(fromVertex.label) && verticesInCycle.contains(toVertex))
				{
					cycleExists = true;
				}	
				
				if(cycleExists)
				{
					break;
				}
			}
		}
		
		if(!cycleExists)
		{
			if(!verticesInCycle.isEmpty())
			{
				verticesInCycle.pop();
			}
		}
		
		u.color = BLACK;	
		time++;
		u.finishTime = time;
	}
	
	//Runs iterative Depth First Search for finding edges in a cycle
	private void iterativeDFS()
	{
		initializeVertices();
		cycleExists = false;
		verticesInCycle = new Stack<Vertex>();
		edgesRemovedCount = 0;
		
		for(Edge e: edges)
		{
			Vertex u = vertices.get(e.fromVertex.label);
			fromVertex = u;
			Vertex v = vertices.get(e.toVertex.label);
			toVertex = v;	
			
			ArrayList<Edge> uEdges = graph.get(u.label);
			ArrayList<Edge> vEdges = graph.get(v.label);
			
			if(uEdges.size() > 1 && vEdges.size() > 1)
			{
				
				verticesInCycle.push(v);
				u.color = GRAY;
				v.color = GRAY;
				v.parent = u;
				
				while(!verticesInCycle.isEmpty() && !cycleExists)
				{
					Vertex w = verticesInCycle.pop();
					ArrayList<Edge> edgesOfVertexW = graph.get(w.label);
					
					for(Edge edgeofW : edgesOfVertexW)
					{
						if(cycleExists)
						{
							break;
						}
						
						Vertex neighborOfW = edgeofW.toVertex;
						if(neighborOfW.color == WHITE)
						{
							neighborOfW.color = GRAY;
							neighborOfW.parent = w;
							verticesInCycle.push(neighborOfW);
						}
						else if(neighborOfW.color != WHITE && neighborOfW.label.equals(fromVertex.label) && 
								!w.parent.label.equals(fromVertex.label) && toVertex.color != WHITE)
						{
							if(w.parent.label.equals(v.label))
							{
								cycleExists = true;
								break;
							}
							else
							{
								//Once vertex traversal meets vertex of edge, trace parents of edge to make sure the other
								//vertex of the edge is in the traversal path
								Vertex traceVertex = w;
								while(traceVertex.parent != null)
								{
									if(traceVertex.label.equals(toVertex.label))
									{
										cycleExists = true;
										break;
									}
									else
									{
										traceVertex = traceVertex.parent;
									}
								}
							}
						}
					}	
				}
				
				if(cycleExists)
				{
					removeEdgeFromAdjacencyList(e.fromVertex, e.toVertex);
					edgesRemovedCount++;
				}
				
				u.resetVertices();
				verticesInCycle.clear();
				cycleExists = false;
			}
		}
	}
	
	//Removes an edge from the adjacency list after it has been found in a cycle. 
	private void removeEdgeFromAdjacencyList(Vertex v1, Vertex v2)
	{
		ArrayList<Edge> edges = graph.get(v1.label);
		for(int i = 0; i<edges.size(); i++)
		{
			Edge e = edges.get(i);
			if(e.toVertex.equals(v2))
			{
				edges.remove(i);
			}
		}
		
		edges = graph.get(v2.label);
		for(int i = 0; i<edges.size(); i++)
		{
			Edge e = edges.get(i);
			if(e.toVertex.equals(v1))
			{
				edges.remove(i);
			}
		}
	}
	
	//Loads graph from text file and initiates the necessary data structures for storage.
	public void graphLoader(String fileName)
	{
		
		File currentDir = new File(".");
	    File parentDir = currentDir.getParentFile();
	    File newFile = new File(parentDir,fileName);

		
		try(BufferedReader br = new BufferedReader(new FileReader(newFile))) {
		   
			StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    
		    //Initialize adjacency list, queue, and list of vertices and edges
		    graphSize = Integer.parseInt(line);
		    graph = new ArrayList<ArrayList<Edge>>(graphSize);
		    VertexComparator vertexComparator = new VertexComparator();
		    queue = new PriorityQueue<>(graphSize, vertexComparator);
		    vertices = new ArrayList<Vertex>(graphSize);
		    createVertices();
		    edges = new ArrayList<Edge>();
		    setUpGraphList(graphSize);
		    
		    System.out.println("Number of Vertices: " + graphSize);
		    
		    sb.append(line);
	        sb.append(System.lineSeparator());
	        line = br.readLine();
	        
	        numOfEdges = Integer.parseInt(line);
	        System.out.println("Number of Edges: " + numOfEdges);
		   
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        if(line != null)
		        {
		        		Edge [] edgePair = createEdge(line);
		        		addNodeToAdjList(edgePair[0]);
		        		addNodeToAdjList(edgePair[1]);
		        		edges.add(edgePair[0]);
		        }		        
		    }   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Creates Edge Objects
	private Edge[] createEdge(String line)
	{
		Edge[] edgePair = new Edge[2];
		String[] splitStr = line.split("\\s+");
		Integer vertexFromID = Integer.parseInt(splitStr[0]);
		Integer vertexToID = Integer.parseInt(splitStr[1]);
		Vertex vFrom = vertices.get(vertexFromID);
		Vertex vTo = vertices.get(vertexToID);
		Double weight = Double.parseDouble(splitStr[2]);
		edgePair[0] = new Edge(vFrom, vTo, weight);
		edgePair[1] = new Edge(vTo, vFrom, weight);
		return edgePair;
	}
	
	//Creates Vertex Objects
	private void createVertices()
	{
		for(int i = 0; i<graphSize; i++)
		{
			Vertex v = new Vertex(i);
			vertices.add(v);
		}
	}
	
	//Sets up adjacency list
	private void setUpGraphList(int numOfVertices)
	{
		for(int i = 0; i<numOfVertices; i++)
		{
			graph.add(new ArrayList<Edge>());
		}
	}
	
	//Prints Vertices and their attributes
	public void printVertices()
	{
		System.out.println("Vertices: ");
		
		for(int i = 0; i<vertices.size(); i++)
		{
			Vertex v = vertices.get(i);
			if(v != null)
			{
				if(v.parent != null)
				{
					System.out.println("Vertex: " + v.label + " Min. Weight: " + v.minWeight + " Parent Vertex: " + v.parent.label);
				}
				else
				{
					System.out.println("Vertex: " + v.label + " Min. Weight: " + v.minWeight + " Parent Vertex: Null");
				}
			}
		}
		
		System.out.println(" ");
	}
	
	//Prints adjacency list
	public void printEdges()
	{
		System.out.println("\nAdjacency List:");
		
		for(int i = 0; i<graph.size(); i++)
		{
			ArrayList<Edge> edges = graph.get(i);
			
			System.out.print(i + " -> ");
			
			for(int j = 0; j<edges.size(); j++)
			{
				Edge e = edges.get(j);
				
				if(j != edges.size()-1)
					System.out.print("(" + e.toVertex.label + ", " + e.weight + ")" + " -> ");
				else
					System.out.println("(" + e.toVertex.label + ", " + e.weight + ")");
			}
			
		}
		
		System.out.println("");
	}
	
	//Initializes Vertex objects
	private void initializeVertices()
	{
		for(int vID = 0; vID<graph.size(); vID++)
		{
			Vertex v = new Vertex(vID);
			vertices.add(v);
		}
	}
	
	//Sorts ArrayList of vertices
	public void sortVertices()
	{
		Collections.sort(vertices);
	}
	
	//Adds edge of adjacency list
	private void addNodeToAdjList(Edge e)
	{
		ArrayList<Edge> edges = graph.get(e.fromVertex.label);
		edges.add(e);
	}
	
	//Sets the start time when running Prim's and the new algorithm
	public void setStartTime()
	{
		this.startTime = System.currentTimeMillis();
	}
	
	//Determines the duration of running Prim's and the new algorithm
	public void duration()
	{
		System.out.println("Time to run: " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	class Edge implements Comparable <Edge>
	{
		Vertex fromVertex;		//Represents one vertex of an edge.
		Vertex toVertex;			//Represents one vertex of an edge.
		Double weight;			//Represents weight of an edge.
		boolean visited;			//Represents whether an edge has been visited when running DFS.

		//Initializes an edge object.
		Edge(Vertex fromVertex, Vertex toVertex, Double weight)
		{
			this.fromVertex = fromVertex;
			this.toVertex = toVertex;
			this.weight = new Double(weight);
			this.visited = false;
		}
		
		//Compare method used to put edges in descending order
		public int compareTo(Edge e)
		{			
			if(e.weight < weight)
			{
				return -1;
			}
			else if (e.weight > weight)
			{
				return 1;
			}
			return 0;
		}
	}
	
	class Vertex implements Comparable <Vertex>
	{
		Integer label;					//Indicates the vertex number.
		Double minWeight;				//The minimum weight a vertex determined when using Prim's.
		Vertex parent;					//Parent vertex determined when using Prim's.
		int color;						//Color of a vertex used when running DFS to determine if vertex has been visited.
		int discoverTime = 0;			//Keeps track of when vertex is discovered when running DFS.
		int finishTime = 0;				//Keeps track of when vertex has been fully explored when running DFS.
		
		//Initializes vertex object
		Vertex(Integer label)
		{
			this.label = label;
			this.minWeight = new Double(10000.00);
			this.parent = null;
			this.color = WHITE;
		}
		
		//Returns the number edges a vertex has.
		public int getEdgeCount(Vertex v)
		{
			ArrayList<Edge> edges = graph.get(v.label);
			return edges.size();
		}
		
		//Resets vertex after running DFS.
		private void resetVertices()
		{
			for(Vertex v: vertices)
			{
				v.color = WHITE;
				v.parent = null;
				v.discoverTime = 0;
				v.finishTime = 0;
			}
		}
		
		//Used to sort vertex objects in the vertices list.
		public int compareTo(Vertex v)
		{
		     return(label - v.label);
		}
	}
	
	//Used to order Minimum Priority Queue.
	private class VertexComparator implements Comparator<Vertex> {

	    public int compare(Vertex a, Vertex b) {
	        if(a.minWeight < b.minWeight)
	        {
	        		return -1;
	        }
	        else if(a.minWeight > b.minWeight)
	        {
	        		return 1;
	        }
	        
	        return 0;
	    }
	}
}
