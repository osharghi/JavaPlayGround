
public class Add {

	Add(int x, int y)
	{
		int big = x > y ? x : y;
		int small = x < y ? x : y;
		System.out.println(add(big, small));
	}
	
	int add(int big, int small)
	{
		small = big - small;
		big = big*2;
		
		return big - small;
	}
}
