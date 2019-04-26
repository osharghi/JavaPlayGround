//888. Fair Candy Swap
//https://leetcode.com/problems/fair-candy-swap/

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int sa = 0;
        int sb = 0;
        
        for(int x: A) sa += x;
        for(int x: B) sb += x;
        
        HashSet<Integer> setB = new HashSet<>();
        for(int x: B) setB.add(x);
        
        int[] result = new int[2];
        
        for(int x: A)
        {
            int delta = x + (sb-sa)/2;
            if(setB.contains(delta))
            {
                result[0] = x;
                result[1] = delta;
                break;
    
            }
        }
        
        return result;   
    }
}