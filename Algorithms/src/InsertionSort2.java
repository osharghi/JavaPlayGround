import java.util.Arrays;

public class InsertionSort2 {

	InsertionSort2()
	{
		int[] arr = {73, 14, 12, 4, 6, 101, 90, 88, 1};
		
		for(int i = 1; i<arr.length; i++)
		{
			int key = arr[i];
			int j = i -1;
			while(j>=0 && key<arr[j])
			{
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
		}
		
		System.out.println(Arrays.toString(arr));

	}
	
}
