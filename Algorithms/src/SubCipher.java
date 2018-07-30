import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SubCipher {
	
	TreeMap<Character, Integer> freqMap;
	PriorityQueue<Character> queue;
	HashSet<String> permutations;
	
	SubCipher()
	{
		freqMap = new TreeMap<>();
		
		String s = "GBSXUCGSZQGKGSQPKQKGLSKASPC"
				+  "GBGBKGUKGCEUKUZKGGBSQEICA"
				+  "CGKGCEUERWKLKUPKQQGCIICUAEU"
				+  "VSHQKGCEUPCGBCGQOEVSHUNSU"
				+  "GKUZCGQSNLSHEHIEEDCUOGEPKHZ"
				+  "GBSNKCUGSUKUASERLSKASCUGB"
				+  "SLKACRCACUZSSZEUSBEXHKRGSHW"
				+  "KLKUSQSKCHQTXKZHEUQBKZAEN"
				+  "NSUASZFENFCUOCUEKBXGBSWKLKU"
				+  "SQSKNFKQQKZEHGEGBSXUCGSZQ"
				+  "GKGSQKUZBCQAEIISKOXSZSICVSH"
				+  "SZGEGBSQSAHSGKHMERQGKGSKR"
				+  "EHNKIHSLIMGEKHSASUGKNSHCAKU"
				+  "NSQQKOSPBCISGBCQHSLIMQGKG"
				+  "SZGBKGCGQSSNSZXQSISQQGEAEUG"
				+  "CUXSGBSSJCQGCUOZCLIENKGCA"
				+  "USOEGCKGCEUQCGAEUGKCUSZUEGB"
				+  "HSKGEHBCUGERPKHEHKHNSZKGGKAD";
		
		getCharCount(s);
		queue = new PriorityQueue<Character>(freqMap.size(), new CharComparator());
		printFreqMap();
		permutations = new HashSet<>();
		for(char c: freqMap.keySet())
		{
			queue.add(c);
		}
		
		
		
		
//		char[] mostCommonChars = {'E', 'T', 'A', 'O', 'I', 'N', 'S', 'R', 'H', 'L', 'D', 'C', 'U', 'M', 'F', 'P', 'G', 'W', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z'};
//		LinkedList<Character> charList = convertList(mostCommonChars);
//		
//		guess(s, charList);
//		
//		for(String str: permutations)
//		{
//			System.out.println(str);
//		}

	}
	
	void getCharCount(String s)
	{
		for(int i = 0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			
			if(!freqMap.containsKey(c))
			{
				freqMap.put(c, 1);
			}
			else
			{
				freqMap.put(c, freqMap.get(c)+1);
			}			
		}
	}
	
	void guess(String s, LinkedList<Character> ll)
	{
		int size = ll.size();
		for(int i = 0; i<size; i++)
		{
			boolean[] visited = new boolean[s.length()];

			char cKey = ll.remove(i);
			char cReplace = queue.poll();
			
			StringBuilder sBuild = new StringBuilder();
			for(int j = 0; j<s.length(); j++)
			{
				if(s.charAt(j) == cReplace && !visited[j])
				{
					sBuild.append(cKey);
					visited[j] = true;
				}
				else
				{
					sBuild.append(s.charAt(j));
				}
			}
			
			String newString = sBuild.toString();
			guess2(newString, ll, visited);
			
			ll.add(i, cKey);
			queue.add(cReplace);
		}
	}
	
	void guess2(String s, LinkedList<Character> ll, boolean[] visited)
	{
		if(ll.size() == 0 || queue.isEmpty())
		{
			if(!permutations.contains(s))
			{
				permutations.add(s);
				System.out.println(s);
			}
			return;
		}
		
		int size = ll.size();
		for(int i = 0; i<size; i++)
		{
			boolean[] visitedClone = visited.clone();
			
			char cKey = ll.remove(i);
			char cReplace = queue.poll();

			StringBuilder sBuild = new StringBuilder();
			for(int j = 0; j<s.length(); j++)
			{
				if(s.charAt(j) == cReplace && !visitedClone[j])
				{
					sBuild.append(cKey);
					visitedClone[j] = true;
				}
				else
				{
					sBuild.append(s.charAt(j));
				}
			}
			
			String newString = sBuild.toString();
			guess2(newString, ll, visitedClone);
			
			ll.add(i, cKey);
			queue.add(cReplace);
		}
	}
	
	void printFreqMap()
	{
		for(char c: freqMap.keySet())
		{
			System.out.println(c + ": " + freqMap.get(c));
		}
	}
	
	String replaceChar(String s, char toReplace, char replaceWith)
	{
		s = s.replace(toReplace, replaceWith);
		System.out.println(s);
		return s;
	}
	
	LinkedList<Character> convertList(char[] list)
	{
		LinkedList<Character> ll = new LinkedList<>();
		for(char c: list)
		{
			ll.addLast(c);
		}
		
		return ll;
	}
	
	class CharComparator implements Comparator<Character>
	{
		public int compare(Character c1, Character c2)
		{
			if(freqMap.get(c1)<freqMap.get(c2))
			{
				return 1;
			}
			else if(freqMap.get(c1) == freqMap.get(c2))
			{
				return 0;
			}
			else
			{
				return -1;
			}
		}

	}
	
}
