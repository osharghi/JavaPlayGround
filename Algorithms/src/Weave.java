import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Weave {

	Weave()
	{
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {4, 5, 6};
		
		LinkedList<Integer> ll1 = getLinkedList(arr1);
		LinkedList<Integer> ll2 = getLinkedList(arr2);
		
		int[] result1 = weave(ll1, ll2);
		int[] result2 = weave(ll2, ll1);

		
		System.out.println(Arrays.toString(result1));
		System.out.println(Arrays.toString(result2));


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
	
	int[] weave(LinkedList<Integer> ll1, LinkedList<Integer> ll2)
	{
		ArrayList<int[]> results = new ArrayList<>();
		int size = ll1.size() + ll2.size();
		int[] arr = new int[size];
		int index = 0;
		weave(ll1, ll2, arr, index);
		return arr;
		
	}
	
	void weave(LinkedList<Integer> ll1, LinkedList<Integer> ll2, int[] arr, int index)
	{
		if(ll1.size() == 0 && ll2.size() == 0)
		{
			return;
		}
		
		if(ll1.size() == 0)
		{
			for(int i: ll2)
			{
				arr[index] = i;
				index++;
			}
			
			return;
		}
		
		if(ll2.size() == 0)
		{
			for(int i: ll1)
			{
				arr[index] = i;
				index++;
			}
			
			return;
		}
		
		int n1 = ll1.removeFirst();
		arr[index] = n1;
		
		index++;
		
		int n2 = ll2.removeFirst();
		arr[index] = n2;
		
		weave(ll1, ll2, arr, index+1);
		
		ll1.addFirst(n1);
		ll2.addFirst(n2);
		
		return;
		
	}
	
}
