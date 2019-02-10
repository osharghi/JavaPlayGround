import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

//https://leetcode.com/problems/partition-labels/

public class PartitionLabels {
	
	PartitionLabels()
	{
		List<Integer> results = partitionLabels("ababcbacadefegdehijhklij");
	}
	
	public List<Integer> partitionLabels(String S) {
	        
	        List<Integer> results = new ArrayList<>();
	        
	        if(S.length() == 0 || S == null) return results;
	        
	        HashMap<Character, Integer>  charMap = new HashMap<>();
	        TreeMap<Integer, Integer> parMap = new TreeMap<>();
	        
	        int par = 0;
	        
	        for(int i = 0; i<S.length(); i++)
	        {
	            char c = S.charAt(i);
	            
	            if(!charMap.containsKey(c))
	            {
	                par++;
	                charMap.put(c, i);
	                parMap.put(par, i);
	            }
	            else
	            {
	                int lastIndex = charMap.get(c);
	                charMap.put(c, i);
	                int previousPar = par-1;
	                
	                while(previousPar>0 && parMap.get(previousPar)>=lastIndex)
	                {
	                    previousPar--;
	                    if(previousPar == 0) break;
	                }
	                
	                previousPar += 1;
	                parMap.put(previousPar, i);
	                for(int j = previousPar+1; j<=par; j++)
	                {
	                    parMap.remove(j);
	                }
	                
	                par = previousPar;
	            }
	        }
	        
	        int currentSum = 0;
	        for(Integer key: parMap.keySet())
	        {
	            int endIndex = parMap.get(key);
	            results.add(endIndex-currentSum+1);
	            currentSum += endIndex-currentSum+1;
	            
	        }
	        
	        return results;
	    }

}
