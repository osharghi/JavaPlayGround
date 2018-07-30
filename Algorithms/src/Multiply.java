
public class Multiply {

	
	Multiply()
	{
		int x = 8;
		int y = 1;
		
		int big = x>y ? x : y;
		int small = x<y ? x : y;
		
		System.out.println(multiply(10,9));
			
	}
	
	int multiply(int big, int small)
	{
		if(small == 1)
		{
			return big;
		}
		
		if(small == 0)
		{
			return 0;
		}
		
		int s = small >> 1;
		
		int side1 = multiply(big, s);
		
		if(small%2 != 0)
		{
			return side1 + side1 + big;
		}
		
		return side1+side1;
	}
	
}
