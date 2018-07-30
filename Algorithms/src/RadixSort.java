import java.util.Arrays;

public class RadixSort {
	
	RadixSort()
	{
		int[] arr = {73, 14, 12, 4, 6, 101, 90, 88};
		int max = getMax(arr);

		
		for(int exp =1; max/exp>0; exp *= 10)
		{
			sort(arr, arr.length, exp);
		}
		
		System.out.println("Radix Sort");
		System.out.println(Arrays.toString(arr));

	}
	

	
	int getMax(int[] arr)
	{
		int max = arr[0];
		for(int i = 1; i<arr.length; i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
		}
		
		return max;
	}
	
	
	void sort(int[] arr, int n, int exp)
	{
		int[] output = new int[n];
		int[] count = new int[10];
		
		Arrays.fill(count, 0);
		int i;
		
		for(i = 0; i<n; i++)
		{
			count[(arr[i]/exp)%10]++;
		}
		
		for(i = 1; i<10; i++)
		{
			count[i] += count[i-1];
		}
		
		for(i = n-1; i>=0; i--)
		{
			output[count[(arr[i]/exp)%10]-1] = arr[i];
			count[(arr[i]/exp)%10]--;
		}
		
		for(i = 0; i<n; i++)
		{
			arr[i] = output[i];
		}
	}
	
//	void sort(int arr[], int n, int exp)
//	{
//		int[] output = new int[n];
//		int[] counter = new int[10];
//		Arrays.fill(counter, 0);
//		int i;
//		
//		for(i = 0; i<n; i++)
//		{
//			counter[(arr[i]/exp)%10]++;
//		}
//		
//		for(i = 1; i<10; i++)
//		{
//			counter[i] += counter[i-1];
//		}
//		
//		for(i = n - 1; i>=0; i--)
//		{
//			output[counter[(arr[i]/exp)%10]-1] = arr[i];
//			counter[(arr[i]/exp)%10]--;
//		}
//		
//		for(i = 0; i<n; i++)
//		{
//			arr[i] = output[i];
//		}
//	}
}
	

