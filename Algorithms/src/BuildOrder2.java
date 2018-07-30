import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BuildOrder2 {
	
	
	HashMap<String, Project> projectMap;
	
	BuildOrder2()
	{
		projectMap = new HashMap<>();
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = {
				{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}
		};
		
		for(String s: projects)
		{
			Project p = new Project(s);
			projectMap.put(s, p);
		}
		
		for(String[] dep: dependencies)
		{
			Project p = projectMap.get(dep[0]);
			p.dependencies.add(projectMap.get(dep[1]));
			
		}
		
		LinkedList<String> order = build(projects);
		
		if(order != null)
		{
			for(String s: order)
			{
				System.out.print(s + " -> ");
			}
		}
		else
		{
			System.out.println("NUll");
		}
		

	}
	
	LinkedList<String> build(String[] projects)
	{
		HashSet<Project> visited = new HashSet<>();
		LinkedList<String> order = new LinkedList<>();
		for(String s: projects)
		{
			Project p = projectMap.get(s);
			if(!visited.contains(p))
			{
				if(!doDFS(p, visited, order)) return null;
			}
		}
		
		return order;
	}
	
	boolean doDFS(Project p, HashSet<Project> visited, LinkedList<String> order)
	{
		visited.add(p);
		
		for(Project child: p.dependencies)
		{
			if(!visited.contains(child))
			{
				if(!doDFS(child, visited, order)) return false;
			}
		}
		
		order.addFirst(p.title);
		
		return true;
	}
	
	
	class Project
	{
		String title;
		ArrayList<Project> dependencies;
		
		Project(String s)
		{
			title = s;
			dependencies = new ArrayList<>();
		}
	}

}
