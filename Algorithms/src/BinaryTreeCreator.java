
public class BinaryTreeCreator {

	BinaryTreeNode root;
	
	BinaryTreeCreator()
	{
		BinaryTreeNode b2 = new BinaryTreeNode(2);
		BinaryTreeNode b3 = new BinaryTreeNode(3);
		BinaryTreeNode b4 = new BinaryTreeNode(4);
		BinaryTreeNode b5 = new BinaryTreeNode(5);
		BinaryTreeNode b6 = new BinaryTreeNode(6);
		BinaryTreeNode b7 = new BinaryTreeNode(7);
		BinaryTreeNode b8 = new BinaryTreeNode(8);
		BinaryTreeNode b9 = new BinaryTreeNode(9);
		BinaryTreeNode b10 = new BinaryTreeNode(10);
		BinaryTreeNode b1 = new BinaryTreeNode(1);
		BinaryTreeNode b0 = new BinaryTreeNode(0);
		
		root = b5;
		
		b5.left = b3;
		b5.right = b8;
		
		b3.left = b2;
		b3.right = b4;
		
		b8.left = b7;
		b8.right = b9;
		
		b7.left = b6;
		
		b9.right = b10;
		
		b2.left = b1;
		b1.left = b0;
				

		
	}
	
	Result findAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q)
	{
		if(root == null)
		{
			Result r = new Result(null, false);
			return r;
		}
		
		if(root == p && root == q)
		{
			return new Result(root, true);
		}
		
		Result rLeft = findAncestor(root.left, p, q);
		if(rLeft.isAncestor)
		{
			return rLeft;
		}
		
		Result rRight = findAncestor(root.right, p, q);
		if(rRight.isAncestor)
		{
			return rRight;
		}
		
		if(rLeft.node != null && rRight.node != null)
		{
			return new Result(root, true);
		}
		else if(root == p || root == q)
		{
			boolean isAncestor = rLeft.node != null || rRight.node != null;
			return new Result(root, isAncestor);
		}
		else
		{
			return new Result(rLeft.node != null ? rLeft.node : rRight.node, false);
		}
	}
	
	
	class Result
	{
		BinaryTreeNode node;
		boolean isAncestor;
		
		Result(BinaryTreeNode n, boolean isAnc)
		{
			node = n;
			isAncestor = isAnc;
		}
	}
	
}
