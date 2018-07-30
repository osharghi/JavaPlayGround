import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Perm {

	Perm()
	{
		int i = 128;
		int count = getLength(i);
		LinkedList<Integer> ll = addElements(count, i);
		ArrayList<int[]> perms = new ArrayList<>();
		getPerms(ll, perms);
		ArrayList<Integer> nums = addNums(perms, count);
		for(Integer val: nums)
		{
			System.out.println(val);
		}
		
		boolean isPowOf2 = isPowerOf2(nums);
		System.out.println(isPowOf2);
	}
	
	int getLength(int i) 
	{
		int count = 0;
		while(i > 0)
		{
			i = i/10;
			count++;
		}
		
		return count;
	}
	
	LinkedList<Integer> addElements(int count,int i)
	{
		int k = 0;
		LinkedList<Integer> ll = new LinkedList<>();
		while(k<count)
		{
			ll.add(i%10);
			i = i/10;
			k++;
		}
		
		return ll;
	}
	
	void getPerms(LinkedList<Integer> oLink, ArrayList<int[]> results)
	{
		int size = oLink.size();
		int k = 0;
		for(int i = 0; i<size; i++)
		{
			int[] arrNew = new int[size];
			int num = oLink.remove(i);
			arrNew[k] = num;
			getPerms(oLink, results, arrNew, k+1);
			oLink.add(i, num);
		}
	}
	
	void getPerms(LinkedList<Integer> oLink, ArrayList<int[]> results, int[] arr, int k)
	{
		if(oLink.isEmpty())
		{
			results.add(arr);
			return;
		}
		
		for(int i = 0; i<oLink.size(); i++)
		{
			int[] clonedArr = (int[]) arr.clone();
			int num = oLink.remove(i);
			clonedArr[k] = num;
			getPerms(oLink, results, clonedArr, k+1);
			oLink.add(i, num);
		}
	}
	
	ArrayList<Integer> addNums(ArrayList<int[]>results, int size)
	{
		ArrayList<Integer> totalNums = new ArrayList<>();
		for(int[] arr: results)
		{
			int val = 0;
			int dec = size-1;
			for(int i = 0; i<size; i++)
			{
				val = val + (int)Math.pow(10, dec) * arr[i];
				dec--;
			}
			
			totalNums.add(val);
			
		}
		
		return totalNums;
	}
	
	boolean isPowerOf2(ArrayList<Integer> results)
	{
		boolean result = false;
		
		for(Integer val: results)
		{
			while(true)
			{
				if(val%2 != 0)
				{
					break;
				}
				
				val = val/2;
				
				if(val == 1) return true;
			}			
		}
		
		return result;
	}
	

	
	
	
}
