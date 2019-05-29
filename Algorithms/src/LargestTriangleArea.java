//812. Largest Triangle Area
//https://leetcode.com/problems/largest-triangle-area/


class Solution {
    public double largestTriangleArea(int[][] points) {
        
        double max = Integer.MIN_VALUE;
        
        for(int i = 0; i<points.length-2; i++)
        {
            for(int j = i+1; j<points.length-1; j++)
            {
                for(int k = j+1; k<points.length; k++)
                {
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    
                    double a = getDistance(p1, p2);
                    double b = getDistance(p2, p3);
                    double c = getDistance(p1, p3);
                    
                    double s = (a+b+c)/2;
                    
                    double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
                    
                    if(area>max)
                    {
                        max = area;
                    }
                }
            }
        }
        
        return max;
    }
    
    double getDistance(int[] p1, int[] p2)
    {
        return Math.sqrt(Math.pow(p2[1]-p1[1],2) + Math.pow(p2[0]-p1[0],2));
    }
}