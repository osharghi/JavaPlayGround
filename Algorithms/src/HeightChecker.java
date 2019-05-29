//1051. Height Checker
//https://leetcode.com/problems/height-checker/

class Solution {
    public int heightChecker(int[] heights) {
        
        int count = 0;
        int[] digitCount = new int[101];
        
        for(int i = 0; i<heights.length; i++)
        {
            digitCount[heights[i]]++;
        }
        
        int[] mirrorHeights = new int[heights.length];
        
        int j = 0;
        
        for(int i = 0; i<digitCount.length; i++)
        {
            if(digitCount[i] != 0)
            {
                for(int k = j; k<j+digitCount[i]; k++)
                {
                    mirrorHeights[k] = i;
                }
                j += digitCount[i];
            }
        }
        
        for(int i = 0; i<heights.length; i++)
        {
            if(heights[i] != mirrorHeights[i])
            {
                count++;
            }
        }
        
        return count;
        
    }
}