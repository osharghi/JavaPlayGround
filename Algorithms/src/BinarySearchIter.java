
public class BinarySearchIter {

	BinarySearchIter()
	{
		int[] arr = {0, 3, 5, 7, 9, 11, 13, 19, 22, 25, 29, 38};
		System.out.println(search(arr, 0, arr.length-1, 8));

	}
	
	int search(int[] arr, int low, int high, int x)
	{
		int l = low;
		int h = high;
		
		while(l<=h)
		{
			int mid = (l+h)/2;
			
			if(arr[mid] == x) return mid;
			
			if(l == h) 
			{
				if(x<arr[mid])
				{
					return mid;
				}
				else
				{
					return mid+1;
				}
			}
			
			if(x>arr[mid]) l = mid+1;
			
			if(x<arr[mid]) h = mid - 1;
		}
		
		return -1;
	}
}
