import java.util.ArrayList;

public class MeetUp5 {

	//give integer array, find max of non adjacent elements
	
	int maxSum = Integer.MIN_VALUE;
	ArrayList<Integer> maxSet;
	
	MeetUp5()
	{
//		int[] arr = {-2, 1, 3, -4, 5};
		int[] arr = {-2, 1, 3, 3, 8};

		for(int i = 0; i<arr.length-1; i++)
		{
			ArrayList<Integer> resultSet = new ArrayList<>();
			resultSet.add(arr[i]);
			int max = traverse(arr, i+2, resultSet, arr[i]);
			if(max>maxSum)
			{
				maxSum = max;
				maxSet = resultSet;
			}
		}
		
		System.out.println(maxSet.toString());
	}
	
	int traverse(int[] arr, int index, ArrayList<Integer> results, int runningTotal)
	{
		if(index >= arr.length) return runningTotal;
		
		if(arr[index] + runningTotal > runningTotal)
		{
			results.add(arr[index]);
			runningTotal += arr[index];
			return traverse(arr, index+2, results, runningTotal);
		}
		else
		{
			return traverse(arr, index+2, results, runningTotal);
		}
		
		
	}
	
	
	
}
