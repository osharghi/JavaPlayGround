import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class IntPerm {
	
	IntPerm()
	{
		LinkedList<Integer> ll = new LinkedList<>();
		int x = 652;
		getDigits(x, ll);
				
		ArrayList<int[]> results = getPerm(ll);
		if(!results.isEmpty())
		{
			for(int[] arr : results)
			{
				System.out.println(Arrays.toString(arr));
			}
		}
		
		
	}
	
	ArrayList<int[]> getPerm(LinkedList<Integer> ll)
	{
		ArrayList<int[]> results = new ArrayList<>();
		for(int i = 0; i<ll.size(); i++)
		{
			int[] arr = new int[ll.size()];
			int firstDigit= ll.remove(i);
			arr[0] = firstDigit;
			getPerms(1, ll, arr, results);
			ll.add(i, firstDigit);
		}
		
		return results;
		
	}
	
	void getPerms(int index, LinkedList<Integer> ll, int [] arr, ArrayList<int[]> results)
	{
		if(ll.isEmpty())
		{
			results.add(arr);
		}
		
		for(int i = 0; i<ll.size(); i++)
		{
			int[] arrCloned = (int[]) arr.clone();
			int firstDigit= ll.remove(i);
			arrCloned[index] = firstDigit;
			getPerms(index+1, ll, arrCloned, results);
			ll.add(i, firstDigit);
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	}
	
	void getDigits(int x, LinkedList<Integer> ll)
	{
		while(x>0)
		{
			ll.add(x%10);
			x = x/10;
		}
		
		
	}
}
