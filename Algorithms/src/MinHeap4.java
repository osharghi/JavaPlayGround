import java.util.ArrayList;

public class MinHeap4 {
	
	ArrayList<Integer> heap;
	
	MinHeap4()
	{
		heap = new ArrayList<>();
		add(7);
		add(15);
		printHeap();
		add(1);
		printHeap();
		add(2);
		printHeap();
		add(6);
		printHeap();
		add(4);
		printHeap();
		System.out.println(getMin());
		printHeap();



	}
	
	void printHeap()
	{
		System.out.println(heap.toString());
	}
	
	void add(int x)
	{
		if(heap.isEmpty())
		{
			heap.add(x);
		}
		else
		{
			heap.add(x);
			int lastIndex = heap.size()-1;
			heapifyUp(lastIndex);
			
		}
	}
	
	void heapifyUp(int currentIndex)
	{	
		if(currentIndex > 0)
		{
			int currentVal = heap.get(currentIndex);
			int parentIndex = getParent(currentIndex);
			int parentVal = heap.get(parentIndex);
			
			if(currentVal<parentVal)
			{
				swap(currentIndex, parentIndex);
				heapifyUp(parentIndex);
			}
		}
	}
	
	Integer getMin()
	{
		try
		{
			if(heap.isEmpty()) throw new Exception("Heap is empty");
			
			int returnVal = heap.get(0);
			
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
			
			return returnVal;
		}
		catch (Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
	void heapifyDown(int currentIndex)
	{
		int minIndex = currentIndex;
		
		int leftIndex = getLeftIndex(currentIndex);
		int rightIndex = getRightIndex(currentIndex);
		
		if(heap.get(leftIndex)<heap.get(minIndex))
		{
			minIndex = leftIndex;
		}
		
		if(heap.get(rightIndex)<heap.get(minIndex))
		{
			minIndex = rightIndex;
		}
		
		if(minIndex != currentIndex)
		{
			swap(minIndex, currentIndex);
			heapifyDown(minIndex);
		}
		
	}
	
	void swap(int x, int y)
	{
		int temp = heap.get(x);
		heap.set(x, heap.get(y));
		heap.set(y, temp);
	}
	
	int getLeftIndex(int i)
	{
		return 2*i + 1;
	}
	
	int getRightIndex(int i)
	{
		return 2*i + 2;
	}
	
	int getParent(int i)
	{
		return (i-1)/2;
	}
}
