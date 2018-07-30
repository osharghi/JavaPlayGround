
public class SparseSearch {
	
	SparseSearch()
	{
		String[] arr = {"at", "", "", "", "ball", "be", "", "car", "", "", "dad", "", ""};
		String target = "dad";
		
		System.out.println(search(arr, target, 0, arr.length-1));
		
	}
	
	int search(String[] arr, String target, int low, int high)
	{
		if(low>high) return -1;
		
		int mid = (low+high)/2;
		
		if(arr[mid].isEmpty())
		{
			int  left = mid - 1;
			int right = mid + 1;
			while(true)
			{
				if(left<low && right>high)
				{
					return -1;
				}
				else if(right<=high && !arr[right].isEmpty())
				{
					mid = right;
					break;
				}
				else if(left>=low && !arr[low].isEmpty())
				{
					mid = low;
					break;
				}
				
				right++;
				left--;
			}
		}
			
		if(arr[mid].equals(target)) return mid;
		
		if(arr[mid].compareTo(target)>0)
		{
			return search(arr, target, low, mid - 1);
		}
		else
		{
			return search(arr, target, mid+1, high);
		}
		
		
	}
	
		
}
