
public class Rectangles {

	Rectangles()
	{
		int[] rect1 = {0,0,1,1};
		int[] rect2 = {0,0,3,3};
		
		if(checkHorizontal(rect1, rect2)){
			
			System.out.println(checkVertical(rect1, rect2));
		}
		else
		{
			System.out.println("False");
		}

	}
	
	boolean checkHorizontal(int[] rect1, int[] rect2)
	{
		if(rect1[0]<=rect2[0] && rect1[2]>rect2[0]){
			
			return true;
		}
		else if(rect2[0]<=rect1[0] && rect2[2]>rect1[0])
		{
			return true;
		}
		
		return false;
	}
	
	boolean checkVertical(int[] rect1, int[] rect2)
	{
		if(rect1[1]<=rect2[1] && rect1[3]> rect2[1])
		{
			return true;
		}
		else if(rect2[1]<=rect1[1] && rect2[3]> rect1[1])
		{
			return true;
		}
		
		return false;
	}
	
}
