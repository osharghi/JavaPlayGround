import RemoveDupesLL.CustLinkedList;

public class RemoveKth {

	
	RemoveKth()
	{
		CustLinkedList ll = new CustLinkedList();
		ll.add(7);
		ll.add(8);
		ll.add(3);
		ll.add(4);
		ll.add(2);
		ll.add(1);
		ll.print();
		removeK(3, ll);
		ll.print();
	}
	
	void removeK(int k, CustLinkedList ll)
	{
		LLNode runner = ll.head;
		for(int i = 0; i<=k; i++)
		{
			runner = runner.next;
		}
		
		LLNode current = ll.head;
		while(runner != null)
		{
			runner = runner.next;
			current = current.next;
		}
		
		current.next = current.next.next;
	}
	
	class CustLinkedList
	{
		LLNode head;
		
		void add(int x)
		{
			if(head == null)
			{
				head = new LLNode(x);
			}
			else
			{
				LLNode newHead = new LLNode(x);
				newHead.next = head;
				head = newHead;
			}
		}
		
		void print()
		{
			System.out.print("LL");
			LLNode current = head;
			while(current != null)
			{
				System.out.print(" -> " + current.val);
				current = current.next;
			}
			System.out.println("");
		}
	}
	
	class LLNode
	{
		int val;
		LLNode next;
		
		LLNode(int x)
		{
			val = x;
			next = null;
		}
	}
	
}
