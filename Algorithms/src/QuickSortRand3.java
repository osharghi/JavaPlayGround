import java.util.Arrays;
import java.util.Random;

public class QuickSortRand3 {
	
	QuickSortRand3()
	{
		int[] arr = {73, 14, 12, 4, 6, 101, 90, 88, 1};
		quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}
	
	void quicksort(int[] arr, int low, int high)
	{
		if(low<high)
		{
			int p = partition_r(arr, low, high);
			quicksort(arr, low, p-1);
			quicksort(arr, p+1, high);
		}
	}
	
	int partition_r(int[] arr, int low, int high)
	{
		Random rand = new Random();
		
		int r = low + rand.nextInt(high-low+1);
		System.out.println("r: " + r + " Length: " + arr.length);
		
		int temp = arr[high];
		arr[high] = arr[r];
		arr[r] = temp;
		
		return partition(arr, low, high);
		
	}
	
	int partition(int[] arr, int low, int high)
	{
		int p = low -1;
		
		for(int i = low; i<high; i++)
		{
			if(arr[i]<arr[high])
			{
				p++;
				
				int temp = arr[p];
				arr[p] = arr[i];
				arr[i] = temp;
			}
		}
		
		int temp = arr[p+1];
		arr[p+1] = arr[high];
		arr[high] = temp;
		return p+1;
		
	}

}
