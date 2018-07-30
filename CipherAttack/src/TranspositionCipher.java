import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import org.apache.commons.lang3.StringUtils;

public class TranspositionCipher {

	PriorityQueue<PlainText> queue;
	
	PlainText attack(String cryptoText, int keyLength)
	{
		queue =  new PriorityQueue<>(2000, new TextComparator());
//		String c = cryptoText.toLowerCase();		
		String c = cryptoText;		
		int kLength = keyLength;
		ArrayList<int[]> keyPermutations = getPerms(kLength);
		decryptAttack(keyPermutations, c, kLength);
		
		PlainText pObj = queue.peek();
		return pObj;
	}
	
	String encrypt(String p, int[] key)
	{
		String pText = p.replaceAll("\\s+","");
		
		StringBuilder sBuild = new StringBuilder();
		
		for(int i = 0; i<pText.length(); i+=key.length)
		{
			int start = i;
			int end = i+key.length;
			sBuild.append(encryptBlock(start, end, pText, key));
		}
		
		return sBuild.toString();
	}
	
	String decrypt(String cText, int[] key)
	{
		StringBuilder sBuild = new StringBuilder();

		
		for(int i = 0; i<cText.length(); i+=key.length)
		{
			int start = i;
			int end = i+key.length;
			sBuild.append(decryptBlock(start, end, cText, key));
		}
		
		String plainText = sBuild.toString();
		return plainText;
	}
	
	void decryptAttack(ArrayList<int[]> keys, String cText, int kLength)
	{
		for(int[] key: keys)
		{
			StringBuilder sBuild = new StringBuilder();
			
			for(int i = 0; i<cText.length(); i+=kLength)
			{
				int start = i;
				int end = i+kLength;
				sBuild.append(decryptBlock(start, end, cText, key));
			}
			
			String plainText = sBuild.toString();
			int wordCount = checkForWords(plainText);
			
			if(wordCount>0)
			{
				addToQueue(plainText, wordCount, key);
			}
		}
	}
	
	int checkForWords(String p)
	{
		String[] words = {"be", "have", "do", "say", "get", "make", "go", "know", "take", "see", "come", "think", "look", "want", "give", "use",
				"find", "tell", "ask", "work", "seem", "feel", "try", "leave", "call", "good", "new", "first", "last", "long", "great", "little",
				"own", "other", "old", "right", "big", "high", "different", "small", "large", "next", "early", "young", "important", "few", "public",
				"bad", "same", "able", "to", "of", "in", "for", "on", "with", "at", "by", "from", "up", "about", "into", "over", "after", "the", "and",
				"that", "it", "not", "he", "as", "you", "this", "but", "his", "they", "her", "she", "or", "an", "will", "my", "one", "all", "would", 
				"there", "their"};
		
		int wordCount = 0;
		
		for(String s: words)
		{
			int count = StringUtils.countMatches(p, s);
			wordCount += count;
		}
		
		return wordCount;
	}
	
	void addToQueue(String p, int count, int[] arr)
	{
		PlainText pObj = new PlainText(p, count, arr);
		queue.add(pObj);
	}
	
	String decryptBlock(int start, int end, String cText, int[] key)
	{
		
		if(end>cText.length())
		{
			int diff = end - cText.length();
			end = end - diff;
		}
		
		String block = cText.substring(start, end);
		
		StringBuilder sBuild = new StringBuilder();
		
		for(int i = 0; i<key.length; i++)
		{
			sBuild.append(block.charAt(key[i]));
		}
		
		return sBuild.toString();
	}
	
	String encryptBlock(int start, int end, String pText, int[] key)
	{
		
		if(end>pText.length())
		{
			int diff = end - pText.length();
			end = end - diff;
		}
		
		String block = pText.substring(start, end);
		
		StringBuilder sBuild = new StringBuilder();
		
		for(int i = 0; i<key.length; i++)
		{
			for(int j = 0; j<key.length; j++)
			{
				if(key[j] == i)
				{
					sBuild.append(block.charAt(j));
					break;
				}
			}
			
		}
				
		return sBuild.toString();
	}
	
	ArrayList<int[]> getPerms(int k)
	{
		ArrayList<int[]> results = new ArrayList<>();
		
		int index = 0;
		
		for(int i = 0; i<k; i++)
		{
			int[] arr = new int[k];
			HashSet<Integer> set = new HashSet<>();
			
	
			arr[index] = i;
			set.add(i);
			getPerms(arr, index+1, k, results, set);
		}
		
		return results;
	}
	
	void getPerms(int[] arr, int index, int k, ArrayList<int[]> results, HashSet<Integer> set)
	{
		if(index == k)
		{
			int[] finalArr = (int[]) arr.clone();
			results.add(finalArr);
		}
		else
		{
			for(int i = 0; i<k; i++)
			{				
				if(!set.contains(i))
				{
					int[] cloneArr = (int[]) arr.clone();
					HashSet<Integer> cloneSet = (HashSet<Integer>) set.clone();
					cloneArr[index] = i;
					cloneSet.add(i);
					getPerms(cloneArr, index+1, k, results, cloneSet);
				}
			}
		}
	}
}

class PlainText
{
	int wordCount = 0;
	int[] key;
	String p;
	
	PlainText(String s, int count, int[] arr)
	{
		p = s;
		wordCount = count;
		key = arr;
	}	
}

class TextComparator implements Comparator<PlainText>
{
	public int compare(PlainText p1, PlainText p2)
	{
		if(p1.wordCount>p2.wordCount)
		{
			return -1;
		}
		else if(p1.wordCount == p2.wordCount)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}


