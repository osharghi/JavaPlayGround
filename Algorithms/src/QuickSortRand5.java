import java.util.Arrays;
import java.util.Random;

public class QuickSortRand5 {

	QuickSortRand5()
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
		int r = low+ rand.nextInt(high-low+1);
		
		swap(arr, r, high);
		
		return partition(arr, low, high);
		
	}
	
	int partition(int[] arr, int low, int high)
	{
		int p = low - 1;
		
		for(int i = low; i<high; i++)
		{
			if(arr[i]<arr[high])
			{
				p++;
				swap(arr, i, p);
			}
		}
		
		swap(arr, p+1, high);
		return p+1;
		
	}
	
	void swap(int[] arr, int x, int y)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
}
