//872. Leaf-Similar Trees
//https://leetcode.com/problems/leaf-similar-trees/

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        getLeaves(root1, list1);
        getLeaves(root2, list2);
        
        if(list1.size() != list2.size())
        {
            return false;
        }
        else
        {
            for(int i = 0; i<list1.size(); i++)
            {
                if(list1.get(i) != list2.get(i))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    void getLeaves(TreeNode n, ArrayList<Integer> values)
    {
        if(n == null) return;
        
        if(n.left == null && n.right == null)
        {
            values.add(n.val);
            return;
        }
        
        getLeaves(n.left, values);
        getLeaves(n.right, values);
        return;
    }
}