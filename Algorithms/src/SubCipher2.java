import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SubCipher2 {
	
	TreeMap<Character, Integer> freqMap;
	HashMap<Integer, Character> keyMap;
	HashSet<Character> charSet;
	
	SubCipher2()
	{
		freqMap = new TreeMap<>();
		keyMap = new HashMap<>();
		charSet = new HashSet<>();
		
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
			printFreqMap();
			
			boolean run = true;
			while(run)
			{
				System.out.print("Enter key of 26 alphabetic characters without commas or spaces or enter -1 to exit:\n");
				Scanner reader = new Scanner(System.in);  
				String key = reader.next();
				if(key.equals("-1"))
				{
					run = false;
					System.out.println("Exiting");
				}
				else
				{
					if(!validateString(key))
					{
						System.out.println("Not a valid key.");
						continue;
					}
					else
					{
						String plainText = decrypt(s);
						System.out.println("Cipher:     " + s);
						System.out.println("Plain Text: " + plainText);
					}
				}
			}
	}
	
	boolean validateString(String s)
	{
		
		s = s.replace(" ", "");
		
		if(s.length() != 26) return false;
		
		for(int i = 0; i<s.length(); i++)
		{
			Character c = s.charAt(i);
			c = Character.toUpperCase(c);
			
			if(Character.isAlphabetic(c) && !charSet.contains(c))
			{
				keyMap.put(i, c);
				charSet.add(c);
			}
			else
			{
				keyMap.clear();
				charSet.clear();
				return false;
			}
		}
		
		return true;
	}
	
	String decrypt(String ciper)
	{
		StringBuilder sbldr = new StringBuilder();
		for(int i = 0; i<ciper.length(); i++)
		{
			char c = ciper.charAt(i);
			int key = getCharInt(c);
			char newKey = keyMap.get(key);
			sbldr.append(newKey);
		}
		
		return sbldr.toString();
	}
	
	int getCharInt(char c)
	{
		char cUpper = Character.toUpperCase(c);
		return Character.getNumericValue(cUpper) - Character.getNumericValue('A');
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
	
	void printFreqMap()
	{
		System.out.println("Character Frequency:");
		for(char c: freqMap.keySet())
		{
			System.out.println(c + ": " + freqMap.get(c));
		}
	}
}
