import java.util.LinkedList;
import java.util.Queue;

public class TreeAncestor {

	Node root;
	
	TreeAncestor()
	{
		int[] arr = {1, 2, 3,4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
		buildTree(arr, 0, arr.length-1);
//		printTree();
		Result  r = (findAncestor(root, 1, 17));
		System.out.println("Result: " + r.isAncestor + " Val: " + r.n.val);
	}
	
	Result findAncestor(Node n, int u, int v)
	{
		if(n == null) return new Result(null, false);
		
		
		Result rL = findAncestor(n.left, u, v);
		
		if(rL.isAncestor)
		{
			return rL;
		}
		
		
		Result rR = findAncestor(n.right, u, v);
		
		if(rR.isAncestor) {
			return rR;
		}
		
		if(n.val == u && n.val == v)
		{
			return new Result(n, true);
		}
		else if(rL.n != null && rR.n != null)
		{
			return new Result(n, true);
		}
		else if(n.val == u || n.val == v)
		{
			boolean isAnc = rL.n != null || rR.n != null;
			return new Result(n, isAnc);
		}
		else
		{
			Node newN = rL.n != null ? rL.n : rR.n;
			return new Result(newN, false);
		}
	}
	
	void buildTree(int[] arr, int low, int high) 
	{
		if(low<high)
		{
			int mid = (low+high)/2;
			
			if(root == null)
			{
				root = new Node(arr[mid]);
			}
			else
			{
				root.add(arr[mid]);
			}
			
			buildTree(arr, low, mid-1);
			buildTree(arr, mid+1, high);
		}
	}
	
	void printTree()
	{
		if(root == null) return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			Node n = q.poll();
			
			System.out.print("Node: " + n.val);
			
			if(n.left != null)
			{
				System.out.print(" L: " + n.left.val);
				q.add(n.left);

			}
			
			if(n.right != null)
			{
				System.out.print(" R: " + n.right.val);
				q.add(n.right);
			}
			
			System.out.println("");
			
		}
		
	}
	
	class Result
	{
		Node n;
		boolean isAncestor;
		
		Result(Node node, boolean isAnc)
		{
			n = node;
			isAncestor = isAnc;
		}
		
	}
	
	
	class Node
	{
		int val;
		Node left;
		Node right;
		
		Node(int i)
		{
			val = i;
			left = null;
			right = null;
		}
		
		void add(int x)
		{
			if(x<=val)
			{
				if(left == null)
				{
					Node l = new Node(x);
					left = l;
				}
				else
				{
					left.add(x);;
				}
			}
			else
			{
				if(right == null)
				{
					Node r = new Node(x);
					right = r;
				}
				else
				{
					right.add(x);
				}
			}
		}
	}
	
}
