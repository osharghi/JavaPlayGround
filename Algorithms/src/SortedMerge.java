import java.util.Arrays;

public class SortedMerge {
	
	SortedMerge()
	{
		int[] arr1 = new int[10];
		int[] arr2 = new int[5];

		arr1[0] = 0;
		arr1[1] = 1;
		arr1[2] = 2;
		arr1[3] = 3;
		arr1[4] = 4;
		
		arr2[0] = 5;
		arr2[1] = 6;
		arr2[2] = 7;
		arr2[3] = 8;
		arr2[4] = 9;
		
		sort(arr1, arr2);
		
		System.out.println(Arrays.toString(arr1));
	}
	
	void sort(int[] arr1, int[] arr2)
	{
		int k = arr1.length-1;
		int j = arr2.length-1;
		int i = j;
		
		while(i >=0 && j>=0)
		{
			if(arr1[i] >= arr2[j])
			{
				arr1[k] = arr1[i];
				i--;
			}
			else
			{
				arr1[k] = arr2[j];
				j--;
			}
			k--;
		}
	}
	
}
