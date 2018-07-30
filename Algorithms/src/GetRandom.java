import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class GetRandom {
	
	TreeNode root;

	GetRandom()
	{
		int[] arr = {1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		createTree(arr, 0, arr.length-1);
		
		printTree();
		
		TreeNode n = getRandom();
		if(n!= null)
		{
			System.out.println("Node Val: " + n.val);
		}
		else
		{
			System.out.println("NULL");
		}
	}
	
	TreeNode getRandom()
	{
		Random r = new Random();
		int rVal = r.nextInt(root.leftSize + 1 + root.rightSize);
		System.out.println("rVal: " + rVal);
		return getNode(rVal, root);
	}
	
	TreeNode getNode(int random, TreeNode root)
	{
		System.out.println("rVal: " + random);
		
		if(random == root.leftSize) return root;
		
		if(random<root.leftSize)
		{
			return getNode(random, root.left);
		}
		else
		{
			return getNode(random-(root.leftSize+1), root.right);
		}
	}
	
	void createTree(int[] arr, int low, int high)
	{
		if(low<=high)
		{
			int mid = (low+high)/2;
			
			if(root == null)
			{
				root = new TreeNode(arr[mid]);
			}
			else
			{
				root.add(arr[mid]);
			}
			
			createTree(arr, low, mid-1);
			createTree(arr, mid+1, high);
		}
	}
	
	class TreeNode
	{
		int val;
		int leftSize;
		int rightSize;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x)
		{
			val = x;
			leftSize = 0;
			rightSize = 0;
			left = null;
			right = null;
		}
		
		void add(int x)
		{
			if(x<=val)
			{
				if(left != null)
				{
					left.add(x);
				}
				else
				{
					left = new TreeNode(x);
				}
				
				leftSize++;
			}
			else
			{
				if(right != null)
				{
					right.add(x);
				}
				else
				{
					right = new TreeNode(x);
				}
				rightSize++;
			}
		}
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
				
				System.out.print("C: " + current.val);
				
				if(current.left != null)
				{
					System.out.print(" L: " + current.left.val);
					queue.add(current.left);
				}
				
				if(current.right != null)
				{
					System.out.print(" R: " + current.right.val);
					queue.add(current.right);
				}
				
				System.out.println("");
			}
		}
	}
	
}
