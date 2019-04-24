//852. Peak Index in a Mountain Array
//https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    public int peakIndexInMountainArray(int[] A) {
     
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        
        for(int i=1; i<A.length-1; i++)
        {
            if(A[i]>A[i-1] && A[i]>A[i+1])
            {
                if(A[i]>maxValue)
                {
                    maxIndex = i;
                    maxValue = A[i];
                }
            }
        }
        return maxIndex;
    }
}