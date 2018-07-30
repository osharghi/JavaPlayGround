import java.util.ArrayList;

public class MinHeap2 {

	ArrayList<Integer> heap;
	
	MinHeap2()
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
		int index = heap.size()-1;
		
		heapifyUp(index);
	}
	
	void heapifyUp(int index)
	{
		if(heap.size()>1)
		{
			int parentIndex = parent(index);
			
			if(heap.get(parentIndex)>heap.get(index))
			{
				swap(index, parentIndex);
				heapifyUp(parentIndex);
			}
		}
		
		//what to do when adding same value as min
	}
	
	void heapifyDown(int index)
	{
		if(heap.size()>1)
		{
			int minIndex = index;
			
			int leftIndex = leftChild(index);
			
			if(leftIndex<heap.size() && heap.get(leftIndex)<heap.get(minIndex))
			{
				minIndex = leftIndex;
			}
			
			int rightIndex = rightChild(index);

			
			if(rightIndex<heap.size() && heap.get(rightIndex)<heap.get(minIndex))
			{
				minIndex = rightIndex;
			}
			
			if(index!=minIndex) 
			{
				swap(index, minIndex);
				heapifyDown(minIndex);
			}
		}
	}
	
	Integer peek()
	{
		try
		{
			if(heap.isEmpty()) throw new Exception("EMPTY HEAP");
			
			Integer min = heap.get(0);
			return min;
			
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
			if(heap.isEmpty()) throw new Exception("EMPTY HEAP");
			
			Integer val = heap.get(0);
			System.out.println("VAL: " + val);
			
			if(heap.size()>1)
			{
				heap.set(0, heap.get(heap.size()-1));
				heap.remove(heap.size()-1);

				heapifyDown(0);
			}
			else
			{
				heap.remove(0);
			}
			
			return val;
		}
		catch(Exception ex)
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
	
	int parent(int i) 
	{
		return (i-1)/2;
	}
	
	int leftChild(int i)
	{
		return 2*i + 1;
	}
	
	int rightChild(int i)
	{
		return 2*i + 2;
	}
	
	void print()
	{
		System.out.println(heap.toString());
	}
	
	
	
}
