import java.util.ArrayList;
import java.util.HashMap;

public class PermNoDups {

	PermNoDups()
	{
		String word = "hello";
		HashMap<Character, Integer> map = new HashMap<>();
		ArrayList<String> results = new ArrayList<>();
		getCharCount(word, map);
		getPerm(results, map, "", word.length());
		for(String s: results)
		{
			System.out.println(s);
		}
	}
	
	void getPerm(ArrayList<String> results, HashMap<Character, Integer> map, String prefix, int size)
	{
		if(prefix.length() == size)
		{
			results.add(prefix);
			return;
		}
		
		
		for(char c: map.keySet())
		{
			int count = map.get(c);
			
			if(count>0)
			{
				count--;
				map.put(c,  count);
				getPerm(results, map, prefix+c, size);
				count++;
				map.put(c,  count);
				
			}
			else {
				
			}
		}
	}
	
	void getCharCount(String word, HashMap<Character, Integer> map)
	{
		for(char c: word.toCharArray())
		{
			if(!map.containsKey(c))
			{
				map.put(c, 0);
			}
			
			map.put(c, map.get(c)+1);
		}
	}

	
	
}
