import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/find-duplicate-file-in-system/

public class FindDuplicateFile {
	
	public List<List<String>> findDuplicate(String[] paths) {
        
        List<List<String>> results = new ArrayList<>();
        
        if(paths.length == 0) return results;
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s: paths)
        {
            int directoryEndIndex = directoryEnd(s); 
            String directory = s.substring(0, directoryEndIndex)+"/";
        
            int startPara = -1;
            int endPara = -1;
            int startFile = -1;
            
            for(int i = directoryEndIndex; i<s.length(); i++)
            {
                if(s.charAt(i) == '(')
                {
                    startPara = i;
                }
                else if(s.charAt(i) == ')')
                {
                    endPara = i;
                    String content = s.substring(startPara+1, endPara);
                    String file = s.substring(startFile, startPara);
                    String fullPath = directory+file;
                    
                    if(map.containsKey(content))
                    {
                        map.get(content).add(fullPath);
                    }
                    else
                    {
                        List<String> list = new ArrayList<>();
                        list.add(fullPath);
                        map.put(content, list);
                    }
                }
                else if(s.charAt(i) == ' ')
                {
                    startFile = i+1;
                }
            }
        }
        
        for(String key: map.keySet())
        {
            List<String> list = map.get(key);
            if(list.size() >= 2) results.add(list);
        }
        
        return results;
        
        
    }
    
    int directoryEnd(String s)
    {
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == ' ')
            {
                return i;
            }
        }
        
        return -1;
    }

}
