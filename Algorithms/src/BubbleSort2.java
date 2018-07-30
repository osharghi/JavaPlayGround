import java.util.Arrays;

public class BubbleSort2 {

	BubbleSort2()
	{
		int[] arr = {73, 14, 12, 4, 6, 101, 90, 88, 1};
		int high = arr.length;
		
		for(int i= 0; i<arr.length; i++)
		{
			for(int j = 0; j<high-1; j++)
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
		
		System.out.println(Arrays.toString(arr));
	}
}
