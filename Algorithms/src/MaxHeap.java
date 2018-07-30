import java.util.ArrayList;

public class MaxHeap {

	ArrayList<Integer> list;
	
	MaxHeap()
	{
		list = new ArrayList<>();
	}
	
	
	void add(int x)
	{
		list.add(x);
		
		if(list.size()>1)
		{
			int index = list.size()-1;
			heapifyUp(index);
		}
	}
	
	void heapifyUp(int x)
	{
		if(x>=1)
		{
			int parent = getParent(x);
			
			if(list.get(x)>list.get(parent))
			{
			
				swap(parent, x);
				heapifyUp(parent);
			}
		}
	}
	
	void heapifyDown(int x)
	{
		if(list.size()>1)
		{
			int maxIndex = x;
			
			int leftIndex = getLeft(x);
			
			if(leftIndex<list.size())
			{
				maxIndex = list.get(x)>list.get(leftIndex) ? x : leftIndex; 
			}
			
			int rightIndex = getRight(x);
			
			if(rightIndex<list.size())
			{
				maxIndex = list.get(x)>list.get(rightIndex) ? x : rightIndex; 
			}
			
			if(maxIndex != x)
			{
				swap(maxIndex, x);
				heapifyDown(maxIndex);
			}

		}
	}
	
	Integer peek()
	{
		try
		{
			if(list.isEmpty()) throw new Exception("Heap is empty");
			
			return list.get(0);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
	Integer poll()
	{
		try
		{
			if(list.isEmpty()) throw new Exception("Heap is empty");
			
			
			int max = list.get(0);
			list.set(0, list.get(list.size()-1));
			list.remove(list.size()-1);
			heapifyDown(0);
			
			return max;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
	void swap(int x, int y)
	{
		int temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}
	
	int getParent(int i)
	{
		return (i-1)/2;
	}
	
	int getLeft(int i)
	{
		return 2*i + 1;
	}
	
	int getRight(int i)
	{
		return 2*i + 2;
	}
	
	void print()
	{
		System.out.println(list.toString());
	}
}
