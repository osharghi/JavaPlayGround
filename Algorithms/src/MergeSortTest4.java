import java.util.Arrays;

public class MergeSortTest4 {

	MergeSortTest4()
	{
		int[] arr = {73, 14, 12, 4, 6, 101, 90, 88, 1};
		mergesort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	void mergesort(int[] arr, int low, int high)
	{
		if(low<high)
		{
			int mid = (low+high)/2;
			mergesort(arr, low, mid);
			mergesort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	
	void merge(int[] arr, int low, int mid, int high)
	{
		int[] helper = new int[arr.length];
		for(int i = 0; i<arr.length; i++)
		{
			helper[i] = arr[i];
		}
		
		int i = low;
		int j = mid+1;
		int k = low;
		
		while(i<=mid && j<=high)
		{
			if(helper[i]<=helper[j])
			{
				arr[k] = helper[i];
				i++;
			}
			else
			{
				arr[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while(i<=mid)
		{
			arr[k] = helper[i];
			i++;
			k++;
		}
	}
	
	
}
