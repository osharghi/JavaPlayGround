
public class Successor2 {
	
	Successor2()
	{
		TreeNode n9 = new TreeNode(9);
		TreeNode n3 = new TreeNode(3);
		TreeNode n1 = new TreeNode(1);
		TreeNode n5 = new TreeNode(5);
		TreeNode n15 = new TreeNode(15);
		TreeNode n11 = new TreeNode(11);
		TreeNode n17 = new TreeNode(17);
		
		n9.left = n3;
		n9.right = n15;
		
		n3.parent = n9;
		n15.parent = n9;
		
		n3.left = n1;
		n3.right = n5;
		
		n1.parent = n3;
		n5.parent = n3;
		
		n15.left = n11;
		n15.right = n17;
		
		n11.parent = n15;
		n17.parent = n15;
		
		TreeNode result = getSuccessor(n17);
		
		if(result != null)
		{
			System.out.println("Successor: " + result.val);
		}
		else
		{
			System.out.println("No successor");
		}

	}
	
	TreeNode getSuccessor(TreeNode node)
	{
		if(node.right != null) return getMin(node.right);
		
		if(node.left == null && node.right == null)
		{
			if(node.parent.left == node)
			{
				return node.parent;
			}
			else if(node.parent.right == node)
			{
				return getParent(node);
			}
			else
			{
				return null;
			}
		}
		
		return null;
		
	}
	
	TreeNode getMin(TreeNode node)
	{
		if(node.left == null)
		{
			return node;
		}
		else
		{
			return getMin(node.left);
		}
	}
	
	TreeNode getParent(TreeNode node)
	{
		if(node.parent == null) return null;
		
		if(node.parent.right == node)
		{
			return getParent(node.parent);
		}
		else if(node.parent.left == node)
		{
			return node.parent;
		}
		else
		{
			return null;
		}
	}
	
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		TreeNode(int i)
		{
			val = i;
			left = null;
			right = null;
			parent = null;
		}
	}

}
