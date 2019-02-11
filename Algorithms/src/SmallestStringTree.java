import java.util.ArrayList;

//https://leetcode.com/problems/smallest-string-starting-from-leaf/

public class SmallestStringTree {
	
	public String smallestFromLeaf(TreeNode root) {
        
        String currentVal = null;
        
        if(root == null) return currentVal;
        
        ArrayList<Integer> result = getString(root);
        return buildString(result);
        
    }
    
    String buildString(ArrayList<Integer> list)
    {
        StringBuilder s = new StringBuilder();
        for(Integer x: list)
        {
            char c = getChar(x);
            s.append(c);
        }
        
        return s.toString();
    }
    
    char getChar(int x)
    {
        x += 97; 
        char c = (char) x;
        return c;
    }
    
    ArrayList<Integer> getString(TreeNode node)
    {
        if(node == null) return new ArrayList<>();
        
        ArrayList<Integer> left = getString(node.left);
        ArrayList<Integer> right = getString(node.right);
        
        ArrayList<Integer> result = helper(left, right);
        result.add(node.val);
        return result;
        
    }
    
    ArrayList<Integer> helper(ArrayList<Integer> left, ArrayList<Integer> right)
    {
        ArrayList<Integer> result = null;
        
        if(left.isEmpty() && right.isEmpty()) return left;
        if(left.isEmpty()) return right;
        if(right.isEmpty()) return left;
        
        int limit = Math.min(left.size(), right.size());
        
        for(int i = 0; i<limit; i++)
        {
            int val1 = left.get(i);
            int val2 = right.get(i);
            
            if(val1<val2)
            {
                result = left;
                return result;
            }
            else if(val2<val1)
            {
                result = right;
                return result;
            }
        }
        
        if(result == null)
        {
            if(left.size()<right.size())
            {
                result = left;
            }
            else
            {
                result = right;
            }
        }
        return result;
    }
    
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}
