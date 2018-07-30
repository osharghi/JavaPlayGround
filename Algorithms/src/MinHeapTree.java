import java.util.LinkedList;
import java.util.Queue;

public class MinHeapTree {

	HeapNode root;
		
	public void add(int v)
	{
		if(root == null)
		{
			root = new HeapNode(v);
			return;
		}
		
		doBFS(root, v);
	}
	
	private void doBFS(HeapNode node, int v)
	{
		Queue<HeapNode> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty())
		{
			HeapNode n = queue.poll();
			
			if(n.left == null)
			{
				HeapNode newNode = new HeapNode(v);
				n.left = newNode;
				newNode.parent = n;
				heapifyUp(newNode);
				break;
			}
			
			if(n.right == null)
			{
				HeapNode newNode = new HeapNode(v);
				n.right = newNode;
				newNode.parent = n;
				heapifyUp(newNode);
				break;
			}
			
			if(n.left != null) queue.add(n.left);
			
			if(n.right != null) queue.add(n.right);
		}
	}
	
	private void heapifyUp(HeapNode newNode)
	{
		if(newNode.parent == null) return;
		
		if(newNode.value<newNode.parent.value)
		{
			int tempVal = newNode.value;
			newNode.value = newNode.parent.value;
			newNode.parent.value = tempVal;
			
			heapifyUp(newNode.parent);
		}
	}
	
	private void heapifyDown(HeapNode parent)
	{
		HeapNode min = parent;

		if(parent.left != null)
		{
			if(min.value > parent.left.value)
			{
				min = parent.left;
			}
			

		}
		
		if(parent.right != null)
		{
			if(min.value > parent.right.value)
			{
				min = parent.right;
			}
			
		}

		if(min != parent)
		{
			//swap parent and min
			int tempVal = parent.value;
			parent.value = min.value;
			min.value = tempVal;
			heapifyDown(min);
		}

	}
	
	void print()
	{
		Queue<HeapNode> queue = new LinkedList<>();
		queue.add(root);
		
		System.out.println("PRINT");
		
		while(!queue.isEmpty())
		{
			HeapNode n = queue.poll();
			
			System.out.print(n.value + ": ");
			
			if(n.left != null)
			{
				System.out.print(" L: " + n.left.value);
				queue.add(n.left);
			}
			
			if(n.right != null)
			{
				System.out.print(" R: " + n.right.value);
				queue.add(n.right);
			}
			
			System.out.println("");
		}
	}
	
	public int peek()
	{
		if(root == null)
		{
			return -1;
		}
		
		return root.value;
	}
	
	public int remove()
	{
		if(root == null) return -1;
		
		if(root.left == null && root.right == null)
		{
			int val = root.value;
			root = null;
			return val;
		}
		
		int returnVal = root.value;
		
		HeapNode last = getLast();

		root.value = last.value;

		removeParent(last, last.parent);

		last = null;

		heapifyDown(root);
		return returnVal;
		
	}
	
	private void removeParent(HeapNode child, HeapNode parent)
	{
		if(parent.left == child)
		{
			parent.left = null;
			child.parent = null;
			return;
		}
		
		if(parent.right == child)
		{
			parent.right = null;
			child.parent = null;
		}
		
	}
	
	private HeapNode getLast()
	{
		Queue<HeapNode> queue = new LinkedList<>();
		queue.add(root);
		
		HeapNode last = null;
		
		while(!queue.isEmpty())
		{
			last = queue.poll();
			
			if(last.left != null) queue.add(last.left);
			
			if(last.right != null) queue.add(last.right);
		}
		
		return last;
	}
	
	
}

class HeapNode
{
	int value;
	HeapNode left;
	HeapNode right;
	HeapNode parent;

	
	HeapNode(int v)
	{
		value = v;
		left = null;
		right = null;
		parent = null;
	}

}
