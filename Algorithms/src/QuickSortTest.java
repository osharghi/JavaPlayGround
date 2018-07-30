import java.util.Arrays;

public class QuickSortTest {

	QuickSortTest()
	{
		int[] arr = {73, 14, 22, 4, 33, 101, 90, 13};
		quicksort(arr, 0, arr.length-1);
		System.out.println("QUICKSORT");
		System.out.println(Arrays.toString(arr));
	}
	
	void quicksort(int[] arr, int low, int high)
	{
		if(low<high)
		{
			int p = partition(arr, low, high);
			quicksort(arr, low, p-1);
			quicksort(arr, p+1, high);
		}
	}
	
	int partition(int[] arr, int low, int high)
	{
		int p = low-1;
		
		for(int i = low; i<high; i++)
		{
			if(arr[i]<arr[high])
			{
				p++;
				
				int temp = arr[i];
				arr[i] = arr[p];
				arr[p] = temp;
			}
		}
		
		int temp = arr[p+1];
		arr[p+1] = arr[high];
		arr[high] = temp;
		return p+1;
	}
	
}
