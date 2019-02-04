import java.util.Stack;

//https://leetcode.com/problems/reorder-list/

public class ReorderList {
	
	 public void reorderList(ListNode head) {
	     
	        
	        if(head == null) return;
	        
	        Stack<ListNode> stack = new Stack<>();
	        
	        ListNode current = head;
	        
	        while(current != null)
	        {
	            stack.push(current);
	            current = current.next;
	        }
	        
	        if(stack.size() < 3) return;
	        
	        current = head;
	        
	        while(current != null)
	        {
	            ListNode temp = current.next;
	            
	            if(current == stack.peek())
	            {
	                current.next = null;
	                break;
	            }
	            
	            current.next = stack.pop();
	            
	            if(current.next == temp)
	            {
	                current.next.next = null;
	                break;
	            }
	            else
	            {   
	                current.next.next = temp;
	                current = temp;
	            }
	        }
	        
	        return;
	        
	    }
	 
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
		  
	 }
		 

}
