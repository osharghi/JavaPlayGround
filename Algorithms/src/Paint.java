import java.util.Arrays;

public class Paint {

	enum Color {Red, Black, White, Blue};
	
	Paint()
	{
		Color[][] grid = new Color[10][10];
		
		for(Color[] row: grid) 
		{
			Arrays.fill(row, Color.White);
		}
		
		for(Color[] row: grid)
		{
			for(int i = 0; i<row.length; i++)
			{
				if(row[i] == Color.White)
				{
					System.out.print(" W ");
				}
			}
			
			System.out.println("");
			
		}
		
		color(7, 8, Color.Red, grid);
		
		System.out.println("");
		
		for(Color[] row: grid)
		{
			for(int i = 0; i<row.length; i++)
			{
				if(row[i] == Color.Red)
				{
					System.out.print(" R ");
				}
			}
			
			System.out.println("");
			
		}
	
		
	}
	
	void color(int row, int column, Color color, Color[][] grid)
	{
		if(row>= grid.length || row < 0 || column>= grid[0].length || column<0)
		{
			return;
		}
		
		if(grid[row][column] != color)
		{
			grid[row][column] = color;
			color(row-1, column, color, grid);
			color(row+1, column, color, grid);
			color(row, column-1, color, grid);
			color(row, column+1, color, grid);
		}
		
		return;
	}
	
}
