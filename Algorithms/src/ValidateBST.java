
public class ValidateBST {

	ValidateBST()
	{
		BinaryTreeCreator btc = new BinaryTreeCreator();
		checkTree(btc.root);
	}
	
	void checkTree(BinaryTreeNode root)
	{
		boolean r1 = isValid(root.left, Integer.MIN_VALUE, root.data);
		
		if(r1)
		{
			boolean r2 = isValid(root.right, root.data, Integer.MAX_VALUE);
			
			if(r2)
			{
				System.out.println("Is Valid!");
			}
			else
			{
				System.out.println("Is not valid!");
			}
		}
		else
		{
			System.out.println("Is not valid!");

		}
		
	}
	
	boolean isValid(BinaryTreeNode root, int min, int max)
	{
		if(root == null)
		{
			return true;
		}
		
		if(root.data > min && root.data <= max)
		{
			
			boolean r1 = isValid(root.left, min, root.data);
			boolean r2 = isValid(root.right, root.data, max);
			
			if(r1 & r2)
			{
				return true;
			}
			
			return false;
			
		}
		else
		{
			return false;
		}
	}
	
	
}
