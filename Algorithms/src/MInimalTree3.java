import java.util.LinkedList;
import java.util.Queue;

public class MInimalTree3 {

	Node root;
	
	MInimalTree3()
	{
		int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
		buildTree(arr, 0, arr.length-1);
//		printTree();
	}
	
	void buildTree(int[] arr, int low, int high)
	{
		if(low<high)
		{
			int mid = (low+high)/2;
			
			if(root == null)
			{
				Node n = new Node(arr[mid]);
				root = n;
			}
			else
			{
				root.addNode(arr[mid]);
			}
			
			buildTree(arr, low, mid-1);
			buildTree(arr, mid+1, high);	
		}
	}
	
	void printTree()
	{
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			Node current = queue.poll();
			
			System.out.print("Current: " + current.val);
			
			if(current.left != null)
			{
				System.out.print(" Left: " + current.left.val);
				
				queue.add(current.left);
			}
			
			if(current.right != null)
			{
				System.out.print(" Right: " + current.right.val);
				queue.add(current.right);

			}
			
			System.out.println("");
		}
	}
	
	class Node
	{
		int val;
		Node left;
		Node right;
		
		Node(int x)
		{
			val = x;
			left = null;
			right = null;
		}
		
		void addNode(int x)
		{
			if(x<= val)
			{
				if(left == null)
				{
					Node n = new Node(x);
					left = n;
				}
				else
				{
					left.addNode(x);
				}
			}
			else
			{
				if(right == null)
				{
					Node n = new Node(x);
					right = n;
				}
				else
				{
					right.addNode(x);
				}
			}
		}
	}
	
}
