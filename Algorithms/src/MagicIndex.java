
public class MagicIndex {

	MagicIndex()
	{
		int[] arr = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		int val = getMagic(arr, 0, arr.length-1);
		System.out.println(val);
		
		
	}
	
	int getMagic(int[] arr, int low, int high)
	{
		if(low>high) 
		{
			return -1;
		}
		
		int midIndex = (low+high)/2;
		int midVal = arr[midIndex];
		
		if(midVal == midIndex)
		{
			return midVal;
		}
		
		int leftIndex = Math.min(midVal, midIndex-1);
		int left = getMagic(arr, low, leftIndex);
		if(left != -1)
		{
			return left;
		}
		
		int rightIndex = Math.max(midVal, midIndex+1);
		int right = getMagic(arr, rightIndex, high);
		
		return right;
		
	}
	
}
