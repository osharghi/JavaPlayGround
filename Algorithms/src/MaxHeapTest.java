
public class MaxHeapTest {
	
	MaxHeapTest()
	{
		MaxHeap maxHeap = new MaxHeap();
		
		maxHeap.add(5);
		maxHeap.print();
		maxHeap.add(3);
		maxHeap.print();
		maxHeap.add(2);
		maxHeap.print();
		System.out.println(maxHeap.peek());
		System.out.println(maxHeap.poll());
		maxHeap.print();
		maxHeap.add(10);
		maxHeap.print();
	}

}
