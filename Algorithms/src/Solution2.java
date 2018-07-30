import java.util.HashMap;

public class Solution2 {
	
	HashMap<Integer, Integer> map;

	Solution2()
	{
		int[] arr = {1, 2, 3, 4, 4, 3, 1, 1, 2, 2, 1};
		System.out.println(getMax(arr));
		
	}
	
	int getMax(int[] trees)
	{
		
		int max = Integer.MIN_VALUE;

		for(int i = 0; i<trees.length; i++)
		{
			int basket1 = trees[i];
			int basket2 = -1;
			int count1 = 1;
			int count2 = 0;
			int jOriginal = -1;
			
			System.out.println("i: " + i);
			
			for(int j = i+1; j<trees.length; j++)
			{
				System.out.println("j: " + j);

				if(trees[j] == basket1)
				{
					count1++;
				}
				else if(basket2 == -1)
				{
					basket2 = trees[j];
					count2++;
					jOriginal = j;
				}
				else if(basket2 == trees[j])
				{
					count2++;
				}
				else if(basket2 != -1 && basket2 != trees[j])
				{
					int total = count1 + count2;
					max = total > max ? total : max;
					System.out.println("Count1: " + count1 + " Count2: " + count2 + " Total: " + total + " Max: " + max);	
					count2 = 0;
					basket2 = -1;
					j = jOriginal;
				}
			}
		}
		
		return max;
		
	}
	
	
	
}
