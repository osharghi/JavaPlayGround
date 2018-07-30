
public class CommonAncestor {

	CommonAncestor()
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
		
		n3.left = n1;
		n3.right = n5;
		
		n15.left = n11;
		n15.right = n17;
		
		commonAnc(n9, n15, n17);
		
	}
	
	TreeNode commonAnc(TreeNode root, TreeNode p, TreeNode q)
	{
		Result r = commonHelper(root, p, q);
		if(r.isAncestor)
		{
			System.out.println("Ancestor: " + r.n.data);
			return r.n;
		}
		
		System.out.println("NULL");
		
		return null;
	}
	
	Result commonHelper(TreeNode root, TreeNode p, TreeNode q)
	{
		if(root == null) return new Result(null, false);
		
		if(root == p && root == q) return new Result(root, true);
		
		Result rx = commonHelper(root.left, p, q);
		if(rx.isAncestor) return rx;
		
		Result ry = commonHelper(root.right, p, q);
		if(ry.isAncestor) return ry;
		
		if(rx.n != null && ry.n != null)
		{
			return new Result(root, true);
		}
		else if(root == p || root == q)
		{
			boolean isAncestor = rx.n != null || ry.n != null;
			return new Result(root, isAncestor);
		}
		else
		{
			return new Result(rx.n != null ? rx.n : ry.n, false);
		}
		
	}
	
	class Result
	{
		TreeNode n;
		boolean isAncestor;
		Result(TreeNode node, boolean isAnc)
		{
			n = node;
			isAncestor = isAnc;
		}
	}
}
