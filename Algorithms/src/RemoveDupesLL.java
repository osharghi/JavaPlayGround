
public class RemoveDupesLL {
	
	RemoveDupesLL()
	{
		CustLinkedList ll = new CustLinkedList();
		ll.add(7);
		ll.add(8);
		ll.add(3);
		ll.add(4);
		ll.add(7);
		ll.add(3);
		ll.print();
		removeDupes(ll);
		ll.print();
		
	}
	
	void removeDupes(CustLinkedList ll)
	{
		LLNode current = ll.head;
		while(current != null)
		{
			removeDup(current, current.val);
			current = current.next;
		}
	}
	
	void removeDup(LLNode current, int target)
	{
		if(current.next == null)
		{
			return;
		}
		else if(current.next.val == target)
		{
			if(current.next.next == null)
			{
				current.next = null;
				return;
			}
			else
			{
				current.next = current.next.next;
				removeDup(current, target);
			}
		}
		else
		{
			removeDup(current.next, target);
		}
		
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
