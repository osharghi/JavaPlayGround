
public class BinaryTreeCreatorParents {
	
	BinaryTreeNodeParent root;
	
	BinaryTreeCreatorParents()
	{
		BinaryTreeNodeParent b2 = new BinaryTreeNodeParent(2);
		BinaryTreeNodeParent b3 = new BinaryTreeNodeParent(3);
		BinaryTreeNodeParent b4 = new BinaryTreeNodeParent(4);
		BinaryTreeNodeParent b5 = new BinaryTreeNodeParent(5);
		BinaryTreeNodeParent b6 = new BinaryTreeNodeParent(6);
		BinaryTreeNodeParent b7 = new BinaryTreeNodeParent(7);
		BinaryTreeNodeParent b8 = new BinaryTreeNodeParent(8);
		BinaryTreeNodeParent b9 = new BinaryTreeNodeParent(9);
		BinaryTreeNodeParent b10 = new BinaryTreeNodeParent(10);
		
		root = b5;
		
		b5.left = b3;
		b5.right = b8;
		b3.parent = b5;
		b8.parent = b5;
		
		
		b3.left = b2;
		b3.right = b4;
		b2.parent = b3;
		b4.parent = b3;
		
		
		b8.left = b7;
		b8.right = b9;
		b7.parent = b8;
		b9.parent = b8;
		
		b7.left = b6;
		b6.parent = b7;
		
		b9.right = b10;
		b10.parent = b9;
		
		
		BinaryTreeNodeParent successor = findSuccessor(b10);
		if(successor != null)
		{
			System.out.println(successor.value);
		}
		else
		{
			System.out.println("No successor");
		}
	}
	
	BinaryTreeNodeParent findSuccessor(BinaryTreeNodeParent node)
	{
		if(node == null)
		{
			return null;
		}
		
		if(node.right != null)
		{
			return findLeft(node.right);
		}
		
		if(node.right == null)
		{
		
			if(node.parent.left == node)
			{
				return node.parent;
			}
			else
			{
				BinaryTreeNodeParent parent = findParent(node);
				if(parent == null)
				{
					return null;
				}
				else
				{
					return parent;
				}
			}
		}
		
		return null;
	}
	
	BinaryTreeNodeParent findParent(BinaryTreeNodeParent node)
	{
		if(node.parent == null)
		{
			return null;
		}
		
		if(node.parent.left == node)
		{
			return node.parent;
		}
		else
		{
			return findParent(node.parent);
		}
	}

	
	BinaryTreeNodeParent findLeft(BinaryTreeNodeParent node)
	{
		if(node.left != null)
		{
			return findLeft(node.left);
		}
		else
		{
			return node;
		}
	}

}
