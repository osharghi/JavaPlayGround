
public class WeightBoat {
	
	WeightBoat(int limit, int[] weights)
	{	
		int min = minBoats(limit, weights);
		System.out.println(min);
	}
	
	int minBoats(int limit, int[] weights)
	{
		int l = 0;
		int r = weights.length-1;
		int count = 0;
		while(l<=r)
		{
			count++; 
			if(weights[l] + weights[r] <= limit)
			{
				l++;
			}
			
			r--;
		}
		
		return count;
	}
}
