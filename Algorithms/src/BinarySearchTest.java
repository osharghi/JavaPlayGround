
public class BinarySearchTest {

	BinarySearchTest()
	{
		int[] arr = {1, 5, 9, 11, 17, 22, 34, 47, 52, 69, 73, 81, 98};
		System.out.println(search(arr, 0, arr.length-1, 10));
	}
	
	int search(int[] arr, int low, int high, int x)
	{
		if(low<=high)
		{
			int mid = (low+high)/2;
						
			if(arr[mid] == x) return mid;
			
			if(low==high) return mid;

			
			if(x<arr[mid]) return search(arr, low, mid-1, x);
			
			if(x>arr[mid]) return search(arr, mid+1, high, x);
		}
		
		return -1;
	}
	
	
}
