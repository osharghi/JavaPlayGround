
//559. Maximum Depth of N-ary Tree
//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        
        if(root == null) return 0;
                
        int max = 0;
        
        for(Node n: root.children)
        {
            int depth = maxDepth(n);
            if(depth>max)
            {
                max = depth;
            }
        }
        return max+1;   
    }
}