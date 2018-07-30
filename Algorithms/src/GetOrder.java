import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class GetOrder {
	
	HashMap<Character, ArrayList<Character>> depMap;
	HashMap<Character, Integer> depCount;
	ArrayList<Character> charList;
	ArrayList<Character> unvisited;
	ArrayList<Character> visiting;
	ArrayList<Character> visited;


	
	GetOrder()
	{
		String[] names = {"omid", "yang", "max"};
		charList = new ArrayList<>();
		depMap = new HashMap<>();
		depCount = new HashMap<>();
		buildCharMap(names);
				
		unvisited = new ArrayList<>();
		visiting = new ArrayList<>();
		visited = new ArrayList<>();
		unvisited.addAll(charList);
		
		
		for(Character k: depMap.keySet())
		{
			ArrayList<Character> dependencies = depMap.get(k);
			System.out.print(k + ": ");
			System.out.print(dependencies.toString() + "\n");
			
		}
		
		
		System.out.println(charList.toString());
		
		Stack<Character> stack = new Stack<>();
		
		for(Character c: charList)
		{
			if(!doDFS(stack, c))
			{
				stack = null;
			}
		}
		
		if(stack == null)
		{
			System.out.println("No order");
		}
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
		
//		for(Character k: depCount.keySet())
//		{
//			int count= depCount.get(k);
//			System.out.println(k + ": " + count);
//		}
	}
	
	boolean doDFS(Stack<Character> stack, Character c)
	{
		if(visiting.contains(c))
		{
			return false;
		}
		
		if(unvisited.contains(c))
		{
			unvisited.remove(c);
			visiting.add(c);
			ArrayList<Character> children = depMap.get(c);
			for(Character child: children)
			{
				if(!doDFS(stack, child))
				{
					return false;
				}
			}
			
			visiting.remove(c);
			visited.add(c);
			stack.push(c);
		}
		
		return true;
	}
	
	void buildCharMap(String[] names)
	{
		for(String name: names)
		{
			char prevChar = ' ';
			
			for(char c: name.toCharArray())
			{
				if(prevChar == ' ')
				{
					if(!depMap.containsKey(c))
					{
						ArrayList<Character> dependencies = new ArrayList<>();
						depMap.put(c, dependencies);
					}
					prevChar = c;
				}
				else
				{
					if(!depMap.containsKey(c))
					{
						ArrayList<Character> dependencies = new ArrayList<>();
						depMap.put(c, dependencies);

						ArrayList<Character> prevDependencies = depMap.get(prevChar);
						prevDependencies.add(c);
					}
					else
					{
						ArrayList<Character> prevDependencies = depMap.get(prevChar);
						if(!prevDependencies.contains(c))
						{
							prevDependencies.add(c);
						}
					}
					prevChar = c;
				}
				
				if(!charList.contains(c))
				{
					charList.add(c);
				}
			}
		}
	}
}


