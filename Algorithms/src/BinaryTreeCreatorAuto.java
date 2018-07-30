import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCreatorAuto {

	TreeNode root;
	
	BinaryTreeCreatorAuto(int[] arr)
	{
		for(int i = 0; i<arr.length; i++)
		{
			add(arr[i]);
		}
	}
	
	void add(int i)
	{
		TreeNode lastNode = BFS();
		
		if(lastNode  == null)
		{
			root = new TreeNode(i);
			return;
		}
		
		
		if(lastNode.left == null)
		{
			lastNode.left = new TreeNode(i);
			return;
		}
		
		if(lastNode.right == null)
		{
			lastNode.right = new TreeNode(i);
			return;
		}
	}
	
	TreeNode BFS()
	{
		if(root != null)
		{
		
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			
			while(!queue.isEmpty())
			{
				TreeNode node = queue.poll();
				
				if(node.left  == null || node.right == null) return node;
				
				if(node.left != null) queue.add(node.left);
				
				if(node.right != null) queue.add(node.right);
			}
		}
		
		return null;
	}
	
	void printTree()
	{
		if(root != null)
		{
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			
			while(!queue.isEmpty())
			{
				TreeNode current = queue.poll();
				
				System.out.print("C: " + current.data);
				
				if(current.left != null)
				{
					System.out.print(" L: " + current.left.data);
					queue.add(current.left);
				}
				
				if(current.right != null)
				{
					System.out.print(" R: " + current.right.data);
					queue.add(current.right);
				}
				
				System.out.println("");
			}
		}
	}
	
	
}
