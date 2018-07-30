import java.util.Arrays;

public class InsertionSortRecur {

	InsertionSortRecur()
	{
		int[] arr = {5, 1, 3, 6, 8, 11, 4, 0};
		sort(arr, 1);
		System.out.println(Arrays.toString(arr));

	}
	
	void sort(int[] arr, int index)
	{
		if(index == arr.length || index>arr.length) return;
		
		if(arr[index]<arr[index-1])
		{
			int key = arr[index];
			arr[index] = arr[index-1];
			traverse(arr, index-1, key);
		}
		
		sort(arr, index+1);
		
	}
	
	void traverse(int[] arr, int index, int key)
	{
		if(index == 0)
		{
			arr[index] = key;
			return;
		}
		
		if(key<arr[index-1])
		{
			arr[index] = arr[index-1];
			traverse(arr, index-1, key);
		}
		else
		{
			arr[index] = key;
		}
	}
	

}
