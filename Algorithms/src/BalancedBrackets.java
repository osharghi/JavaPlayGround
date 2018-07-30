
public class BalancedBrackets {

	BalancedBrackets(String s)
	{
		System.out.println(balance(s));
	}
	
	int balance(String s)
	{
		int sum = 0;
		int count = 0;
		for(int i = 0; i<s.length()-1; i++)
		{
			System.out.println(i);
			if(s.charAt(i) == '[')
			{
				count++;
			}
			else
			{
				count --;
			}
			
			if(count<0)
			{
				int j = i+1;
				while(s.charAt(j) != '[')
				{
					j++;
				}
				
				sum += j-i;
				
				char[] charArr = s.toCharArray();
				charArr[i] = '[';
				charArr[j] = ']';
				
				s = new String(charArr);
				
				count = 0;
				
				i += 1;
			}
		}
		
		System.out.println(s);
		return sum;
	}
	
}
