import java.util.Arrays;

public class SelectionSort {
	
	SelectionSort()
	{
		int[] arr = {5, 1, 3, 6, 8, 11, 4, 0};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	void sort(int[] arr)
	{
		for(int i = 0; i<arr.length-1; i++)
		{
			int iMin = i;
			for(int j = i+1; j<arr.length; j++)
			{
				if(arr[j]<arr[iMin])
				{
					iMin = j;
				}
			}
			
			if(iMin != i)
			{
				int temp = arr[i];
				arr[i] = arr[iMin];
				arr[iMin] = temp;
			}
		}
	}
}
