import java.util.ArrayList;

public class PermString {

	PermString()
	{
		String word = "flex";
		ArrayList<String> results = getPerm(word);
		
		
		for(String s: results)
		{
			System.out.println(s);
		}
		
	}
	
	ArrayList<String> getPerm(String word)
	{
		ArrayList<String> results = new ArrayList<>();		
		getPerm("", word, results);
		
		return results;
	}
	
	void getPerm(String prefix, String remainder, ArrayList<String> results)
	{				
		if(remainder.equals(""))
		{
			results.add(prefix);
			return;
		}
		
		for(int i = 0; i<remainder.length(); i++)
		{
			char c = remainder.charAt(i);
			String before = remainder.substring(0, i);
			String after = remainder.substring(i+1, remainder.length());
			getPerm(prefix+c, before+after, results);
		}
		
	}
	
	
}
