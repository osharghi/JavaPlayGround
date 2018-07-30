import java.util.LinkedList;
import java.util.Queue;

public class MinimalTree2 {

	TreeNode2 root;
	
	MinimalTree2(int[] arr)
	{
		buildTree(arr, 0, arr.length-1);
	}
	
	void buildTree(int[] arr, int low, int high)
	{
		if(low<=high)
		{
			int mid = (low+high)/2;
			
			if(root == null)
			{
				root = new TreeNode2(arr[mid]);
				buildTree(arr, low, mid-1);
				buildTree(arr, mid+1, high);
			}
			else 
			{
				root.add(arr[mid]);
				buildTree(arr, low, mid-1);
				buildTree(arr, mid+1, high);
			}
		}
	}
	
	void print()
	{
		Queue<TreeNode2> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			TreeNode2 node = queue.poll();
			System.out.print("Current: " + node.val);
			
			if(node.left != null)
			{
				queue.add(node.left);
				System.out.print(" L: " + node.left.val);
			}
			
			if(node.right != null)
			{
				queue.add(node.right);
				System.out.print(" R: " + node.right.val);
			}
			
			System.out.println("");
		}
		
	}
	
	class TreeNode2
	{
		int val;
		TreeNode2 left;
		TreeNode2 right;
		
		TreeNode2(int x)
		{
			val = x;
			left = null;
			right = null;
		}
		
		void add(int x)
		{
			if(x<=val)
			{
				if(left == null)
				{
					left = new TreeNode2(x);
				}
				else
				{
					left.add(x);
				}
			}
			else
			{
				if(right == null)
				{
					right = new TreeNode2(x);
				}
				else
				{
					right.add(x);
				}
			}
		}
	}
	
}
