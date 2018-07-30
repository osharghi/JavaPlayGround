import java.util.LinkedList;
import java.util.Queue;

public class MinimalTreeNoOrder {

	TreeNode root;
	
	MinimalTreeNoOrder()
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		buildTree(arr);
		print();
	}
	
	void buildTree(int[] arr)
	{
		for(int i = 0; i<arr.length; i++)
		{
			if(root == null)
			{
				root = new TreeNode(arr[i]);
			}
			else
			{
				add(arr[i]);
			}
		}
	}
	
	void add(int x)
	{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			
			if(node.left == null)
			{
				node.left = new TreeNode(x);
				return;
			}
			else
			{
				queue.add(node.left);
			}
			
			if(node.right == null)
			{
				node.right = new TreeNode(x);
				return;
			}
			else
			{
				queue.add(node.right);
			}
		}
	}
	
	void print()
	{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			System.out.print("Current: " + node.val);
			
			if(node.left!= null)
			{
				queue.add(node.left);
				System.out.print(" L: " + node.left.val);
			}
			
			if(node.right!= null)
			{
				queue.add(node.right);
				System.out.print(" R: " + node.right.val);
			}
			
			System.out.println("");
			
		}
		
	}
	
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int i)
		{
			val = i;
			left = null;
			right = null;
		}
	}
	
	
}
