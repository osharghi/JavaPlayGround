import java.util.ArrayList;
import java.util.Arrays;


//LeetCode: 821. Shortest Distance to a Character
//https://leetcode.com/problems/shortest-distance-to-a-character/

public class ShortestDistanceToACharacter {
	
	public int[] shortestToChar(String S, char C) {
	     
        int[] arr = new int[S.length()];
        ArrayList<Integer> indices = new ArrayList<>();
        
        Arrays.fill(arr, Integer.MAX_VALUE);
        
        for(int i = 0; i<S.length(); i++)
        {
            if(S.charAt(i) == C)
            {
                arr[i] = 0;
                indices.add(i);
            }
        }
        
        for(int i:indices)
        {
            adjust(arr, i, S);
            
        }
        
        return arr;
    }
    
    void adjust(int[] arr, int index, String S)
    {
        int dist = 0;
        int left = index-1;
        int right = index+1;
        
        while(left>=0 && right<=S.length()-1)
        {
            dist++;
            if(dist<arr[left]) arr[left] = dist;
            if(dist<arr[right]) arr[right] = dist;
            left--;
            right++;
        }
        
        while(left>=0)
        {
            dist++;
            if(dist<arr[left]) arr[left] = dist;
            left--;
        }
        
        while(right<=S.length()-1)
        {
            dist++;
            if(dist<arr[right]) arr[right] = dist;
            right++;
        }
    }

}
