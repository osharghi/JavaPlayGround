import java.util.HashMap;

public class Stream {

	DoubleLL ll;
	HashMap<Character, DoubleLinkedNode> map;
	Stream()
	{
		ll = new DoubleLL();
		map = new HashMap<>();
	}
	
	void addChar(char c)
	{
		if(!map.containsKey(c))
		{
			DoubleLinkedNode node = ll.insert(c);
			map.put(c, node);
		}
		else
		{
			DoubleLinkedNode node = map.get(c);
			ll.remove(node);
		}
	}
	
	void getFirstUnique()
	{
		if(ll.head != null)
		{
			System.out.println(ll.head.data);
		}
		else
		{
			System.out.println("No unique");
		}
	}
	
}
