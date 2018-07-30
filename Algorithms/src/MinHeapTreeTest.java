
public class MinHeapTreeTest {
	
	MinHeapTreeTest()
	{
		MinHeapTree heap = new MinHeapTree();
		heap.add(5);
		heap.print();
		heap.add(3);
		heap.print();
		heap.add(2);
		heap.print();
//		heap.add(1);
//		heap.print();
		System.out.println("Remove " + heap.remove());
		heap.print();
//		System.out.println("Remove " + heap.remove());
//		heap.print();
//		heap.add(1);
//		heap.print();



	}

}
