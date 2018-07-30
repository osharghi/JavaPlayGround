
public class LongestSubString {

	LongestSubString()
	{
		String str = "123123";
		String sub = newSub(str);
		System.out.println(sub);
		
	}
	
	String newSub(String str)
	{
		int start = 0; 
		int end = str.length()-1;
		char[] arr = str.toCharArray();
		String sub = "";
		while(start < end)
		{
			for(int i = end; i>start; i--)
			{
				if((start - i + 1)%2 == 0)
				{
					boolean isValid = check(start, i, arr);
					
					if(isValid)
					{
						if(i-start+1 > sub.length())
						{
							if(i == str.length()-1)
							{
								sub=str.substring(start);
							}
							else
							{
								sub = str.substring(start, i+1);
							}
						}
					}
				}				
			}
			
			start++;
		}
		
		return sub;
	}
	
	boolean check(int start, int end, char[] arr)
	{
		int mid = (start+end)/2;
		
		int val1 = 0;
		int val2 = 0;
		
		for(int i = start; i<=mid; i++)
		{
			char c = arr[i];
			val1 += Character.getNumericValue(c);
		}
		
		for(int i = mid+1; i<=end; i++)
		{
			char c = arr[i];
			val2 += Character.getNumericValue(c);
		}
		
//		System.out.println(val1 + " and " + val2);
		
		if(val1 == val2)
		{
			return true;
		}
		
		return false;
	}
	
	
}
