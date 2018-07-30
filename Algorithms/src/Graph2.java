import java.util.ArrayList;
import java.util.Stack;

public class Graph2 {

	ArrayList<ArrayList<Integer>> aList;
	
	Graph2(int count)
	{
		int V = count;
		aList = new ArrayList<>(V);
		for( int i  = 0; i<V; i++)
		{
			ArrayList<Integer> childList = new ArrayList<>();
			aList.add(childList);
		}
		
 	}
	
	void addEdge(int source, int dest)
	{
		ArrayList<Integer> childList = aList.get(source);
		childList.add(dest);
	}
	
	void checkForCycle() {
		
		boolean hasCycle = false;
		
		for(int i = 0; i<aList.size(); i++)
		{
			hasCycle = hasCycle(i);
			if(hasCycle) break;
		}
		
		System.out.println("Has Cycle: " + hasCycle);
		
	}
	
	boolean hasCycle(int i)
	{
		ArrayList<Integer> visited = new ArrayList<>();
		ArrayList<Integer> neighbors = aList.get(i);
	
		Stack<Integer> stack = new Stack<>();
		stack.push(i);
		
		while(!stack.isEmpty())
		{
			int val = stack.pop();
			if(visited.contains(val))
			{
				return true;
			}
			
			visited.add(val);
			
			ArrayList<Integer> children = aList.get(val);
			for(int child : children)
			{
				stack.push(child);
			}
		}
		
		return false;
	}
	
	
	
}
