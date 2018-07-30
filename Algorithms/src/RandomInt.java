import java.util.Arrays;
import java.util.Random;

public class RandomInt {

	
	RandomInt()
	{
		int[] arr = {3, 2, 1, 4};
		for(int i = 1; i<arr.length; i++)
		{
			arr[i] = arr[i-1] + arr[i];
		}
		
		System.out.println(Arrays.toString(arr));
		
		int result = getRandom(arr);
		
		System.out.println(result);
		
	}
	
	int getRandom(int[] arr)
	{
		Random r = new Random();
		int x = r.nextInt(arr[arr.length-1]);
		
		int low = 0;
		int high = arr.length-1;
		
		System.out.println("random: " + x);
		
		while(low+1<high)
		{
			int mid = (low+high)/2;
			
			if(x>=arr[mid])
			{
				low = mid;
			}
			else
			{
				high = mid;
			}
		}
		
		if(x<arr[low])
		{
			return low;
		}
		
		
		return high;
	}
		
}
