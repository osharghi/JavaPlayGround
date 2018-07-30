import java.util.Arrays;

public class URLify {
	
	URLify()
	{
		String word = "Mr John Smith    ";
		int lengthTrue = 13;
		System.out.println(urlify(word, lengthTrue));
	}
	
	String urlify(String word, int trueLength)
	{
		char[] wordArr = word.toCharArray();
		int k = word.length()-1;
		
		for(int i = trueLength-1; i>=0; i--)
		{
			System.out.println(Arrays.toString(wordArr));
			
			if(wordArr[i] != ' ')
			{
				wordArr[k] = wordArr[i];
				k--;
			}
			else
			{
				wordArr[k] = '0';
				wordArr[k-1] = '2';
				wordArr[k-2] = '%';
				k = k - 3;
			}
		}
		
		return new String(wordArr);
	}

}
