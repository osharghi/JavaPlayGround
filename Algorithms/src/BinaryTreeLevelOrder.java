import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-level-order-traversal/

public class BinaryTreeLevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        if(root == null) return results;
        
        traverse(root, results, 0);
        return results;
 
    }
    
    void traverse(TreeNode node, List<List<Integer>> results, int index)
    {
        if(node == null) return;
        
        if(results.size() == 0)
        {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            results.add(list);
        }
        else
        {
            if(results.size() == index)
            {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                results.add(list);
            }
            else
            {
                List<Integer> list = results.get(index);
                list.add(node.val);
            }
        }
        
        traverse(node.left, results, index+1);
        traverse(node.right, results, index+1);
    }
	
}
