import java.util.ArrayList;
import java.util.HashMap;

public class Solution1 {

	HashMap<Integer, Integer> map;
	
	Solution1()
	{
		map = new HashMap<>();
	}
	
	public int solution(int[] A) {
		
		setUpMap(A);
		
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		
		for(int key: map.keySet())
		{
			int count = map.get(key);
			if(count > max1)
			{
				max1 =count;
			}
			else if(count > max2)
			{
				max2 = count;
			}
		}
		
		return max1+max2;
    }
	
	void setUpMap(int[] arr)
	{
		for(int i = 0; i<arr.length; i++)
		{
			int currentVal = -1;
			int otherBasket = -1;
			int currentValCount = 0;
			
			if(!map.containsKey(arr[i]))
			{
				currentVal = arr[i];
				currentValCount++;
				map.put(currentVal, currentValCount);
				
				
				for(int j = i+1; j<arr.length; j++)
				{
					if(j == arr.length) break;
					
					if(arr[j] == currentVal)
					{
						currentValCount++;
					}
					else
					{
						if(otherBasket == -1) {
							otherBasket = arr[j];
						}
						else if(otherBasket != arr[j])
						{
							int count = map.get(currentVal);
							if(currentValCount>count)
							{
								count = currentValCount;
								map.put(currentVal, count);
							}
							currentValCount = 0;
							otherBasket = arr[j];
						}
						else
						{
							currentValCount++;
						}
					}
				}
			}
		}
		
	}
}
