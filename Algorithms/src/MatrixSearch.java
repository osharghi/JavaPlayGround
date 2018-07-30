
public class MatrixSearch {
	
	MatrixSearch()
	{
		int[][] matrix = {	{15, 20, 40, 85},
							{20, 35, 80, 95},
							{30, 55, 95, 105},
							{40, 80, 100, 120}};
		
		Point p  = search(matrix, 100);
		
		if(p.r == -1)
		{
			System.out.println("Not found");
		}
		else
		{
			System.out.println("Row: " + p.r + " Column: " + p.c);
		}
		
	}
	
	Point search(int[][] matrix, int x)
	{
		int row = matrix.length-1;
		int column = matrix[0].length-1;

		int r = 0;
		int c = column;
		
		while(c>=0 && c<=column && r>=0 && r<=row)
		{
			if(matrix[r][c] == x)
			{
				return new Point(r, c);
			}
			else if(matrix[r][c]<x)
			{
				r++;
			}
			else
			{
				c--;
			}
		}
		
		return new Point(-1,-1);
		
	}
	
	class Point
	{
		int r;
		int c;
		
		Point(int row, int column)
		{
			r = row;
			c = column;
		}
	}

}
