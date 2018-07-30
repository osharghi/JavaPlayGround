
public class CheckSubtree {

	CheckSubtree()
	{
		BinaryTreeCreator btc1 = new BinaryTreeCreator();
		BinaryTreeCreator2 btc2 = new BinaryTreeCreator2();
		
		boolean result = isSubtree(btc1.root, btc2.root);
		
		System.out.println("Is subtree: " + result);
	}
	
	boolean isSubtree(BinaryTreeNode bigNode, BinaryTreeNode smallNode)
	{
		boolean result = doDFS(bigNode, smallNode);
		return result;
	}
	
	boolean doDFS(BinaryTreeNode bigNode, BinaryTreeNode smallNode)
	{
		if(bigNode == null)
		{
			return false;
		}
		
		if(bigNode.data == smallNode.data)
		{
			boolean result = compare(bigNode, smallNode);
			if(result)
			{
				return result;
			}
		}
		
		boolean result = doDFS(bigNode.left, smallNode);
		if(result)
		{
			return result;
		}
		
		result = doDFS(bigNode.right, smallNode);
		
		return result;
		
	}
	
	boolean compare(BinaryTreeNode root1, BinaryTreeNode root2)
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		
		if(root1 == null || root2 == null)
		{
			return false;
		}
		
		if(root1.data != root2.data)
		{
			return false;
		}
		
		boolean resultL = compare(root1.left, root2.left);
		if(!resultL)
		{
			return resultL;
		}
		
		boolean resultR = compare(root1.right, root2.right);
		if(!resultR)
		{
			return resultR;
		}
		
		return true;
			
	}

	
	
	
}
