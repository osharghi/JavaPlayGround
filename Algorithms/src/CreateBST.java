
public class CreateBST {

	CreateBST()
	{
		int[] arr = {1, 3, 5, 7, 8, 9, 13, 15, 17};
		createTree(arr);
		
	}
	
	void createTree(int[] arr)
	{
		if(arr.length>2)
		{
			int mid = arr.length/2;
			Node midNode = new Node(arr[mid]);
			Tree t = new Tree(midNode);
			createTree(arr, t.head, 0, mid-1);
			createTree(arr, t.head, mid+1, arr.length-1);
			printTree(t.head);
		}
		else
		{
			
		}	
	}
	
	void createTree(int[] arr, Node head, int low, int high)
	{
		if(low<high)
		{
			int mid = (low+high)/2;
			Node n = new Node(arr[mid]);
			if(n.data<= head.data)
			{
				head.left = n;
			}
			else
			{
				head.right = n;
			}
			
			createTree(arr, n, low, mid -1);
			createTree(arr, n, mid+1, high);
			
		}
		else if(low==high)
		{
			Node n = new Node(arr[low]);
			if(n.data<= head.data)
			{
				head.left = n;
			}
			else
			{
				head.right = n;
			}
		}
	}
	
	void printTree(Node head)
	{
		if(head!=null)
		{
			System.out.print("Head: " + head.data);
		}
		
		if(head.left != null)
		{
			System.out.print(" Left: " + head.left.data);
		}
		
		if(head.right != null)
		{
			System.out.print(" Right: " + head.right.data);
		}
		
		System.out.println("");
		
		if(head.left != null)
		{
			printTree(head.left);
		}
		
		if(head.right != null)
		{
			printTree(head.right);
		}	
	}

	
	class Tree
	{
		Node head;
		
		Tree(Node n)
		{
			head = n;
		}
	}
	
	class Node
	{
		int data;
		Node left;
		Node right;
		
		Node(int d)
		{
			data = d;
			left = null;
			right = null;
		}
	}
}
