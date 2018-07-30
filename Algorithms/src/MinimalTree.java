import java.util.LinkedList;
import java.util.Queue;

public class MinimalTree {

	TreeNode root;
	
	MinimalTree(int[] arr)
	{
		buildTree(arr);
//		printTree(root);
		
	}
	
	TreeNode buildTree(int[] arr)
	{
		if(arr.length == 0)
		{
			return null;
		}
		else
		{
			int mid = (0 + (arr.length-1))/2;
			root = new TreeNode(arr[mid]);
			buildTree(arr, root, 0, mid-1);
			buildTree(arr, root, mid+1, arr.length-1);
			return root;
		}
	}
	
	void buildTree(int[] arr, TreeNode root, int low, int high)
	{
		if(high<low)
		{
			return;
		}
		
		if(low == high)
		{
			root.insert(arr[low]);
		}
		else
		{
			int mid = (low+high)/2;
			root.insert(arr[mid]);
			buildTree(arr, root, low, mid-1);
			buildTree(arr, root, mid+1, high);

		}
	}
	
	void printTree(TreeNode root)
	{
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			TreeNode n = q.poll();
			System.out.print(n.data + ": ");
			
			if(n.left != null)
			{
				q.add(n.left);
				System.out.print(" L: " + n.left.data);
			}
			
			if(n.right != null)
			{
				q.add(n.right);
				System.out.print(" R: " + n.right.data);
			}
			
			System.out.println(" ");
			
		}
	}
	
}
