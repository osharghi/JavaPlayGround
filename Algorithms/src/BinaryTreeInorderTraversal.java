import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-inorder-traversal/

public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> results = new ArrayList<>();
        
        if(root == null) return results;
        
        inorder(root, results);
        return results;
        
    }
    
    void inorder(TreeNode node, List<Integer> results)
    {
        if(node == null) return;
        
        inorder(node.left, results);
        results.add(node.val);
        inorder(node.right, results);
        return;
    }
	
}
