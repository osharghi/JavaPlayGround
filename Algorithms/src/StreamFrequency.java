import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class StreamFrequency {

	HashMap<Integer, Integer> map;
	PriorityQueue<Integer> queue;
	
	StreamFrequency()
	{
		map = new HashMap<>();
		queue = new PriorityQueue<>(new IntComparator());
	}
	
	void add(int i)
	{
		if(map.containsKey(i))
		{
			Integer count = map.get(i);
			count++;
			map.put(i, count);
			queue.remove(i);
			queue.add(i);
		}
		else
		{
			map.put(i, 1);
			queue.add(i);
		}
	}
	
	int getHighFrequency()
	{
		Integer num = queue.peek();
		return num;
	}
	
	class IntComparator implements Comparator<Integer>
	{
		public int compare(Integer i1, Integer i2)
		{
			int c1 = map.get(i1);
			int c2 = map.get(i2);
			
			if(c1-c2 < 0)
			{
				return 1;
			}
			else if(c1 == c2)
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


