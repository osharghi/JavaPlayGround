import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ArrayPerm {

	ArrayPerm()
	{
		int[] arr = {1, 2, 3};
		LinkedList<Integer> ll = getLinkedList(arr);
		ArrayList<int[]> results = getPerms(ll);
		for(int[] a: results)
		{
			System.out.println(Arrays.toString(a));
		}
		
	}
	
	LinkedList<Integer> getLinkedList(int[] arr)
	{
		LinkedList<Integer> ll = new LinkedList<>();
		for(int i = 0; i<arr.length; i++)
		{
			ll.add(arr[i]);
		}
		
		return ll;
	}
	
	ArrayList<int []> getPerms(LinkedList<Integer> ll)
	{
		ArrayList<int[]> results = new ArrayList<>();
		for(int i = 0; i<ll.size(); i++)
		{
			int index = 0;
			int[] arr = new int[ll.size()];
			int n = ll.remove(i);
			arr[index] = n;
			getPerms(ll, arr, index+1, results);
			ll.add(i, n);
		}
		
		return results;
	}
	
	void getPerms(LinkedList<Integer> ll, int[] arr, int index, ArrayList<int[]> results)
	{
		if(ll.isEmpty())
		{
			results.add(arr);
			return;
		}
		
		for(int i = 0; i<ll.size(); i++)
		{
			int[] cloned = (int[]) arr.clone();
			int n = ll.remove(i);
			cloned[index] = n;
			getPerms(ll, cloned, index+1, results);
			ll.add(i, n);
		}
		
	}
	
}
