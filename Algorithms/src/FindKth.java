
public class FindKth {

	FindKth()
	{
		LinkedListCreator llc = new LinkedListCreator();
		LinkedList ll = llc.ll;
		LinkedNode kth = findKth(ll, 4);
		if(kth != null)
		{
			System.out.println(kth.data);
		}
		else
		{
			System.out.println("List isn't big enough");
		}
	}
	
	LinkedNode findKth(LinkedList ll, int kth)
	{
		LinkedNode current = ll.head;
		LinkedNode runner = ll.head;
		
		int i = 0;
		while(i<kth)
		{
			runner = runner.next;
			if(runner == null)
			{
				return null;
			}
			i++;
		}
		
		while(runner != null)
		{
			runner = runner.next;
			current = current.next;
		}
		
		return current;
		
		
	}
	
}
