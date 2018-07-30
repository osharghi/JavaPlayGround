import java.util.ArrayList;

public class HashMapCust<K, V>
{
	private ArrayList<HashNode<K, V>> map;
	private int numBuckets;
	private int size;
	
	HashMapCust()
	{

		map = new ArrayList<>();
		numBuckets = 10;
		size = 0;

		for(int i = 0; i<numBuckets; i++)
		{
			map.add(null);
		}

	}
	
	private int getHash(K k)
	{
		int hash = k.hashCode();
		return Math.abs(hash%numBuckets);
	}
	
	public V get(K k)
	{
		int index = getHash(k);
		
		HashNode<K, V> head = map.get(index);
		
		while(head != null)
		{
			if(head.key.equals(k))
			{
				return head.value;
			}
			
			head = head.next;
		}
		
		return null;
	}
	
	public V delete(K k)
	{
		int index = getHash(k);
		HashNode<K, V> head = map.get(index);
		
		
		HashNode<K, V> prev = null;

		while(head!=null)
		{
			if(head.key.equals(k))
			{
				break;
			}
			
			prev = head;
			head = head.next;
		}
		
		if(head == null) return null;
		
		
		V val = head.value;
		
		size--;
		
		if(prev!= null)
		{
			prev.next = head.next;
		}
		else
		{
			map.set(index, head.next);
		}
		
		return val;
	}
	
	public void add(K k, V v)
	{

		int index = getHash(k);
		System.out.println(index);
		
		HashNode<K, V> head = map.get(index);
		
		while(head!=null)
		{
			if(head.key.equals(k))
			{
				head.value = v;
				return;
			}
			
			head = head.next;
		}
		
		head = map.get(index);
		HashNode<K, V> newHead = new HashNode<K, V>(k, v);
		
		newHead.next = head;
		
		map.set(index, newHead);
		
		size++;
		System.out.println("ADD");
		
		if((1.0*size)/numBuckets >=0.7)
		{
			System.out.println("EXPAND");
			ArrayList<HashNode<K, V>> temp = map;
			
			map = new ArrayList<HashNode<K, V>>();
			
			numBuckets = numBuckets*2;
			
			size = 0;
			
			for(int i = 0; i<numBuckets; i++)
			{
				map.add(null);
			}
			
			for(HashNode<K,V> tempHead: temp)
			{
				while(tempHead != null)
				{
					add(tempHead.key, tempHead.value);
					tempHead = tempHead.next;
				}
			}
		}
	}
	
	void print()
	{
		for(int i = 0; i<numBuckets; i++)
		{
			System.out.print(i + ": ");
			HashNode<K,V> head = map.get(i);
			while(head!= null)
			{
				System.out.print(head.key + ", " + head.value + " -> ");
				head = head.next;
			}
			System.out.println("");
		}
		System.out.println("");

	}
	
	
	
	
}

class HashNode<K, V>
{
	K key;
	V value;
	HashNode<K, V> next;
	
	HashNode(K k, V v)
	{
		key = k;
		value = v;
		next = null;
	}
}
