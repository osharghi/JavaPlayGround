
public class ReverseLL {

	ReverseLL()
	{
		ListNode head = createLL(10);
		ListNode rHead = reverseLL(head);
		printLL(rHead);
	}
	
	void printLL(ListNode head)
	{
		ListNode current = head;
		
		while(current != null)
		{
			System.out.print(current.val + "->");
			current = current.next;
		}
	}
	
	ListNode reverseLL(ListNode head)
	{
		ListNode prev = null;
		ListNode cur = head;
		
		while(cur != null)
		{
			ListNode tmp = cur.next;
			cur.next= prev;
			prev = cur;
			cur = tmp;
		}
		
		return prev;
	}
	
	ListNode createLL(int x)
	{
		ListNode head = null;
		ListNode current = null;
		for(int i = 0; i<x; i++)
		{
			ListNode n = new ListNode(i);
			
			if(head == null)
			{
				head = n;
				current = n;
			}
			else
			{
				current.next = n;
				current = n;
			}
		}
		
		return head;
	}
	
	class ListNode
	{
		int val;
		ListNode next;
		ListNode(int i)
		{
			val = i;
			next = null;
		}
	}
	
}
