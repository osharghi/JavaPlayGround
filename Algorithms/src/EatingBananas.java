import java.util.Arrays;

public class EatingBananas {
	
	EatingBananas()
	{
		int[] piles = {30,11,23,4,20};
		int k = 6;
		System.out.println(findMin(piles, k));
	}
	
	int findMin(int[] arr, int k)
	{
		int min = Integer.MAX_VALUE;
		Arrays.sort(arr);
		
		if(arr.length == k)
		{
			return arr[arr.length-1];
		}
		

		int low = arr[0];
		int high = arr[arr.length-1];
		while(low<=high)
		{
			int mid = (low+high)/2;
			
			boolean isValid = compare(arr, mid, k);
			if(isValid) 
			{
				min = mid;
				high = mid - 1;
			}
			else
			{
				low = mid+1;
			}
		}
		
		return min;
	}
	
	boolean compare(int[] arr, int min, int hours)
	{
		int i = 0;
		int k = hours;
		while(i < arr.length)
		{
			if(arr[i]<=min)
			{
				k--;
			}
			else
			{
				int result = ((arr[i]-1)/min) + 1;
				k -= result;
			}
			
			if(k<0)
			{
				return false;
			}
			
			i++;
		}
		
		return true;
	}
	

}
