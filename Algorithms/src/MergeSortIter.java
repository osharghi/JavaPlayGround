import java.util.Arrays;

public class MergeSortIter {
	
	MergeSortIter()
	{
		int[] arr = {5, 1, 3, 6, 8, 11, 4};
		int high = arr.length-1;
		System.out.println("Merge sort ITER");
	
		for(int m = 1; m<=high; m *= 2)
		{
			for(int i = 0; i<high; i += 2*m)
			{
				int from = i;
				int mid = i+m-1;
				int to = Math.min(i + 2*m -1, high);
				merge(arr, from, mid, to);
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	void merge(int[] arr, int low, int mid, int high)
	{
		int[] helper = new int[arr.length];
		for(int i= 0; i<arr.length; i++)
		{
			helper[i] = arr[i];
		}
		
		int i = low;
		int j = mid+1;
		int k = low;
		
		while(i<=mid && j <= high)
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
