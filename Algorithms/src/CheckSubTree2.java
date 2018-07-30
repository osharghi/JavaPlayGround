
public class CheckSubTree2 {
	
	TreeNode root1;
	TreeNode root2;
	
	CheckSubTree2()
	{
		int[] arr1 = {1, 3, 5, 7, 9, 11, 13 ,15, 17, 19, 21, 24, 26, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 53, 55, 57, 61, 63, 65};
//		int[] arr1 = {1, 3, 5, 7, 9, 11, 13 ,15, 17, 19, 21, 24, 26};

		
		BinaryTreeCreatorAuto btc1 = new BinaryTreeCreatorAuto(arr1);
		root1 = btc1.root;
		
		int[] arr2 = {11, 24, 26};
		BinaryTreeCreatorAuto btc2 = new BinaryTreeCreatorAuto(arr2);
		root2 = btc2.root;
		
		System.out.println("Result: " + findRoot(root1, root2));
	}
	
	boolean findRoot(TreeNode n1, TreeNode n2)
	{
		if(n1 == null)
		{
			return false;
		}
		else if(n1.data == n2.data)
		{
			return compareTrees(n1, n2);
		}
		else
		{
			return findRoot(n1.left,n2) || findRoot(n1.right, n2);	
		}
	}
	
	boolean compareTrees(TreeNode n1, TreeNode n2)
	{
		if(n1 == null && n2 == null)
		{
			return true;
		}
		else if(n1 == null || n2 == null)
		{
			return false;
		}
		else if(n1.data == n2.data)
		{	
			return compareTrees(n1.left, n2.left) && compareTrees(n1.right, n2.right);
			
		}
		else
		{
			return false;
		}
	}
}
