//LeetCode: 965. Univalued Binary Tree
//https://leetcode.com/problems/univalued-binary-tree/

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        
        if(root == null) return true;
        
        return checkNodes(root, root.val);
            
    }
    
    boolean checkNodes(TreeNode n, int val)
    {
        if(n == null)
        {
            return true;
        }
        
        if(n.val != val)
        {
            return false;
        }
        
        boolean left = checkNodes(n.left, val);
        if(!left) return false;
        
        boolean right = checkNodes(n.right, val);
        
        return right;
    }
}