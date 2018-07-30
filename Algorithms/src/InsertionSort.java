import java.util.Arrays;

public class InsertionSort {

	InsertionSort()
	{
		int[] arr = {5, 1, 3, 6, 8, 11, 4, 0};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	void sort(int[] arr)
	{
		for(int i = 1; i<arr.length; i++)
		{
			int key = arr[i];
			int j = i - 1;
			while(j>=0 && key<arr[j])
			{
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
		}
	}
	
}
