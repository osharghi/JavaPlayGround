
public class BinaryTreeCreator2 {
	
	BinaryTreeNode root;
	
	BinaryTreeCreator2()
	{
		BinaryTreeNode b6 = new BinaryTreeNode(6);
		BinaryTreeNode b7 = new BinaryTreeNode(7);
		BinaryTreeNode b8 = new BinaryTreeNode(8);
		BinaryTreeNode b9 = new BinaryTreeNode(9);
		BinaryTreeNode b10 = new BinaryTreeNode(10);

		root = b8;
		
		b8.left = b7;
		b8.right = b9;
		
		b7.left = b6;
		
		b9.right = b10;
		
	}

}
