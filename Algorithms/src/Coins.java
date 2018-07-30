import java.util.Arrays;

public class Coins {

	Coins()
	{
		int[] mem = new int[10+1];
		Arrays.fill(mem, -1);
		int[] denom = {25, 10, 5, 1};
		int total = getCombos(10, mem, denom);
		System.out.println(total);
	}
	
	int getCombos(int n, int[] mem, int[] denom)
	{
		if(n == 0)
		{
			return 1;
		}
		
		if(n < 0)
		{
			return 0;
		}
		
		if(mem[n] != -1)
		{
			return mem[n];
		}
		
		int total = 0;
		
		for(int i: denom)
		{
			total += getCombos(n-i, mem, denom);
		}
	
		mem[n] = total;
		return mem[n];
	}
}
