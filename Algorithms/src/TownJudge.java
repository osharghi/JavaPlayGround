//LeetCode: 997. Find the Town Judge
//https://leetcode.com/problems/find-the-town-judge/

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        boolean[] arr = new boolean[N+1];
        int[] count = new int[N+1];        
        
        for(int i = 0; i<trust.length; i++)
        {
            int[] pair = trust[i];
            arr[pair[0]] = true;
            count[pair[1]]++;
        }
        
        int judge = -1;
        
        for(int i = 1; i<arr.length; i++)
        {
            if(arr[i] == false)
            {
                if(judge == -1)
                {
                    judge = i;
                }
                else
                {
                    return -1;
                }
            }
        }
        
        if(judge == -1 || count[judge] != N-1)
        {
            return -1;
        }
        
        return judge;
    }
}