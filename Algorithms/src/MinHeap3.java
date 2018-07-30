import java.util.ArrayList;

public class MinHeap3 {

	ArrayList<Integer> heap;
	
	MinHeap3()
	{
		heap = new ArrayList<>();
	}
	
	void add(int x)
	{
		if(heap.isEmpty())
		{
			heap.add(x);
			return;
		}
		
		heap.add(x);
		heapifyUp(heap.size()-1);	
	}
	
	void heapifyUp(int currentIndex)
	{
		if(currentIndex == 0) return;
		
		int parentIndex = getParent(currentIndex);
		
		if(heap.get(currentIndex) < heap.get(parentIndex))
		{
			swap(currentIndex, parentIndex);
			heapifyUp(parentIndex);
		}
	}
	
	void heapifyDown(int index)
	{
		int minIndex = index;
		
		int leftIndex = getLeft(index);
		if(leftIndex<heap.size())
		{
			if(heap.get(leftIndex)<heap.get(index))
			{
				minIndex = leftIndex;
			}
		}
		
		int rightIndex = getRight(index);
		if(rightIndex<heap.size())
		{
			if(heap.get(rightIndex)<heap.get(minIndex))
			{
				minIndex = rightIndex;
			}
		}
		
		if(index != minIndex)
		{
			swap(index, minIndex);
			heapifyDown(minIndex);
		}
	}
	
	Integer remove()
	{
		try
		{
			if(heap.isEmpty()) throw new Exception("Empty Heap");
			
			int returnVal = heap.get(0);
			
			if(heap.size()>1)
			{
				heap.set(0, heap.size()-1);
				heap.remove(heap.size()-1);
				heapifyDown(0);
			}
			else
			{
				heap.remove(0);
			}
			
			return returnVal;
			
		}
		catch (Exception ex)
		{
			System.out.println(ex);
			return null;
		}

	}
	
	void swap(int x, int y)
	{
		int temp  = heap.get(x);
		heap.set(x, heap.get(y));
		heap.set(y, temp);
	}
	
	int getLeft(int i)
	{
		return 2*i + 1;
	}
	
	int getRight(int i)
	{
		return 2*i + 2;
	}
	
	int getParent(int i)
	{
		return (i-1)/2;
	}
	
	void print()
	{
		System.out.println(heap.toString());
	}
	
}
