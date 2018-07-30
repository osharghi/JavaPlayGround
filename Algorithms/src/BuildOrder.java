import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class BuildOrder {
	
	BuildOrder()
	{
		char[] proj = {'a','b','c','d','e','f'};
		char[][] dependencies = {{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}};
		
		HashMap<Character, Project> projects = new HashMap<>();
		
		for(char c: proj)
		{
			Project p = new Project(c);
			projects.put(c, p);
		}
		
		for(char[] pair: dependencies)
		{
			Project p = projects.get(pair[0]);
			Project child = projects.get(pair[1]);
			p.children.add(child);
		}
		
		LinkedList<Character> order = doDFS(projects);
		
		System.out.println(order.toString());
	}
	
	LinkedList<Character> doDFS(HashMap<Character, Project> projects)
	{
		LinkedList<Character> order = new LinkedList<>();
		
		Stack<Project> stack = new Stack<>();
		
		for(char key: projects.keySet())
		{
			Project p = projects.get(key);
			
			if(p.state == State.BLANK)
			{
				stack.push(p);
	
				while(!stack.isEmpty())
				{
					Project proj = stack.peek();
					
					if(proj.state != State.COMPLETED)
					{
						if(proj.children.isEmpty())
						{
							proj.state = State.COMPLETED;
							order.addFirst(proj.name);
							stack.pop();
						}
						else if(proj.state == State.BLANK)
						{
							proj.state = State.PARTIAL;
							
							for(Project child: proj.children)
							{
								if(child.state == State.PARTIAL) return null;
								if(child.state == State.BLANK) stack.add(child);
							}
						}
						else
						{
							boolean childrenCompleted = true;
							for(Project child: proj.children)
							{
								if(child.state == State.PARTIAL)
								{
									childrenCompleted = false;
								}
							}
							
							if(childrenCompleted)
							{
								proj.state = State.COMPLETED;
								stack.pop();
								order.addFirst(proj.name);
							}
							
						}
					}
					
				}
			}
		}
		
		return order;
	}
	
	
	enum State {BLANK, PARTIAL, COMPLETED};
	
	class Project{
		
		char name;
		State state;
		ArrayList<Project> children;
		
		Project(char c)
		{
			name = c;
			state = State.BLANK;
			children = new ArrayList<>();
		}
		
	}
	
}
