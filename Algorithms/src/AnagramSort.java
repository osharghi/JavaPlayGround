import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class AnagramSort {

	AnagramSort()
	{
		String[] arr = {"atc", "dog", "frog", "tac", "act", "cat", "toe", "fly"};
		Arrays.sort(arr, new AnagramComparator());
		for(String s: arr)
		{
			System.out.println(s);
		}
	}
}

class AnagramComparator implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		s1 = new String(arr1);
		s2 = new String(arr2);
		
		return s1.compareTo(s2);
	}

	
	
}
	
	
