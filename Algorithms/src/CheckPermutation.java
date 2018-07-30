import java.util.Arrays;

public class CheckPermutation {

	CheckPermutation(String word1, String word2)
	{
		if(word1.length() != word2.length())
		{
			System.out.println("False");
		}
		else
		{
			word1 = sort(word1);
			word2 = sort(word2);
			
			System.out.println(word1);
			System.out.println(word2);

			
			if(word1.equals(word2))
			{
				System.out.println("True");
			}
			else
			{
				System.out.println("False");

			}
		}
	}
	
	String sort(String word)
	{
		char[] arr = word.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
}
