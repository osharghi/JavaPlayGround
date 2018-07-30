import java.util.ArrayList;

public class Paran {

	Paran(int n)
	{
		int leftCount = n;
		int rightCount = n;
		ArrayList<String> results = new ArrayList<>();
		build("(", leftCount-1, rightCount, results);
		
		for(String s: results)
		{
			System.out.println(s);
		}
		
	}
	
	void build(String prefix, int leftCount, int rightCount, ArrayList<String> results)
	{
		if(leftCount == 0 && rightCount == 0)
		{
			results.add(prefix);
			return;
		}
		
		if(leftCount>0)
		{
			build(prefix + '(', leftCount-1, rightCount, results);
		}
		
		if(rightCount>leftCount)
		{
			build(prefix + ')', leftCount, rightCount-1, results);
		}		
	}
	
}
