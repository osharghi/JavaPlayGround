import java.util.Arrays;
import java.util.HashMap;

public class MaxPerm {

	MaxPerm()
	{
		int[] arr1 = { 0, 20, 7, 11};
		int[] arr2 = { 1, 32, 10, 14};
		HashMap<Integer, Integer> map1 = getMap(arr1, arr2);
		
		for(int key: map1.keySet())
		{
			arr1[map1.get(key)] = key;
		}
		
		System.out.println(Arrays.toString(arr1));

	}
	
	HashMap<Integer, Integer> getMap(int[] arr1, int[] arr2)
	{
		
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		
		for(int i = 0; i<arr2.length; i++)
		{
			map2.put(arr2[i], i);
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for(int i = 0; i<arr1.length; i++)
		{
			
			if(i<arr1.length-1)
			{
				if(arr1[i]<arr2[i])
				{
					if(arr1[i+1]>arr2[i])
					{
						swap(arr1, i, i+1);
					}
				}
			}
			
			map1.put(arr1[i], map2.get(arr2[i]));
			System.out.println(arr1[i] +  " : " + map2.get(arr2[i]));
		}


		
		
		return map1;
		
	}
	
	void swap(int[] arr1, int i, int j)
	{
		int temp = arr1[i];
		arr1[i] = arr1[j];
		arr1[j] = temp;
	}
	
}
