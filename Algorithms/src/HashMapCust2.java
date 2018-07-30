import java.util.ArrayList;

public class HashMapCust2<K, V> {
	
	
	private ArrayList<LLNode<K, V>> map;
	int numBuckets;
	int size;
	
	HashMapCust2()
	{
		map = new ArrayList<>();
		numBuckets = 10;
		size = 0;
		for(int i = 0; i<numBuckets; i++)
		{
			map.add(null);
		}
	}
	
	int getHash(K k)
	{
		int hash = k.hashCode();
		int index = Math.abs(hash%numBuckets);
		return index;
	}
	
	V get(K k)
	{
		int index = getHash(k);
		LLNode<K, V> current = map.get(index);
		while(current != null)
		{
			if(current.key.equals(k))
			{
				return current.val;
			}
		}
		
		return null;
	}
	
	void print()
	{
		for(int i = 0; i<map.size(); i++)
		{
			if(map.get(i) != null)
			{
				LLNode<K, V> current  = map.get(i);
				System.out.print(i);
				while(current != null)
				{
					System.out.print(" -> " + current.key + "," + current.val);
					current = current.next;
				}
				System.out.println("");
			}
		}
	}
	
	void add(K k, V v)
	{
		int index = getHash(k);
		if(map.get(index) == null)
		{
			LLNode<K, V> newNode = new LLNode<>(k,v);
			map.set(index, newNode);
		}
		else
		{
			LLNode<K, V> current = map.get(index);
			while(current != null)
			{
				if(current.key.equals(k))
				{
					current.val = v;
					break;
				}
				
				current = current.next;
			}
			
			LLNode<K, V> newNode = new LLNode<>(k, v);
			newNode.next = map.get(index);
			map.set(index, newNode);
		}
		
		size++;
		
		if((1.0*size)/numBuckets>=0.7)
		{
			ArrayList<LLNode<K, V>> temp = map;
			map = new ArrayList<>();
			numBuckets *= 2;
			size = 0;
			
			for(int i = 0; i<numBuckets; i++)
			{
				map.add(null);
			}
			
			for(int i = 0; i<temp.size(); i++)
			{
				LLNode<K, V> current = temp.get(i);
				
				while(current != null)
				{
					add(current.key, current.val);
					current = current.next;
				}
			}
		}
	}
}

class LLNode<K, V>
{
	K key;
	V val;
	LLNode<K, V> next;
	
	LLNode(K k, V v)
	{
		key = k;
		val = v;
		next = null;
	}
}
