
public class TreeNode {
	
	int data;
	TreeNode left = null;
	TreeNode right = null;
	int size = 1;
	
	TreeNode(int d)
	{
		data = d;
	}
	
	void insert(int d)
	{
		if(d<=data)
		{
			if(left == null) left = new TreeNode(d);
			else left.insert(d);
		}
		else
		{
			if(right == null) right = new TreeNode(d);
			else right.insert(d);
		}
		
		size++;
	}
	
	TreeNode getIth(int i)
	{
		int leftSize = this.left == null ? 0 : this.left.size;
		if(i<leftSize)
		{
			return this.left.getIth(i);
		}
		else if(i == leftSize)
		{
			return this;
		}
		else 
		{
			return this.right.getIth(i - (leftSize +1));
		}
	}

}
