
public class TreeKNeighbor {

	Node root = null;
	
	TreeKNeighbor()
	{
	
		int[] arr = {1, 2, 3,4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
		buildTree(arr, 0, arr.length-1);
		getK(root, 2, 13);

		
	}
	
	int getK(Node n, int k, int x)
	{
		if(n == null) return -1;
		
		if(n.val == x)
		{
			//traverse down;
			traverseDown(n, k, 0);
			return 1;
		}
		
		int leftReturn = getK(n.left, k, x);
		
		if(leftReturn !=  -1)
		{
			if(leftReturn == k)
			{
				System.out.println(n.val);
			}
			else
			{
				//traverse down right
				traverseDown(n.right, k, leftReturn+1);
				return leftReturn+1;

			}
		}
		
		int rightReturn = getK(n.right, k, x);
		
		if(rightReturn != -1)
		{
			
			if(rightReturn == k)
			{
				System.out.println(n.val);
			}
			else
			{
				//traverse down left
				traverseDown(n.left, k, rightReturn+1);
				return rightReturn+1;

			}
		}
		
		return -1;
	}
	
	void traverseDown(Node n, int k, int currentIndex)
	{
		if(n == null) return;
		
		if(k == currentIndex)
		{
			System.out.println(n.val);
		}
		else
		{
			traverseDown(n.left, k, currentIndex+1);
			traverseDown(n.right, k, currentIndex+1);

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
		
		void add(int x)
		{
			if(x<=val)
			{
				if(left == null)
				{
					left = new Node(x);
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
					right = new Node(x);
				}
				else
				{
					right.add(x);
				}
			}
		}
	}
	
}
