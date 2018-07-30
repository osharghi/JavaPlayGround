
public class DoubleLL {

	DoubleLinkedNode head = null;
	DoubleLinkedNode tail = null;
	
	DoubleLinkedNode insert(char c)
	{
		
		if(head == null)
		{
			head = new DoubleLinkedNode(c);
			return head;
		}
		else if(head.next == null)
		{
			DoubleLinkedNode newNode = new DoubleLinkedNode(c);
			tail = newNode;
			tail.previous = head;
			head.next = newNode;
			return tail;
		}
		else
		{
			DoubleLinkedNode newNode = new DoubleLinkedNode(c);
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;
			return tail;
		}
	}
	
	void remove(DoubleLinkedNode removeNode)
	{
		if(removeNode == head && removeNode  == tail)
		{
			head = null;
			tail = null;
		}
		else if(removeNode == tail)
		{
			tail = removeNode.previous;
			tail.next = null;
		}
		else if(removeNode == head)
		{
			head = removeNode.next;
			head.previous = null;
		}
		else
		{
			
			removeNode.next.previous = removeNode.previous;
			removeNode.previous.next = removeNode.next;
			
		}
	}
	
	void printLL()
	{
		if(head == null)
		{
			System.out.println("List is emtpy");
		}
		else
		{
			DoubleLinkedNode current = head;
			while(current != null)
			{
				System.out.print(" -> " + current.data);
				current = current.next;
			}
			System.out.println("");
		}
	}
	
	
}
