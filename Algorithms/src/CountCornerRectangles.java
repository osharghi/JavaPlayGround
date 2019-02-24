
//https://leetcode.com/problems/number-of-corner-rectangles/

public class CountCornerRectangles {

	public int countCornerRectangles(int[][] grid) {
        
        int count = 0;
        
        for(int r = 0; r<grid.length-1; r++)
        {
            for(int c = 0; c<grid[0].length-1; c++)
            {
                if(grid[r][c] == 1)
                {
                    
                    count += findRightCorner(grid, r, c);
                }   
            }
        }
        
        return count;
    }
    
    int findRightCorner(int[][] grid, int row1, int cLeft)
    {
        int count = 0;
        
        for(int cRight = cLeft+1; cRight<grid[0].length; cRight++)
        {
            if(grid[row1][cRight] == 1)
            {                
                for(int row2 = row1+1; row2<grid.length; row2++)
                {
                    if(grid[row2][cLeft] == 1 && grid[row2][cRight] == 1)
                    {
                        count++;
                    }                    
                }

            }
        }
        
        return count;
    }
	
	
}
