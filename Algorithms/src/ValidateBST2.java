
public class ValidateBST2 {

	ValidateBST2()
	{
//		int[] arr = {1, 3, 5, 7, 9, 11, 13 ,15, 17, 19};
//		MinimalTree mt = new MinimalTree(arr);
//		mt.printTree(mt.root);
		
		
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n3.left = n2;
		n3.right = n4;
		
		n2.left = n1;
		n1.left = n0;
		
		n4.right = n5;
		
		
		validate(n3);
	}
	
	void validate(TreeNode root)
	{
		boolean leftVal = validate(root.left, Integer.MIN_VALUE, root.data);
		boolean rightVal = validate(root.right, root.data, Integer.MAX_VALUE);
		
		if(leftVal && rightVal)
		{
			System.out.println("VALID");
		}
		else
		{
			System.out.println("Not Valid");

		}

		
	}
	
	boolean validate(TreeNode n, int min, int max)
	{
		if(n == null) return true;
		
		if(n.data > min && n.data <= max)
		{
			boolean result = true;
			
			result = validate(n.left, min, n.data);
			
			if(!result) return false;
			
			result = validate(n.right, n.data, max);
			
			return result;
			
		}
		else
		{
			
			return false;
		}
		
	}
}
