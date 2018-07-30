import java.util.Arrays;

public class BubbleSort {
	
	BubbleSort()
	{
		int[] array = {3,1,6,2,4,7};
		sort(array);
		System.out.println("Bubble Sort");
		System.out.println(Arrays.toString(array));

	}
	
	void sort(int[] arr)
	{
		int high = arr.length-1;
		for(int i = 0; i<arr.length-1; i++)
		{
			for(int j = 0; j<high; j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
			high--;
		}
	}
}
