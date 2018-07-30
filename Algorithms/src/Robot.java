import java.util.Arrays;

public class Robot {

	int[][] grid;
	int rows = 10;
	int columns = 8;
	
	Robot()
	{
		grid = new int[rows][columns];
		
		grid[1][0] = -1;
		grid[1][1] = -1;
		grid[2][2] = -1;
		grid[4][3] = -1;
		grid[5][1] = -1;
		grid[6][5] = -1;
		
		boolean[][] mem = new boolean[rows][columns];
		for(boolean[] row: mem)
		{
			Arrays.fill(row, true);
		}
		
		move(0, 0, mem);
		
		for(int[] row: grid)
		{
			for(int i: row)
			{
				System.out.print(i + " ");
			}
			
			System.out.println("");
		}
	}
	
	boolean move(int r, int c, boolean[][] mem)
	{
		if(r == rows-1 && c == columns - 1)
		{
			grid[r][c] = 1;
			System.out.println("reached");
			return true;
		}
		
		if(r < rows && c < columns)
		{
			if(grid[r][c] == -1)
			{
				mem[r][c] = false;
				return false;
			}
			else
			{
				grid[r][c] = 1;
				
				boolean result = false;
				
				if(r+1 < rows && mem[r+1][c])
				{
					result = move(r+1, c, mem);
				}
				
				if(!result)
				{
					if(c+1 < columns && mem[r][c+1])
					{
						result = move(r, c+1, mem);
					}
				}
					
				return result;
				
			}	
		}
		
		return false;
	}
	
	
}
