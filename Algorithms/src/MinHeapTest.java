
public class MinHeapTest {

	MinHeapTest()
	{
		MinHeap minHeap = new MinHeap();
		minHeap.add(7);
		minHeap.print();
		minHeap.add(5);
		minHeap.print();
		minHeap.add(4);
		minHeap.print();
		minHeap.add(1);
		minHeap.print();
		System.out.println(minHeap.remove());
		minHeap.print();


	}
	
}
