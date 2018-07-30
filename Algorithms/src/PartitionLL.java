
public class PartitionLL {

	PartitionLL()
	{
		CustLinkedList ll = new CustLinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(10);
		ll.add(5);
		ll.add(8);
		ll.add(5);
		ll.add(3);
		ll.print();
		System.out.println("partition");
		partition(ll, 5);
		ll.print();
	}
	
	void partition(CustLinkedList ll, int x)
	{
		LLNode current= ll.head;
		LLNode insertionNode = null;
		
		if(current.val >= x) 
		{
			insertionNode = current;
		}
		
		while(current.next != null)
		{
			if(insertionNode == null && current.next.val >= x)
			{
				insertionNode = current.next;
				current = current.next;
			}
			else if(insertionNode != null)
			{
				if(current.next.val < insertionNode.val)
				{
					LLNode temp = current.next;
					current.next = current.next.next;
					temp.next = ll.head;
					ll.head = temp;
					
				}
				else
				{
					current = current.next;
				}
			}
		}
	}
	
	
	class CustLinkedList
	{
		LLNode head;
		
		void add(int i)
		{
			if(head == null)
			{
				head = new LLNode(i);
			}
			else
			{
				LLNode newNode = new LLNode(i);
				newNode.next = head;
				head = newNode;
			}
		}
		
		void print()
		{
			LLNode current = head;
			while(current!= null)
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
