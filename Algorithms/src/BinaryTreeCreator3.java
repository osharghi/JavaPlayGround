
public class BinaryTreeCreator3 {

	BinaryTreeNode root;
	
	BinaryTreeCreator3()
	{
		BinaryTreeNode b10 = new BinaryTreeNode(10);
		BinaryTreeNode b5 = new BinaryTreeNode(5);
		BinaryTreeNode b3 = new BinaryTreeNode(-3);
		BinaryTreeNode b3a = new BinaryTreeNode(3);
		BinaryTreeNode b2 = new BinaryTreeNode(2);
		BinaryTreeNode b11 = new BinaryTreeNode(11);
		BinaryTreeNode b3b = new BinaryTreeNode(3);
		BinaryTreeNode b2a = new BinaryTreeNode(-2);
		BinaryTreeNode b1 = new BinaryTreeNode(1);
	
		root = b10;
		
		b10.left = b5;
		b10.right = b3;
		
		b5.left = b3a;
		b5.right = b2;
		
		b3a.left = b3b;
		b3a.right = b2a;
		
		b2.right = b1;
		
		b3.right = b11;
		
	}
	
}
