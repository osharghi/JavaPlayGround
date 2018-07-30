import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	HashMap<String, Integer> map;
	
	Solution()
	{
		map = new HashMap<>();
		String[] arr = {"omid.sharghi@gm.ai.l.com"};
		int i = solution(arr);
				
	}
	
	public int solution(String[] L) {
        // write your code in Java SE 8
		
		for(String s: L)
		{
			checkString(s, map);
		}
		
		int totalCount = 0;
		
		for(String key: map.keySet())
		{
			int count = map.get(key);
			if(count>1) {
				totalCount++;
			}
		}
		
		
		return totalCount;

    }
	
	private void checkString(String email, HashMap<String, Integer> map)
	{
		int ampDiscoveredAt = 0;
		
		for(int i= 0; i<email.length(); i++)
		{
			if(email.charAt(i) == '@')
			{
				ampDiscoveredAt = i;
				break;
			}
		}
		
		String pre = email.substring(0, ampDiscoveredAt);
		String post = email.substring(ampDiscoveredAt+1, email.length());
		
		pre = pre.replace("+", "");
		pre = pre.replace(".", "");

		
		int periodCount = 0;
		for(int i = 0; i<post.length(); i++)
		{
			if(post.charAt(i) == '.') periodCount++;
		}
		
		periodCount--;
		
		StringBuilder newPost = new StringBuilder();
		
		for(int i = 0; i<post.length(); i++)
		{
			if(periodCount>0)
			{
				if(post.charAt(i) != '.')
				{
					newPost.append(post.charAt(i));
				}
				else
				{
					periodCount--;
				}
			}
			else
			{
				newPost.append(post.charAt(i));

			}
		}
				
		String newEmail = pre + "@" + newPost;
		
		if(map.containsKey(newEmail))
		{
			int count = map.get(newEmail);
			map.put(newEmail, count+1);
		}
		else
		{
			map.put(newEmail, 1);
		}		
	}
	
}
