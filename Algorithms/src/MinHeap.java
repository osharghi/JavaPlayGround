import java.util.ArrayList;

public class MinHeap {

	ArrayList<Integer> list;
	
	MinHeap()
	{
		list = new ArrayList<>();
	}
	
	void add(int x)
	{
		list.add(x);
		
		if(list.size() != 1)
		{
			//heapify up
			int index = list.size() - 1;
			heapifyUp(index);
		}
	}
	
	void heapifyUp(int index)
	{

		if(index > 0 && list.get(index)<list.get(parent(index)))
		{
			swap(index, parent(index));
			heapifyUp(parent(index));
		}
	}
	
	void heapifyDown(int index)
	{
		int right = right(index);
		int left = left(index);
		int smallest = index;
		
		if(left<list.size() && list.get(left)<list.get(smallest))
		{
			smallest = left;
		}
		
		if(right<list.size() && list.get(right)<list.get(smallest))
		{
			smallest = right;
		}
		
		if(index != smallest)
		{
			swap(smallest, index);
			heapifyDown(smallest);
		}
		
	}
	
	Integer remove()
	{
		if(list.size() >= 1)
		{
			int root = list.remove(0);

			if(list.size()>1)
			{
				int end = list.remove(list.size()-1);
				list.add(0, end);
				heapifyDown(0);
			}
			
			return root;
		}
		else
		{
			return null;
		}
	}
	
	void swap(int index, int parentIndex)
	{
		int temp = list.get(index);
		list.set(index, list.get(parentIndex));
		list.set(parentIndex, temp);
	}
	
	int parent(int i)
	{
		
		if(i==0)
		{
			return 0;
		}
		
		return (i-1)/2;
		
	}
	
	int left(int i)
	{
		return (i*2) + 1;
	}
	
	int right(int i)
	{
		return (i*2) + 2;
	}
	
	void print()
	{
		System.out.println(list.toString());
	}
	
}
