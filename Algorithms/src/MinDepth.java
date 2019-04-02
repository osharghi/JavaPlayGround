
//LeetCode: 111. Minimum Depth of Binary Tree
//https://leetcode.com/problems/minimum-depth-of-binary-tree/

public class MinDepth {
	
	public int minDepth(TreeNode root) {
        
        if(root == null) return 0;
        
        return getMin(root);
    }
    
    int getMin(TreeNode node)
    {
        if(node == null)
        {
             return 0;
        }
        
        int val1 = getMin(node.left);
        int val2 = getMin(node.right);
        
        if(val1 != 0 && val2 != 0)
        {
            return Math.min(val1, val2) + 1;
        }
        else
        {
            return Math.max(val1, val2) + 1;
        }        
    }
}
