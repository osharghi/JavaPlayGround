
public class RotatedArray {
	
	RotatedArray()
	{
		int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
//		int[] arr = {5, 16, 19, 20, 25, 5, 5, 5, 5, 5, 5, 5};


		System.out.println(bSearch(arr, 15, 0, arr.length-1));
	}
	
	int bSearch(int[] arr, int x, int low, int high)
	{
		if(low>high)
		{
			return -1;
		}
		
		int mid = (low+high)/2;
		
		if(arr[mid] == x)
		{
			return mid;
		}
		
		if(arr[low]>arr[mid])
		{
			if(x>arr[mid] && x<=arr[high]) {
				return bSearch(arr, x, mid+1, high);
			}
			else {
				return bSearch(arr, x, low, mid-1);
			}
		}
		else if(arr[mid]<arr[high])
		{
			if(x>arr[mid] && x<=arr[high])
			{
				return bSearch(arr, x, mid+1, high);
			}
			else
			{
				return bSearch(arr, x, low, mid-1);
			}
		}
		else if(arr[low] == arr[mid])
		{
			if(arr[mid] != arr[high])
			{
				return bSearch(arr, x, mid+1, high);
			}
			else
			{
				int result = bSearch(arr, x, low, mid-1);
				
				if(result == -1)
				{
					return bSearch(arr, x, mid+1, high);
				}
				
				return result;
			}
		}
		
		return -1;
		
	}


}
