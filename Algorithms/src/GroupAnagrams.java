import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/group-anagrams/

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> results = new ArrayList<>();

        if(strs.length == 0) return results;

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs)
        {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sSort = new String(arr);

            if(map.containsKey(sSort))
            {
                map.get(sSort).add(s);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sSort, list);
            }

        }

        for(String key: map.keySet())
        {
            List<String> list = map.get(key);
            results.add(list);
        }

        return results;

    }


}
