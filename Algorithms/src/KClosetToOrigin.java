//973. K Closest Points to Origin
//https://leetcode.com/problems/k-closest-points-to-origin/


class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        int[] distances = new int[points.length];
        
        if(points.length == 1)
        {
            return points;
        }
        
        for(int i= 0; i<points.length; i++)
        {
            int[] point = points[i];
            
            int x = point[0] - 0;
            int y = point[1] - 0;
            
            x = x*x;
            y = y*y;
                
            distances[i] = x+y;
        }
        
        Arrays.sort(distances);
        int maxDistance = distances[K-1];
        
        int[][] results = new int[K][2];
        
        int j = 0;
        for(int i = 0; i<points.length; i++)
        {
            int[] point = points[i];
            
            int x = point[0] - 0;
            int y = point[1] - 0;
            
            x = x*x;
            y = y*y;
            
            int distance = x+y;
            
            if(distance<=maxDistance)
            {
                results[j] = point;
                j++;
            }   
        }
        
        return results;
   
    }
}