import java.util.Arrays;

public class SelectionSortRecur {

	SelectionSortRecur()
	{
		int[] arr = {5, 1, 3, 6, 8, 11, 4, 0};
		sort(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));

	}
	
	void sort(int[] arr, int index, int n)
	{
		if(index == n) return;
		
		int k = minIndex(arr, index, n-1);
		
		if(k != index)
		{
			int temp = arr[index];
			arr[index] = arr[k];
			arr[k] = temp;
		}
		
		sort(arr, index+1, n);
		
	}
	
	int minIndex(int[] arr, int i, int j)
	{
		if(i==j)
		{
			return i;
		}
		
		int k = minIndex(arr, i+1, j);
		
		return arr[i]<arr[k] ? i : k;
		
	}
	
}
