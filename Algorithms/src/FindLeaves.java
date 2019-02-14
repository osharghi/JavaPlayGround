import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-leaves-of-binary-tree/

public class FindLeaves {
	
	public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        if(root == null) return results;
        
        removeLeaves(root, results);
        
        return results;
    }
    
    int removeLeaves(TreeNode node, List<List<Integer>>  results)
    {        
        if(node == null) return 0;
        
        int leftVal = removeLeaves(node.left, results);
        int rightVal = removeLeaves(node.right, results);
        
        int level = Math.max(leftVal, rightVal);
        if(results.size() == level)
        {
            List<Integer> sub = new ArrayList<>();
            sub.add(node.val);
            results.add(sub);
        }
        else
        {
            List<Integer> sub = results.get(level);
            sub.add(node.val);
        }
        
        return level+1;
    }
    
    public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	 }

}
