//1002. Find Common Characters
//https://leetcode.com/problems/find-common-characters/

class Solution {
    
    public List<String> commonChars(String[] A) {
        
        List<String> results = new ArrayList<>();
        ArrayList<int[]> charCount = new ArrayList<>();
        
        for(String word: A)
        {
            int[] count = buildList(word);
            charCount.add(count);
        }
        
        for(int i=0; i<26; i++)
        {
            int min = Integer.MAX_VALUE;
            
            for(int[] count: charCount)
            {
                min = Math.min(min, count[i]);
            }
            
            if(min>0)
            {
                for(int j = 0; j<min; j++)
                {
                    results.add(String.valueOf((char)(i+97)));
                }
            }
            
        }
        
        return results;
        
    }
    
    int[] buildList(String word)
    {
        int[] arr = new int[26];
        
        for(char c: word.toCharArray())
        {
            int index = c-'a';
            arr[index]++;
        }
        
        return arr;
    }
}