
public class CheckBalanced {

	CheckBalanced()
	{
		BinaryTreeCreator btc = new BinaryTreeCreator();
		checkBalanced(btc.root);
		
	}
	
	void checkBalanced(BinaryTreeNode root)
	{
		int val = checkNode(root);
		if(val == Integer.MIN_VALUE)
		{
			System.out.println("Not balanced");
		}
		else
		{   
			System.out.println("balanced");
		}
	}
	
	int checkNode(BinaryTreeNode root)
	{
		if(root == null)
		{
			return 1;
		}
		
		int val1 = checkNode(root.left);
		int val2 = checkNode(root.right);
		
		if(val1 == Integer.MIN_VALUE || val2 == Integer.MIN_VALUE)
		{
			return Integer.MIN_VALUE;
		}
		else if(Math.abs(val1 - val2) > 1)
		{
			return Integer.MIN_VALUE;
		}
		else
		{
			int max = val1>=val2 ? val1 : val2;
			return max + 1;
		}
	}
}
