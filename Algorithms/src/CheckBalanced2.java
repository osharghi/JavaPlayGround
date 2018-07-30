
public class CheckBalanced2 {
	
	TreeNode root;
	
	CheckBalanced2()
	{
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);

		
		
		n0.left = n1;
		n0.right = n2;
		
//		n1.left = n3;
		n2.left = n3;
		n2.right = n4;
//		
		n4.right = n5;
		
		root = n0;

		checkBalanced();
		
	}
	
	void checkBalanced()
	{
		int leftVal = checkBalanced(root.left);
		int rightVal = checkBalanced(root.right);
		
		if(leftVal == -1 || rightVal == -1)
		{
			System.out.println("Not Balanced");
		}
		else
		{
			int diff = Math.abs(leftVal-rightVal);
			
			if(diff>1)
			{
				System.out.println("Not Balanced");
			}
			else
			{
				System.out.println("Balanced");
			}
		}

	}
	
	int checkBalanced(TreeNode node)
	{
		if(node == null) return 0;
		
		int diff = 0;
		
		int leftVal = checkBalanced(node.left);
		int rightVal = checkBalanced(node.right);
		
		if(leftVal == -1 || rightVal == -1)
		{
			return -1;
		}
		
		diff = Math.abs(leftVal-rightVal);
		
		if(diff>1)
		{
			return -1;
		}
		else
		{
			int height = Math.max(leftVal, rightVal) + 1;
			return height;
		}
		
		
	}

}
