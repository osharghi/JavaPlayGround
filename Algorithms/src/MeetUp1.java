import java.util.ArrayList;
import java.util.Arrays;

public class MeetUp1 {

	int[] mins;
	int[] maxs;
	
	MeetUp1()
	{
		// Given m arrays find the maximum difference between 2 elements of different arrays
		int[] arr1=  {3, 1, 5, 9, 11};
		int[] arr2=  {99, 2, 5, 8, -2};
		int[] arr3 = {-200, 3, 50, 6, 1};
		int[] arr4 = {-76, 50, 2, 83, 72};
		
		ArrayList<int[]> arrs = new ArrayList<>();
		arrs.add(arr1);
		arrs.add(arr2);
		arrs.add(arr3);
		arrs.add(arr4);
		
		mins = new int[4];
		maxs = new int[4];
		
		initializeMinMax(arrs);
		
		System.out.println(Arrays.toString(mins));
		System.out.println(Arrays.toString(maxs));
		
		int maxVal = getMax(maxs, mins);
		System.out.println(maxVal);
		
		
	}
	
	void initializeMinMax(ArrayList<int[]> arrs)
	{
		for(int i = 0; i<arrs.size(); i++)
		{
			int[] arr = arrs.get(i);
			int min = Integer.MAX_VALUE;
			int max= Integer.MIN_VALUE;
			
			for(int j = 0; j<arr.length; j++)
			{
				if(arr[j] > max)
				{
					max = arr[j];
				}
				
				if(arr[j] < min)
				{
					min = arr[j];
				}
			}
			
			mins[i] = min;
			maxs[i] = max;
			
		}
	}
	
	int getMax(int[] max, int[] min)
	{
		int maxVal = Integer.MIN_VALUE;
		
		for(int i = 0; i<max.length; i++)
		{
			for(int j = 0; j<min.length; j++)
			{
				if(i == j) continue;
				
				int diff = max[i] - min[j];
				if(diff>maxVal) maxVal = diff;
			}
		}
		
		return maxVal;
	}
	
	
	
}
