import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotate-list/

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
        
        ListNode current = head;
        
        if(head == null) return null;
        if(k == 0) return current;
        
        Queue<ListNode> queue = new LinkedList<>();
        buildQueue(queue, head);
        
        for(int i = 0; i<k%queue.size(); i++)
        {
            ListNode newHead = queue.poll();
            newHead.next = current;
            current = newHead;
            queue.add(current);
            ListNode tail = queue.peek();
            tail.next = null;
        }
        
        return current;
        
    }
    
    void buildQueue(Queue<ListNode> queue, ListNode n)
    {
        if( n == null) return;
        
        buildQueue(queue, n.next);
        queue.add(n);
        return;
    }
    
    public class ListNode {
    	     int val;
    	     ListNode next;
    	     ListNode(int x) { val = x; }
    	}
	
}
