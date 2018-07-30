
public class ElementAt {
	
	ElementAt()
	{
		Listy l = new Listy();
		
		int index = 1; 
		int val = 29;
		
		while(l.getElementAt(index) != -1 && val>l.getElementAt(index))
		{
			index *= 2;
		}
		
		System.out.println(search(l, val, index/2, index));
		
		

	}
	
	int search(Listy l, int val, int low, int high)
	{
		if(low>high) return -1;
		
		int mid = (low+high)/2;
		int midVal = l.getElementAt(mid);
		
		if(midVal == -1 || midVal > val)
		{
			return search(l, val, low, mid-1);
		}
		else if(midVal<val)
		{
			return search(l, val, mid+1, high);
		}
		else
		{
			return mid;
		}		
	}


	
	class Listy
	{
		int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33};
		
		int getElementAt(int index)
		{
			if(index>arr.length-1)
			{
				return -1;
			}
			else
			{
				return arr[index];
			}
		}
	}
	
}
